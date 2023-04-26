package com.example.sspi.svnitsportsmanagment.Models;

public class PlayerModel {

    String playerName;
    String playerId;
    String teamName;
    int score;

    public PlayerModel(String playerName, String playerId, String teamName, int score) {
        this.playerName = playerName;
        this.playerId = playerId;
        this.teamName = teamName;
        this.score = score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
