package com.pecesteam.questodo;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.pecesteam.questodo.sourceClasses.Tasks;

import java.util.ArrayList;

public class MainDoingList extends AppCompatActivity {

    private ArrayAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doing_list);

        String project;

        //TODO:llegir les consultes i el nom de projecte
        //ArrayList of To Do tasks

        project = "banana";

        TextView window = (TextView) findViewById(R.id.projectNameDngL);
        window.setText(project);

        ArrayList<Tasks> tasks = new ArrayList<>();
        Tasks banana = new Tasks("Sopar", "Menjar", "Hi ha pizza per sopar");
        tasks.add(banana);
        banana = new Tasks("HackUPC", "Morir", "Guanyarem la HackUPC BITCHES");
        tasks.add(banana);
        String[] tdTask = new String[tasks.size()];
        for(int i = 0; i < tasks.size(); i++){
            tdTask[i] = tasks.get(i).getName() + ": " + tasks.get(i).getDescription() + ". Type: " + tasks.get(i).getType();
        }

        final ListView mListView = (ListView) findViewById(R.id.doingListList);
        mAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,tdTask);

        if(mListView != null){
            mListView.setAdapter(mAdapter);
        }

        //TODO:POPUP DE CONFIRMACIÓ

        final Button button = (Button) findViewById(R.id.todoListDngL);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainTodoList.class);
                startActivity(i);
            }
        });
        final Button button2 = (Button) findViewById(R.id.doneListDngL);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainDoneList.class);
                startActivity(i);
            }
        });
        final Button button3 = (Button) findViewById(R.id.backButtonDngL);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainQuestodo.class);
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
