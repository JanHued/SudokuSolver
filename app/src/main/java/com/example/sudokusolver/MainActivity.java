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

    private Solver solver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        solver = new Solver();
    }

    @SuppressLint("ResourceType")
    public void onClickSolve(View view) {
        List<Integer> grid = readInput();
        solver.solve(grid);
        writeOutput(grid);
    }

    private List<Integer> readInput() {
        Resources r = getResources();
        String name = getPackageName();
        List<Integer> inputData = new ArrayList<>();
        for (int y = 1; y <= 9; y++) {
            for (int x = 1; x <= 9; x++) {
                String id = "h" + x + "_v" + y;
                EditText inputField = findViewById(r.getIdentifier(id, "id", name));
                String inputString = inputField.getText().toString();
                if (isNotANumber(inputString)) {
                    inputString = "0";
                }
                inputData.add(Integer.parseInt(inputString));
            }
        }
        return inputData;
    }

    private void writeOutput(List<Integer> output) {
        Resources r = getResources();
        String name = getPackageName();
        for (int y = 1; y <= 9; y++) {
            for (int x = 1; x <= 9; x++) {
                String id = "h" + x + "_v" + y;
                EditText inputField = findViewById(r.getIdentifier(id, "id", name));
            }
        }
    }

    private boolean isNotANumber(String inputString) {
        return !List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9").contains(inputString);
    }
}