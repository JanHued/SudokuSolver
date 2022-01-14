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
        List<Integer> inputData = readInput();
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

    private boolean isNotANumber(String inputString) {
        return !List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9").contains(inputString);
    }

    private void solve(List<Integer> grid) {
        for (int i = 0; i < grid.size(); i++) {
            if (grid.get(i).equals(0)) {
                for (int candidate = 1; candidate <= 9; candidate++) {
                    if (possible(grid, i, candidate)) {
                        grid.set(i, candidate);
                        solve(grid);
                        grid.set(i, 0);
                    }
                }
            }
        }
    }

    private boolean possible(List<Integer> grid, int index, int candidate) {
        return possibleForRow(grid, index, candidate) && possibleForSquare(grid, index, candidate);
    }

    private boolean possibleForSquare(List<Integer> grid, int index, int candidate) {
        List.of(thirdRowOfIndex(index, grid));
        return false;
    }

    private List<Integer> thirdRowOfIndex(int index, List<Integer> grid) {
        int start = 3 * Math.floorDiv(index, 3);
        return grid.subList(start, start + 2);
    }

    private boolean possibleForRow(List<Integer> grid, int index, int candidate) {
        int start = 9 * Math.floorDiv(index, 9);
        return !grid.subList(start, start + 8).contains(candidate);
    }
}