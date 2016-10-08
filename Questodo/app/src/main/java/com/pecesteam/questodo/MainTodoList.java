package com.pecesteam.questodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by ARNAU on 08/10/2016.
 */
public class MainTodoList extends AppCompatActivity {

    Button toDoingButton = null;
    Button backButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        toDoingButton = (Button) findViewById(R.id.doingList);
        backButton = (Button) findViewById(R.id.backButton);
        toDoingButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainDoingList.class);
                startActivity(i);
            }
        });

        /*backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainQuestodo.class);
                startActivity(i);
            }
        });*/
    }

}
