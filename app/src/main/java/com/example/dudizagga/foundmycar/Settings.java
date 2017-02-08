package com.example.dudizagga.foundmycar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by DudiZagga on 28/01/2017.
 */

public class Settings extends AppCompatActivity {
    EditText name, carKind, carNum;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        name = (EditText) findViewById(R.id.nameSet);
        carKind = (EditText) findViewById(R.id.carKindSet);
        carNum = (EditText) findViewById(R.id.carNumSet);

        SharedPreferences userPref = getSharedPreferences("users", 0);
        String Uname = userPref.getString("userName", "יוסי כהן");
        String UcarKind = userPref.getString("carKind", "הונדה");
        String UcarNum = userPref.getString("carNum", "11-22-33");
        name.setText(Uname);
        carKind.setText(UcarKind);
        carNum.setText(UcarNum);


    }



    public void saveChanges(View view) {
        String Uname = name.getText().toString();
        String UcarKind = carKind.getText().toString();
        String UcarNum = carNum.getText().toString();

        SharedPreferences  userPref = getSharedPreferences("users", 0);
        SharedPreferences.Editor editor= userPref.edit();
        editor.putString("userName",Uname);
        editor.putString("carKind",UcarKind);
        editor.putString("carNum",UcarNum);
        editor.commit();
        name.setText(Uname);
        carKind.setText(UcarKind);
        carNum.setText(UcarNum);
        MainActivity.med.start();
        Toast.makeText(this, "השינויים שמרו בהצלחה", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Settings.this,MainActivity.class));



    }


}
