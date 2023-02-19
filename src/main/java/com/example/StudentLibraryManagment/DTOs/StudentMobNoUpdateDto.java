package com.example.StudentLibraryManagment.DTOs;

public class StudentMobNoUpdateDto {


    private int id;

    private String mobNo;

    public StudentMobNoUpdateDto(){


    }

    public StudentMobNoUpdateDto(int id, String mobNo) {
        this.id = id;
        this.mobNo = mobNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }
}
