package com.example.SpringBootOpenApi.repository.sample;

import org.springframework.stereotype.Repository;

@Repository
public class SampleRepository {

    public SampleRecord select() {
        return new SampleRecord("Hello, World!!");
    }
}
