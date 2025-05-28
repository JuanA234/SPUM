package com.example.spum_backend.service.impl;

import com.example.spum_backend.dto.request.ItemRequestDTO;
import com.example.spum_backend.dto.response.ItemResponseDTO;
import com.example.spum_backend.entity.Item;
import com.example.spum_backend.entity.ItemType;
import com.example.spum_backend.exception.notFound.ItemNotFoundException;
import com.example.spum_backend.mapper.ItemMapper;
import com.example.spum_backend.repository.ItemRepository;
import com.example.spum_backend.service.interfaces.ItemService;
import com.example.spum_backend.service.interfaces.internal.ItemServiceEntity;
import com.example.spum_backend.service.interfaces.internal.ItemTypeServiceEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService, ItemServiceEntity {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    private final ItemMapper itemMapper;
    private final ItemTypeServiceEntity itemTypeService;


    @Override
    public List<ItemResponseDTO> findAllItems() {
        return itemRepository.findAll()
                .stream().map(itemMapper::toDto).toList();
    }

    @Override
    public ItemResponseDTO findItemById(Long id) {
        Item item = getItemById(id);
        return modelMapper.map(item, ItemResponseDTO.class);
    }

    @Override
    public List<ItemResponseDTO> findItemByName(String nombre) {
        List<Item> items = itemRepository.findByItemNameContainingIgnoreCase(nombre);
        if (items.isEmpty()) {
            throw new ItemNotFoundException("No se encontró ningún item con el nombre que contiene: " + nombre);
        }
        return items.stream()
                .map(itemMapper::toDto)
                .toList();
    }
    @Override
    public ItemResponseDTO addItem(ItemRequestDTO item) {
        Item itemToSave = modelMapper.map(item, Item.class);

        // Look for the item type
        ItemType itemType = itemTypeService.getItemTypeById(item.getItemType());

        itemToSave.setItemType(itemType);

        return modelMapper.map(itemRepository.save(itemToSave), ItemResponseDTO.class);
    }

    @Override
    public void deleteItemById(Long id) {
        Item item = getItemById(id);
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
