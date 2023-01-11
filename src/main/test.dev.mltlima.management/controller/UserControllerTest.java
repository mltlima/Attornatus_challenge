package test.dev.mltlima.management.controller;

import dev.mltlima.management.controller.UserController;
import dev.mltlima.management.model.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserController controller;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/users")).andExpect(status().isOk())
                .andExpect(content().string(containsString("[]")));
    }

    @Test
    public void shouldReturnUser() throws Exception {
        User user = new User();
        user.setName("Test");
        user.setEmail("test@mail.com");
        user.setBirthday("1990-01-01");

        this.mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(user.toString()))
                .andExpect(status().isOk()).andExpect(content().string(containsString("Test")));
    }
}