package class06.lab.problem3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Integer, BankAccount> accounts = new HashMap<>();

        while (!input.equals("End")) {
            String[] tokens = input.split(" ");
            switch (tokens[0]) {
                case "Create": {
                    BankAccount account = new BankAccount();
                    accounts.put(account.getId(), account);
                    break;
                }
                case "Deposit": {
                    if (accounts.containsKey(Integer.parseInt(tokens[1]))) {
                        BankAccount account = accounts.get(Integer.parseInt(tokens[1]));
                        account.deposit(Double.parseDouble(tokens[2]));
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                }
                case "SetInterest":
                    BankAccount.setInterestRate(Double.parseDouble(tokens[1]));
                    break;
                case "GetInterest": {
                    if (accounts.containsKey(Integer.parseInt(tokens[1]))) {
                        BankAccount account = accounts.get(Integer.parseInt(tokens[1]));
                        double interest = account.getInterest(Integer.parseInt(tokens[2]));
                        System.out.printf("%.2f%n", interest);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                }
                default:
                    System.out.println("Invalid command");
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
