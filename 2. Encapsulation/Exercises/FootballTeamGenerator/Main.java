package Encapsulation.Exercises.FootballTeamGenerator;

import java.util.HashMap;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Team> teams = new HashMap<>();

        String input = scanner.nextLine();
        while(!input.equals("END"))
        {
            String[] commandParts = input.split(";");

            String command = commandParts[0];
            if(command.equals("Team"))
            {
                String teamName = commandParts[1];
                teams.put(teamName, new Team(teamName));
            }
            else if(command.equals("Add"))
            {
                String teamName = commandParts[1];
                String playerName = commandParts[2];
                int endurance = Integer.parseInt(commandParts[3]);
                int sprint = Integer.parseInt(commandParts[4]);
                int dribble = Integer.parseInt(commandParts[5]);
                int passing = Integer.parseInt(commandParts[6]);
                int shooting = Integer.parseInt(commandParts[7]);

                if(!teams.containsKey(teamName))
                {
                    System.out.println("Team " + teamName + " does not exist.");
                }
                else
                {
                    try
                    {
                        Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                        teams.get(teamName).addPlayer(player);
                    }
                    catch(IllegalArgumentException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
            }
            else if(command.equals("Remove"))
            {
                String teamName = commandParts[1];
                String playerName = commandParts[2];

                if(!teams.containsKey(teamName))
                {
                    System.out.println("Team " + teamName + " does not exist.");
                }
                else
                {
                    teams.get(teamName).removePlayer(playerName);
                }
            }
            else if(command.equals("Rating"))
            {
                String teamName = commandParts[1];

                if(!teams.containsKey(teamName))
                {
                    System.out.println("Team " + teamName + " does not exist.");
                }
                else
                {
                    int rating = (int) Math.round(teams.get(teamName).getRating());
                    System.out.println(teamName + " - " + rating);
                }
            }

            input = scanner.nextLine();
        }
    }
}
