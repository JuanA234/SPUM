package com.example.spum_backend.controller;

import com.example.spum_backend.dto.request.ItemRequestDTO;
import com.example.spum_backend.dto.response.ItemResponseDTO;
import com.example.spum_backend.service.interfaces.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@CrossOrigin(value = "http://localhost:5173")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<ItemResponseDTO> getAllItems() {
        return itemService.findAllItems();
    }

    @GetMapping("/search")
    public ResponseEntity<List<ItemResponseDTO>> searchItemByName(@RequestParam String name) {
        return ResponseEntity.ok(itemService.findItemByName(name));
    }

    @GetMapping("/{id:\\d+}")
    public ItemResponseDTO getItemById(@PathVariable Long id) {
        return itemService.findItemById(id);
    }

    @PostMapping
    public ItemResponseDTO addItem(@RequestBody ItemRequestDTO itemRequestDTO) {
        return itemService.addItem(itemRequestDTO);
    }
}
