package com.wsr.business.controller;

import com.wsr.business.data.payload.CreateRequestForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/request")
public class RequestController {
    @PostMapping
    public Object createRequest(@RequestBody CreateRequestForm form) {
        // TODO: validate input form and create request
        return null;
    }
}
