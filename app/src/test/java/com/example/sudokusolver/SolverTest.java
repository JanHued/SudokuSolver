package com.example.sudokusolver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolverTest {


    private final Solver solver = new Solver();
    private List<Integer> testGrid;
    private List<Integer> solutionGrid;

    @Test
    public void testIsValid() {
        initTestGrid();
        assertTrue(solver.isValid(testGrid));
        assertTrue(solver.isValid(solutionGrid));
        initInvalidTestGrid();
        assertFalse(solver.isValid(testGrid));
    }

    @Test
    public void testSolve() {
        initTestGrid();
        solver.solve(testGrid);
        assertEquals(testGrid, solutionGrid);
    }

    @Test
    @Disabled
    public void testSolveOnImpossibleGrid() {
        initTestGrid();
        List<Integer> impossibleGrid = new ArrayList<>(testGrid);
        for (int i = 0; i < 9; i++) {
            impossibleGrid.set(i, 1);
        }
        solver.solve(impossibleGrid);
    }

    private void initInvalidTestGrid() {
        testGrid = new ArrayList<>(Collections.nCopies(81, 0));
        testGrid.set(0,1);
        testGrid.set(8,1);
    }

    private void initTestGrid() {
        testGrid = new ArrayList<>();
        solutionGrid = new ArrayList<>();
        testGrid.add(0);
        testGrid.add(0);
        testGrid.add(5);
        testGrid.add(4);
        testGrid.add(8);
        testGrid.add(0);
        testGrid.add(0);
        testGrid.add(6);
        testGrid.add(7);
        testGrid.add(8);
        testGrid.add(3);
        testGrid.add(0);
        testGrid.add(0);
        testGrid.add(6);
        testGrid.add(9);
        testGrid.add(5);
        testGrid.add(0);
        testGrid.add(0);
        testGrid.add(7);
        testGrid.add(0);
        testGrid.add(6);
        testGrid.add(5);
        testGrid.add(0);
        testGrid.add(0);
        testGrid.add(4);
        testGrid.add(0);
        testGrid.add(8);
        testGrid.add(0);
        testGrid.add(7);
        testGrid.add(0);
        testGrid.add(9);
        testGrid.add(0);
        testGrid.add(6);
        testGrid.add(0);
        testGrid.add(5);
        testGrid.add(2);
        testGrid.add(6);
        testGrid.add(0);
        testGrid.add(3);
        testGrid.add(0);
        testGrid.add(7);
        testGrid.add(2);
        testGrid.add(1);
        testGrid.add(9);
        testGrid.add(0);
        testGrid.add(0);
        testGrid.add(2);
        testGrid.add(9);
        testGrid.add(1);
        testGrid.add(0);
        testGrid.add(0);
        testGrid.add(8);
        testGrid.add(0);
        testGrid.add(0);
        testGrid.add(3);
        testGrid.add(8);
        testGrid.add(0);
        testGrid.add(0);
        testGrid.add(5);
        testGrid.add(7);
        testGrid.add(0);
        testGrid.add(0);
        testGrid.add(9);
        testGrid.add(0);
        testGrid.add(0);
        testGrid.add(7);
        testGrid.add(3);
        testGrid.add(0);
        testGrid.add(4);
        testGrid.add(2);
        testGrid.add(8);
        testGrid.add(0);
        testGrid.add(5);
        testGrid.add(0);
        testGrid.add(2);
        testGrid.add(6);
        testGrid.add(0);
        testGrid.add(0);
        testGrid.add(7);
        testGrid.add(0);
        testGrid.add(3);

        solutionGrid.add(2);
        solutionGrid.add(1);
        solutionGrid.add(5);
        solutionGrid.add(4);
        solutionGrid.add(8);
        solutionGrid.add(3);
        solutionGrid.add(9);
        solutionGrid.add(6);
        solutionGrid.add(7);
        solutionGrid.add(8);
        solutionGrid.add(3);
        solutionGrid.add(4);
        solutionGrid.add(7);
        solutionGrid.add(6);
        solutionGrid.add(9);
        solutionGrid.add(5);
        solutionGrid.add(2);
        solutionGrid.add(1);
        solutionGrid.add(7);
        solutionGrid.add(9);
        solutionGrid.add(6);
        solutionGrid.add(5);
        solutionGrid.add(2);
        solutionGrid.add(1);
        solutionGrid.add(4);
        solutionGrid.add(3);
        solutionGrid.add(8);
        solutionGrid.add(1);
        solutionGrid.add(7);
        solutionGrid.add(8);
        solutionGrid.add(9);
        solutionGrid.add(4);
        solutionGrid.add(6);
        solutionGrid.add(3);
        solutionGrid.add(5);
        solutionGrid.add(2);
        solutionGrid.add(6);
        solutionGrid.add(5);
        solutionGrid.add(3);
        solutionGrid.add(8);
        solutionGrid.add(7);
        solutionGrid.add(2);
        solutionGrid.add(1);
        solutionGrid.add(9);
        solutionGrid.add(4);
        solutionGrid.add(4);
        solutionGrid.add(2);
        solutionGrid.add(9);
        solutionGrid.add(1);
        solutionGrid.add(3);
        solutionGrid.add(5);
        solutionGrid.add(8);
        solutionGrid.add(7);
        solutionGrid.add(6);
        solutionGrid.add(3);
        solutionGrid.add(8);
        solutionGrid.add(1);
        solutionGrid.add(2);
        solutionGrid.add(5);
        solutionGrid.add(7);
        solutionGrid.add(6);
        solutionGrid.add(4);
        solutionGrid.add(9);
        solutionGrid.add(9);
        solutionGrid.add(6);
        solutionGrid.add(7);
        solutionGrid.add(3);
        solutionGrid.add(1);
        solutionGrid.add(4);
        solutionGrid.add(2);
        solutionGrid.add(8);
        solutionGrid.add(5);
        solutionGrid.add(5);
        solutionGrid.add(4);
        solutionGrid.add(2);
        solutionGrid.add(6);
        solutionGrid.add(9);
        solutionGrid.add(8);
        solutionGrid.add(7);
        solutionGrid.add(1);
        solutionGrid.add(3);
    }
}