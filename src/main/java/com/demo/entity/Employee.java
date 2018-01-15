package com.demo.entity;


import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false,unique = true)
    private String employeeName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private int age;
    private String remark;
    @Transient
    private String otherName;

    public Employee(){

    }

    public Employee(String employeeName, String password, int age, String remark, String otherName) {
        this.employeeName = employeeName;
        this.password = password;
        this.age = age;
        this.remark = remark;
        this.otherName = otherName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
