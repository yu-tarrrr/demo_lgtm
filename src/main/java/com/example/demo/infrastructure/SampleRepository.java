package com.example.demo.infrastructure;

import com.example.demo.controller.resources.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<Sample, String> {
}
