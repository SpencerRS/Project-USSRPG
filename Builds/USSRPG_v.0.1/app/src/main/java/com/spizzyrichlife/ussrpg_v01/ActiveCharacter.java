package com.spizzyrichlife.ussrpg_v01;

/**
 * Created by SpizzyRich on 9/8/16.
 */

//Keeps track of the current active character
public class ActiveCharacter {

 PlayerCharacter activeCharacter;

    private static ActiveCharacter activeCharacterInstance = new ActiveCharacter();

    public static ActiveCharacter getInstance() {
        return activeCharacterInstance;
    }

//    private ActiveCharacter() {
//    }

    private void setActiveCharacterInstance(int id){
activeCharacter = DBHelper.getInstance(get).getActiveCharacter(id);
    }
}
