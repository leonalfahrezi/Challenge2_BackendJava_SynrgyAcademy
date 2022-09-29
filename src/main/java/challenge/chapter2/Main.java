/*-----------------------------------
Challenge Chapter 2
Nama  : Muhammad Leon Alfahrezi
Kelas : Back End Java B
------------------------------------*/

package challenge.chapter2;

import challenge.chapter2.model.Rumus;
import challenge.chapter2.model.KomponenMenu;
import challenge.chapter2.model.Perhitungan;
import challenge.chapter2.model.GenerateFileMenu;

public class Main {

    //class khusus untuk menampilkan main menu, dibuat objek terlebih dahulu

    public static void main(String[] args) {

        Rumus buatBacaFile = new Perhitungan();
        KomponenMenu buatMainMenu = new GenerateFileMenu(buatBacaFile);

        buatMainMenu.showMainMenu();

    }
}
