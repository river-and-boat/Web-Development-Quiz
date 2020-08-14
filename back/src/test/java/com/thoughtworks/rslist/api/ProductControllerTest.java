package com.thoughtworks.rslist.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.rslist.entity.ProductEntity;
import com.thoughtworks.rslist.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ProductControllerTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllProducts() throws Exception {
        ProductEntity product = ProductEntity.builder().name("可口可乐")
                .price(5.5).unit("瓶").build();
        productRepository.save(product);
        ProductEntity product2 = ProductEntity.builder().name("雪碧")
                .price(3.5).unit("瓶").build();
        productRepository.save(product);
        productRepository.save(product2);

        mockMvc.perform(get("/products"))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateOneProductNormal() throws Exception {
        ProductEntity product = ProductEntity.builder().name("可口可乐")
                .price(5.5).unit("瓶").build();

        mockMvc.perform(post("/product"))
                .andExpect(status().isCreated())
                .andExpect(header().string("create","1"));
    }

    @Test
    public void testCreateWithIllegalField() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        ProductEntity product = ProductEntity.builder()
                .price(5.5).unit("瓶").build();
        mockMvc.perform(post("/product")
                .content(objectMapper.writeValueAsString(product))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error", is("illegal filed")))
                .andExpect(status().isBadRequest());
    }
}