package com.daam.controller;

import com.daam.model.MenuItem;
import com.daam.service.MenuItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MenuItemController.class)
public class MenuItemControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    MenuItemService service;

    final MenuItem ITEM_1 = new MenuItem(
            1,
            "Bison Burger",
            "Packed with protein and a touch of sweetness, it's topped with your choice of cheese and classic burger fixings. Lean, humanely raised meat for those who are more health-conscious.",
            "entrees",
            new java.math.BigDecimal("11.54"),
            "/images/food/burger_1.jpg",
            true
    );

    @Test
    public void testGetMenuItem() throws Exception {

        when(service.getById(1)).thenReturn(ITEM_1);
        this.mockMvc.perform( get("/menuitems/1"))
                .andExpect(status().isOk());

    }

    @Test
    void return404ForId0() throws Exception {
        when(service.getById(0)).thenReturn(null);
        this.mockMvc.perform( get("/items/0"))
                .andExpect(status().isNotFound());
    }
}
