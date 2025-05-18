package com.example.spum_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "penalty_types")
public class PenaltyType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long penaltyTypeId;

    private String penaltyType;

}
