package com.daam.controller;

import com.daam.model.User;
import com.daam.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    UserService userService;

    List<User> users = List.of(
            new User[]{
                    new User(0, "admin", "$2a$12$sPUi2kLGlu.YcCV9cfnE.uzJiPOR/G1sRHZcwV3agV9ScZReaY3VO", "Administrator", "User", "(555) 943-2230", "admin@daam.com", "https://minimaltoolkit.com/images/randomdata/female/70.jpg", "", 6, 2025, "ROLE_ADMIN"),
                    new User(0, "cmac", "$2a$12$sPUi2kLGlu.YcCV9cfnE.uzJiPOR/G1sRHZcwV3agV9ScZReaY3VO", "Caitlin", "McIntyre", "(555) 442-2093", "cmac@daam.com", "https://minimaltoolkit.com/images/randomdata/female/71.jpg", "4332-1234-1234-1234", 6, 2025, "ROLE_ADMIN"),
                    new User(0, "me", "$2a$12$sPUi2kLGlu.YcCV9cfnE.uzJiPOR/G1sRHZcwV3agV9ScZReaY3VO", "Test", "User", "(555) 853-1039", "testUser@daam.com", "https://minimaltoolkit.com/images/randomdata/female/7.jpg", "4332-1234-1234-1234", 6, 2025, "ROLE_USER"),
                    new User(0, "server1", "$2a$12$sPUi2kLGlu.YcCV9cfnE.uzJiPOR/G1sRHZcwV3agV9ScZReaY3VO", "Jo", "Server", "(555) 443-4567", "server1@daam.com", "https://minimaltoolkit.com/images/randomdata/female/9.jpg", null, 0, 0, "ROLE_SERVER"),
                    new User(0, "server1", "$2a$12$sPUi2kLGlu.YcCV9cfnE.uzJiPOR/G1sRHZcwV3agV9ScZReaY3VO", "Lee", "Server", "(555) 123-4954", "server2@daam.com", "https://minimaltoolkit.com/images/randomdata/male/9.jpg", null, 0, 0, "ROLE_SERVER")
            }
    );



    @Test
    public void testGetUsers() throws Exception {
        when(userService.getUsers()).thenReturn(users);
        mockMvc.perform( get("/users") )
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void getUser() throws Exception {
        when(userService.getUserById(1)).thenReturn(users.getFirst());
        mockMvc.perform( get("/users/1"))
                .andExpect(status().isOk());
    }
}
