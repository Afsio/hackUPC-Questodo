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
public class MainDoingList extends AppCompatActivity {

    Button todoButton = null;
    Button doneButton = null;
    Button backButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doing_list);

        todoButton = (Button) findViewById(R.id.todoList);
        doneButton = (Button) findViewById(R.id.doneList);
        backButton = (Button) findViewById(R.id.backButton);

        todoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainTodoList.class);
                startActivity(i);
            }
        });
        doneButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainDoneList.class);
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
