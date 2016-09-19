package com.spizzyrichlife.ussrpg_v01;

import android.content.Context;

/**
 * Created by SpizzyRich on 9/8/16.
 */

//Keeps track of the current active character for use in play... when implemented...
public class ActiveCharacter {

    PlayerCharacter activeCharacter;

    private static ActiveCharacter activeCharacterInstance = new ActiveCharacter();

    public static ActiveCharacter getInstance() {
        return activeCharacterInstance;
    }

    private ActiveCharacter() {
    }

    private void setActiveCharacterInstance(int id, Context context) {
        activeCharacter = DBHelper.getInstance(context).getActiveCharacter(id);
    }
}
