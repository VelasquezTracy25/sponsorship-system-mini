package com.tracyvelasquezsite;

import java.util.*;

public class Main {

    public static List<League> leagues = new ArrayList<>();

    public static void main(String[] args) {

        leagues.add(new League("The Wyld Stallions", "1,1", 4500));
        leagues.add(new League("Team Zoidberg", "1,1", 6000));
        leagues.add(new League("The Zoomers", "1,1", 1500));
        leagues.add(new League("North Horseburg Little League", "1,1", 3500));
        leagues.add(new League("The Duloc Ogres", "1,1", 2500));

        addLeague("The Losers", "1,1", 2200);

        sponsorLeagues("1,1", 5, 20000);
        sponsorLeagues("1,1", 5, 1000);
        sponsorLeagues("1,1", 5, 8000);
    }


    public static void addLeague(String name, String coords, int price){
        leagues.add(new League(name, coords, price));
        for (League league : leagues) {
            System.out.println(league.getName());
        }
    }

    public static void sponsorLeagues(String coords, int radius, int budget) {
        List<League> acceptedLeagues = findLeagues(coords, radius, budget);

        int totalSpend = 0;

        for (League acceptedLeague : acceptedLeagues) {
            if (budget - acceptedLeague.getPrice() <= 0) {
                System.out.println("Your budget cannot sponsor a league.");
            }
            System.out.println("Name:" + acceptedLeague.getName());
            System.out.println("Price:" + acceptedLeague.getPrice());
            totalSpend = totalSpend + acceptedLeague.getPrice();
        }
        System.out.println("--------------------------------------");
        System.out.println("Total Budget Used: " + totalSpend);
        System.out.println("Total Budget Remaining: " + (budget - totalSpend));
    }

    public static List<League> findLeagues(String coords, int radius, int budget) {

        List<League> acceptedLeagues = new ArrayList<>();
        Collections.sort(leagues, Comparator.comparingInt(League::getPrice));

        for (League league : leagues) {
            if (budget - league.getPrice() <= 0)
                return acceptedLeagues;
            else if (league.getPrice() <= budget) {
                budget = budget - league.getPrice();
                acceptedLeagues.add(league);
            }
        }
        return acceptedLeagues;
    }

}