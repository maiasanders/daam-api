package com.daam.model;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "orders")
public class Order {

    public Order(int id, User user, Timestamp orderTime, Timestamp pickupTime, String area, String location, BigDecimal tip, String pan, int expiryMonth, int expiryYear, String status) {
        this.id = id;
        this.user = user;
        this.orderTime = orderTime;
        this.pickupTime = pickupTime;
        this.area = area;
        this.location = location;
        this.tip = tip;
        this.pan = pan;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    @Column(name = "ordertime")
    private Timestamp orderTime;

    @Column(name = "pickuptime")
    private Timestamp pickupTime;

    private String area;

    private String location;

    private BigDecimal tip;

    private String pan;

    @Column(name = "expiry_month")
    private int expiryMonth;

    @Column(name = "expiry_year")
    private int expiryYear;

    private String status;
}
