package com.example.SpringBootOpenApi.service.sample;

import com.example.SpringBootOpenApi.repository.sample.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SampleService {

    private final SampleRepository repository;

    public SampleEntity find() {
        var record = repository.select();
        return new SampleEntity(record.getContent());
    }
}
