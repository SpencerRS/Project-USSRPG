package com.spizzyrichlife.ussrpg_v01.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.spizzyrichlife.ussrpg_v01.DBHelper;
import com.spizzyrichlife.ussrpg_v01.R;

//This is where all search results and continued searching is handled.
// Launch mode singletop (inside manifest) to stop it from opening itself multiple times
public class SearchActivity extends AppCompatActivity {
    EditText searchBox;
    Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchBox = (EditText) findViewById(R.id.search_box);
        searchButton = (Button) findViewById(R.id.search_again_button);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: implement search functionality here based on data inside the Search Box edit text
                DBHelper.getInstance(SearchActivity.this).getSearchResults(getSearch());
            }
        });
    }

    public String getSearch(){
        String search = searchBox.getText().toString();
        return search;

    }
}
