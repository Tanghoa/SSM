package com.qst.bean;

public class Student {
    private Integer id;

    private String name;

    private String email;

    private Integer dId;

    private Department department;


    /**
     * @Description
     * @author Tanghoa
     * @date 2020年9月12日
     * @version 0.Max
     */



    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", email=" + email + ", dId=" + dId + ", department="
                + department + "]";
    }



}