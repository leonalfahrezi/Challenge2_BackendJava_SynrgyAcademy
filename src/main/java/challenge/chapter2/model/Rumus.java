package challenge.chapter2.model;

import java.util.List;

public interface Rumus {

    List<Integer> bacaCsv(); //method buat baca file csv

    double hitungMean(List<Integer> getList); //method buat hitung mean

    double hitungMedian(List<Integer> getList); //method buat hitung median

    double hitungModus(List<Integer> getList); //method buat hitung modus

}
