package fr.epsi.b32324c2.jdbc.entites;

public class Fournisseur {
    private int id;
    private String name;

    public Fournisseur() {

    }

    public Fournisseur(String name) {
        this.name = name;
    }

    public Fournisseur(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name;
    }
}
