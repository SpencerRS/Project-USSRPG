package com.spizzyrichlife.ussrpg_v01;

/**
 * Created by SpizzyRich on 9/6/16.
 */

//This is where the Player Character object is defined.
    //TODO: Add methods to this class to help do shiz as to/with the character
public class PlayerCharacter {
//    int _id; //TODO: decide if this is needed in OOP
    String name;
    int xp; //Character's experience point total to compare total spent with
    int hp; //Character's max health
    int sp; // Character's max stamina
    int cp; // Character's current total of Cinematic Points
//    TODO: add these back in once Players and Locations are implemented.
//    int player_id;
//    int location_id;

// TODO: update with player_id and location_id when they are implemented
    public PlayerCharacter(String name, int xp, int hp, int sp, int cp) {
        this.name = name;
        this.xp = xp;
        this.hp = hp;
        this.sp = sp;
        this.cp = cp;
    }

    public String getName() {
        return name;
    }

    public int getXp() {
        return xp;
    }

    public int getHp() {
        return hp;
    }

    public int getSp() {
        return sp;
    }

    public int getCp() {
        return cp;
    }
}
