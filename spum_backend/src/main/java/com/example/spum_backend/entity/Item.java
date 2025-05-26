package com.example.spum_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "itemType")
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;

    private String itemName;
    private String itemDescription;
    private Long itemQuantity;

    @OneToOne
    @JoinColumn(name = "itemTypeId", referencedColumnName = "itemTypeId")
    private ItemType itemType;

    @OneToMany
    private List<Booking> bookings;

}
