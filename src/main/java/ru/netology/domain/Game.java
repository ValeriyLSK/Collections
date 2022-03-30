package ru.netology.domain;

import ru.netology.data.Player;
import ru.netology.exceptions.NotRegisteredException;

import java.util.*;

public class Game {
    Collection<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public List findAll() {
        return (List) players;
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (player1 == null) {
            throw new NotRegisteredException("Player: " + playerName1 + " not registered");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Player: " + playerName2 + " not registered");
        }

        int compare = player1.compareTo(player2);
        if (compare > 0) {
            return 1;
        } else if (compare < 0) {
            return 2;
        } else {
            return 0;
        }
    }
}
