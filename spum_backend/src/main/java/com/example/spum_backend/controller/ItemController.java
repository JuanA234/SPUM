package com.example.spum_backend.controller;

import com.example.spum_backend.dto.response.ItemResponseDTO;
import com.example.spum_backend.service.interfaces.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/all")
    public List<ItemResponseDTO> getAllItems() {
        return itemService.findAllItems();
    }

    @GetMapping("/{id}")
    public ItemResponseDTO getItemById(@PathVariable Long id) {
        return itemService.findItemById(id);
    }

}
