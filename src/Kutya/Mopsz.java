package Kutya;

public class Mopsz {

    private int jollakottsag;
    private int egeszseg;
    private int kedv;
    private int energia;
    private int rendetlenseg;

    private String nev;
    private String tulajdonos;
    private int penz;

    public Mopsz(int jollakottsag, int egeszseg, int kedv, int energia, int rendetlenseg, String nev, String tulajdonos, int penz) {
        this.jollakottsag = jollakottsag;
        this.egeszseg = egeszseg;
        this.kedv = kedv;
        this.energia = energia;
        this.rendetlenseg = rendetlenseg;
        this.nev = nev;
        this.tulajdonos = tulajdonos;
        this.penz = penz;


    }

    public int getJollakottsag() {
        return jollakottsag;
    }

    public int getEgeszseg() {
        return egeszseg;
    }

    public int getKedv() {
        return kedv;
    }

    public int getEnergia() {
        return energia;
    }

    public int getRendetlenseg() {
        return rendetlenseg;
    }

    public String getNev() {
        return nev;
    }

    public String getTulajdonos() {
        return tulajdonos;
    }

    public int getPenz() {
        return penz;
    }

    public void setJollakottsag(int jollakottsag) {
        int checkedNumber = checkPercentage(jollakottsag);
        this.jollakottsag = checkedNumber; // igy a leellenorzott szamot adjuk vissza mar.
    }

    public void setEgeszseg(int egeszseg) {
        int checkedNumber = checkPercentage(egeszseg);
        this.egeszseg = checkedNumber;
    }

    public void setKedv(int kedv) {
        int checkedNumber = checkPercentage(kedv);
        this.kedv = checkedNumber;
    }

    public void setEnergia(int energia) {
        int checkedNumber = checkPercentage(energia);
        this.energia = checkedNumber;
    }

    public void setRendetlenseg(int rendetlenseg) {
        int checkedNumber = checkPercentage(rendetlenseg);
        this.rendetlenseg = checkedNumber;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setTulajdonos(String tulajdonos) {
        this.tulajdonos = tulajdonos;
    }

    public void setPenz(int penz) {
        this.penz = penz;
    }

    private int checkPercentage(int number) { //csekkoljuk hogy nagyobb-e 100%nál az adat, vagy kisebb, ha egyiksem akkor az aktuális számot adjuk
        if (number > 100) {
            return 100;
        }
        if (number < 0) {
            return 0;
        }
        return number;
    }

    @Override
    public String toString() {
        return "Mopsz{" +
                "jollakottsag=" + jollakottsag +
                ", egeszseg=" + egeszseg +
                ", kedv=" + kedv +
                ", energia=" + energia +
                ", rendetlenseg=" + rendetlenseg +
                ", nev='" + nev + '\'' +
                ", tulajdonos='" + tulajdonos + '\'' +
                ", penz=" + penz +
                '}';
    }
}
