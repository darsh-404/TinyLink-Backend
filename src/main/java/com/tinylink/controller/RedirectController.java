package com.tinylink.controller;

import com.tinylink.entity.Link;
import com.tinylink.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RedirectController {

    @Autowired
    private LinkService linkService;

    @GetMapping("/{code}")
    public ResponseEntity<Void> redirect(@PathVariable String code) {
        Link link = linkService.incrementClicksAndGet(code);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", link.getTargetUrl());

        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }
}
