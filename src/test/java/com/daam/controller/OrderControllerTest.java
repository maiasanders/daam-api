package com.daam.controller;

import com.daam.model.Order;
import com.daam.model.User;
import com.daam.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = OrderController.class)
class OrderControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    private OrderService orderService;

    private User user;
    private Order order;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(3);

        java.sql.Timestamp orderTime = java.sql.Timestamp.valueOf("2024-08-01 11:42:25");
        java.sql.Timestamp pickupTime = java.sql.Timestamp.valueOf("2024-08-01 11:51:47");

        order = new Order(
            1,
            user,
            orderTime,
            pickupTime,
            "Theater 1",
            "Table 37",
            new java.math.BigDecimal("12.93"),
            "4026664388908977",
            9,
            2028,
            "completed"
        );
    }

    @Test
    void testGetById() throws Exception {
        when(orderService.getById(1)).thenReturn(order);
        mockMvc.perform( get("/orders/1"))
                .andExpect(status().isOk());
    }
}
