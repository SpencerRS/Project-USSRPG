package com.spizzyrichlife.ussrpg_v01.Activities;

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

    //Set Yellow Dice Values (d12)
    String[] yellow1 = {"blank",                "0",    "0"}; //[0] = description, [1] = success, [2] = advantage

    //Set Black Dice Values (d6)
    String[] black1 = {"blank",                 "0",    "0"}; //[0] = description, [1] = success, [2] = advantage
    String[] black2 = {"disadvantage",          "0",    "-1"};
    String[] black3 = {"fail",                  "-1",   "0"};
    String[] black4 = {"disadvantage",          "0",    "-1"};
    String[] black5 = {"fail",                  "-1",   "0"};
    String[] black6 = {"blank",                 "0",    "0"};

    //Set Purple Dice Values (d8)
    String[] purple1 = {"blank",                "0",    "0"}; //[0] = description, [1] = success, [2] = advantage

    //Set Red Dice Values (d12)
    String[] red1 = {"blank",                   "0",    "0"}; //[0] = description, [1] = success, [2] = advantage
}
