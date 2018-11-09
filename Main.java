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
    static ArrayList <Player> players = new ArrayList <Player>();
   
    public static void main(String[] args) {               
        play();
        sorts();
    }
 
    public static void play() {
        players.add(new Player("A"));
        players.add(new Player("B"));
        players.add(new Player("C"));
        players.add(new Player("D"));
        players.add(new Player("E"));
        players.add(new Player("F"));
        players.add(new Player("G"));
        players.add(new Player("H"));
        players.add(new Player("I"));
        players.add(new Player("J"));        
        for(int turn = 0; turn <= NUMBER_OF_ACTIONS; turn++) {
            if(turn == NUMBER_OF_ACTIONS) {
                System.out.println("Simulation final results:");
                Collections.sort(players, Player.Comparators.TOTALXP);
                print();
            } else if (turn % 100 == 0 || turn == NUMBER_OF_ACTIONS) {
                if(turn != NUMBER_OF_ACTIONS)
                    System.out.println("Action #" + turn);        
                Collections.sort(players, Player.Comparators.TOTALXP);
                print();
            }
            int player = (int)(Math.random() * players.size());
            players.get(player).doSomething();
        }  
    }
       
    public static void sorts() {
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("Sorted By Name:");            
        Collections.sort(players, Player.Comparators.NAME);
        Collections.reverse(players);
        print();
        System.out.println("Players Sorted By Total Points:");
        Collections.sort(players, Player.Comparators.TOTALXP);
        print();
        System.out.println("Sorted By Health Points Restored:");
        Collections.sort(players, Player.Comparators.HEALTHS);
        print();
        System.out.println("Sorted By Areas Visted:");
        Collections.sort(players, Player.Comparators.AREAS);
        print();
        System.out.println("Sorted By Players Encountered:");
        Collections.sort(players, Player.Comparators.SOCIALS);
        print();
        System.out.println("Sorted By Maps Created:");
        Collections.sort(players, Player.Comparators.MAPMADES);
        print();
        System.out.println("Sorted By Items Gathered:");
        Collections.sort(players, Player.Comparators.HOARDERS);
        print();
        System.out.println("Sorted By Items Repaired:");
        Collections.sort(players, Player.Comparators.FIXERS);
        print();
        System.out.println("Sorted By Itemes Merged:");
        Collections.sort(players, Player.Comparators.JOINERS);
        print();
        System.out.println("Sorted By Damage Points Dealt:");
        Collections.sort(players, Player.Comparators.ASSAULTS);
        print();
        System.out.println("Sorted By Maps Completed:");
        Collections.sort(players, Player.Comparators.OBSESSEDS);
        print();
        }
        
    public static void print() {
        Collections.reverse(players);
        for(int i = 0; i < players.size(); i++)
            System.out.println(players.get(i).toString());
    }
}