package shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public Double getPerimeter() {
        return this.perimeter;
    }

    protected void setArea(Double area) {
        this.area = area;
    }

    public Double getArea() {
        return this.area;
    }

    protected abstract void calculatePerimeter();

    protected abstract void calculateArea();
}
