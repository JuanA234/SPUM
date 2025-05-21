package com.example.spum_backend.service.impl;

import com.example.spum_backend.dto.request.ItemRequestDTO;
import com.example.spum_backend.dto.response.ItemResponseDTO;
import com.example.spum_backend.entity.Item;
import com.example.spum_backend.entity.ItemType;
import com.example.spum_backend.exception.ItemNotFoundException;
import com.example.spum_backend.exception.ItemTypeNotFoundException;
import com.example.spum_backend.repository.ItemRepository;
import com.example.spum_backend.repository.ItemTypeRepository;
import com.example.spum_backend.service.interfaces.ItemService;
import com.example.spum_backend.service.interfaces.internal.ItemServiceEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ItemServiceImpl implements ItemService, ItemServiceEntity {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    private final ItemTypeRepository itemTypeRepository;

    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper modelMapper, ItemTypeRepository itemTypeRepository) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
        this.itemTypeRepository = itemTypeRepository;
    }

    @Override
    public List<ItemResponseDTO> findAllItems() {
        return itemRepository.findAll()
                .stream().map(item -> modelMapper.map(item, ItemResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ItemResponseDTO findItemById(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item with id "+ id +" Not found"));
        return modelMapper.map(item, ItemResponseDTO.class);
    }

    @Override
    public ItemResponseDTO addItem(ItemRequestDTO item) {
        Item itemToSave = modelMapper.map(item, Item.class);

        // Look for the item type
        ItemType itemType = itemTypeRepository.findById(item.getItemType())
                .orElseThrow(() -> new ItemTypeNotFoundException("Item type not found"));
        itemToSave.setItemType(itemType);

        return modelMapper.map(itemRepository.save(itemToSave), ItemResponseDTO.class);
    }

    @Override
    public void deleteItemById(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item with id "+ id +" Not found"));
        itemRepository.delete(item);
    }

    // Service methods for inner tasks.
    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item with id "+ id +" Not found"));
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }
}
