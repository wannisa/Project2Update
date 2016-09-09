package com.example.aoyler.pawarisaclinicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SearchActivity extends AppCompatActivity {

    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ImageView button = (ImageView) findViewById(R.id.searchButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText = (EditText) findViewById(R.id.searchTextbox);
                String _val = editText.getText().toString();
                System.out.println("_val: " + _val);

                Bundle bundle =  new Bundle();
                bundle.putString("keyword", _val);
                v.getContext().startActivity(new Intent(v.getContext(), FeedPatientActivity.class).putExtras(bundle));
            }
        });


    }
}
