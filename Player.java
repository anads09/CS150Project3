/*
Austin Nadler
CS150-002
Program #2
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
                calculatePlayerLevel();
                break;
            case 2:
                explore();
                calculatePlayerLevel();
                break;
            case 3:
                encounterPlayer();
                calculatePlayerLevel();
                break;
            case 4:
                createMap();
                calculatePlayerLevel();
                break;
            case 5:
                gatherItem();
                calculatePlayerLevel();
                break;
            case 6:
                itemRepaired();
                calculatePlayerLevel();
                break;
            case 7:
                mergeItems();
                calculatePlayerLevel();
                break;
            case 8:
                topScore();
                calculatePlayerLevel();
                break;
            case 9:
                assault();
                calculatePlayerLevel();
                break;
            case 10:
                completeMap();
                calculatePlayerLevel();
                break;
            default: 
                break;                         
        }
    }
    
    public void heal() {
        healerXP++;
        totalXP += HEAL_XP;
        if (healerXP < 2000)
            healerBadge = NO_BADGE;
        else if(healerXP < 10000)
            healerBadge = TIN_BADGE;
        else if (healerXP < 30000)
            healerBadge = BRONZE_BADGE;
        else if (healerXP < 100000)
            healerBadge = SILVER_BADGE;
        else if (healerXP < 200000)
            healerBadge = GOLD_BADGE;
        else if (healerXP >= 200000) 
            healerBadge = PLAT_BADGE;
        
    }
    
    public void explore() {
        explorerXP++;
        totalXP += AREA_VISITED_XP;
        if(explorerXP < 50)
            explorerBadge = NO_BADGE;
        else if(explorerXP < 1000)
            explorerBadge = TIN_BADGE;
        else if (explorerXP < 5000)
            explorerBadge = BRONZE_BADGE;
        else if (explorerXP < 17000)
            explorerBadge = SILVER_BADGE;
        else if (explorerXP < 40000)
            explorerBadge = GOLD_BADGE;
        else if (explorerXP >= 40000) 
            explorerBadge = PLAT_BADGE;
    }
    
    public void encounterPlayer () {
        socialiteXP++;
        totalXP += PLAYER_ENCOUNTERED_XP;
        if(socialiteXP < 100)
            socialiteBadge = NO_BADGE;
        else if(socialiteXP < 1000)
            socialiteBadge = TIN_BADGE;
        else if (socialiteXP < 2000)
            socialiteBadge = BRONZE_BADGE;
        else if (socialiteXP < 10000)
            socialiteBadge = SILVER_BADGE;
        else if (socialiteXP < 30000)
            socialiteBadge = GOLD_BADGE;
        else if (socialiteXP >= 30000) 
            socialiteBadge = PLAT_BADGE;
    }
    
    public void createMap() {
        contributorXP++;
        totalXP += MAP_CREATED_XP;
        if(contributorXP < 3)
            contributorBadge = NO_BADGE;
        else if(contributorXP < 10)
            contributorBadge = TIN_BADGE;
        else if (contributorXP < 20)
            contributorBadge = BRONZE_BADGE;
        else if (contributorXP < 90)
            contributorBadge = SILVER_BADGE;
        else if (contributorXP < 150)
            contributorBadge = GOLD_BADGE;
        else if (contributorXP >= 150) 
            contributorBadge = PLAT_BADGE;
    }
    
    public void gatherItem() {
        hoarderXP++;
        totalXP += ITEM_GATHERED_XP;
        if(hoarderXP < 2000)
            hoarderBadge = NO_BADGE;
        else if(hoarderXP < 10000)
            hoarderBadge = TIN_BADGE;
        else if (hoarderXP < 30000)
            hoarderBadge = BRONZE_BADGE;
        else if (hoarderXP < 100000)
            hoarderBadge = SILVER_BADGE;
        else if (hoarderXP < 200000)
            hoarderBadge = GOLD_BADGE;
        else if (hoarderXP >= 200000) 
            hoarderBadge = PLAT_BADGE;
    }
    
    public void itemRepaired() {
        fixerXP++;
        totalXP += ITEM_REPAIRED_XP;
        if(fixerXP < 100)
            fixerBadge = NO_BADGE;
        else if(fixerXP < 1000)
            fixerBadge = TIN_BADGE;
        else if (fixerXP < 5000)
            fixerBadge = BRONZE_BADGE;
        else if (fixerXP < 15000)
            fixerBadge = SILVER_BADGE;
        else if (fixerXP < 40000)
            fixerBadge = GOLD_BADGE;
        else if (fixerXP >= 40000) 
            fixerBadge = PLAT_BADGE;
    }
    
    public void mergeItems() {
        joinerXP++;
        totalXP += ITEMS_MERGED_XP;
        if(joinerXP < 100)
            joinerBadge = NO_BADGE;
        else if(joinerXP < 1000)
            joinerBadge = TIN_BADGE;
        else if (joinerXP < 5000)
            joinerBadge = BRONZE_BADGE;
        else if (joinerXP < 15000)
            joinerBadge = SILVER_BADGE;
        else if (joinerXP < 40000)
            joinerBadge = GOLD_BADGE;
        else if (joinerXP >= 40000) 
            joinerBadge = PLAT_BADGE;
    }
    
    public void topScore() {
        leaderXP++;
        totalXP += TOP_SCORE_XP;
        if(leaderXP < 20)
            leaderBadge = NO_BADGE;
        else if(leaderXP < 200)
            leaderBadge = TIN_BADGE;
        else if (leaderXP < 1000)
            leaderBadge = BRONZE_BADGE;
        else if (leaderXP < 5000)
            leaderBadge = SILVER_BADGE;
        else if (leaderXP < 20000)
            leaderBadge = GOLD_BADGE;
        else if (leaderXP >= 20000) 
            leaderBadge = PLAT_BADGE;
    }
    
    public void assault() {
        punisherXP++;
        totalXP += DAMAGE_DEALT_XP;
        if(punisherXP < 2000)
            punisherBadge = NO_BADGE;
        else if(punisherXP < 10000)
            punisherBadge = TIN_BADGE;
        else if (punisherXP < 30000)
            punisherBadge = BRONZE_BADGE;
        else if (punisherXP < 100000)
            punisherBadge = SILVER_BADGE;
        else if (punisherXP < 300000)
            punisherBadge = GOLD_BADGE;
        else if (punisherXP >= 300000) 
            punisherBadge = PLAT_BADGE;
    }
    
    public void completeMap() {
        obsessedXP++;
        totalXP += MAP_COMPLETED_XP;
        if(obsessedXP < 2000)
            obsessedBadge = NO_BADGE;
        else if(obsessedXP < 10000)
            obsessedBadge = TIN_BADGE;
        else if (obsessedXP < 30000)
            obsessedBadge = BRONZE_BADGE;
        else if (obsessedXP < 100000)
            obsessedBadge = SILVER_BADGE;
        else if (obsessedXP < 300000)
            obsessedBadge = GOLD_BADGE;
        else if (obsessedXP >= 300000) 
            obsessedBadge = PLAT_BADGE;
    }
    
    public void calculatePlayerLevel() {
        if (totalXP < 10000)
            this.playerLvl = 1;
            else if (totalXP < 25000)
                this.playerLvl = 2;
            else if (totalXP < 80000)
               this.playerLvl = 3;
            else if (totalXP < 150000)
                this.playerLvl = 4;
            else if (totalXP < 300000)
                this.playerLvl = 5;
            else if (totalXP < 1000000)
                this.playerLvl = 6;
            else if (totalXP < 2200000)
                this.playerLvl = 7;
            else if (totalXP < 4500000)
                this.playerLvl = 8;
            else if (totalXP < 10000000)
                this.playerLvl = 9;
            else if (totalXP < 20000000)
                this.playerLvl = 10;
            else if (totalXP < 35000000)
                this.playerLvl = 11;
            else if (totalXP >= 35000000)
                this.playerLvl = 12;
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