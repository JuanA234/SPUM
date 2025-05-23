package com.example.spum_backend.controller;

import com.example.spum_backend.dto.ItemTypeDTO;
import com.example.spum_backend.entity.ItemType;
import com.example.spum_backend.service.interfaces.ItemTypeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class ItemTypeController {

    private final ItemTypeService itemTypeService;

    public ItemTypeController(ItemTypeService itemTypeService) {
        this.itemTypeService = itemTypeService;
    }

    // Fix this method
    @PostMapping("/add")
    public String add(@RequestBody ItemTypeDTO itemType) {
        return itemTypeService.addItemType(itemType).toString();
    }

}
