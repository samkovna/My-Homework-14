package ru.netology.tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void roundIfWinFirstPlayer() {
        Player player1 = new Player(3, "Andrey100", 4);
        Player player2 = new Player(77, "Katya777", 1);
        //Player player3 = new Player(9, "Vanya666", 99);
        //   Player player4 = new Player(50, "Masha1505", 5);

        Game listPlayers = new Game();
        listPlayers.register(player1);
        listPlayers.register(player2);

        int expected = 1;
        int actual = listPlayers.round(player1, player2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundIfWinSecondPlayer() {
        Player player1 = new Player(3, "Andrey100", 4);
        Player player2 = new Player(9, "Vanya666", 99);

        Game listPlayers = new Game();
        listPlayers.register(player1);
        listPlayers.register(player2);

        int expected = 2;
        int actual = listPlayers.round(player1, player2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundIfDrawnGame() {
        Player player1 = new Player(3, "Andrey100", 99);
        Player player2 = new Player(9, "Vanya666", 99);

        Game listPlayers = new Game();
        listPlayers.register(player1);
        listPlayers.register(player2);

        int expected = 0;
        int actual = listPlayers.round(player1, player2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundIfFirstPlayerNotRegistered() {
        Player player1 = new Player(3, "Andrey100", 4);
        Player player2 = new Player(9, "Vanya666", 99);

        Game listPlayers = new Game();
        listPlayers.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            listPlayers.round(player1, player2);
        });
    }

    @Test
    public void roundIfSecondPlayerNotRegistered() {
        Player player1 = new Player(3, "Andrey100", 4);
        Player player2 = new Player(9, "Vanya666", 99);

        Game listPlayers = new Game();
        listPlayers.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            listPlayers.round(player1, player2);
        });
    }
}