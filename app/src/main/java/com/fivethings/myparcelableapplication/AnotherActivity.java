package com.fivethings.myparcelableapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Bundle bundle = getIntent().getExtras();
        Aluno a = bundle.getParcelable("parcelable");
        Dog d = bundle.getParcelable("parcelable2");

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(a.getNome() + " " + a.getAula());

        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(d.getNome() + " " + d.getAge());

    }
}
