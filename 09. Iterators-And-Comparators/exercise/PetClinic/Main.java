package class09.exercise.PetClinic;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Pet> pets = new LinkedHashMap<>();
        HashMap<String, Clinic> clinics = new LinkedHashMap<>();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] token = sc.nextLine().split("\\s+");
            switch (token[0]) {
                case "Create":
                    if (token[1].equals("Pet")) {
                        Pet pet = new Pet(token[2], Integer.parseInt(token[3]), token[4]);
                        pets.put(token[2], pet);
                    } else if (token[1].equals("Clinic")) {
                        try {
                            Clinic clinic = new Clinic(token[2], Integer.parseInt(token[3]));
                            clinics.put(token[2], clinic);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "Add": {
                    Pet pet = pets.get(token[1]);
                    Clinic clinic = clinics.get(token[2]);
                    System.out.println(clinic.add(pet));
                    break;
                }
                case "Release": {
                    Clinic clinic = clinics.get(token[1]);
                    System.out.println(clinic.release());
                    break;
                }
                case "HasEmptyRooms": {
                    Clinic clinic = clinics.get(token[1]);
                    System.out.println(clinic.hasEmptyRoom());
                    break;
                }
                case "Print": {
                    if (token.length == 2) {
                        Clinic clinic = clinics.get(token[1]);
                        clinic.print();
                    } else {
                        Clinic clinic = clinics.get(token[1]);
                        clinic.print(Integer.parseInt(token[2]) - 1);
                    }
                    break;
                }
            }
        }
    }
}
