package com.fivethings.myparcelableapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Aluno a = new Aluno("android", "Eliete");

        Animal n = new Animal("Sheldon");
        Dog d = new Dog(2, n);

        Intent i = new Intent(this, AnotherActivity.class);
        i.putExtra("parcelable", a);
        i.putExtra("parcelable2", d);
        startActivity(i);


    }
}
