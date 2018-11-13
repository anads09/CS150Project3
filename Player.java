/*
Austin Nadler
CS150-002
Program #3
11/13/2018
*/
package cs150proj03.game.sim;

import java.util.*;
import java.text.NumberFormat;

public class Player implements Comparable<Player>{
    private static final int HEAL_XP = 23;
    private static final int AREA_VISITED_XP = 200;
    private static final int PLAYER_ENCOUNTERED_XP = 175;
    private static final int MAP_CREATED_XP = 1500;
    private static final int ITEM_GATHERED_XP = 20;
    private static final int ITEM_REPAIRED_XP = 100;
    private static final int ITEMS_MERGED_XP = 125;
    private static final int TOP_SCORE_XP = 250;
    private static final int DAMAGE_DEALT_XP = 17;
    private static final int MAP_COMPLETED_XP = 750; 
    private final String name;
    private int playerLvl;
    public int totalXP, healerXP, explorerXP, socialiteXP, contributorXP, hoarderXP, fixerXP, joinerXP,leaderXP, punisherXP, obsessedXP;
                             //           tin  bronze silver  gold    platinum
    private Badge healerBadge = new Badge(2000, 10000, 30000, 100000, 200000);
    private Badge explorerBadge = new Badge(50, 1000, 5000, 17000, 40000);
    private Badge socialiteBadge = new Badge(100, 1000, 2000, 10000, 30000);
    private Badge contributorBadge = new Badge(3, 10, 20, 90, 150);
    private Badge hoarderBadge = new Badge(2000, 10000, 30000, 100000, 200000);
    private Badge fixerBadge = new Badge(100, 1000, 5000, 15000, 40000);
    private Badge joinerBadge = new Badge(100, 500, 2000, 10000, 40000);
    private Badge leaderBadge = new Badge(20, 10000, 30000, 100000, 300000);
    private Badge punisherBadge = new Badge(2000, 10000, 30000, 100000, 300000);
    private Badge obsessedBadge = new Badge(10, 50, 200, 500, 5000);
    
    public Player(String name) {
        this.name = name;
        playerLvl = 1;
        totalXP = 0;
        healerXP = 0;
        explorerXP = 0;
        socialiteXP = 0;
        contributorXP = 0;
        hoarderXP = 0;
        fixerXP = 0;
        joinerXP = 0;
        leaderXP = 0;
        punisherXP = 0;
        obsessedXP = 0;
    }
    
