package com.spizzyrichlife.ussrpg_v01.Activities;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by SpizzyRich on 9/19/16.
 */
public class DiceRoller {
    //Set Blue Dice Values (d6)
    String[] blue1 = {"blank",                  "0",    "0"}; //[0] = description, [1] = success, [2] = advantage
    String[] blue2 = {"advantage",              "0",    "1"};
    String[] blue3 = {"success + advantage",    "1",    "1"};
    String[] blue4 = {"success",                "1",    "0"};
    String[] blue5 = {"advantages",             "0",    "2"};
    String[] blue6 = {"blank",                  "0",    "0"};

    //Set Green Dice Values (d8)
    String[] green1 = {"blank",                 "0",    "0"}; //[0] = description, [1] = success, [2] = advantage
    String[] green2 = {"successes",             "2",    "0"};
    String[] green3 = {"advantage",             "0",    "1"};
    String[] green4 = {"success",               "1",    "0"};
    String[] green5 = {"success",               "1",    "0"};
    String[] green6 = {"success",               "1",    "0"};
    String[] green7 = {"advantage",             "0",    "1"};
    String[] green8 = {"success + advantage",   "1",    "1"};

    //Set Yellow Dice Values (d12)
    String[] yellow1 = {"blank",                "0",    "0"}; //[0] = description, [1] = success, [2] = advantage
    String[] yellow2 = {"successes",            "2",    "0"};
    String[] yellow3 = {"advantage",            "0",    "1"};
    String[] yellow4 = {"success",              "1",    "0"};
    String[] yellow5 = {"success + advantage",  "1",    "1"};
    String[] yellow6 = {"advantages",           "0",    "2"};
    String[] yellow7 = {"advantages",           "0",    "2"};
    String[] yellow8 = {"success + advantage",  "1",    "1"};
    String[] yellow9 = {"success",              "1",    "0"};
    String[] yellow10 = {"success + advantage", "1",    "1"};
    String[] yellow11 = {"successes",           "2",    "0"};
    String[] yellow12 = {"critical success",    "3",    "3"};

    //Set Black Dice Values (d6)
    String[] black1 = {"blank",                 "0",    "0"}; //[0] = description, [1] = success, [2] = advantage
    String[] black2 = {"disadvantage",          "0",    "-1"};
    String[] black3 = {"fail",                  "-1",   "0"};
    String[] black4 = {"disadvantage",          "0",    "-1"};
    String[] black5 = {"fail",                  "-1",   "0"};
    String[] black6 = {"blank",                 "0",    "0"};

    //Set Purple Dice Values (d8)
    String[] purple1 = {"blank",                "0",    "0"}; //[0] = description, [1] = success, [2] = advantage
    String[] purple2 = {"disadvantage",         "0",    "-1"};
    String[] purple3 = {"fail + disadvantage",  "-1",   "-1"};
    String[] purple4 = {"fails",                "-2",   "0"};
    String[] purple5 = {"disadvantage",         "0",    "-1"};
    String[] purple6 = {"disadvantage",         "0",    "-1"};
    String[] purple7 = {"fails",                "-2",   "0"};
    String[] purple8 = {"fail",                 "-1",   "0"};

    //Set Red Dice Values (d12)
    String[] red1 = {"blank",                   "0",    "0"}; //[0] = description, [1] = success, [2] = advantage
    String[] red2 = {"disadvantage",            "0",    "-1"};
    String[] red3 = {"fails",                   "-2",   "0"};
    String[] red4 = {"fail",                    "-1",   "0"};
    String[] red5 = {"fail + disadvantage",     "-1",   "-1"};
    String[] red6 = {"disadvantages",           "0",    "-2"};
    String[] red7 = {"disadvantages",           "0",    "-2"};
    String[] red8 = {"fail + disadvantage",     "-1",   "-1"};
    String[] red9 = {"fail",                    "-1",   "0"};
    String[] red10 = {"fails",                  "-2",   "0"};
    String[] red11 = {"disadvantage",           "0",    "-1"};
    String[] red12 = {"critical fail",          "-3",   "-3"};

    //Roll a dice of sizeX
    public int rollDx(int x){
        Random random = new Random();
        int randomNum = random.nextInt(x - 1) + 1;
        return randomNum;
    }
    //Roll num of blue dice, receive results as Array List of String[]s. List length = num
    public ArrayList<String[]> rollBlue(int num){
        ArrayList<String[]> blueResults = new ArrayList<>();
        for (int i = 0; i < num ; i++) {
            int roll = rollDx(6);
            if (roll == 1){
                blueResults.add(blue1);
            }else if (roll == 2){
                blueResults.add(blue2);
            }else if (roll == 3){
                blueResults.add(blue3);
            }else if (roll == 4){
                blueResults.add(blue4);
            }else if (roll == 5){
                blueResults.add(blue5);
            }else blueResults.add(blue6);
        }
        return blueResults;
    }

