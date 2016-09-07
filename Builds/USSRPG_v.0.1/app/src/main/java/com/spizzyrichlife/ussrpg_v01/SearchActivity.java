package com.spizzyrichlife.ussrpg_v01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//This is where all search results and continued searching is handled.
// Launch mode singletop (inside manifest) to stop it from opening itself multiple times
public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }
}
