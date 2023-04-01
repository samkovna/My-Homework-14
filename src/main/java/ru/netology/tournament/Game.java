package ru.netology.tournament;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {

    ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if ((player.getName()).equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(Player playerName1, Player playerName2) {
        if (findByName(playerName1.name) == null) {
            throw new NotRegisteredException(
                    "Игрок с ником " + playerName1.name + " не зарегистирован"
            );
        }
        if (findByName(playerName2.name) == null) {
            throw new NotRegisteredException(
                    "Игрок с ником " + playerName2.name + " не зарегистирован"
            );
        }
        Round point = new Round();
        return point.getPoint(playerName1, playerName2);
    }
}
