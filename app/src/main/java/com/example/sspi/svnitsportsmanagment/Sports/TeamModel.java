package com.example.sspi.svnitsportsmanagment.Models;

public class TeamModel {

    int teamId;
    String teamName;
    String deptName;
    int teamStrength;

    public TeamModel(int teamId, String teamName, String deptName, int teamStrength) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.deptName = deptName;
        this.teamStrength = teamStrength;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getTeamStrength() {
        return teamStrength;
    }

    public void setTeamStrength(int teamStrength) {
        this.teamStrength = teamStrength;
    }
}
