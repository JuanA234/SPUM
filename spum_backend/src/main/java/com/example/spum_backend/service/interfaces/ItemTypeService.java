package com.example.spum_backend.service.interfaces;

import com.example.spum_backend.dto.ItemTypeDTO;
import com.example.spum_backend.entity.ItemType;

import java.util.List;

public interface ItemTypeService {

    ItemTypeDTO addItemType(ItemTypeDTO itemTypeDTO);
    ItemTypeDTO updateItemType(Long id, ItemTypeDTO itemTypeDTO);
    void deleteItemType(Long id);
    List<ItemTypeDTO> getAllItemTypes();
    ItemTypeDTO findItemTypeById(Long id);
}
