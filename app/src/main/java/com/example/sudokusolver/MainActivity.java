package com.example.sudokusolver;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Solver solver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onAppStart();
    }

    private void onAppStart() {
        setContentView(R.layout.activity_main);
        setTextChangedListeners();
        solver = new Solver();
    }

    private void setTextChangedListeners() {
        Resources r = getResources();
        String name = getPackageName();

        for (int y = 1; y <= 9; y++) {
            for (int x = 1; x <= 9; x++) {
                String id = "h" + x + "_v" + y;
                EditText inputField = findViewById(r.getIdentifier(id, "id", name));
                inputField.addTextChangedListener(getTextChangeListener());
            }
        }
    }

    private TextWatcher getTextChangeListener() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                TextView text = (TextView) getCurrentFocus();

                if (text != null && text.length() > 0) {
                    View next = text.focusSearch(View.FOCUS_FORWARD); // or FOCUS_FORWARD
                    if (next != null)
                        next.requestFocus();
                }
            }
        };
    }

    public void onClickRefresh(View view){
        finish();
        startActivity(getIntent());
    }

    @SuppressLint("ResourceType")
    public void onClickSolve(View view) throws InterruptedException {
        List<Integer> grid = readInput();
        new Thread(() -> {
            solver.solve(grid);
        }).start();
        long start = System.currentTimeMillis();
        long end = start + 5000;
        while (System.currentTimeMillis() < end) {
            if (solved(grid)) {
                writeOutput(grid);
                return;
            }
        }
        setContentView(R.layout.activity_timeout);
    }

    private boolean solved(List<Integer> grid) {
        return !grid.contains(0);
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

    private void writeOutput(List<Integer> outputGrid) {
        Resources r = getResources();
        String name = getPackageName();
        EditText outputField;
        for (int y = 1; y <= 9; y++) {
            for (int x = 1; x <= 9; x++) {
                String id = "h" + x + "_v" + y;
                outputField = findViewById(r.getIdentifier(id, "id", name));
                outputField.setText(String.valueOf(outputGrid.get((y - 1) * 9 + x - 1)), TextView.BufferType.NORMAL);
            }
        }
    }

    private boolean isNotANumber(String inputString) {
        return !List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9").contains(inputString);
    }

    public void onClickRetry(View view) {
        setContentView(R.layout.activity_main);
        onAppStart();
    }
}