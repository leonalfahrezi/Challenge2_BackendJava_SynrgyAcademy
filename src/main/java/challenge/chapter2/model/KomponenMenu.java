package challenge.chapter2.model;

public interface KomponenMenu {

    void showModus(); //method buat pilihan 1 pada main menu untuk generate modus (frekuensi)

    void showMeanMedianModus(); //method buat pilihan 2 pada main menu untuk generate mean, median, modus

    void showAll(); //method buat pilihan 3 pada main menu untuk generate keduanya

    void showMainMenu(); //method untuk menampilkan main menu

    void showMenuDua(); //method untuk menampilkan menu kedua (nested method)

}
