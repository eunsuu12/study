package edu.java.class03;

// class = field + constructor + method ==> data type
public class Rectangle {
    // field - 가로, 세로
    double width; // 직사각형의 가로 길이
    double height; // 직사각형의 세로 길이
    
    // constructor - 기본 생성자, argument 2개를 갖는 생성자
    public Rectangle() {}
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    // method - 둘레 길이, 넓이
    public double perimeter() {
        return 2 * (this.width + this.height);
    }
    
    public double area() {
        return this.width * this.height;
    }
    
}
