package com.example.zodiak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class detail_horoskop extends AppCompatActivity {

    TextView textViewNama, dateTime, zInfo;
    ImageView imeg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_horoskop);

        textViewNama = findViewById(R.id.view_nama);
        textViewNama.setText(getIntent().getStringExtra("jeneng"));

        dateTime = findViewById(R.id.view_tanggal);
        dateTime.setText(getIntent().getStringExtra("tanggal"));

        zInfo = findViewById(R.id.view_info);
        zInfo.setText(getIntent().getStringExtra("information"));

        imeg = findViewById(R.id.view_photo);
        Glide.with(this)
                .load(getIntent().getStringExtra("foto"))
                .apply(new RequestOptions().override(250, 250))
                .into(imeg);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }

}
