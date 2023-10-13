package com.binarfud.binarfud.Controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import com.binarfud.binarfud.Model.MenuItem;


public class Menu {
    // pake arrayList Object MenuItem biar bisa 2 tipe data
     ArrayList<MenuItem> pesananMenuItems = new ArrayList<>();
    private DecimalFormat decimalFormat = new DecimalFormat("#,###");
    private Scanner input = new Scanner(System.in);
    private String templateA = "=============";

    public ArrayList<MenuItem> getPesananMenuItems() {
        return pesananMenuItems;
    }

    // membuat Menunya
    private final MenuItem[] menuItems = {
            new MenuItem(1, "Nasi Goreng", 15000),
            new MenuItem(2, "Mie Goreng", 13000),
            new MenuItem(3, "Bihun Goreng", 12000),
            new MenuItem(4, "Es Teh Manis", 3000),
            new MenuItem(5, "Es Jeruk", 8000)
    };

    // Looping menunya sama nampilin menu
    public void printMenu() {

        System.out.println(templateA + "\nSelamat Datang di Binar FUD" + "\n" +templateA + "\nSilahkan Pilih Makanan : ");
        Arrays.stream(menuItems)
                .forEachOrdered(item -> {
                    System.out.println(
                            item.getId() + ". " + item.getName() + " | " + decimalFormat.format(item.getPrice()));
                });
        System.out.println("98. Lihat Menu" + "\n99. Pesan dan Bayar");

    }

    public void tambahMenuKeOrderan(String name, int price ,int qty){
        pesananMenuItems.add(new MenuItem(name,price,qty));
    }



    public int printMenu(int pilihan) {
        int hasil = 0;
        System.out.println(templateA);
        System.out.println("Berapa pesanan anda");
        System.out.println(templateA);
        System.out.println(
                this.menuItems[pilihan].getName() + " | " + decimalFormat.format(this.menuItems[pilihan].getPrice()));
        System.out.println("input 0 untuk kembali");

        System.out.print("Qty :");
        int banyak = input.nextInt();

        if (banyak == 0) {

            return hasil;
        } else {
            Optional<MenuItem> existingOrder = pesananMenuItems.stream()
                    .filter(order -> order.getName().equals(menuItems[pilihan].getName()))
                    .findFirst();

            if (existingOrder.isPresent()) {
                // Jika pesanan yang sama sudah ada, tambahkan qty
                MenuItem order = existingOrder.get();
                order.setQty(banyak);
                hasil += (menuItems[pilihan].getPrice() * banyak);
                System.out.println("Anda Memesan " + menuItems[pilihan].getName() + " sebanyak " + banyak
                        + " = " + decimalFormat.format(hasil));
                return hasil;
            } else {

                tambahMenuKeOrderan(menuItems[pilihan].getName(), menuItems[pilihan].getPrice(), banyak);
                hasil += (menuItems[pilihan].getPrice() * banyak);
                System.out.println("Anda Memesan " + menuItems[pilihan].getName() + " sebanyak " + banyak + " = "
                        + decimalFormat.format(hasil));
                return hasil;
            }
        }

    }

    private void getConfirmationChoice() {
        System.out.println("1. Konfirmasi dan Bayar");
        System.out.println("2. Kembali ke menu utama");
        System.out.println("0. Keluar Aplikasi");
        System.out.print("=>");
    }

    public void printOrder() {

        pesananMenuItems.stream()
                .forEach(menuItem -> System.out.println(menuItem.getName() + " "
                        + decimalFormat.format(menuItem.getPrice() * menuItem.getQty()) + " "
                        + menuItem.getQty()));
    }

    public void confirmOrder(int hasil) {
        System.out.println(templateA);
        System.out.println("Konfirmasi & Pembayaran");
        System.out.println(templateA);

        printOrder();

        System.out.println("-------------------+");
        System.out.println("Total : " + decimalFormat.format(hasil));

        getConfirmationChoice();
        int confirm = input.nextInt();
        switch (confirm) {

            case 1:
                saveOrderToFile("receipt.txt");
                System.exit(0);

            case 2:
                System.out.println("Kembali ke menu awal ----");
                break;
            case 0:
                System.exit(0);
                break;
            default:

                System.out.println(
                        "Pilihan tidak valid. Silakan pilih nomor menu yang benar. Kembali ke menu awal.");
                break;
        }

    }

    public void saveOrderToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            writer.write("================ \nBinar FUD  \n================ \n");
            writer.write("Terima kasih sudah memesan di BinarFud \nDibawah ini adalah pesanan anda\n \n");
            for (MenuItem order : pesananMenuItems) {
                writer.newLine();
                writer.write(order.getName() + " " + decimalFormat.format(order.getPrice() * order.getQty()) + " "
                        + order.getQty());
            }
            writer.newLine();
            writer.write("================ \nSimpan struk sebagai bukti pembayaran \n================ \n");

            System.out.println("pesanan telah di print ke " + fileName + "'.");
        } catch (IOException e) {
            System.out.println("Gagal print struk");
        }
    }

}
