package com.span.leagueranking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LeagueManager leagueManager = new LeagueManager();

        // Try-with-resources ensures the Scanner is closed automatically
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter match results (type 'done' to finish):");

            while (true) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("done")) {
                    break;
                }
                leagueManager.processMatch(input);
            }
        }

        System.out.println("League Ranking:");
        leagueManager.printRanking();
    }
}

