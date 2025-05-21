package com.example.spum_backend.service.interfaces.internal;

import com.example.spum_backend.entity.Item;

import java.util.List;

public interface ItemServiceEntity {
    Item getItemById(Long id);
    List<Item> getAllItems();
    Item saveItem(Item item);
}
