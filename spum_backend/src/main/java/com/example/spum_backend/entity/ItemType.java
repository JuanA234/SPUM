package com.example.spum_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "item_types")
public class ItemType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemTypeId;

    private String itemTypeName;

    @OneToOne(mappedBy = "itemType")
    private Item item;
}
