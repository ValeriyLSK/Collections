package ru.netology.domain;

import ru.netology.data.Player;
import ru.netology.exceptions.NotRegisteredException;

import java.util.*;

public class Game {
    Player player = new Player();
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
        Player player1 = (Player) findByName(playerName1);
        Player player2 = (Player) findByName(playerName2);

        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Player: " + playerName1 + " not registered");
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Player: " + playerName2 + " not registered");
        }
        int compare = player1.compareTo(player2);
        if (compare > 0) {
            return 1;
        } else if (compare < 0) {
            return 2;
        } else return 0;
    }
}
