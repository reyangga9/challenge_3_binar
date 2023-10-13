
package com.binarfud.binarfud;
import com.binarfud.binarfud.View.RestaurantService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RestaurantApp {
    public static void main(String[] args) {
        RestaurantService restaurantService = new RestaurantService();
        restaurantService.startApp();
    }
}
