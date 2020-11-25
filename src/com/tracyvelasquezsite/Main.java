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

        returnAllLeagues(); //returns list of original 5 Leagues ascending by price

        sponsorLeagues("1,1", 5, 8000);
        // Should return The Zoomers, The Duloc Ogres, and The North Horseburg Little League

        addLeague("The Losers", "1,1", 2200);
        addLeague("The Boys", "1,1", 1100);
        addLeague("The Mighty Ducks", "1,1", 5600);

        returnAllLeagues(); //returns list of 8 leagues - minimum price $1100

        sponsorLeagues("1,1", 5, 15000);
        sponsorLeagues("1,1", 5, 1000); //should return "cannot sponsor" message
        sponsorLeagues("1,1", 5, 0); //should return "cannot sponsor" message
        sponsorLeagues("1,1", 5, 10000);
    }


    public static void addLeague(String name, String coords, int price) {
        leagues.add(new League(name, coords, price));
    }

    public static void sponsorLeagues(String coords, int radius, int budget) {
        List<League> acceptedLeagues = findLeagues(coords, radius, budget);

        int totalSpend = 0;


        if (acceptedLeagues.size() <= 0) {
            System.out.println("--------------------------------------");
            System.out.println("Your budget of $" + budget + " cannot be used to sponsor a league.");
            System.out.println("--------------------------------------");
        } else {
            System.out.println("--------------------------------------");
            for (League acceptedLeague : acceptedLeagues) {
                System.out.println("Name:" + acceptedLeague.getName());
                System.out.println("Price: $" + acceptedLeague.getPrice());
                totalSpend = totalSpend + acceptedLeague.getPrice();
            }
            System.out.println("Total Budget: $" + budget);
            System.out.println("Total Budget Used: $" + totalSpend);
            System.out.println("Total Budget Remaining: $" + (budget - totalSpend));
            System.out.println("--------------------------------------");
        }
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

    public static void returnAllLeagues() {
        Collections.sort(leagues, Comparator.comparingInt(League::getPrice));
        System.out.println("Here is the full list of leagues: ");
        for (int i = 0; i < leagues.size(); i++) {
            System.out.println("Name: " + leagues.get(i).getName());
            System.out.println("Price: $" + leagues.get(i).getPrice());
        }
    }

}