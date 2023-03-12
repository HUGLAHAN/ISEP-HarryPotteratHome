package com.isep.hpah.core.belongings;

public class House {
    public static final House GRYFFINDOR = new House("Gryffindor", "Godric Gryffindor", "lion", "rouge et or");
    public static final House SLYTHERIN = new House("Slytherin", "Salazar Serpentard", "serpent", "vert et argent");
    public static final House HUFFLEPUFF = new House("Hufflepuff", "Helga Poufsouffle", "blaireau", "jaune et noir");
    public static final House RAVENCLAW = new House("Ravenclaw", "Rowena Serdaigle", "aigle", "bleu et bronze");

    private String name;
    private String founder;
    private String animal;
    private String colors;

    public House(String name, String founder, String animal, String colors) {
        this.name = name;
        this.founder = founder;
        this.animal = animal;
        this.colors = colors;
    }

    // getters and setters
}
