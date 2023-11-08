package com.example.SpringBootOpenApi.controller.sample;

import com.example.SpringBootOpenApi.service.sample.SampleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/samples")
public class SampleController {

    private final SampleService sampleService = new SampleService();

    @GetMapping
    public SampleDTO index() {
        var entity = sampleService.find();
        return new SampleDTO(entity.getContent(), LocalDateTime.now());
    }
}
