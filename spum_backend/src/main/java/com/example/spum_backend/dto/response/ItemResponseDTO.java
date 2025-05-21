package com.example.spum_backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponseDTO{
    String itemName;
    String itemDescription;
    Long itemQuantity;
    Long itemType;
}
