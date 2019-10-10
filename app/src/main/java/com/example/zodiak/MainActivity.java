package com.example.zodiak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity{
    private RecyclerView tampilZodiak;
    private ArrayList<dataM> list = new ArrayList<>();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("");
        tampilZodiak = findViewById(R.id.view_horoskop);
        tampilZodiak.setHasFixedSize(true);

        list.addAll(DataZodiak.getListData());
        showRecyclerList();

    }

    private void showRecyclerList(){
        tampilZodiak.setLayoutManager(new LinearLayoutManager(this));
        dataControl dataControl = new dataControl(list);
        tampilZodiak.setAdapter(dataControl);
    }



    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.open_foto:
                Intent about = new Intent(MainActivity.this , about_me.class);
                startActivity(about);
                break;
        }
        return false;
    }
}
