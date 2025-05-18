package com.example.spum_backend.service.interfaces;

import com.example.spum_backend.dto.request.ItemRequestDTO;
import com.example.spum_backend.dto.response.ItemResponseDTO;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<ItemResponseDTO> findAllItems();
    Optional<ItemResponseDTO> findItemById(Long id);
    ItemResponseDTO addAnItem(ItemRequestDTO item);
    void deleteItemById(Long id);
}
