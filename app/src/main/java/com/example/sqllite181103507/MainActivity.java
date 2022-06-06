package com.example.sqllite181103507;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText firstname, lastname;
    TextView textView;
    dbcontroler controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstname = (EditText) findViewById(R.id.editfirstname);
        lastname = (EditText) findViewById(R.id.editlastname);
        textView = (TextView) findViewById(R.id.textView);
        controller = new dbcontroler(this,"",null,1);
    }
    public void  btn_click(View view){
        switch (view.getId()){
            case R.id.btn_add:
                try {
                    controller.insert_student(firstname.getText().toString(), lastname.getText().toString());
                }catch (SQLiteException e){
                    Toast.makeText(MainActivity.this,"ALREDY EXIST", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_Delet:
                controller.delete_student(firstname.getText().toString());
                break;
            case R.id.btn_list:
                controller.list_all_students(textView);
                break;
            case R.id.btn_update:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Masukan Nama");

                final EditText newFirstName = new EditText(this);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        controller.update_student(firstname.getText().toString(), newFirstName.getText().toString());
                    }
                });

                break;
                }

        }
        }
