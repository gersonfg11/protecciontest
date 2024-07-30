package com.example.fibonacci.controller;

import com.example.fibonacci.model.FibonacciRequest;
import com.example.fibonacci.model.FibonacciResponse;
import com.example.fibonacci.service.FibonacciService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fibonacci")
@Tag(name = "Fibonacci Controller", description = "API para generar series de Fibonacci")
public class FibonacciController {

    @Autowired
    private FibonacciService fibonacciService;

    @PostMapping
    @Operation(summary = "Generar serie Fibonacci", description = "Genera una serie Fibonacci basada en la hora proporcionada.")
    public ResponseEntity<FibonacciResponse> generateFibonacci(@RequestBody FibonacciRequest request) {
        FibonacciResponse response = fibonacciService.generateFibonacci(request);
        return ResponseEntity.ok(response);
    }
}
