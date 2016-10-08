package com.pecesteam.questodo;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //TODO:Llegir dades del perfil

        final Button button = (Button) findViewById(R.id.archiButtonPr);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainAchivements.class);
                startActivity(i);
            }
        });

        final Button button2 = (Button) findViewById(R.id.backButtonPr);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainQuestodo.class);
                startActivity(i);
            }
        });
    }
}
