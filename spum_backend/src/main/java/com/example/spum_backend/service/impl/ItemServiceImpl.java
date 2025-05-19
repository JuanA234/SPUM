package com.example.spum_backend.service.impl;

import com.example.spum_backend.dto.request.ItemRequestDTO;
import com.example.spum_backend.dto.response.ItemResponseDTO;
import com.example.spum_backend.entity.Item;
import com.example.spum_backend.exception.ItemNotFoundException;
import com.example.spum_backend.repository.ItemRepository;
import com.example.spum_backend.service.interfaces.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;

    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
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
        return modelMapper.map(itemRepository.save(itemToSave), ItemResponseDTO.class);
    }

    @Override
    public void deleteItemById(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item with id "+ id +" Not found"));
        itemRepository.delete(item);
    }
}
