package ru.netology.tournament;

public class Round {
    public int getPoint(Player playerName1, Player playerName2) {
        int strength1 = playerName1.getStrength();
        int strength2 = playerName2.getStrength();
        if (strength2 > strength1) {
            return 2;
        } else if (strength2 < strength1) {
            return 1;
        } else {
            return 0;
        }
    }
}
