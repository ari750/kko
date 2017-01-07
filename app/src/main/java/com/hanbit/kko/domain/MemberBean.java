package com.hanbit.kko.domain;

/**
 * Created by hb2012 on 2017-01-07.
 */

public class MemberBean {
    //스키마, 메타데이타. instance변수는 초기화 하지 않는다. 데이타베이스의 값을 저장하기 때문에. getter, setter 메서드 이용  alt+ins
    private String id;
    private String pw;
    private String name;
    private String email;
    private String phone;
    private String photo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAadr() {
        return aadr;
    }

    public void setAadr(String aadr) {
        this.aadr = aadr;
    }

    private String aadr;

}
