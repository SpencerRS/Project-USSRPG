package com.spizzyrichlife.ussrpg_v01.Activities;

//Your work must:
//   [X]   Have a theme and display data related to that theme.
//   [X]   Allow the user to search by at least three different search criteria
//   [X]     Show results in separate entries/pages to the user, including descriptions, images, and whatever else you like
//   [X]     Gather data for the search results from the database
//TODO: Add U and D functionality from CRUD
//   [X]   Allow the user to add rows to a database, which they can view at any time
//   [X]   Incorporate Object Oriented principles into your app
//   [X]   Contain code comments, explaining the functionality behind sections of code
//   [X]  Include at least 4 user stories in the readme.md
//   [X]   Include espresso tests for your app
//   [X]   Ensure that you add a sufficient number of tests for the features of each screen of your app
//Bonus:
//   []   Use relationships between tables (highly recommended)
//TODO: Create attributes table linked to PC table.
//   []   Incorporate Square's Picasso photo library
//   []   Incorporate Material Design principles into your app
//   []   Add more complexity to the user's searches (possibly allowing more than one search criteria at a time)
//   []   Add JUnit tests for your non-Android classes (i.e. not Activity or Fragment)


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.spizzyrichlife.ussrpg_v01.DBHelper;
import com.spizzyrichlife.ussrpg_v01.R;

public class MainActivity extends AppCompatActivity {
    Button toLobby;
    Button toPool;
    Button toSelection;
    //    Button toCreation;

    //Notification ID
    public static final int NOTIFICATION_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
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

        //TODOne: Selection Button to Character Selection Activity
        toSelection = (Button) findViewById(R.id.selectMainButton);
        toSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CharacterSelectionActivity.class);
                DBHelper.getInstance(MainActivity.this);
                startActivity(intent);
            }
        });
        //Get first instance on create.
        DBHelper.getInstance(this);

        //Pending Intent Test
        Intent intent = new Intent(this, CharacterSelectionActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

        //Test Notification that pops up when you open the app's main activity.
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("This is a notification");
        builder.setContentText("Hello, this is some more text");
        builder.setAutoCancel(true);
        builder.setContentIntent(pendingIntent);
        builder.setPriority(Notification.PRIORITY_DEFAULT);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(NOTIFICATION_ID, builder.build());
    }
    // Creation moved to Action Bar
    //        //TODOne: Creation Button link to Character Creation Activity
//        toCreation = (Button) findViewById(R.id.create_main_button);
//        toCreation.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, CharacterCreationActivity.class);
//                startActivity(intent);
//            }
//        });

    //TODO: Copy Both of these to each activity once it is complete.
    //Inflate options menu for this activity.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Interpret menu item clicks.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_attribute:
//              TODO: Make this popup a fragment to add Attributes to the currently selected character
                return true;

            case R.id.action_edit:
//              TODO: Make this switch to an activity to edit the attributes of the currently selected character
                return true;

            case R.id.action_create:
                //TODOne: Make this direct to character creation activity TODO: or make it a fragment inside a popup dialogue
//                showDialogue();
                Intent intent = new Intent(MainActivity.this, CharacterCreationActivity.class);
                startActivity(intent);
                return true;

            default:
                // If we get here, then the user's action wasn't recognized.
                return super.onOptionsItemSelected(item);

        }
    }
//// Show a dialog fragment with character creation methods TODO: make this dialog work/find out why it is not working
//    public void showDialogue(){
//        FragmentManager manager = getFragmentManager();
//        CharacterCreateDialog charCreate = new CharacterCreateDialog();
//        charCreate.show(manager);
//    }
}
