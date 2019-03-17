package com.example.demo.infrastructure;

import com.example.demo.controller.resources.Lgtm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LgtmRepository extends JpaRepository<Lgtm, Integer> {
}
