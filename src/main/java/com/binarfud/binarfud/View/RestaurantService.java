package com.binarfud.binarfud.View;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.binarfud.binarfud.Controller.Menu;

public class RestaurantService {

    private final Menu menu = new Menu();
    int choice;

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public int getChoice() {
        return choice;
    }

    int hasil = 0;
    Scanner input = new Scanner(System.in);

    public void startApp() {
        menu.printMenu();
        while (true) {


            try {
                System.out.print("=======Pilih Menu=======: ");
                choice = input.nextInt();
                switch (choice) {
                    case 0:
                        break;
                    case 1:

                        hasil += menu.printMenu(0);

                        break;
                    case 2:
                        hasil += menu.printMenu(1);
                        break;
                    case 3:
                        hasil += menu.printMenu(2);
                        break;
                    case 4:
                        hasil += menu.printMenu(3);
                        break;
                    case 5:

                        hasil += menu.printMenu(4);
                        break;
                    case 97:
                        System.out.println("Pesanan saat ini");
                        menu.printOrder();
                    case 98:
                        menu.printMenu();
                        break;
                    case 99:
                        menu.confirmOrder(hasil);
                        break;

                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih nomor menu yang benar.");

                        break;

                }

            } catch (InputMismatchException e) {
                System.out.println("Anda memasukkan input yang tidak valid. Harap masukkan angka.");
                input.nextLine(); // Membersihkan buffer masukan
            }




        }
    }

}
