package com.example.SpringBootOpenApi.controller.sample;

import java.time.LocalDateTime;

public class SampleDTO {

    private String content;
    private LocalDateTime timestamp;

    public SampleDTO(String content, LocalDateTime timestamp) {
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
