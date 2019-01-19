package com.example.zeyad.jetandroid;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView showRandomNamber = findViewById(R.id.showRandomNamber);
        Button reloade = findViewById(R.id.reloade);


        final MainActivity_ViewModel model = ViewModelProviders.of(this).get(MainActivity_ViewModel.class);
        final LiveData<String> number = model.getRandomNamber();
        number.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                showRandomNamber.setText(s);
            }
        });

        reloade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.CreateNumber();
            }
        });

    }
}
