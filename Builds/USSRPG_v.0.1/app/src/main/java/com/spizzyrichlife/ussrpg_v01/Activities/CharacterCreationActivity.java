package com.spizzyrichlife.ussrpg_v01.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.spizzyrichlife.ussrpg_v01.DBHelper;
import com.spizzyrichlife.ussrpg_v01.PlayerCharacter;
import com.spizzyrichlife.ussrpg_v01.R;

// This activity allows players to create new characters and add them to the the PC table.
public class CharacterCreationActivity extends AppCompatActivity {
    EditText charName;
    EditText charStartXP;
    Button createCharButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation);
        charName = (EditText) findViewById(R.id.nameEditText);
        charStartXP = (EditText) findViewById(R.id.xpEditText);
        createCharButton = (Button) findViewById(R.id.charCreateButton);
        createCharButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String name = charName.getText().toString();
                //TODO: error check to see if string is an int.
                int xp = Integer.parseInt(charStartXP.getText().toString());
               PlayerCharacter newPC = new PlayerCharacter(name, xp, 10,10,1);
                DBHelper.getInstance(CharacterCreationActivity.this).createPC(newPC);
                charName.setText("");
                charStartXP.setText("");
                //TODOne: make this button close the activity once it is pressed and redirect back to main activity
                Intent intent = new Intent(CharacterCreationActivity.this, CharacterSelectionActivity.class);
                startActivity(intent);
            }
        });
    }
}