    public void doSomething() {
        int n = (int)(Math.random() * 10 + 1);
        switch(n) {
            case 1:
                healerXP++;
                totalXP += HEAL_XP;
                healerBadge.setValue(healerXP);
                calcPlayerLevel();
                break;
            case 2:
                explorerXP++;
                totalXP += AREA_VISITED_XP;
               explorerBadge.setValue(explorerXP);
               calcPlayerLevel();
                break;
            case 3:
                socialiteXP++;
                totalXP += PLAYER_ENCOUNTERED_XP;
                socialiteBadge.setValue(socialiteXP);
                calcPlayerLevel();
                break;
            case 4:
                contributorXP++;
                totalXP += MAP_CREATED_XP;
                contributorBadge.setValue(contributorXP);
                calcPlayerLevel();
                break;
            case 5:
                hoarderXP++;
                totalXP += ITEM_GATHERED_XP;
                hoarderBadge.setValue(hoarderXP);
                calcPlayerLevel();
                break;
            case 6:
                fixerXP++;
                totalXP += ITEM_REPAIRED_XP;
                fixerBadge.setValue(fixerXP);
                calcPlayerLevel();
                break;
            case 7:                
                joinerXP++;
                totalXP += ITEMS_MERGED_XP;
                 joinerBadge.setValue(joinerXP);
                 calcPlayerLevel();
                break;
            case 8:
                leaderXP++;
                totalXP += TOP_SCORE_XP;
                leaderBadge.setValue(leaderXP);
                calcPlayerLevel();
                break;
            case 9:
                punisherXP++;
                totalXP += DAMAGE_DEALT_XP;
                punisherBadge.setValue(punisherXP);
                calcPlayerLevel();
                break;
            case 10:
                obsessedXP++;
                totalXP += MAP_COMPLETED_XP;
                obsessedBadge.setValue(obsessedXP);
                calcPlayerLevel();
                break;                   
        }
    }
     public void calcPlayerLevel() {
        final int lvl2FLR = 10000;
        final int lvl3FLR = 25000;
        final int lvl4FLR = 80000;
        final int lvl5FLR = 150000;
        final int lvl6FLR = 300000;
        final int lvl7FLR = 1000000;
        final int lvl8FLR = 2200000;
        final int lvl9FLR = 4500000;
        final int lvl10FLR = 10000000;
        final int lvl11FLR = 20000000;
        final int lvl12FLR = 35000000;
            if (totalXP >= lvl12FLR)
                playerLvl = 12;
            else if (totalXP >= lvl11FLR)
                playerLvl = 11; 
            else if (totalXP >= lvl10FLR)
                playerLvl = 10;   
            else if (totalXP >= lvl9FLR)
                playerLvl = 9;       
            else if (totalXP >= lvl8FLR)
                playerLvl = 8;   
            else if (totalXP >= lvl7FLR)
               playerLvl = 7;
            else if (totalXP >= lvl6FLR)
                playerLvl = 6;    
            else if (totalXP >= lvl5FLR)
                playerLvl = 5;   
            else if (totalXP >= lvl4FLR)
               playerLvl = 4;  
            else if (totalXP >= lvl3FLR)
                playerLvl = 3;  
            else if( totalXP >= lvl2FLR)
                playerLvl = 2; 
            else
                playerLvl = 1;   
            }
    @Override
    public String toString() {
        String output = String.format("%10s: lvl%3d, points:%15s Stats: Health Points Restored=%d Areas Visited=%d Players Encountered=%d Maps Created=%d Items Gathered=%d Items Repaired=%d Items Merged=%d Top Scores=%d Damage Points Dealt=%d Maps Completed=%d%n                                           Badges: Healer:%s Explorer:%s Socialite:%s Contributor:%s Hoarder:%s Fixer %s Joiner:%s Leader:%s Punisher:%s Obsessed:%s", name, playerLvl, NumberFormat.getIntegerInstance(Locale.US).format(totalXP), healerXP, explorerXP, socialiteXP, contributorXP, hoarderXP, fixerXP, joinerXP, leaderXP, punisherXP, obsessedXP, healerBadge.value, explorerBadge.value, socialiteBadge.value, contributorBadge.value, hoarderBadge.value, fixerBadge.value, joinerBadge.value, leaderBadge.value, punisherBadge.value, obsessedBadge.value);
        return output;
    }
    
    @Override
    public int compareTo(Player otherGamerTest) {
        return Comparators.NAME.compare(this, otherGamerTest);
    }
    
    public static class Comparators {
        public static final Comparator<Player> NAME = (Player o1, Player o2) -> o1.name.compareTo(o2.name);
        public static final Comparator<Player> TOTALXP = (Player o1, Player o2) -> Integer.compare(o1.totalXP, o2.totalXP);
        public static final Comparator<Player> HEALTHS = (Player o1, Player o2) -> Integer.compare(o1.healerXP, o2.healerXP);
        public static final Comparator<Player> AREAS = (Player o1, Player o2) -> Integer.compare(o1.explorerXP, o2.explorerXP);
        public static final Comparator<Player> SOCIALS = (Player o1, Player o2) -> Integer.compare(o1.socialiteXP, o2.socialiteXP);
        public static final Comparator<Player> MAPMADES = (Player o1, Player o2) -> Integer.compare(o1.contributorXP, o2.contributorXP);
        public static final Comparator<Player> HOARDERS = (Player o1, Player o2) -> Integer.compare(o1.hoarderXP, o2.hoarderXP);
        public static final Comparator<Player> FIXERS = (Player o1, Player o2) -> Integer.compare(o1.fixerXP, o2.fixerXP);
        public static final Comparator<Player> JOINERS = (Player o1, Player o2) -> Integer.compare(o1.joinerXP, o2.joinerXP);
        public static final Comparator<Player> ASSAULTS = (Player o1, Player o2) -> Integer.compare(o1.punisherXP, o2.punisherXP);
        public static final Comparator<Player> OBSESSEDS = (Player o1, Player o2) -> Integer.compare(o1.obsessedXP, o2.obsessedXP);
    }
}
