package edu.java.inheritance09;

// 직사각형(가로, 세로)
public class Rectangle extends Shape {
    private double width;
    private double height;
    
    public Rectangle(String type, double width, double height) {
        super(type);
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
    
    @Override
    public double perimeter() {
        return (width + height) * 2;
    }
    
}
