package fr.epsi.b32324c2.jdbc.entites;

public class Fournisseur {
    private final int id;
    private final String name;

    public Fournisseur(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name;
    }
}
