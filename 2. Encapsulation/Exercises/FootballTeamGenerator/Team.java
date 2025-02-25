package Encapsulation.Exercises.FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team
{
    private String name;
    private List<Player> players;

    public Team(String name)
    {
        setName(name);
        this.players = new ArrayList<>();
    }

    public void setName(String name)
    {
        if(name == null || name.trim().isEmpty())
        {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void addPlayer(Player player)
    {
        players.add(player);
    }

    public void removePlayer(String playerName)
    {
        Player playerToRemove = players.stream()
                .filter(player -> player.getName().equals(playerName))
                .findFirst()
                .orElse(null);

        if(playerToRemove != null)
        {
            players.remove(playerToRemove);
        }
        else
        {
            System.out.println("Player " + playerName + " is not in " + name + " team.");
        }
    }

    public double getRating()
    {
        if(players.isEmpty())
        {
            return 0;
        }
        return players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0);
    }
}
