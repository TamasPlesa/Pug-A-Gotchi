package Munka;

public class Munka {

    private int penz;
    private int energia;
    private int elet;

    public Munka(int penz, int energia, int elet) {
        this.penz = penz;
        this.energia = energia;
        this.elet = elet;
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

    public void setPenz(int penz) {
        this.penz = penz;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public void setElet(int elet) {
        this.elet = elet;
    }
}
