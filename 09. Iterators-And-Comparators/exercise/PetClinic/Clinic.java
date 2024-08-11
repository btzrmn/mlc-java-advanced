package class09.exercise.PetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Pet> rooms;
    private String name;
    private Integer size;
    private Integer centre;
    private Integer used;

    public Clinic(String name, Integer size) {
        if (size % 2 == 0) {
            throw new IllegalStateException("Invalid Operation!");
        }
        this.rooms = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            this.rooms.add(null);
        }
        this.name = name;
        this.size = size;
        this.centre = size / 2;
        this.used = 0;
    }

    public boolean add(Pet pet) {
        if (hasEmptyRoom()) {
            int current = this.centre;
            if (this.rooms.get(current) == null) {
                this.used++;
                this.rooms.set(current, pet);
                return true;
            }
            int step = 1;
            for (int i = 0; i < size / 2; i++) {
                current = centre - step;
                if (this.rooms.get(current) == null) {
                    this.used++;
                    this.rooms.set(current, pet);
                    return true;
                }
                current = centre + step;
                if (this.rooms.get(current) == null) {
                    this.used++;
                    this.rooms.set(current, pet);
                    return true;
                }
                step++;
            }
        }
        return false;
    }

    public boolean release() {
        if (used == 0) {
            return false;
        } else {
            int current = centre;
            while (true) {
                if (this.rooms.get(current) != null) {
                    this.rooms.set(current, null);
                    this.used--;
                    return  true;
                } else {
                    if(current == size - 1) {
                        current = 0;
                    } else {
                        current++;
                    }
                }
            }
        }
    }

    public boolean hasEmptyRoom() {
        return used != size;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            print(i);
        }
    }

    public void print(int room) {
        Pet pet = this.rooms.get(room);
        if (pet == null) {
            System.out.println("Room empty");
        } else {
            pet.print();
        }
    }

    public String getName() {
        return name;
    }

    public Integer getSize() {
        return size;
    }
}
