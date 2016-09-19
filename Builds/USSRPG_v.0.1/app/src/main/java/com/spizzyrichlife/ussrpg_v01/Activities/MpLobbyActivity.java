package com.spizzyrichlife.ussrpg_v01.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.spizzyrichlife.ussrpg_v01.R;

public class MpLobbyActivity extends AppCompatActivity {
    // This screen will allow Game Masters to host game lobbies and allow players to join lobbies.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_lobby);
    }
}
