package com.pecesteam.questodo;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.pecesteam.questodo.sourceClasses.Tasks;

public class MainNewTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        final EditText name = (EditText) findViewById(R.id.taskName);
        final EditText desc = (EditText) findViewById(R.id.taskDesc);
        final EditText type = (EditText) findViewById(R.id.taskType);

        final Button button = (Button) findViewById(R.id.createTask);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Tasks newT = new Tasks(name.getText().toString(),type.getText().toString(),desc.getText().toString());
                //TODO: create new Task i desar a fitxer
                Intent i = new Intent(v.getContext(), MainTodoList.class);
                startActivity(i);
            }
        });
        final Button button2 = (Button) findViewById(R.id.backButtonNT);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainTodoList.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_questodo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}