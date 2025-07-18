package com.daam.controller;

import com.daam.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)

class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ItemService itemService;

    private com.daam.model.Item item;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        // Create related Order and MenuItem with ids from data.sql
        com.daam.model.Order order = new com.daam.model.Order();
        order.setId(1); // orderid from first INSERT INTO items

        com.daam.model.MenuItem menuItem = new com.daam.model.MenuItem();
        menuItem.setId(14); // itemid from first INSERT INTO items

        item = new com.daam.model.Item();
        item.setId(1);
        item.setOrder(order);
        item.setItem(menuItem);
        item.setPrice(new java.math.BigDecimal("5.1"));
        item.setFirstName("Nora");
        item.setNotes("");
    }

    @Test
    void getById() throws Exception {
        when(itemService.getById(1)).thenReturn(item);
        mockMvc.perform( get("/items/1"))
                .andExpect(status().isOk());
    }
}
