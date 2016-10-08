package com.pecesteam.questodo;

import android.content.Intent;
import android.os.Bundle;
import java.io.IOException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.pecesteam.questodo.sourceClasses.Achivement;
import com.pecesteam.questodo.sourceClasses.CustomAchiAdapter;
import com.pecesteam.questodo.sourceClasses.ListAchivement;

public class MainAchivements extends AppCompatActivity {

    private ListAchivement achi;
    private ListView achiList;
    private CustomAchiAdapter achiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achivements);

        achi = new ListAchivement();

        try{
            achi.readFile();
        }catch(IOException e){
            System.out.println("El fitxer de logros no existeix");
            Log.e("myApp", "EXCEPTION");
            return;
        }

        //Data to initialize the ListView
        int max = achi.getListArray().length;
        Achivement[] list;
        list = achi.getListArray();
        Integer[] img = new Integer[max];
        String[] desc = new String[max];
        for(int i = 0; i < max;i++) {
            Log.w("myApp", list[i].toString());
            img[i] = list[i].getImg();
            desc[i] = list[i].getName() + ":" + list[i].getDescription();
        }

        /*achiList = (ListView) findViewById(R.id.achiList);
        achiAdapter = new CustomAchiAdapter(this,desc,img);
        if(achiList != null){
            achiList.setAdapter(achiAdapter);
        }

        achiList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent i = new Intent(view.getContext(), MainTodoList.class);
                startActivity(i);
            }
        });

        /*final Button button = (Button) findViewById(R.id.backButtonAr);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainProfile.class);
                startActivity(i);
            }
        });*/
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

    /*@Override
    protected void onResume() {
        super.onResume();

        try{
            if(achi.setAchive()) achi.readFile();
            //TODO:actualizar la lista gráfica
        }catch(IOException e){
            System.out.println("El fitxer de logros no existeix");
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }*/


}