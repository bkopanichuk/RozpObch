package oop.lab2.Task3;

public class Monk {
    enum Monastery {Guan_Yin, Guan_Yan}

    Monastery monastery;
    int qiEnergy;

    Monk(Monastery monastery, int qiEnergy) {
        this.monastery = monastery;
        this.qiEnergy = qiEnergy;
    }

    @Override
    public String toString() {
        return "\nMonk { \n" +
                " monastery = " + monastery +
                ", qiEnergy= " + qiEnergy +
                "\n}";
    }
}
