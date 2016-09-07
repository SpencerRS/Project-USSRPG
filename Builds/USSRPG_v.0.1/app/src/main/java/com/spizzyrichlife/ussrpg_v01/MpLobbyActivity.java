package com.spizzyrichlife.ussrpg_v01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MpLobbyActivity extends AppCompatActivity {
// This screen will allow Game Masters to host game lobbies and allow players to join lobbies.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_lobby);
    }
}
