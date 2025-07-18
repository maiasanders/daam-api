package com.daam.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemDto {
    private int id;
    private int orderId;
    private int itemid;
    private BigDecimal price;
    private String notes;
    private String firstName;
}
