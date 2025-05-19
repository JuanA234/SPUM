package com.example.spum_backend.service.interfaces;

import com.example.spum_backend.dto.ItemTypeDTO;

public interface ItemTypeService {

    ItemTypeDTO addItemType(String itemTypeName);
    ItemTypeDTO updateItemType(Long id, String itemTypeName);
    void deleteItemType(Long id);

}
