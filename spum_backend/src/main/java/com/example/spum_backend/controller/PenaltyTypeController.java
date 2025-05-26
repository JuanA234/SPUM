package com.example.spum_backend.controller;


import com.example.spum_backend.dto.PenaltyTypeDTO;
import com.example.spum_backend.service.interfaces.PenaltyTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/penalty-types")
public class PenaltyTypeController {

    private final PenaltyTypeService penaltyTypeService;

    public PenaltyTypeController(PenaltyTypeService penaltyTypeService) {
        this.penaltyTypeService = penaltyTypeService;
    }

    @GetMapping("/all")
    public List<PenaltyTypeDTO> getAllPenalties() {
        return penaltyTypeService.getAllPenaltyTypes();
    }

    @PostMapping("/add")
    public PenaltyTypeDTO addPenaltyType(@RequestBody PenaltyTypeDTO itemType) {
        return penaltyTypeService.addPenaltyType(itemType);
    }

}
