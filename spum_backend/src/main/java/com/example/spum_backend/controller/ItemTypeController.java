package com.example.spum_backend.controller;

import com.example.spum_backend.dto.ItemTypeDTO;
import com.example.spum_backend.entity.ItemType;
import com.example.spum_backend.service.interfaces.ItemTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class ItemTypeController {

    private final ItemTypeService itemTypeService;

    public ItemTypeController(ItemTypeService itemTypeService) {
        this.itemTypeService = itemTypeService;
    }

    @PostMapping("/add")
    public ResponseEntity<ItemTypeDTO> addItemType(@RequestBody ItemTypeDTO itemType) {
        return ResponseEntity.status(HttpStatus.CREATED).body(itemTypeService.addItemType(itemType));
    }

    @GetMapping
    public ResponseEntity<List<ItemTypeDTO>> getAllItemsType() {
        return ResponseEntity.ok(itemTypeService.getAllItemTypes());
    }

    @GetMapping("{id}")
    public ResponseEntity<ItemTypeDTO> getItemTypeById(@PathVariable Long id) {
        return ResponseEntity.ok(itemTypeService.findItemTypeById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<ItemTypeDTO> updateItemType(@PathVariable Long id, @RequestBody ItemTypeDTO itemType) {
        return ResponseEntity.ok(itemTypeService.updateItemType(id, itemType));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteItemType(@PathVariable Long id) {
        itemTypeService.deleteItemType(id);
        return ResponseEntity.noContent().build();
    }
}
