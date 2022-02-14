package com.example.sudokusolver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Grid {
    private final List<Integer> grid;

    public Grid(List<Integer> grid) {
        this.grid = grid;
    }

    public Grid(Grid grid) {
        this.grid = grid.grid;
    }

    public int getSize() {
        return grid.size();
    }

    public Integer get(int index) {
        return grid.get(index);
    }

    public void set(int index, int value) {
        grid.set(index, value);
    }

    public boolean equals(Grid gridToCompare) {
        return grid.equals(gridToCompare.grid);
    }

    protected boolean isValid() {
        return List.of(getColumns(), getRows(), getSquares()).stream().flatMap(Collection::stream)
                .noneMatch(this::hasDuplicates);
    }

    private boolean hasDuplicates(List<Integer> checkList) {
        List<Integer> testList = checkList.stream().filter(i -> !i.equals(0)).collect(Collectors.toList());
        Set<Integer> testSet = new HashSet<>(testList);
        return testList.size() > testSet.size();
    }

    public List<List<Integer>> getRows() {
        List<List<Integer>> rows = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            rows.add(grid.subList(9 * i, 9 * i + 9));
        }
        return rows;
    }

    public List<List<Integer>> getColumns() {
        List<List<Integer>> columns = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            columns.add(getColumnStartingAt(i));
        }
        return columns;
    }

    public List<List<Integer>> getSquares() {
        List<List<Integer>> squares = new ArrayList<>();
        List<Integer> squareStarts = List.of(0, 3, 6, 27, 30, 33, 54, 57, 60);
        squareStarts.stream().map(this::getSublistOfSquareStartingAt).forEach(squares::add);
        return squares;
    }

    protected boolean solved() {
        return !grid.contains(0);
    }

    protected boolean possible(int index, int candidate) {
        return possibleForLinear(index, candidate) && possibleForSquare(index, candidate);
    }

    private boolean possibleForLinear(int index, int candidate) {
        return possibleForRow(index, candidate) && possibleForColumn(index, candidate);
    }

    private boolean possibleForRow(int index, int candidate) {
        int start = 9 * Math.floorDiv(index, 9);
        return !grid.subList(start, start + 9).contains(candidate);
    }

    private boolean possibleForColumn(int index, int candidate) {
        int start = index % 9;
        return !getColumnStartingAt(start).contains(candidate);
    }

    private List<Integer> getColumnStartingAt(int start) {
        List<Integer> verticalRow = new ArrayList<>(grid.get(start));
        for (int i = start; i < grid.size(); i += 9) {
            verticalRow.add(grid.get(i));
        }
        return verticalRow;
    }

    private boolean possibleForSquare(int index, int candidate) {
        int startRow = Math.floorDiv(getRowOfIndex(index), 3) * 3;
        int startCol = Math.floorDiv(getColumnOfIndex(index), 3) * 3;
        int startIndex = getIndexOfRowAndColumn(startRow, startCol);
        return !getSublistOfSquareStartingAt(startIndex).contains(candidate);
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

    private List<Integer> getSublistOfSquareStartingAt(int index) {
        List<Integer> sublistOfSquare = new ArrayList<>(grid.subList(index, index + 3));
        index += 9;
        sublistOfSquare.addAll(grid.subList(index, index + 3));
        index += 9;
        sublistOfSquare.addAll(grid.subList(index, index + 3));
        return sublistOfSquare;
    }

    protected boolean isFinished() {
        return !grid.contains(0);
    }
}
