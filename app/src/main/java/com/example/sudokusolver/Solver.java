package com.example.sudokusolver;

import java.util.ArrayList;
import java.util.List;

public class Solver {

    protected void solve(List<Integer> grid) {
        long start = System.currentTimeMillis();
        long end = start + 10 * 1000;
        while (System.currentTimeMillis() < end) {
            for (int i = 0; i < grid.size(); i++) {
                if (grid.get(i).equals(0)) {
                    for (int candidate = 1; candidate <= 9; candidate++) {
                        if (possible(grid, i, candidate)) {
                            grid.set(i, candidate);
                            solve(grid);
                            if (!solved(grid)) {
                                grid.set(i, 0);
                            }
                        }
                    }
                    return;
                }
            }
        }
    }

    private boolean solved(List<Integer> grid) {
        return !grid.contains(0);
    }

    private boolean possible(List<Integer> grid, int index, int candidate) {
        return possibleForRows(grid, index, candidate) && possibleForSquare(grid, index, candidate);
    }

    private boolean possibleForRows(List<Integer> grid, int index, int candidate) {
        return possibleForHorizontal(grid, index, candidate) && possibleForVertical(grid, index, candidate);
    }

    private boolean possibleForHorizontal(List<Integer> grid, int index, int candidate) {
        int start = 9 * Math.floorDiv(index, 9);
        return !grid.subList(start, start + 9).contains(candidate);
    }

    private boolean possibleForVertical(List<Integer> grid, int index, int candidate) {
        int start = index % 9;
        return !getVerticalRow(grid, start).contains(candidate);
    }

    private List<Integer> getVerticalRow(List<Integer> grid, int start) {
        List<Integer> verticalRow = new ArrayList<>(grid.get(start));
        for (int i = start + 9; i < grid.size(); i += 9) {
            verticalRow.add(grid.get(i));
        }
        return verticalRow;
    }

    private boolean possibleForSquare(List<Integer> grid, int index, int candidate) {
        int startRow = Math.floorDiv(getRowOfIndex(index), 3) * 3;
        int startCol = Math.floorDiv(getColumnOfIndex(index), 3) * 3;
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
        List<Integer> sublistOfSquare = new ArrayList<>(grid.subList(index, index + 3));
        index += 9;
        sublistOfSquare.addAll(grid.subList(index, index + 3));
        index += 9;
        sublistOfSquare.addAll(grid.subList(index, index + 3));
        return sublistOfSquare;
    }
}
