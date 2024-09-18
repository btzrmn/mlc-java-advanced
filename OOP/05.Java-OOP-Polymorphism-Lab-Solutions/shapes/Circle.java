package shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.setRadius(radius);
        this.calculatePerimeter();
        this.calculateArea();
    }

    private void setRadius(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return radius;
    }

    protected void calculatePerimeter() {
        this.setArea(2 * Math.PI * this.radius);
    }

    protected void calculateArea() {
        this.setArea(Math.PI * this.radius * this.radius);
    }
}
