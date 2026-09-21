package lw01.unguided;

public abstract class Rental implements Chargeable {
    private String id;
    private int days;
    
    protected Rental(String id, int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Jumlah hari tidak valid.");
        }

        this.id = id;
        this.days = days;
    }

    public String getId() {
        return this.id;
    }

    public int getDays() {
        return this.days;
    }

    @Override
    public abstract int calculateCharge();

    public int calculateCharge(int units) {
        if (units <= 0) {
            throw new IllegalArgumentException("Jumlah unit tidak valid.");
        }

        return units * calculateCharge();
    }

    public String label() {
        return "Rental";
    }

    public String summary() {
        return this.id + " | " + label() + " | " + calculateCharge();
    }
}

