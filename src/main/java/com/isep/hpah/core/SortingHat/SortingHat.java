package com.isep.hpah.core.SortingHat;

import com.isep.hpah.core.belongings.*;
import java.util.Scanner;

public class SortingHat {
    public static House sort() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Hogwarts Sorting Hat ceremony!");
        System.out.println("I am the Sorting Hat, and I will determine your Hogwarts house.");
        System.out.println("Answer the following questions truthfully:");
        System.out.println("Do you consider yourself brave? (y/n)");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("y")) {
            System.out.println("Interesting, very interesting. You have a lot of courage.");
            System.out.println("Do you value intelligence and wit? (y/n)");
            answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                System.out.println("You are clever as well as brave. Perhaps you belong in RAVENCLAW.");
                return House.RAVENCLAW;
            } else {
                System.out.println("Hmm, you have a good heart, but perhaps not as sharp a mind.");
                System.out.println("Are you particularly patient and loyal? (y/n)");
                answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("y")) {
                    System.out.println("You are a hard worker and a good friend. Welcome to HUFFLEPUFF.");
                    return House.HUFFLEPUFF;
                } else {
                    System.out.println("You are brave and loyal, and have a strong sense of right and wrong.");
                    System.out.println("Your house is GRYFFINDOR!");
                    return House.GRYFFINDOR;
                }
            }
        } else {
            System.out.println("I see, you are not particularly brave.");
            System.out.println("Do you value intelligence and wit? (y/n)");
            answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                System.out.println("You are clever and resourceful, and will do well in SLYTHERIN.");
                return House.SLYTHERIN;
            } else {
                System.out.println("Hmm, you have a kind heart, but perhaps not as sharp a mind or strong a will.");
                System.out.println("Are you particularly patient and loyal? (y/n)");
                answer = scanner.nextLine();
                if (answer.equalsIgnoreCase("y")) {
                    System.out.println("You are a hard worker and a good friend. Welcome to HUFFLEPUFF.");
                    return House.HUFFLEPUFF;
                } else {
                    System.out.println("You have a strong will and ambition, and know what you want.");
                    System.out.println("Your house is SLYTHERIN!");
                    return House.SLYTHERIN;
                }
            }
        }
    }
}
