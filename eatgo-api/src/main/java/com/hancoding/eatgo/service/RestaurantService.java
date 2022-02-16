package com.hancoding.eatgo.service;

import com.hancoding.eatgo.domain.MenuItem;
import com.hancoding.eatgo.domain.MenuItemRepository;
import com.hancoding.eatgo.domain.Restaurant;
import com.hancoding.eatgo.domain.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final MenuItemRepository menuItemRepository;

    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurant(Long id) {

        Restaurant restaurant = restaurantRepository.findById(id);
        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
        restaurant.setMenuItems(menuItems);

        return restaurant;
    }

    public Restaurant addRestaurant(Restaurant restaurant) {
        restaurant.setId(1L);
        return restaurant;
    }
}
