package com.spizzyrichlife.ussrpg_v01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

//Your work must:
//   []   Have a theme and display data related to that theme.
//   []   Allow the user to search by at least three different search criterias
//   []   Show results in separate entries/pages to the user, including descriptions, images, and whatever else you like
//   []   Gather data for the search results from the database
//   []   Allow the user to add rows to a database, which they can view at any time
//   []   Incorporate Object Oriented principles into your app
//   []   Contain code comments, explaining the functionality behind sections of code
//   []   Include at least 4 user stories in the readme.md
//   []   Include espresso tests for your app
//   []   Ensure that you add a sufficient number of tests for the features of each screen of your app
//Bonus:
//   []   Use relationships between tables (highly recommended)
//   []   Incorporate Square's Picasso photo library
//   []   Incorporate Material Design principles into your app
//   []   Add more complexity to the user's searches (possibly allowing more than one search criteria at a time)
//   []   Add JUnit tests for your non-Android classes (i.e. not Activity or Fragment)


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
