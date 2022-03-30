package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.data.Player;
import ru.netology.exceptions.NotRegisteredException;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Ivan", 100);
    Player player2 = new Player(2, "Anton", 95);
    Player player3 = new Player(3, "Roman", 31);
    Player player4 = new Player(4, "Valeriy", 100);
    Player player5 = new Player(5, "Alexandr", 96);
    Player player6 = new Player(6, "Sergey", 94);
    Player player7 = new Player(7, "Vadim", 99);
    Player player8 = new Player(8, "Anatoly", 20);

    @Test
    void shouldRegister() {
        game.register(player1);
        List expected = Arrays.asList(player1);
        List actual = game.findAll();
        assertEquals(expected, actual);
    }

    @Test
    void shouldRegisterBoundary() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);
        game.register(player7);
        List expected = List.of(player1, player2, player3, player4, player5, player6, player7);
        List actual = game.findAll();
        assertEquals(expected, actual);
    }

    @Test
    void shouldRegisterAll() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);
        game.register(player7);
        game.register(player8);
        List expected = List.of(player1, player2, player3, player4, player5, player6, player7, player8);
        List actual = game.findAll();
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByName() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);
        game.register(player7);
        game.register(player8);
        game.findByName("Valeriy");
        Player expected = player4;
        Player actual = game.findByName("Valeriy");
        assertEquals(expected, actual);
    }

    @Test
    void shouldRoundWinFirst() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);
        game.register(player7);
        game.register(player8);
        game.round("Valeriy", "Alexandr");
        int expected = 1;
        int actual = game.round("Valeriy", "Alexandr");
        assertEquals(expected, actual);
    }

    @Test
    void shouldRoundWinSecond() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);
        game.register(player7);
        game.register(player8);
        game.round("Anatoly", "Alexandr");
        int expected = 2;
        int actual = game.round("Anatoly", "Alexandr");
        assertEquals(expected, actual);
    }

    @Test
    void shouldRoundDraw() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);
        game.register(player7);
        game.register(player8);
        game.round("Ivan", "Valeriy");
        int expected = 0;
        int actual = game.round("Ivan", "Valeriy");
        assertEquals(expected, actual);
    }

    @Test
    void shouldRoundFirstPlayerNotRegistered() {
        game.register(player2);
        assertThrows(NotRegisteredException.class, () -> game.round("Ivan", "Anton"));
        return;
    }

    @Test
    void shouldRoundSecondPlayerNotRegistered() {
        game.register(player1);
        assertThrows(NotRegisteredException.class, () -> game.round("Ivan", "Anton"));
        return;
    }
}