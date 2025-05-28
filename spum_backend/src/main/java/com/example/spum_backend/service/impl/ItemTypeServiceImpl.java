package com.example.spum_backend.service.impl;

import com.example.spum_backend.dto.ItemTypeDTO;
import com.example.spum_backend.entity.ItemType;
import com.example.spum_backend.exception.notFound.ItemTypeNotFoundException;
import com.example.spum_backend.repository.ItemTypeRepository;
import com.example.spum_backend.service.interfaces.ItemTypeService;
import com.example.spum_backend.service.interfaces.internal.ItemTypeServiceEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ItemTypeServiceImpl implements ItemTypeService, ItemTypeServiceEntity {

    private final ModelMapper modelMapper;
    private final ItemTypeRepository itemTypeRepository;

    public ItemTypeServiceImpl(ModelMapper modelMapper, ItemTypeRepository itemTypeRepository) {
        this.modelMapper = modelMapper;
        this.itemTypeRepository = itemTypeRepository;
    }

    @Override
    public ItemTypeDTO addItemType(ItemTypeDTO itemTypeName) {
        ItemType itemType = ItemType
                .builder()
                .itemTypeName(itemTypeName.getItemTypeName())
                .build();
        return modelMapper.map(itemTypeRepository.save(itemType), ItemTypeDTO.class);
    }

    @Override
    public ItemTypeDTO updateItemType(Long id, String itemTypeName) {
        ItemType itemType = getItemTypeById(id);
        itemType.setItemTypeName(itemTypeName);
        return modelMapper.map(itemTypeRepository.save(itemType), ItemTypeDTO.class);
    }

    @Override
    public void deleteItemType(Long id) {
        ItemType itemType = getItemTypeById(id);
        itemTypeRepository.delete(itemType);
    }

    @Override
    public ItemType getItemTypeById(Long id) {
        return itemTypeRepository.findById(id)
                .orElseThrow(() -> new ItemTypeNotFoundException("Item Type Not Found"));
    }
}
