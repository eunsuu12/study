package edu.java.modifier04;

/*
 * field: 아이디, 비밀번호.
 * constructor: argument 2개를 갖는 생성자.
 * method: 아이디 getter, 비밀번호 getter/setter
 */
public class Member {
    // field
    private String memberId;
    private String password;
    
    // constructor
    public Member(String memberId, String password) {
        this.memberId = memberId;
        this.password = password;
    }
    
    // getter/setter
    public String getMemberId() {
        return this.memberId;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
