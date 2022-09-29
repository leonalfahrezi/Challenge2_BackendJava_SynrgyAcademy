package challenge.chapter2.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Perhitungan implements Rumus {

    //override dari class interface yang sudah dibuat (rumus)
    @Override
    public List<Integer> bacaCsv() {
        String line = "";
        String[] tempArr;
        List<Integer> tempList = new ArrayList<>();
        try {
            File file = new File("src/main/resources/data_sekolah.csv");
            FileReader Filereader = new FileReader(file);
            BufferedReader br = new BufferedReader(Filereader);
            String Line = br.readLine();

            while ((line = br.readLine()) != null) {
                tempArr = line.split(";");
                for (int i = 1; i < tempArr.length; i++) {
                    tempList.add(Integer.valueOf(tempArr[i]));
                }
                System.out.println(" ");
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempList;
    }


    @Override
    public double hitungMean(List<Integer> getList) {
        double jumlah = 0;
        double mean = 0;
        for (int i : getList) {
            jumlah += i;
        }
        mean = jumlah / getList.size();
        return mean;
    }


    @Override
    public double hitungMedian(List<Integer> getList) {
        double median = 0;
        if (getList.size() % 2 == 0) {
            double i = getList.get(getList.size() / 2);
            double j = getList.get(getList.size() / 2 - 1);
            median = (i + j) / 2;
        } else {
            median = getList.get(getList.size() / 2);
        }
        return median;
    }


    @Override
    public double hitungModus(List<Integer> getList) {
        double modus = 0;
        int counter = 1;
        for (int i : getList) {
            int freq = Collections.frequency(getList, i);
            if (freq > counter) {
                modus = i;
                counter = freq;
            }
        }
        return modus;
    }
}



