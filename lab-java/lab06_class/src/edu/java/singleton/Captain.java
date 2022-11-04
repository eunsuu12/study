package edu.java.singleton;

// 싱글톤(singleton): 오직 한 번만 생성될 수 있는 객체.
// singleton = (1) private static field + (2) private constructor + (3) public static method

public class Captain {
    // (1) private static Captain 타입 field
    // 생성할 Captain 타입 객체의 주소(참조)값을 저장하기 위한 필드.
    // 생성자 호출 전에 메모리 Method(Static) 영역에 생성되어 있어야 하는 필드.
    private static Captain instance = null;
    
    private String name = "캡틴 아메리카";
    
    // (2) private 생성자
    // -> 다른 클래스에서 생성자가 안 보임. -> 다른 클래스에서는 객체를 생성할 수 없음.
    private Captain() {}

    // (3) public static Captain 타입을 리턴하는 메서드
    // public - 어디에서나 호출할 수 있도록
    // static - 객체 생성 전에, 클래스 이름으로 참조해서 사용할 수 있도록
    // 리턴 타입 Captain - 생성한 Captain 타입 객체의 주로를 리턴. 
    public static Captain getInstance() {
        if (instance == null) {
            instance = new Captain();
        }
        
        return instance;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
}
