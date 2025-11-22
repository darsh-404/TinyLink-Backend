package com.tinylink.service;

import com.tinylink.entity.Link;
import com.tinylink.exception.DuplicateCodeException;
import com.tinylink.exception.InvalidUrlException;
import com.tinylink.exception.LinkNotFoundException;
import com.tinylink.repository.LinkRepository;
import com.tinylink.util.CodeGenerator;
import com.tinylink.util.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;

    @Transactional
    public Link createLink(String targetUrl, String customCode) {
        // Validate URL
        if (!ValidationUtils.isValidUrl(targetUrl)) {
            throw new InvalidUrlException("Invalid URL format");
        }

        String code;

        // Use custom code if provided, otherwise generate one
        if (customCode != null && !customCode.trim().isEmpty()) {
            // Validate custom code format
            if (!ValidationUtils.isValidCode(customCode)) {
                throw new InvalidUrlException("Custom code must be 6-8 alphanumeric characters");
            }

            // Check if custom code already exists
            if (linkRepository.existsByCode(customCode)) {
                throw new DuplicateCodeException("Code already exists");
            }

            code = customCode;
        } else {
            // Generate unique code
            code = generateUniqueCode();
        }

        // Create and save link
        Link link = new Link(code, targetUrl);
        return linkRepository.save(link);
    }

    public List<Link> getAllLinks() {
        return linkRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    public Link getLinkByCode(String code) {
        return linkRepository.findByCode(code)
                .orElseThrow(() -> new LinkNotFoundException("Link not found"));
    }

    @Transactional
    public Link incrementClicksAndGet(String code) {
        Link link = getLinkByCode(code);
        link.setClicks(link.getClicks() + 1);
        link.setLastClicked(LocalDateTime.now());
        return linkRepository.save(link);
    }

    @Transactional
    public void deleteLink(String code) {
        Link link = getLinkByCode(code);
        linkRepository.delete(link);
    }

    private String generateUniqueCode() {
        int maxAttempts = 10;

        for (int i = 0; i < maxAttempts; i++) {
            String code = CodeGenerator.generate();
            if (!linkRepository.existsByCode(code)) {
                return code;
            }
        }

        throw new RuntimeException("Unable to generate unique code after " + maxAttempts + " attempts");
    }
}
