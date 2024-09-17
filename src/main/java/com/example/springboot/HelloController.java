package com.example.springboot;

import java.util.Map;
import java.util.Collections; // Para criar um Map com um único elemento
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
public class HelloController {

    @GetMapping("/")
    public ResponseEntity<?> index(@RequestHeader(value = "Accept", defaultValue = MediaType.TEXT_HTML_VALUE) String acceptHeader) {
        if (acceptHeader.contains(MediaType.APPLICATION_JSON_VALUE)) {
            // Retornar JSON
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(Map.of("message", "Hello World!"));
        } else {
            // Retornar HTML
            String htmlResponse = "<html><body><h1>Hello World!</h1></body></html>";
            return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(htmlResponse);
        }
    }
}
