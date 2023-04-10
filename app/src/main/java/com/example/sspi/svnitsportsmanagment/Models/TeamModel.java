package com.example.sspi.svnitsportsmanagment.Models;

public class TeamModel {

    String teamId, teamName;
    int teamSize;

    TeamModel(){}

    public TeamModel(String teamId, String teamName, int teamSize) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamSize = teamSize;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }
}
