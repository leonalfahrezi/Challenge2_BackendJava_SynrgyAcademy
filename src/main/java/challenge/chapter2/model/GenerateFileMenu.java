package challenge.chapter2.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GenerateFileMenu implements KomponenMenu {

    private final Rumus buatBacaFile;

    private final Scanner scanner = new Scanner(System.in);

    public GenerateFileMenu(Rumus buatBacaFile) {
        this.buatBacaFile = buatBacaFile;
    }

    //override dari class interface yang sudah dibuat (komponen menu)
    @Override
    public void showModus() {

        List<Integer> getList = buatBacaFile.bacaCsv();
        File file = new File("src/main/resources/data_sekolah_modus.txt");

        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (Integer i : getList) {
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("Berikut Hasil Pengolahan Nilai:");
            bw.newLine();
            bw.write("Nilai     |     Frekuensi");
            bw.newLine();
            for (Map.Entry<Integer, Integer> val : hm.entrySet()) {
                bw.write(val.getKey() + "         |       " + val.getValue());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showMeanMedianModus() {
        try {
            List<Integer> getList = buatBacaFile.bacaCsv();
            File file = new File("src/main/resources/data_sekolah_mean_median_modus.txt");

            FileWriter writer = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write("Berikut Hasil Pengolahan Nilai:");
            bw.write("Nilai Median : " + buatBacaFile.hitungMean(getList));
            bw.newLine();
            bw.write("Nilai Rata-rata : " + buatBacaFile.hitungMedian(getList));
            bw.newLine();
            bw.write("Nilai Modus : " + buatBacaFile.hitungModus(getList));
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showAll() {

        try {
            showModus();
            showMeanMedianModus();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //override method menu
    @Override
    public void showMainMenu() {

        System.out.println("--------------------------------------------------");
        System.out.println("Aplikasi Pengolah Nilai Siswa");
        System.out.println("---------------------------------------------------");
        System.out.println("Sebelum lanjut, yuk pastikan apakah file data_sekolah.csv sudah berada di direktori berikut src/main/resources/data_sekolah.csv");

        System.out.println("Jika sudah yakin beud, silahkan tekan enter yaa :) <_____|");
        try{
            System.in.read(); //untuk membaca dan mengeksekusi inputan menjadi suatu nilai agar dapat next sout
            System.out.println("Silahkan pilih menu");
            System.out.println("1. Generate file untuk menampilkan modus (frekuensi)");
            System.out.println("2. Generate file untuk menampilkan mean, median dan modus");
            System.out.println("3. Generate kedua file");
            System.out.println("0. Exit");
            System.out.print("---> ");
            String menu = scanner.nextLine();

            switch (menu.toLowerCase()) {
                case "1" :
                    showModus();
                    showMenuDua();

                case "2" :
                    showMeanMedianModus();
                    showMenuDua();

                case "3" :
                    showAll();
                    showMenuDua();

                case "0" :
                    System.exit(0);

                default :
                    System.out.println("Tolong pilih yang benerrr yaa");
                    this.showMainMenu();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override

    public void showMenuDua() {
        System.out.println("--------------------------------------------------");
        System.out.println("Aplikasi Pengolah Nilai Siswa");
        System.out.println("---------------------------------------------------");
        System.out.println("File telah digenerate di direktori yang sama dengan program, silahkan cek di folder resource");
        System.out.println();
        System.out.println("1. Kembali ke menu utama");
        System.out.println("0. Exit");
        System.out.print("---> ");
        String menuDua = scanner.nextLine();

        switch (menuDua.toLowerCase()){
            case "1" : showMainMenu();
            case "0" : System.exit(0);
            default :
                System.out.println("Tolong pilih yang benerrr yaaaaaaaaa");
                this.showMenuDua();
        }
    }
}