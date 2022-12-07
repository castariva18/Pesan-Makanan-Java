import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    static int milih;
    static int pilih=0;

    static void menu() {

        Scanner input = new Scanner(System.in);
        Scanner enterObj = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("|  Selamat Datang Di Restoran BUNGAR |");
        System.out.println("======================================");
        System.out.println("|    Menu Makanan Spesial Hari Ini   |");
        System.out.println("======================================");
        System.out.println("*Silahkan Masukkan Data Terlebih Dahulu*");
        System.out.println(" ");
        String namaPemesan;
        System.out.print("Nama Pemesan\t: ");
        namaPemesan = input.nextLine();
        int jumlahOrang;
        System.out.print("Jumlah orang\t: ");
        jumlahOrang = input.nextInt();
        System.out.println(" ");
        System.out.println("---Selamat Datang Kakak " + namaPemesan + "---");
        System.out.println("Pesanan Atas Nama\t: " + namaPemesan);
        System.out.println("Jumlah Pesanan\t\t: " + jumlahOrang + " Orang");

        System.out.print("[Tekan Tombol Enter Untuk Melanjutkan]");
        String enter = enterObj.nextLine();

        String[] makanan = {"Nasi Goreng Spesial\t\t|", "Ayam Bakar Spesial\t\t|",
                "Steak Sirloin Spesial\t|", "Kwetiaw Siram Spesial\t|", "Kambing Guling Spesial\t|"};
        double[] harga_makanan = {9999.99, 12345.67, 21108.40, 13579.13, 98765.43};
        String tambahdata;
        System.out.println("======================================");
        System.out.println("|  Selamat Datang Di Restoran BUNGAR |");
        System.out.println("======================================");
        System.out.println("|            ~Pilih Menu~            |");
        System.out.println("======================================");
        System.out.println("|1.             Makanan              |");
        System.out.println("|2.             Keluar               |");
        System.out.println("======================================");

        BufferedReader input2 = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;
        double hargaTotal = 0;
        double totalPesan[] = new double[100];
        int totalPesanan = 0;
        String menus[] = new String[100];
        double harga[] = new double[100];
        double hargaTemp  = 0;
        int hargaTempTotal[];
        DecimalFormat df = new DecimalFormat("#.00");

        Scanner menu = new Scanner(System.in);
        System.out.print("Silahkan Pilih Menu Yang Tersedia = ");
        milih = menu.nextInt();
        boolean keluar;

        //Tampilan===================================================
        System.out.println(" ");
        System.out.println("======================================");
        System.out.println("|    Menu Makanan Spesial Hari Ini   |");
        System.out.println("======================================");
        //===========================================================

        do {
            if (milih == 1) {
                for (int b = 0; b < makanan.length; b++) {
                    System.out.println("[" + (b+1) + "] " + makanan[b] + " Rp." + harga_makanan[b]);
                }
                {
                    do {

                        int pil;
                        System.out.print("\nSilahkan Pilih Menu Spesial Yang Tersedia = ");
                        pil = menu.nextInt();

                        if (pil <= makanan.length) {
                            menus[i] = makanan[pil - 1];
                            harga[i] = harga_makanan[pil - 1];
                        } else if (pil == makanan.length) {
                            menu();
                        } else {
                            System.out.println("Maaf pilihan menu tidak ada");
                            menus[i] = "Tidak Ada";
                            harga[i] = 0;
                        }

                        Scanner input3 = new Scanner(System.in);

                        System.out.println("=====Menu Yang Anda Pesan Adalah=====");
                        System.out.println(menus[i] + " " + harga[i] + " ");

                        System.out.print("\nSilahkan Masukkan Jumlah Pesanan : ");
                        totalPesan[i] = menu.nextInt();

                        hargaTemp = harga[i] * totalPesan[i];
                        System.out.println("Total pesanan anda adalah = " + hargaTemp);

                        System.out.print("Apakah anda ingin memesan lagi ? Y/T : ");
                        tambahdata = input3.nextLine();
                        i++;
                    } while (tambahdata.equalsIgnoreCase("Y"));
                }

                System.out.println("=====Menu Yang Anda Pesan Adalah=====");
                for (int b = 0; b < i; b++) {
                  //  totalPesanan +=  totalPesan[b];
                    System.out.println(menus[b] + " " + harga[b] + " ");
                }

                for (int a = 0; a < totalPesan.length; a++) {
                    totalPesanan +=  totalPesan[a];
                }

                System.out.println("Total Pesan = " + totalPesanan);
                System.out.println("======================================");

                for (int b = 0; b < i; b++) {
                    hargaTotal +=  harga[b] * totalPesan[b];
                }
                System.out.println("harga total\t\t\t\t\t= Rp." + hargaTotal + " ");
                System.out.println("dapat diskon promosi 10%\t= Rp." + df.format(hargaTotal * 0.10) + " ");
                System.out.println("harga setelah diskon 10%\t= Rp." + df.format(hargaTotal-(hargaTotal * 0.10)) + " ");
                System.out.println("pembelian per orang <" + jumlahOrang + ">\t\t= Rp." + df.format((hargaTotal-(hargaTotal * 0.10))/jumlahOrang) + " ");
                System.out.println("======================================");
                System.out.println("Terimakasih atas kunjungan anda");
            }

        } while (keluar = false);

    }

        public static void main(String[] args) {

            menu();

        }

    }


