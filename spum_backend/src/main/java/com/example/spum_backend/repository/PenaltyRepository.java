package com.example.spum_backend.repository;

import com.example.spum_backend.entity.Penalty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PenaltyRepository extends JpaRepository<Penalty, Long> {

}
