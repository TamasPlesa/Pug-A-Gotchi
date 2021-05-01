package Jatek;

public class Jatek {

    private int penz;
    private int energia;
    private int elet;
    private int rendetlenseg;

    public Jatek(int penz, int energia, int elet, int rendetlenseg) {
        this.penz = penz;
        this.energia = energia;
        this.elet = elet;
        this.rendetlenseg = rendetlenseg;
    }

    public int getPenz() {
        return penz;
    }

    public int getEnergia() {
        return energia;
    }

    public int getElet() {
        return elet;
    }

    public int getRendetlenseg() {
        return rendetlenseg;
    }

    public void setPenz(int penz) {
        this.penz = penz;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public void setElet(int elet) {
        this.elet = elet;
    }

    public void setRendetlenseg(int rendetlenseg) {
        this.rendetlenseg = rendetlenseg;
    }
}