    //Roll num of green dice, receive results as Array List of String[]s. List length = num
    public ArrayList<String[]> rollGreen(int num){
        ArrayList<String[]>greenResults = new ArrayList<>();
        for (int i = 0; i < num ; i++) {
            int roll = rollDx(6);
            if (roll == 1){
                greenResults.add(green1);
            }else if (roll == 2){
                greenResults.add(green2);
            }else if (roll == 3){
                greenResults.add(green3);
            }else if (roll == 4){
                greenResults.add(green4);
            }else if (roll == 5){
                greenResults.add(green5);
            }else if (roll == 6){
                greenResults.add(green6);
            }else if (roll == 7){
                greenResults.add(green7);
            }else greenResults.add(green8);
        }
        return greenResults;
    }

        //Roll num of yellow dice, receive results as Array List of String[]s. List length = num
        public ArrayList<String[]> rollYellow(int num){
        ArrayList<String[]> yellowResults = new ArrayList<>();
        for (int i = 0; i < num ; i++) {
            int roll = rollDx(6);
            if (roll == 1){
                yellowResults.add(yellow1);
            }else if (roll == 2){
                yellowResults.add(yellow2);
            }else if (roll == 3){
                yellowResults.add(yellow3);
            }else if (roll == 4){
                yellowResults.add(yellow4);
            }else if (roll == 5){
                yellowResults.add(yellow5);
            }else if (roll == 6){
                yellowResults.add(yellow6);
            }else if (roll == 7){
                yellowResults.add(yellow7);
            }else if (roll == 8){
                yellowResults.add(yellow8);
            }else if (roll == 9){
                yellowResults.add(yellow9);
            }else if (roll == 10){
                yellowResults.add(yellow10);
            }else if (roll == 11) {
                yellowResults.add(yellow11);
            }else yellowResults.add(yellow12);
        }
        return yellowResults;
    }

        //Roll num of black dice, receive results as Array List of String[]s. List length = num
        public ArrayList<String[]> rollBlack(int num){
        ArrayList<String[]> blackResults = new ArrayList<>();
        for (int i = 0; i < num ; i++) {
            int roll = rollDx(6);
            if (roll == 1){
                blackResults.add(black1);
            }else if (roll == 2){
                blackResults.add(black2);
            }else if (roll == 3){
                blackResults.add(black3);
            }else if (roll == 4){
                blackResults.add(black4);
            }else if (roll == 5){
                blackResults.add(black5);
            }else blackResults.add(black6);
        }
        return blackResults;
    }

    //Roll num of purple dice, receive results as Array List of String[]s. List length = num
    public ArrayList<String[]> rollPurple(int num){
        ArrayList<String[]>purpleResults = new ArrayList<>();
        for (int i = 0; i < num ; i++) {
            int roll = rollDx(6);
            if (roll == 1){
                purpleResults.add(purple1);
            }else if (roll == 2){
                purpleResults.add(purple2);
            }else if (roll == 3){
                purpleResults.add(purple3);
            }else if (roll == 4){
                purpleResults.add(purple4);
            }else if (roll == 5){
                purpleResults.add(purple5);
            }else if (roll == 6){
                purpleResults.add(purple6);
            }else if (roll == 7){
                purpleResults.add(purple7);
            }else purpleResults.add(purple8);
        }
        return purpleResults;
    }

    //Roll num of red dice, receive results as Array List of String[]s. List length = num
    public ArrayList<String[]> rollRed(int num){
        ArrayList<String[]> redResults = new ArrayList<>();
        for (int i = 0; i < num ; i++) {
            int roll = rollDx(6);
            if (roll == 1){
                redResults.add(red1);
            }else if (roll == 2){
                redResults.add(red2);
            }else if (roll == 3){
                redResults.add(red3);
            }else if (roll == 4){
                redResults.add(red4);
            }else if (roll == 5){
                redResults.add(red5);
            }else if (roll == 6){
                redResults.add(red6);
            }else if (roll == 7){
                redResults.add(red7);
            }else if (roll == 8){
                redResults.add(red8);
            }else if (roll == 9){
                redResults.add(red9);
            }else if (roll == 10){
                redResults.add(red10);
            }else if (roll == 11) {
                redResults.add(red11);
            }else redResults.add(red12);
        }
        return redResults;
    }

    //TODOne: copy formula for other dice
//        //Roll num of green dice, receive results as Array List of String[]s. List length = num
//        public ArrayList<String[]> roll<X>(int num){
//        ArrayList<String[]> someResults = new ArrayList<>();
//        for (int i = 0; i < num ; i++) {
//            int roll = rollDx(6);
//            if (roll == 1){
//                someResults.add(x1);
//            }else if (roll == 2){
//                someResults.add(x2);
//            }else if (roll == 3){
//                someResults.add(x3);
//            }else if (roll == 4){
//                someResults.add(x4);
//            }else if (roll == 5){
//                someResults.add(x5);
//            }else someResults.add(x6);
//        }
//        return someResults;
//    }
}
