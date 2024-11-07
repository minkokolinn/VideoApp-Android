package com.example.admin.videoapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.videoapp.R;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.et_am);
        btn=findViewById(R.id.btn_search_am);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=et.getText().toString();
                Intent i=new Intent(MainActivity.this,VideoActivity.class);
                Bundle bd=new Bundle();
                bd.putString("abc",str);
                i.putExtras(bd);
                startActivity(i);
            }
        });
    }
}
