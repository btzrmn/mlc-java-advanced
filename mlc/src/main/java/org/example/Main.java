package org.example;

public class Main {
    public static void main(String[] args) {
        Clinic clinic = new Clinic(20);
        Pet dog = new Pet("Ellias", 5, "Tim");
        System.out.println(dog);
        clinic.add(dog);

        System.out.println(clinic.remove("Ellias")); // true
        System.out.println(clinic.remove("Pufa")); // false

        Pet cat = new Pet("Bella", 2, "Mia");
        Pet bunny = new Pet("Zak", 4, "Jon");

        clinic.add(cat);
        clinic.add(bunny);

        Pet oldestPet = clinic.getOldestPet();
        System.out.println(oldestPet); // Zak 4 (Jon)

        Pet pet = clinic.getPet("Bella", "Mia");
        System.out.println(pet); // Bella 2 (Mia)

        System.out.println(clinic.getCount()); // 2

        System.out.println(clinic.getStatistics());


    }
}