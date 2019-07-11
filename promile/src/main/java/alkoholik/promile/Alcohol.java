package alkoholik.promile;

public enum Alcohol {

    BEER(0.05),
    VODKA(0.4),
    WINE(0.112),
    HOOCH(0.56);

    private double strength;

    Alcohol(double strength) {
        this.strength = strength;
    }

    public double getStrength() {

        return strength;
    }

    public void setStrength(double strength) {

        this.strength = strength;
    }
}
