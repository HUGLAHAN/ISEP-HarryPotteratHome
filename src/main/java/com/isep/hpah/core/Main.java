package com.isep.hpah.core;

//import com.hogwarts.game.Game;
import com.isep.hpah.core.game.chamberofsecretsLevel2;
import com.isep.hpah.core.game.philosopherStoneLevel1;

//    public class Main {
//    public static void main(String[] args) {
//        Game game = new Game();
//        game.start(); // Appel de la méthode start pour lancer le jeu
//    }
//}


//public class Main {
//    public static void main(String[] args) {
//        philosopherStoneLevel1 game = new philosopherStoneLevel1();
//        game.start(); // Appel de la méthode start pour lancer le jeu
//    }
//}

public class Main {
    public static void main(String[] args) {
        philosopherStoneLevel1 level1 = new philosopherStoneLevel1();
        chamberofsecretsLevel2 level2 = new chamberofsecretsLevel2();
        level1.start(); // Appel de la méthode start pour lancer le jeu
        level2.start();
    }
}