package com.example.fibonacci.model;

import java.util.List;

public class FibonacciResponse {
    private List<Integer> series;

    public FibonacciResponse(List<Integer> series) {
        this.series = series;
    }

    // Getters y setters
    public List<Integer> getSeries() {
        return series;
    }

    public void setSeries(List<Integer> series) {
        this.series = series;
    }
}
