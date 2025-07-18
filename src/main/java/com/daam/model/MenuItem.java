package com.daam.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "menuitems")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String name;

    private String description;

    private String category;

    private BigDecimal price;

    @Column(name = "imageurl")
    private String imageUrl;

    private boolean available;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        MenuItem menuItem = (MenuItem) o;

        if (o.hashCode() != menuItem.hashCode()) return false;

        return isAvailable() == menuItem.isAvailable()
                && getName().equals(menuItem.getName())
                && getDescription().equals(menuItem.getDescription())
                && getCategory().equals(menuItem.getCategory())
                && getPrice().equals(menuItem.getPrice())
                && getImageUrl().equals(menuItem.getImageUrl());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getCategory().hashCode();
        result = 31 * result + getPrice().hashCode();
        result = 31 * result + getImageUrl().hashCode();
        result = 31 * result + Boolean.hashCode(isAvailable());
        return result;
    }
}
