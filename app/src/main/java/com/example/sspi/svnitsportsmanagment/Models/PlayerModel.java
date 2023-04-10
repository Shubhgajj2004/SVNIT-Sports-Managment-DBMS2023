package com.example.sspi.svnitsportsmanagment.Models;

public class PlayerModel {

    String teamName, rollNo, name;
    int point;

    PlayerModel(){}

    public PlayerModel(String teamName, String rollNo, String name, int point) {
        this.teamName = teamName;
        this.rollNo = rollNo;
        this.name = name;
        this.point = point;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
