package mlc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (capacity > data.size()) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(e -> e.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        List<Pet> exist = data.stream().filter(e -> e.getName().equals(name) && e.getOwner().equals(owner)).collect(Collectors.toList());
        if (!exist.isEmpty()) {
            return exist.get(0);
        }
        return null;
    }

    public Pet getOldestPet() {
        Pet pet = data.get(0);
        for (Pet e : data) {
            if (pet.getAge() < e.getAge()) {
                pet = e;
            }
        }
        return pet;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder str = new StringBuilder();
        str.append("The clinic has the following patients:\n");
        for (Pet pet : data) {
            str.append(pet.getName());
            str.append(" ");
            str.append(pet.getOwner());
            str.append("\n");
        }
        return str.toString().trim();
    }
}
