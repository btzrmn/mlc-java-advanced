package oop04.exercise.MilitaryElite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Soldier> soldierList = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split(" ");
            String soldierType = tokens[0];
            int id = Integer.parseInt(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];
            switch (soldierType) {
                case "Private":
                    PrivateImpl privateImpl = new PrivateImpl(id, firstName, lastName, Double.parseDouble(tokens[4]));
                    soldierList.add(privateImpl);
                    break;
                case "LieutenantGeneral":
                    LieutenantGeneralImpl lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, Double.parseDouble(tokens[4]));
                    String[] ids = getIds(tokens);
                    addPrivate(soldierList, lieutenantGeneral, ids);
                    soldierList.add(lieutenantGeneral);
                    break;
                case "Engineer":
                    try {
                        EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, Double.parseDouble(tokens[4]), tokens[5]);
                        String[] parts = getParts(tokens);
                        addRepair(engineer, parts);
                        soldierList.add(engineer);
                    } catch (IllegalArgumentException e) {

                    }
                    break;
                case "Commando":
                    try {
                        CommandoImpl commando = new CommandoImpl(id, firstName, lastName, Double.parseDouble(tokens[4]), tokens[5]);
                        String[] missions = getParts(tokens);
                        addMission(commando, missions);
                        soldierList.add(commando);
                    } catch (IllegalArgumentException e) {

                    }
                    break;
                case "Spy":
                    SpyImpl spy = new SpyImpl(id, firstName, lastName, tokens[4]);
                    soldierList.add(spy);
                    break;
            }
            input = scanner.nextLine();
        }

        soldierList.forEach(s -> System.out.println(s));
    }

    public static void addPrivate(List<Soldier> soldierList, LieutenantGeneralImpl general, String[] ids) {
        for (String id : ids) {
            Soldier soldier = soldierList.stream().filter(s -> s.getId() == Integer.parseInt(id)).findFirst().get();
            general.addPrivate(soldier);
        }
    }

    public static void addRepair(EngineerImpl engineer, String[] parts) {
        for (int i = 0; i < parts.length; i = i + 2) {
            String partName = parts[i];
            int hours = Integer.parseInt(parts[i + 1]);
            RepairImpl repair = new RepairImpl(partName, hours);
            engineer.addRepair(repair);
        }
    }

    public static void addMission(CommandoImpl commando, String[] missions) {
        for (int i = 0; i < missions.length; i = i + 2) {
            String name = missions[i];
            String state = missions[i + 1];
            try {
                MissionImpl mission = new MissionImpl(name, state);
                commando.addMission(mission);
            } catch (IllegalArgumentException e) {

            }
        }
    }


    public static String[] getIds(String[] tokens) {
        String[] ids = new String[tokens.length - 5];
        System.arraycopy(tokens, 5, ids, 0, ids.length);
        return ids;
    }

    public static String[] getParts(String[] tokens) {
        String[] parts = new String[tokens.length - 6];
        System.arraycopy(tokens, 6, parts, 0, parts.length);
        return parts;
    }
}
