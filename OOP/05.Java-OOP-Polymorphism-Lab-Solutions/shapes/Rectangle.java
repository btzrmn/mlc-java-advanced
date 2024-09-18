package shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double heightw, Double width) {
        this.setHeight(height);
        this.setWidth(width);
        this.calculatePerimeter();
        this.calculateArea();
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(this.height * 2 + this.width * 2);
    }

    @Override
    protected void calculateArea() {
        setArea(this.height * this.width);
    }

    private void setHeight(Double height) {
        this.height = height;
    }

    public Double getHeight() {
        return height;
    }

    private void setWidth(Double width) {
        this.width = width;
    }

    public Double getWidth() {
        return width;
    }
}

