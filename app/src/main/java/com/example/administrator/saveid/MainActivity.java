package com.example.administrator.saveid;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText input;
    Button save;
    Button get;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        save = findViewById(R.id.save);
        get = findViewById(R.id.get);
        input = findViewById(R.id.input);
        output = findViewById(R.id.output);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = input.getText().toString();

                SharedPreferences sharedPre = getSharedPreferences("idpath", MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPre.edit();
                editor.putString("authid", id);
                editor.commit();
            }
        });

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPre=getSharedPreferences("idpath", MODE_PRIVATE);
                String getID=sharedPre.getString("authid", "");
                output.setText(getID);
            }
        });
    }
}
