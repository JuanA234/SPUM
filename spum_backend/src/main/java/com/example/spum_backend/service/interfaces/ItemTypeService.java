package com.example.spum_backend.service.interfaces;

import com.example.spum_backend.dto.ItemTypeDTO;

public interface ItemTypeService {

    ItemTypeDTO addItemType(ItemTypeDTO itemTypeDTO);
    ItemTypeDTO updateItemType(ItemTypeDTO itemTypeDTO);
    void deleteItemType(Long id);

}
