package com.example.spum_backend.controller;

import com.example.spum_backend.dto.request.PenaltyRequestDTO;
import com.example.spum_backend.service.interfaces.PenaltyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/penalties")
public class PenaltyController {

    private final PenaltyService penaltyService;

    public PenaltyController(PenaltyService penaltyService) {
        this.penaltyService = penaltyService;
    }

    @PostMapping("/add")
    public void addPenalty(@RequestBody PenaltyRequestDTO penalty) {
        penaltyService.createPenalty(penalty);
    }
    

}
