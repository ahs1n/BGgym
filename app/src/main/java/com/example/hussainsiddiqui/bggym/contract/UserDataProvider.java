package com.example.hussainsiddiqui.bggym.contract;

import java.io.Serializable;

public class UserDataProvider implements Serializable {
    private String name;
    private Long cell_no;
    private String email;
    private int id;

    public UserDataProvider() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCell_no() {
        return cell_no;
    }

    public void setCell_no(Long cell_no) {
        this.cell_no = cell_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
