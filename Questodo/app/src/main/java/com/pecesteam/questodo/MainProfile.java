package com.pecesteam.questodo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by ARNAU on 08/10/2016.
 */
public class MainProfile extends Activity{

    Button logoButton = null;
    Button archiButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        logoButton = (Button) findViewById(R.id.backButton);
        archiButton = (Button) findViewById(R.id.createProject);

        archiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainArchivements.class);
                startActivity(i);
            }
        });

        logoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainQuestodo.class);
                startActivity(i);
            }
        });

    }
}
