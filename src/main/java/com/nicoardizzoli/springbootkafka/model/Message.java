package com.nicoardizzoli.springbootkafka.model;

import java.time.LocalDateTime;

public record Message(String message, LocalDateTime createdAt) {
}
