/*
Austin Nadler
CS150-002
Program #3
11/13/2018
*/
package cs150proj03.game.sim;

public class Badge {
    private static final String BNONE = "None";
    private static final String BTIN = "Tin";
    private static final String BBRONZE = "Bronze";
    private static final String BSILVER = "Silver";
    private static final String BGOLD = "Gold";
    private static final String BPLATINUM = "Platinum";
    private final int TINFLR;
    private final int BRONZEFLR;
    private final int SILVERFLR;
    private final int GOLDFLR;
    private final int PLATFLR;
    public String value;
    
    public Badge (int tinBadgeFLR, int bronzeBadgeFLR, int silverBadgeFLR, int goldBadgeFLR, int platBadgeFLR) {
        TINFLR = tinBadgeFLR;
        BRONZEFLR = bronzeBadgeFLR;
        SILVERFLR = silverBadgeFLR;
        GOLDFLR = goldBadgeFLR;
        PLATFLR = platBadgeFLR;
    }
    
    public void setValue(int xp) {
        if (xp >= PLATFLR)
            value = BPLATINUM; 
        else if (xp >= GOLDFLR)
            value = BGOLD;
        else if (xp >= SILVERFLR)
            value = BSILVER;
        else if (xp >= BRONZEFLR)
           value = BBRONZE;
        else if (xp >= TINFLR)
           value = BTIN;
        else if (xp < TINFLR)
            value = BNONE;     
    }
}