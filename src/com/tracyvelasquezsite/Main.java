package com.tracyvelasquezsite;

import java.util.*;

public class Main {

    public static void main(String[] args) {


//        sponsorLeagues("1,1", 5, 20000);
//        sponsorLeagues("1,1", 5, 1000);
//        sponsorLeagues("1,1", 5, 8000);
    }



    public static List<League> findLeagues(String coords, int radius, int budget) {

        List<League> leagues = new ArrayList<>();
        leagues.add(new League("The Wyld Stallions", "1,1", 5, 4500));
        leagues.add(new League("Team Zoidberg", "1,1", 5, 6000));
        leagues.add(new League("The Zoomers", "1,1", 5, 1500));
        leagues.add(new League("North Horseburg Little League", "1,1", 5, 3500));
        leagues.add(new League("The Duloc Ogres", "1,1", 5, 2500));
        List<League> acceptedLeagues = new ArrayList<>();

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