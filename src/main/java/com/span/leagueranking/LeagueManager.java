package main.java.com.span.leagueranking;

import java.util.*;

public class LeagueManager {
    private Map<String, Team> teams;

    public LeagueManager() {
        teams = new HashMap<>();
    }

    // Process a match result and update teams' points
    public void processMatch(String result) {
        String[] parts = result.split(", ");
        String[] team1Result = parts[0].split(" ");
        String[] team2Result = parts[1].split(" ");
        
        String team1Name = String.join(" ", Arrays.copyOf(team1Result, team1Result.length - 1));
        int team1Score = Integer.parseInt(team1Result[team1Result.length - 1]);

        String team2Name = String.join(" ", Arrays.copyOf(team2Result, team2Result.length - 1));
        int team2Score = Integer.parseInt(team2Result[team2Result.length - 1]);

        Team team1 = teams.computeIfAbsent(team1Name, Team::new);
        Team team2 = teams.computeIfAbsent(team2Name, Team::new);

        if (team1Score > team2Score) {
            team1.addPoints(3); // Team1 wins
        } else if (team2Score > team1Score) {
            team2.addPoints(3); // Team2 wins
        } else {
            team1.addPoints(1); // Draw
            team2.addPoints(1); // Draw
        }
    }

    // Generate the ranking table
    public void printRanking() {
        List<Team> sortedTeams = new ArrayList<>(teams.values());
        Collections.sort(sortedTeams);

        int rank = 1;
        for (int i = 0; i < sortedTeams.size(); i++) {
            if (i > 0 && sortedTeams.get(i).getPoints() == sortedTeams.get(i - 1).getPoints()) {
                System.out.println(rank + ". " + sortedTeams.get(i));
            } else {
                rank = i + 1;
                System.out.println(rank + ". " + sortedTeams.get(i));
            }
        }
    }
}
