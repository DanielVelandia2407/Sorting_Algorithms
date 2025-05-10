package model;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class Politico implements Comparable<Politico> {
    private final String id;
    private final LocalDate fechaNacimiento;
    private final double dineroARobar;

    public Politico(String id, LocalDate fechaNacimiento, double dineroARobar) {
        this.id = id;
        this.fechaNacimiento = fechaNacimiento;
        this.dineroARobar = dineroARobar;
    }

    public static Politico aleatorio() {
        String id = "P" + ThreadLocalRandom.current().nextInt(1000, 9999);
        int year = ThreadLocalRandom.current().nextInt(1950, 2000);
        int month = ThreadLocalRandom.current().nextInt(1, 13);
        int day = ThreadLocalRandom.current().nextInt(1, 28);
        LocalDate fn = LocalDate.of(year, month, day);
        double dinero = ThreadLocalRandom.current().nextDouble(1000, 1_000_000);
        return new Politico(id, fn, dinero);
    }

    public double getDineroARobar() {
        return dineroARobar;
    }

    @Override
    public int compareTo(Politico o) {
        return Double.compare(this.dineroARobar, o.dineroARobar);
    }

    @Override
    public String toString() {
        return id + " | Nac: " + fechaNacimiento + " | $" + String.format("%,.2f", dineroARobar);
    }
}
