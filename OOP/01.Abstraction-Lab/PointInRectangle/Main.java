package class11.lab.PointInRectangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] points = sc.nextLine().split(" ");
        Point bottomLeft = new Point(Integer.parseInt(points[0]),Integer.parseInt(points[1]));
        Point topRight = new Point(Integer.parseInt(points[2]),Integer.parseInt(points[3]));
        Rectangle rectangle = new Rectangle(bottomLeft, topRight);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] pointArr = sc.nextLine().split(" ");
            Point point = new Point(Integer.parseInt(pointArr[0]),Integer.parseInt(pointArr[1]));
            System.out.println(rectangle.contains(point));
        }
    }
}
