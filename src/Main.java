import Egeszseg.AllatOrvos;
import Egeszseg.EletCsomag;
import Egeszseg.KisEletCsomag;
import Egeszseg.NagyEletCsomag;
import Etel.Etel;
import Etel.Csont;
import Etel.Hazikoszt;
import Etel.Jutalomfalatka;
import Etel.KonzervKutyaeledel;
import Etel.KutyaEnergiaital;
import Etel.SzarazKutyatap;
import Etel.Viz;
import Etel.MaximalizaloItal;
import Jatek.Jatek;
import Jatek.JatekAParkban;
import Jatek.Kutyaiskola;
import Jatek.LabdasJatek;
import Jatek.Setaltatas;
import Munka.Munka;
import Munka.Hazorzes;
import Munka.RendoriSegitseg;
import Munka.Ujsagkihordas;



import Kutya.Mopsz;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
// > <
        Mopsz mopsz = new Mopsz(62, 62, 62, 62, 62, "Bodri", "Plesa", 1500);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Add meg a neved: ");
        String tulajdonos = scanner.nextLine();
        mopsz.setTulajdonos(tulajdonos);

        System.out.println("Add meg a mopszod nevét: ");
        String nev = scanner.nextLine();
        mopsz.setNev(nev);


        int rounds = 0;
        while (rounds < 100 && mopsz.getPenz() < 10000) { // (addig fusson amég kisebb, vagy kevesebb) ha elérjük a 100 kört vagy a 10000 pénzt,. akkor vége a játéknak

            boolean run = true;

            boolean koszos = new Random().nextInt(100-0) < 40; // ha kisebb mint 40 akkor koszos

            rounds++;
            System.out.println(rounds + ". körben vagy");

            while (run) { //ez fut "örökké"
                if (mopsz.getPenz() >= 10000) { //a külső a 100 kört számolja,
                    break;
                }
                System.out.println(mopsz);
                System.out.println("Mit szeretnél csinálni a mopszoddal? (Etetés, játék, munka, gyógyítás)");
                String cselekmeny = scanner.nextLine();

                if (koszos) {
                    while (koszos) {
                        System.out.println("Koszos a kutyád, meg kell fürdetned! írd be hogy furdetes");
                        String furdetes = scanner.nextLine();
                        if (furdetes.equals("furdetes")) {
                            System.out.println("Tiszta a kutyád, folytathatod a játékot.");
                            koszos = false;
                        } else {
                            System.out.println("A kutyád koszos maradt, légyszives fürdesd meg"); // ha nem irja be hogy furdetes, akkor ezt kapja, koszos maradt a kutya
                        }
                    }
                }

                switch (cselekmeny) {
                    case "kor vege":
                        run = false; //belső whileból kilép, külső újraindul (uj kor)
                        break;
                    case "alvas":
                        alvas(mopsz);
                        run = false;

                        break;
                    case "etetes":
                        etetes(scanner, mopsz);
                        break;
                    case "jatek":
                        jatek(scanner, mopsz);
                        break;
                    case "munka":
                        if (mopsz.getRendetlenseg() < 40) {
                            munka(scanner, mopsz);
                        } else {
                            System.out.println("A kutyád nem rendetlen, ne dolgoztasd feleslegesen");
                        }
                        break;
                    case "gyogyitas":
                        if (mopsz.getEgeszseg() == 100) {
                            System.out.println("A mopszod makk egészséges!!!");
                        } else {
                            gyogyitas(scanner, mopsz);
                        }
                        break;
                }
            }
        }
        if (rounds == 100) {
            System.out.println("Elérted a 100 kört, vége a játéknak");
        } else {
            System.out.println("Mopszodnak több mint 10.000 pénze van, vége a játéknak");
        }
    }

    private static void alvas(Mopsz mopsz) {
        mopsz.setEnergia(mopsz.getEnergia() + new Random().nextInt(50-30) + 30);
        mopsz.setJollakottsag(mopsz.getJollakottsag() - 8);
        mopsz.setEgeszseg(mopsz.getEgeszseg() - 5);
    }

    private static void etetes(Scanner scanner, Mopsz mopsz) {
        System.out.println("Milyen ételt szeretnél adni?");
        String etel = scanner.nextLine();
        Etel kaja = getEtel(etel);
        if (kaja instanceof KutyaEnergiaital) {
            mopsz.setEnergia(mopsz.getEnergia() + 15);
        }
        mopsz.setJollakottsag(mopsz.getJollakottsag() + kaja.getJollakottsag());
        mopsz.setPenz(mopsz.getPenz() - kaja.getAr());
        mopsz.setEnergia(mopsz.getEnergia() - 3);  //minden etel elfogyasztasakor 3 %-ot csokken az energia
        if (kaja instanceof MaximalizaloItal) {
            mopsz.setEnergia(100);
            mopsz.setJollakottsag(100);
            mopsz.setEgeszseg(100);
            mopsz.setKedv(100);
            mopsz.setRendetlenseg(100);
        }
    }

    private static Etel getEtel(String etel) {
        switch (etel) {
            case "csont":
                return new Csont();
            case "hazikoszt":
                return new Hazikoszt();
            case "jutalomfalatka":
                return new Jutalomfalatka();
            case "konzerv kutyaeledel":
                return new KonzervKutyaeledel();
            case "kutya energiaital":
                return new KutyaEnergiaital();
            case "szaraz kutyatap":
                return new SzarazKutyatap();
            case "maximalizalo ital":
                return new MaximalizaloItal();
            case "viz":
                return new Viz();
            default:
                return new Etel(0, 0);
        }
    }
    //static mainen kivul csak static fv-t tudsz hivni.
    private static void jatek(Scanner scanner, Mopsz mopsz) {
        System.out.println("Mit szeretnél játszani?");
        String jatekString = scanner.nextLine();
        Jatek jatek = getJatek(jatekString); //stringbol visszaadom a megfelelo osztalyt
        mopsz.setPenz(mopsz.getPenz() - jatek.getPenz()); //a mopsznak a pénzéből megy minden
        mopsz.setEnergia(mopsz.getEnergia() - jatek.getEnergia());
        mopsz.setEgeszseg(mopsz.getEgeszseg() - jatek.getElet());
        mopsz.setRendetlenseg(mopsz.getRendetlenseg() - jatek.getRendetlenseg());
    }

    private static Jatek getJatek(String jatek) {
        switch (jatek) {
            case "jatek a parkban":
                return new JatekAParkban();
            case "kutyaiskola":
                return new Kutyaiskola();
            case "labdas jatek":
                return new LabdasJatek();
            case "setaltatas":
                return new Setaltatas();
            default:
                return new Jatek(0, 0, 0, 0);
        }
    }

    private static void munka(Scanner scanner, Mopsz mopsz) {
        System.out.println("Mit dolgozzon a kutyád?");
        String munkaString = scanner.nextLine();
        Munka munka = getMunka(munkaString); //stringbol visszaadom a megfelelo osztalyt
        mopsz.setPenz(mopsz.getPenz() + munka.getPenz());
        mopsz.setEnergia(mopsz.getEnergia() - munka.getEnergia());
        mopsz.setEgeszseg(mopsz.getEgeszseg() - munka.getElet());
    }

    private static Munka getMunka(String munka) {
        switch (munka) {
            case "ujsagkihordas":
                return new Ujsagkihordas();
            case "rendori segitseg":
                return new RendoriSegitseg();
            case "hazorzes":
                return new Hazorzes();
            default:
                return new Munka(0, 0, 0);
        }
    }

    private static void gyogyitas(Scanner scanner, Mopsz mopsz) {
        System.out.println("Mivel szeretnéd gyógyítani a mopszod?");
        String egeszsegString = scanner.nextLine();
        EletCsomag eletCsomag = getEletCsomag(egeszsegString); //stringbol visszaadom a megfelelo osztalyt
        mopsz.setPenz(mopsz.getPenz() - eletCsomag.getAr());
        mopsz.setEgeszseg(mopsz.getEgeszseg() + eletCsomag.getEletero());
    }

    private static EletCsomag getEletCsomag(String egeszseg) {
        switch (egeszseg) {
            case "allatorvos":
                return new AllatOrvos();
            case "kis elet csomag":
                return new KisEletCsomag();
            case "nagy elet csomag":
                return new NagyEletCsomag();
            default:
                return new EletCsomag(0, 0);
        }
    }

}


