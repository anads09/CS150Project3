/*
Austin Nadler
CS150-002
Program #3
11/13/2018
*/
package cs150proj03;

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
    private static final String NO_BADGE = "None";
    private static final String TIN_BADGE = "Tin";
    private static final String BRONZE_BADGE = "Bronze";
    private static final String SILVER_BADGE = "Silver";
    private static final String GOLD_BADGE = "Gold";
    private static final String PLAT_BADGE = "Platinum";   
    
    private final String name;
    private int playerLvl;
    private int totalXP, healerXP, explorerXP, socialiteXP, contributorXP, hoarderXP, fixerXP, joinerXP,leaderXP, punisherXP, obsessedXP;
    private String healerBadge, explorerBadge, socialiteBadge, contributorBadge, hoarderBadge, fixerBadge, joinerBadge,leaderBadge,punisherBadge, obsessedBadge; 

    public Player(String name) {
        this.name = name;
        playerLvl = 0;
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
        healerBadge = NO_BADGE;
        explorerBadge = NO_BADGE;
        socialiteBadge = NO_BADGE;
        contributorBadge = NO_BADGE;
        hoarderBadge = NO_BADGE;
        fixerBadge = NO_BADGE;
        joinerBadge = NO_BADGE;
        leaderBadge = NO_BADGE;
        punisherBadge = NO_BADGE;
        obsessedBadge = NO_BADGE;
    }
    
    public void doSomething() {
        int n = (int) (Math.random() * 10 + 1);
        switch(n) {
            case 1:
                heal();
                break;
            case 2:
                explore();
                break;
            case 3:
                encounterPlayer();
                break;
            case 4:
                createMap();
                break;
            case 5:
                gatherItem();
                break;
            case 6:
                itemRepaired();
                break;
            case 7:
                mergeItems();
                break;
            case 8:
                topScore();
                break;
            case 9:
                assault();
                break;
            case 10:
                completeMap();
                break;
            default: 
                break;                         
        }
    }
    
    public void heal() {
        healerXP++;
        totalXP += HEAL_XP;
        final int TINBADGEXP = 2000;
        final int BRONZEBADGEXP = 10000;
        final int SILVERBADGEXP = 30000;
        final int GOLDBADGEXP = 10000;
        final int PLATBADGEXP = 200000;
        if(healerXP <= TINBADGEXP)
            healerBadge = TIN_BADGE;
        else if (healerXP <= BRONZEBADGEXP)
            healerBadge = BRONZE_BADGE;
        else if (healerXP <= SILVERBADGEXP)
            healerBadge = SILVER_BADGE;
        else if (healerXP <= GOLDBADGEXP)
            healerBadge = GOLD_BADGE;
        else if (healerXP >= PLATBADGEXP) 
            healerBadge = PLAT_BADGE;
        calculatePlayerLevel();
    }
    
    public void explore() {
        explorerXP++;
        totalXP += AREA_VISITED_XP;
        final int BRONZEBADGEXP = 1000;
        final int SILVERBADGEXP = 5000;
        final int GOLDBADGEXP = 17000;
        final int PLATBADGEXP = 40000;        
        if (explorerXP <= BRONZEBADGEXP)
            explorerBadge = BRONZE_BADGE;
        else if (explorerXP <= SILVERBADGEXP)
            explorerBadge = SILVER_BADGE;
        else if (explorerXP <= GOLDBADGEXP)
            explorerBadge = GOLD_BADGE;
        else if (explorerXP >= PLATBADGEXP) 
            explorerBadge = PLAT_BADGE;
        calculatePlayerLevel();
        
    }
    
    public void encounterPlayer () {
        socialiteXP++;
        totalXP += PLAYER_ENCOUNTERED_XP;
        final int TINBADGEXP = 100;
        final int BRONZEBADGEXP = 1000;
        final int SILVERBADGEXP = 2000;
        final int GOLDBADGEXP = 10000;
        final int PLATBADGEXP = 30000;
        if(socialiteXP <= TINBADGEXP)
            socialiteBadge = TIN_BADGE;
        else if (socialiteXP <= BRONZEBADGEXP)
            socialiteBadge = BRONZE_BADGE;
        else if (socialiteXP <= SILVERBADGEXP)
            socialiteBadge = SILVER_BADGE;
        else if (socialiteXP <= GOLDBADGEXP)
            socialiteBadge = GOLD_BADGE;
        else if (socialiteXP >= PLATBADGEXP)
            socialiteBadge = PLAT_BADGE;
        calculatePlayerLevel();
    }
    
    public void createMap() {
        contributorXP++;
        totalXP += MAP_CREATED_XP;
        final int TINBADGEXP = 3;
        final int BRONZEBADGEXP = 10;
        final int SILVERBADGEXP = 20;
        final int GOLDBADGEXP = 90;
        final int PLATBADGEXP = 150;
        if(contributorXP >= TINBADGEXP)
            contributorBadge = TIN_BADGE;
        else if (contributorXP >= BRONZEBADGEXP)
            contributorBadge = BRONZE_BADGE;
        else if (contributorXP >= SILVERBADGEXP)
            contributorBadge = SILVER_BADGE;
        else if (contributorXP >= GOLDBADGEXP)
            contributorBadge = GOLD_BADGE;
        else if (contributorXP >= PLATBADGEXP) 
            contributorBadge = PLAT_BADGE;
        calculatePlayerLevel();
    }
    
    public void gatherItem() {
        hoarderXP++;
        totalXP += ITEM_GATHERED_XP;
        final int TINBADGEXP = 2000;
        final int BRONZEBADGEXP = 10000;
        final int SILVERBADGEXP = 30000;
        final int GOLDBADGEXP = 100000;
        final int PLATBADGEXP = 200000;
        if(hoarderXP <= TINBADGEXP)
            hoarderBadge = TIN_BADGE;
        else if (hoarderXP <= BRONZEBADGEXP)
            hoarderBadge = BRONZE_BADGE;
        else if (hoarderXP <= SILVERBADGEXP)
            hoarderBadge = SILVER_BADGE;
        else if (hoarderXP <= GOLDBADGEXP)
            hoarderBadge = GOLD_BADGE;
        else if (hoarderXP >= PLATBADGEXP) 
            hoarderBadge = PLAT_BADGE;
        calculatePlayerLevel();
    }
    
    public void itemRepaired() {
        fixerXP++;
        totalXP += ITEM_REPAIRED_XP;
        final int TINBADGEXP = 100;
        final int BRONZEBADGEXP = 1000;
        final int SILVERBADGEXP = 5000;
        final int GOLDBADGEXP = 15000;
        final int PLATBADGEXP = 40000;
        if(fixerXP <= TINBADGEXP)
            fixerBadge = TIN_BADGE;
        else if (fixerXP <= BRONZEBADGEXP)
            fixerBadge = BRONZE_BADGE;
        else if (fixerXP <= SILVERBADGEXP)
            fixerBadge = SILVER_BADGE;
        else if (fixerXP <= GOLDBADGEXP)
            fixerBadge = GOLD_BADGE;
        else if (fixerXP >= PLATBADGEXP) 
            fixerBadge = PLAT_BADGE;
        calculatePlayerLevel();
    }
    
    public void mergeItems() {
        joinerXP++;
        totalXP += ITEMS_MERGED_XP;
        final int TINBADGEXP = 100;
        final int BRONZEBADGEXP = 1000;
        final int SILVERBADGEXP = 5000;
        final int GOLDBADGEXP = 15000;
        final int PLATBADGEXP = 40000;
        if(joinerXP <= TINBADGEXP)
            joinerBadge = TIN_BADGE;
        else if (joinerXP <= BRONZEBADGEXP)
            joinerBadge = BRONZE_BADGE;
        else if (joinerXP <= SILVERBADGEXP)
            joinerBadge = SILVER_BADGE;
        else if (joinerXP <= GOLDBADGEXP)
            joinerBadge = GOLD_BADGE;
        else if (joinerXP >= PLATBADGEXP) 
            joinerBadge = PLAT_BADGE;
        calculatePlayerLevel();
    }
    
    public void topScore() {
        leaderXP++;
        totalXP += TOP_SCORE_XP;
        final int TINBADGEXP = 20;
        final int BRONZEBADGEXP = 200;
        final int SILVERBADGEXP = 1000;
        final int GOLDBADGEXP = 5000;
        final int PLATBADGEXP = 20000;
        if(leaderXP <= TINBADGEXP)
            leaderBadge = TIN_BADGE;
        else if (leaderXP <= BRONZEBADGEXP)
            leaderBadge = BRONZE_BADGE;
        else if (leaderXP <= SILVERBADGEXP)
            leaderBadge = SILVER_BADGE;
        else if (leaderXP <= GOLDBADGEXP)
            leaderBadge = GOLD_BADGE;
        else if (leaderXP >= PLATBADGEXP) 
            leaderBadge = PLAT_BADGE;
        calculatePlayerLevel();
    }
    
    public void assault() {
        punisherXP++;
        totalXP += DAMAGE_DEALT_XP;
        final int TINBADGEXP = 2000;
        final int BRONZEBADGEXP = 10000;
        final int SILVERBADGEXP = 30000;
        final int GOLDBADGEXP = 100000;
        final int PLATBADGEXP = 300000;
        if(punisherXP <= TINBADGEXP)
            punisherBadge = TIN_BADGE;
        else if (punisherXP <= 30000)
            punisherBadge = BRONZE_BADGE;
        else if (punisherXP <= BRONZEBADGEXP)
            punisherBadge = SILVER_BADGE;
        else if (punisherXP <= SILVERBADGEXP)
            punisherBadge = GOLD_BADGE;
        else if (punisherXP >= PLATBADGEXP) 
            punisherBadge = PLAT_BADGE;
        calculatePlayerLevel();
    }
    
    public void completeMap() {
        obsessedXP++;
        totalXP += MAP_COMPLETED_XP;
        final int TINBADGEXP = 10;
        final int BRONZEBADGEXP = 50;
        final int SILVERBADGEXP = 200;
        final int GOLDBADGEXP = 500;
        final int PLATBADGEXP = 5000;
        if(obsessedXP <= TINBADGEXP)
            obsessedBadge = TIN_BADGE;
        else if (obsessedXP <= BRONZEBADGEXP)
            obsessedBadge = BRONZE_BADGE;
        else if (obsessedXP <= SILVERBADGEXP)
            obsessedBadge = SILVER_BADGE;
        else if (obsessedXP <= GOLDBADGEXP)
            obsessedBadge = GOLD_BADGE;
        else if (obsessedXP >= PLATBADGEXP) 
            obsessedBadge = PLAT_BADGE;
        calculatePlayerLevel();
    }
    
    public void calculatePlayerLevel() {
        if (totalXP <= 10000)
            playerLvl = 1;
        else if (totalXP <= 25000)
            playerLvl = 2;
        else if (totalXP <= 80000)
           playerLvl = 3;
        else if (totalXP <= 150000)
            playerLvl = 4;
        else if (totalXP <= 300000)
            playerLvl = 5;
        else if (totalXP <= 1000000)
            playerLvl = 6;
        else if (totalXP <= 2200000)
            playerLvl = 7;
        else if (totalXP <= 4500000)
            playerLvl = 8;
        else if (totalXP <= 10000000)
            playerLvl = 9;
        else if (totalXP <= 20000000)
            playerLvl = 10;
        else if (totalXP <= 35000000)
            playerLvl = 11;
        else if (totalXP >= 35000000)
            playerLvl = 12;
    }
    
    @Override
    public String toString() {
        String output = String.format("%10s: lvl%3d, points:%15s Stats: Health Points Restored=%d Areas Visited=%d Players Encountered=%d Maps Created=%d Items Gathered=%d Items Repaired=%d Items Merged=%d Top Scores=%d Damage Points Dealt=%d Maps Completed=%d%n                                           Badges: Healer:%s Explorer:%s Socialite:%s Contributor:%s Hoarder:%s Fixer %s Joiner:%s Leader:%s Punisher:%s Obsessed:%s",name, playerLvl, NumberFormat.getIntegerInstance(Locale.US).format(totalXP), healerXP, explorerXP, socialiteXP, contributorXP, hoarderXP, fixerXP, joinerXP, leaderXP, punisherXP, obsessedXP, healerBadge, explorerBadge, socialiteBadge, contributorBadge, hoarderBadge, fixerBadge, joinerBadge, leaderBadge, punisherBadge, obsessedBadge);
        return output;
    }
    
    @Override
    public int compareTo(Player otherPlayer) {
        return Comparators.NAME.compare(this, otherPlayer);
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