package class11.exercise.TrafficLights;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] signals = sc.nextLine().split("\\s+");
        int n = Integer.parseInt(sc.nextLine());
        List<TrafficLight> trafficLights = Arrays.stream(signals)
                .map(Color::valueOf)
                .map(TrafficLight::new)
                .collect(Collectors.toList());

        for (int i = 0; i < n; i++) {
            for (TrafficLight trafficLight: trafficLights){
                trafficLight.changeColor();
                System.out.print(trafficLight.getColor() + " ");
            }
            System.out.println();
        }
    }
}
