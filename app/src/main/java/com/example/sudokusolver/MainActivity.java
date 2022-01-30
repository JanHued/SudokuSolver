qpackage com.example.sudokusolver;

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
        List<Integer> grid = readInput();
        solve(grid);
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
        int startRow = Math.floorDiv(getRowOfIndex(index), 3);
        int startCol = Math.floorDiv(getColumnOfIndex(index), 3);
        int startIndex = getIndexOfRowAndColumn(startRow, startCol);
        return !getSublistOfSquareStartingAt(grid, startIndex).contains(candidate);
    }

    private int getRowOfIndex(int index) {
        return Math.floorDiv(index, 9);
    }

    private int getColumnOfIndex(int index) {
        return index - Math.floorDiv(index, 9) * 9;
    }

    private int getIndexOfRowAndColumn(int row, int column) {
        return row * 9 + column;
    }

    private List<Integer> getSublistOfSquareStartingAt(List<Integer> grid, int index) {
        List<Integer> sublistOfSquare = grid.subList(index, index + 2);
        index += 9;
        sublistOfSquare.addAll(grid.subList(index, index + 2));
        index += 9;
        sublistOfSquare.addAll(grid.subList(index, index + 2));
        return sublistOfSquare;
    }

    private boolean possibleForRow(List<Integer> grid, int index, int candidate) {
        int start = 9 * Math.floorDiv(index, 9);
        return !grid.subList(start, start + 8).contains(candidate);
    }
}