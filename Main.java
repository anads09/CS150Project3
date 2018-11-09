/*
Austin Nadler
CS150-002
Program #3
11/13/2018
*/

package cs150proj03;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static final int NUMBER_OF_ACTIONS = 200000;
    static final int NUMBER_OF_PLAYERS = 10;
    static ArrayList <Player> players = new ArrayList <Player>();
   
    public static void main(String[] args) {               
        play();
        sorts();
    }
    
    public static void sorts() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Sorted By Name:");            
        Collections.sort(players, Player.Comparators.NAME);
        print();
        System.out.println("Players Sorted By Total Points:");
        Collections.sort(players, Player.Comparators.TOTALXP);
        Collections.reverse(players);
        print();
        System.out.println("Sorted By Health Points Restored:");
        Collections.sort(players, Player.Comparators.HEALTHS);
        Collections.reverse(players);
        print();
        System.out.println("Sorted By Areas Visted:");
        Collections.sort(players, Player.Comparators.AREAS);
        Collections.reverse(players);
        print();
        System.out.println("Sorted By Players Encountered:");
        Collections.sort(players, Player.Comparators.SOCIALS);
        Collections.reverse(players);
        print();
        System.out.println("Sorted By Maps Created:");
        Collections.sort(players, Player.Comparators.MAPMADES);
        Collections.reverse(players);
        print();
        System.out.println("Sorted By Items Collected:");
        Collections.sort(players, Player.Comparators.HOARDERS);
        Collections.reverse(players);
        print();
        System.out.println("Sorted By Items Repaired:");
        Collections.sort(players, Player.Comparators.FIXERS);
        Collections.reverse(players);
        print();
        System.out.println("Sorted By Itemes Merged:");
        Collections.sort(players, Player.Comparators.JOINERS);
        Collections.reverse(players);
        print();
        System.out.println("Sorted By Damage Points Dealt:");
        Collections.sort(players, Player.Comparators.ASSAULTS);
        Collections.reverse(players);
        print();
        System.out.println("Sorted By Maps Completed:");
        Collections.sort(players, Player.Comparators.OBSESSEDS);
        Collections.reverse(players);
        print();
        }
        
    public static void play() {
        players.add(new Player("Afla"));
        players.add(new Player("Echo"));
        players.add(new Player("Lima"));
        players.add(new Player("Xray"));
        players.add(new Player("Foxtrot"));
        players.add(new Player("Ghost"));
        players.add(new Player("Yankee"));
        players.add(new Player("Souls"));
        players.add(new Player("Zima"));
        players.add(new Player("Vault"));        
        for(int turn = 0; turn <= NUMBER_OF_ACTIONS; turn++) {
            if(turn == NUMBER_OF_ACTIONS) {
                System.out.println("Simulation final results:");
                Collections.sort(players, Player.Comparators.TOTALXP);
                Collections.reverse(players);
                print();
            } else if (turn % 100 == 0 || turn == NUMBER_OF_ACTIONS) {
                if(turn != NUMBER_OF_ACTIONS)
                    System.out.println("Action #" + turn);        
                Collections.sort(players, Player.Comparators.TOTALXP);
                Collections.reverse(players);
                print();
            }
            int player = (int)(Math.random() * NUMBER_OF_PLAYERS);
            players.get(player).doSomething();
        }  
    }
    
    public static void print() {
        for(int i = 0; i < NUMBER_OF_PLAYERS; i++)
            System.out.println(players.get(i).toString());
    }



}