package me.dio.coding.votacaobbbapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class StatusController {

    @GetMapping("/api/status")
    public ResponseEntity<String> status(){
        return ResponseEntity.ok("online");
    }
}
