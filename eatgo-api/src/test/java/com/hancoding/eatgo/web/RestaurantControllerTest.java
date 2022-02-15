package com.hancoding.eatgo.web;

import com.hancoding.eatgo.domain.RestaurantRepositoryImpl;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {

    @Autowired
    private MockMvc mvc;

    @SpyBean // test에 의존성 주입
    private RestaurantRepositoryImpl restaurantRepositoryImpl;

    @Test
    @DisplayName("음식점 리스트")
    public void list() throws Exception {
        mvc.perform(get("/restaurants")).andExpect(status().isOk())
                .andExpect(content().string(containsString("hancoding")));
    }
    
    @Test
    @DisplayName("음식점 상세정보")
    public void restaurantDetail() throws Exception {
        mvc.perform(get("/restaurants/1")).andExpect(status().isOk())
                .andExpect(content().string(containsString("hancoding")));
    }
}