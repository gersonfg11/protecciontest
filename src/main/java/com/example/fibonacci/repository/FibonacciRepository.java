package com.example.fibonacci.repository;

import com.example.fibonacci.entity.FibonacciRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FibonacciRepository extends JpaRepository<FibonacciRecord, Long> {

}
