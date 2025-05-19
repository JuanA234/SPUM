package com.example.spum_backend.service.impl;

import com.example.spum_backend.dto.ItemTypeDTO;
import com.example.spum_backend.entity.ItemType;
import com.example.spum_backend.exception.ItemNotFoundException;
import com.example.spum_backend.exception.ItemTypeNotFoundException;
import com.example.spum_backend.repository.ItemTypeRepository;
import com.example.spum_backend.service.interfaces.ItemTypeService;
import org.modelmapper.ModelMapper;

public class ItemTypeServiceImpl implements ItemTypeService {

    private final ModelMapper modelMapper;
    private final ItemTypeRepository itemTypeRepository;

    public ItemTypeServiceImpl(ModelMapper modelMapper, ItemTypeRepository itemTypeRepository) {
        this.modelMapper = modelMapper;
        this.itemTypeRepository = itemTypeRepository;
    }

    @Override
    public ItemTypeDTO addItemType(String itemTypeName) {
        ItemType itemType = ItemType.builder()
                .itemTypeName(itemTypeName)
                .build();
        return modelMapper.map(itemTypeRepository.save(itemType), ItemTypeDTO.class);
    }

    @Override
    public ItemTypeDTO updateItemType(Long id, String itemTypeName) {
        ItemType itemType = itemTypeRepository.findById(id)
                .orElseThrow(() -> new ItemTypeNotFoundException("Item Type Not Found"));
        itemType.setItemTypeName(itemTypeName);
        return modelMapper.map(itemTypeRepository.save(itemType), ItemTypeDTO.class);
    }

    @Override
    public void deleteItemType(Long id) {
        ItemType itemType = itemTypeRepository.findById(id)
                .orElseThrow(() -> new ItemTypeNotFoundException("Item Type Not Found"));
        itemTypeRepository.delete(itemType);
    }
}
