package com.spizzyrichlife.ussrpg_v01;

/**
 * Created by SpizzyRich on 9/6/16.
 */
public class PlayerCharacter {
    int _id;
    String name;
    int xp; //Character's experience point total to compare total spent with
    int hp; //Character's max health
    int sp; // Character's max stamina
    int cp; // Character's current total of Cinematic Points
//    TODO: add these back in once Players and Locations are implemented.
//    int player_id;
//    int location_id;

// TODO: update with player_id and location_id when they are implemented
    public PlayerCharacter(int _id, String name, int xp, int hp, int sp, int cp) {
        this._id = _id;
        this.name = name;
        this.xp = xp;
        this.hp = hp;
        this.sp = sp;
        this.cp = cp;
    }
}
