package br.com.cod3r.cm.visao;

public class Score {
    private int wins = 0;
    private int losses = 0;

    public void incrementWins() {
        wins++;
    }

    public void incrementLosses() {
        losses++;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }
}