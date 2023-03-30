package com.wsr.business.controller;

import com.wsr.business.data.models.Request;
import com.wsr.business.data.payload.CreateRequestForm;
import com.wsr.business.data.repo.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/request")
@RequiredArgsConstructor
public class RequestController {
    private final RequestRepository repository;

    @GetMapping("/{id}")
    public List<Request> getUserRequests(@PathVariable long id) {
        return repository.findByVisitors_Id(id);
    }


    @PostMapping
    public Object createRequest(@RequestBody CreateRequestForm form) {
        // TODO: validate input form and create request
        return null;
    }
}
