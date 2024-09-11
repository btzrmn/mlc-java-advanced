package animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String type = sc.nextLine();
            if (type.equals("Beast!")) {
                break;
            }
            String[] val = sc.nextLine().split("\\s+");
            try {

                switch (type) {
                    case "Dog":
                        Dog dog = new Dog(val[0], Integer.parseInt(val[1]), val[2]);
                        System.out.println(dog);
                        break;
                    case "Frog":
                        Frog frog = new Frog(val[0], Integer.parseInt(val[1]), val[2]);
                        System.out.println(frog);
                        break;
                    case "Cat":
                        Cat cat = new Cat(val[0], Integer.parseInt(val[1]), val[2]);
                        System.out.println(cat);
                        break;
                    case "Kitten":
                        Kitten kitten = new Kitten(val[0], Integer.parseInt(val[1]));
                        System.out.println(kitten);
                        break;
                    case "Tomcat":
                        Tomcat tomcat = new Tomcat(val[0], Integer.parseInt(val[1]));
                        System.out.println(tomcat);
                        break;
                    default:
                        throw new IllegalStateException("Invalid input!");
                }

            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
