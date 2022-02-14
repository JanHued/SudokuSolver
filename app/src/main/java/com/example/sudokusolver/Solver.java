package com.example.sudokusolver;

public class Solver {

    protected void solve(Grid grid) {
        for (int i = 0; i < grid.getSize(); i++) {
            if (grid.get(i).equals(0)) {
                for (int candidate = 1; candidate <= 9; candidate++) {
                    if (grid.possible(i, candidate)) {
                        grid.set(i, candidate);
                        solve(grid);
                        if (!grid.solved()) {
                            grid.set(i, 0);
                        }
                    }
                }
                return;
            }
        }
    }
}
