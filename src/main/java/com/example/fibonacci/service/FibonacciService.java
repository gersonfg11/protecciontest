package com.example.fibonacci.service;

import com.example.fibonacci.entity.FibonacciRecord;
import com.example.fibonacci.model.FibonacciRequest;
import com.example.fibonacci.model.FibonacciResponse;
import com.example.fibonacci.repository.FibonacciRepository;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FibonacciService {

    @Autowired
    private FibonacciRepository fibonacciRepository;
    @Autowired
    private EmailService emailService;

    public FibonacciResponse generateFibonacci(FibonacciRequest request) {
        LocalTime time = LocalTime.parse(request.getTime());
        int seed1 = time.getMinute() / 10;
        int seed2 = time.getMinute() % 10;
        int count = time.getSecond();

        List<Integer> fibonacciSeries = generateFibonacciSeries(seed1, seed2, count);
        saveFibonacciRecord(request.getTime(), fibonacciSeries);
        emailService.sendFibonacciResult(fibonacciSeries.toString());
        return new FibonacciResponse(fibonacciSeries);
    }

    public List<Integer> generateFibonacciSeries(int seed1, int seed2, int count) {
        List<Integer> series = new ArrayList<>();
        series.add(seed1);
        series.add(seed2);

        while (series.size() < count + 2) {
            int next = series.get(series.size() - 1) + series.get(series.size() - 2);
            series.add(next);
        }

        Collections.reverse(series);
        return series;
    }

    private void saveFibonacciRecord(String time, List<Integer> series) {
        FibonacciRecord record = new FibonacciRecord();
        record.setTime(time);
        record.setSeries(series.toString());
        record.setCreatedAt(java.time.LocalTime.now());

        fibonacciRepository.save(record);
    }
}
