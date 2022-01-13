package com.example.sudokusolver;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("ResourceType")
    public void onClickSolve(View view) {
        Resources r = getResources();
        String name = getPackageName();
        List<Integer> inputData = new ArrayList<>();
        for (int i = 0; i < 82; i++) {
            String idString = "h" + (i % 9 + 1) + "_v" + (Math.floorDiv(i, 9) + 1);
            int id = r.getIdentifier(idString, "id", name);
            EditText inputField = findViewById(id);
            inputData.add(Integer.parseInt(String.valueOf(inputField.getText())));
        }
    }
}