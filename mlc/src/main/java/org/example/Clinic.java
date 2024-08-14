package org.example;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.data.size() < capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(item -> item.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : this.data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public Pet getOldestPet() {
        Pet old = this.data.get(0);
        for (Pet pet : this.data) {
            if (pet.getAge() > old.getAge()) {
                old = pet;
            }
        }
        return old;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder("The clinic has the following patients:\n");
        for (Pet pet : this.data) {
            sb.append(pet.getName()).append(" ").append(pet.getOwner()).append("\n");
        }
        return sb.toString();
    }
}
