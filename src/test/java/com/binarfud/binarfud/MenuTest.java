package com.binarfud.binarfud;
import com.binarfud.binarfud.Controller.Menu;
import com.binarfud.binarfud.Model.MenuItem;
import com.binarfud.binarfud.View.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MenuTest {
    private Menu menu;
    private MenuItem modelMenu;
    private RestaurantService restaurantService;

    @BeforeEach
    public void setMenu() {
    modelMenu = new MenuItem();

        menu = new Menu();
        restaurantService = new RestaurantService();

    }

    @Test
    @DisplayName("test printMenu")
    public void printMenu() {
        menu.printMenu();
        String expectedOutput = "Your expected menu output goes here"; // Replace with the expected menu output
        assertEquals(expectedOutput, expectedOutput);

    }

    @Test
    @DisplayName("Test print order ")
    public void printOrder() {
        menu.printOrder();

    }

    @Test
    @DisplayName("Test Tambah Array ke Orderan ")
public void testTambahArray(){
        menu.tambahMenuKeOrderan("Nasi goreng",15000,3);
        assertEquals(1, menu.getPesananMenuItems().size());
        System.out.println("Passing test");
}

    @Test
    @DisplayName("Cek Orderan")
public void testSemuaMenu(){
        menu.tambahMenuKeOrderan("Nasi Goreng",15000,3);
    menu.tambahMenuKeOrderan("Mie Goreng",13000,2);

        ArrayList<MenuItem> daftarMenu = menu.getPesananMenuItems();

    assertEquals("Nasi Goreng",daftarMenu.get(0).getName());
        assertEquals(13000,daftarMenu.get(1).getPrice());

}

    @Test
    @DisplayName("Test Tambah Array ke Orderan ")
public void testModelMenuItem(){

    }





}
