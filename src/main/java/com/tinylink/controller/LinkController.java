package com.tinylink.controller;

import com.tinylink.dto.CreateLinkRequest;
import com.tinylink.dto.CreateLinkResponse;
import com.tinylink.dto.LinkResponse;
import com.tinylink.entity.Link;
import com.tinylink.service.LinkService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/links")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @Value("${frontend.url}")
    private String frontendUrl;

    @PostMapping
    public ResponseEntity<CreateLinkResponse> createLink(@Valid @RequestBody CreateLinkRequest request) {
        Link link = linkService.createLink(request.getTargetUrl(), request.getCustomCode());

        String shortUrl = frontendUrl + "/" + link.getCode();
        CreateLinkResponse response = new CreateLinkResponse(link.getCode(), shortUrl);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<LinkResponse>> getAllLinks() {
        List<Link> links = linkService.getAllLinks();
        List<LinkResponse> response = links.stream()
                .map(LinkResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{code}")
    public ResponseEntity<LinkResponse> getLinkByCode(@PathVariable String code) {
        Link link = linkService.incrementClicksAndGet(code);
        LinkResponse response = new LinkResponse(link);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Map<String, String>> deleteLink(@PathVariable String code) {
        linkService.deleteLink(code);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Link deleted successfully");

        return ResponseEntity.ok(response);
    }
}
