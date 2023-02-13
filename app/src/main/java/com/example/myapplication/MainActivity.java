package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etWho;
    private EditText etTema;
    private  EditText etMassage;
    private Button btnPanel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWho =findViewById(R.id.et_who);
        etTema=findViewById(R.id.et_tema);
        etMassage=findViewById(R.id.et_message);
        btnPanel=findViewById(R.id.buttonPanel);

        btnPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String who = etWho.getText().toString();
                String tema=etTema.getText().toString();
                String message=etMassage.getText().toString();

                Intent imaeil =new Intent(Intent.ACTION_SEND);
                imaeil.putExtra(Intent.EXTRA_EMAIL,new String[]{who});
                imaeil.putExtra(Intent.EXTRA_SUBJECT,tema);
                imaeil.putExtra(Intent.EXTRA_TEXT,message);
                imaeil.setType("message/rfc822");
                startActivity(Intent.createChooser(imaeil,"WYBERITE SOBSENIE"));
            }
        });
    }
}