package com.spizzyrichlife.ussrpg_v01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button toLobby;
    Button toPool;
    Button toCreation;
    Button toSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        //TODOne: Lobby Button to Multi-player Lobby Activity
        toLobby = (Button) findViewById(R.id.lobbyMainButton);
        toLobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MpLobbyActivity.class);
                startActivity(intent);
            }
        });

        //TODOne: Pool Button
        toPool = (Button) findViewById(R.id.poolMainButton);
        toPool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DicePoolerActivity.class);
                startActivity(intent);
            }
        });

        //TODOne: Creation Button link to Characer Creation Activity
        toCreation = (Button) findViewById(R.id.createMainButton);
        toCreation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CharacterCreationActivity.class);
                startActivity(intent);
            }
        });

        //TODOne: Selection Button to Character Selection Activity
        toSelection = (Button) findViewById(R.id.selectMainButton);
        toSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CharacterSelectionActivity.class);
                startActivity(intent);
            }
        });
    }
}
