package com.pecesteam.questodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainDoneList extends AppCompatActivity {

    Button backButton = null;
    Button doingButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done_list);

        backButton = (Button) findViewById(R.id.backButton);
        doingButton = (Button) findViewById(R.id.createProject);

        doingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainDoingList.class);
                startActivity(i);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //TODO: return to MainMenu
            }
        });

    }
}