package com.example.fibonacci.controller;

import com.example.fibonacci.entity.FibonacciRecord;
import com.example.fibonacci.repository.FibonacciRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/fibonacci-records")
@Tag(name = "Fibonacci Record Controller", description = "API para recuperar series de Fibonacci generadas")
public class FibonacciRecordController {

    @Autowired
    private FibonacciRepository fibonacciRepository;

    @GetMapping
    @Operation(summary = "Obtener todas las series de Fibonacci", description = "Recupera todas las series de Fibonacci generadas con sus respectivas horas.")
    public List<FibonacciRecord> getAllFibonacciRecords() {
        return fibonacciRepository.findAll();
    }
}
