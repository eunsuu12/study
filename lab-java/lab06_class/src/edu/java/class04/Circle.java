package edu.java.class04;

public class Circle {
    // field(멤버 변수, property) - 반지름
    double radius;
    
    // constructor - 기본 생성자, argument를 갖는 생성자
    public Circle() {}
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    // method - 둘레 길이(2 * 3.14 * r), 넓이(3.14 * r * r)
    public double perimeter() {
        return 2 * 3.14 * this.radius; // 2 * Math.PI * this.radius
    }
    
    public double area() {
        return 3.14 * this.radius * this.radius; // Math.PI * this.radius * this.radius
    }
    
}
