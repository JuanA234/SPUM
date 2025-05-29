package com.example.spum_backend.mapper;

import com.example.spum_backend.dto.ItemTypeDTO;
import com.example.spum_backend.entity.ItemType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface itemTypeMapper {

    ItemTypeDTO toDTO(ItemType itemType);

    ItemType toEntity(ItemTypeDTO itemTypeDTO);
}
