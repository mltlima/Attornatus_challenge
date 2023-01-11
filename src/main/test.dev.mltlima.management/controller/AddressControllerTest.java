package test.dev.mltlima.management.controller;

import dev.mltlima.management.controller.AddressController;
import dev.mltlima.management.model.Address;
import dev.mltlima.management.repository.AddressRepository;
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
public class AddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AddressController controller;

    @Autowired
    private AddressRepository repository;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/addresses")).andExpect(status().isOk())
                .andExpect(content().string(containsString("[]")));
    }

    @Test
    public void shouldReturnAddress() throws Exception {
        Address address = new Address();
        address.setStreet("Test");
        address.setNumber("123");
        address.setCity("Test");
        address.setState("Test");
        address.setCountry("Test");
        address.setZipCode("12345-678");

        this.mockMvc.perform(post("/addresses").contentType(MediaType.APPLICATION_JSON).content(address.toString()))
                .andExpect(status().isOk()).andExpect(content().string(containsString("Test")));
    }
}