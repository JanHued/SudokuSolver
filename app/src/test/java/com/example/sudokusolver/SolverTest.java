package com.example.sudokusolver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolverTest {


    private final Solver solver = new Solver();
    private Grid testGrid;
    private Grid solutionGrid;

    @Test
    public void testIsValid() {
        initTestGrid();
        assertTrue(testGrid.isValid());
        assertTrue(solutionGrid.isValid());
        initInvalidTestGrid();
        assertFalse(testGrid.isValid());
    }

    @Test
    public void testSolve() {
        initTestGrid();
        solver.solve(testGrid);
        assertTrue(testGrid.equals(solutionGrid));
    }

    @Test
    @Disabled
    public void testSolveOnImpossibleGrid() {
        initTestGrid();
        Grid impossibleGrid = new Grid(testGrid);
        for (int i = 0; i < 9; i++) {
            impossibleGrid.set(i, 1);
        }
        solver.solve(impossibleGrid);
    }

    private void initInvalidTestGrid() {
        List<Integer> testgrid = new ArrayList<>(Collections.nCopies(81, 0));
        testgrid.set(0, 1);
        testgrid.set(8, 1);
        testGrid = new Grid(testgrid);
    }

    private void initTestGrid() {
        List<Integer> testgrid = new ArrayList<>();
        List<Integer> solutiongrid = new ArrayList<>();

        testgrid.add(0);
        testgrid.add(0);
        testgrid.add(5);
        testgrid.add(4);
        testgrid.add(8);
        testgrid.add(0);
        testgrid.add(0);
        testgrid.add(6);
        testgrid.add(7);
        testgrid.add(8);
        testgrid.add(3);
        testgrid.add(0);
        testgrid.add(0);
        testgrid.add(6);
        testgrid.add(9);
        testgrid.add(5);
        testgrid.add(0);
        testgrid.add(0);
        testgrid.add(7);
        testgrid.add(0);
        testgrid.add(6);
        testgrid.add(5);
        testgrid.add(0);
        testgrid.add(0);
        testgrid.add(4);
        testgrid.add(0);
        testgrid.add(8);
        testgrid.add(0);
        testgrid.add(7);
        testgrid.add(0);
        testgrid.add(9);
        testgrid.add(0);
        testgrid.add(6);
        testgrid.add(0);
        testgrid.add(5);
        testgrid.add(2);
        testgrid.add(6);
        testgrid.add(0);
        testgrid.add(3);
        testgrid.add(0);
        testgrid.add(7);
        testgrid.add(2);
        testgrid.add(1);
        testgrid.add(9);
        testgrid.add(0);
        testgrid.add(0);
        testgrid.add(2);
        testgrid.add(9);
        testgrid.add(1);
        testgrid.add(0);
        testgrid.add(0);
        testgrid.add(8);
        testgrid.add(0);
        testgrid.add(0);
        testgrid.add(3);
        testgrid.add(8);
        testgrid.add(0);
        testgrid.add(0);
        testgrid.add(5);
        testgrid.add(7);
        testgrid.add(0);
        testgrid.add(0);
        testgrid.add(9);
        testgrid.add(0);
        testgrid.add(0);
        testgrid.add(7);
        testgrid.add(3);
        testgrid.add(0);
        testgrid.add(4);
        testgrid.add(2);
        testgrid.add(8);
        testgrid.add(0);
        testgrid.add(5);
        testgrid.add(0);
        testgrid.add(2);
        testgrid.add(6);
        testgrid.add(0);
        testgrid.add(0);
        testgrid.add(7);
        testgrid.add(0);
        testgrid.add(3);

        solutiongrid.add(2);
        solutiongrid.add(1);
        solutiongrid.add(5);
        solutiongrid.add(4);
        solutiongrid.add(8);
        solutiongrid.add(3);
        solutiongrid.add(9);
        solutiongrid.add(6);
        solutiongrid.add(7);
        solutiongrid.add(8);
        solutiongrid.add(3);
        solutiongrid.add(4);
        solutiongrid.add(7);
        solutiongrid.add(6);
        solutiongrid.add(9);
        solutiongrid.add(5);
        solutiongrid.add(2);
        solutiongrid.add(1);
        solutiongrid.add(7);
        solutiongrid.add(9);
        solutiongrid.add(6);
        solutiongrid.add(5);
        solutiongrid.add(2);
        solutiongrid.add(1);
        solutiongrid.add(4);
        solutiongrid.add(3);
        solutiongrid.add(8);
        solutiongrid.add(1);
        solutiongrid.add(7);
        solutiongrid.add(8);
        solutiongrid.add(9);
        solutiongrid.add(4);
        solutiongrid.add(6);
        solutiongrid.add(3);
        solutiongrid.add(5);
        solutiongrid.add(2);
        solutiongrid.add(6);
        solutiongrid.add(5);
        solutiongrid.add(3);
        solutiongrid.add(8);
        solutiongrid.add(7);
        solutiongrid.add(2);
        solutiongrid.add(1);
        solutiongrid.add(9);
        solutiongrid.add(4);
        solutiongrid.add(4);
        solutiongrid.add(2);
        solutiongrid.add(9);
        solutiongrid.add(1);
        solutiongrid.add(3);
        solutiongrid.add(5);
        solutiongrid.add(8);
        solutiongrid.add(7);
        solutiongrid.add(6);
        solutiongrid.add(3);
        solutiongrid.add(8);
        solutiongrid.add(1);
        solutiongrid.add(2);
        solutiongrid.add(5);
        solutiongrid.add(7);
        solutiongrid.add(6);
        solutiongrid.add(4);
        solutiongrid.add(9);
        solutiongrid.add(9);
        solutiongrid.add(6);
        solutiongrid.add(7);
        solutiongrid.add(3);
        solutiongrid.add(1);
        solutiongrid.add(4);
        solutiongrid.add(2);
        solutiongrid.add(8);
        solutiongrid.add(5);
        solutiongrid.add(5);
        solutiongrid.add(4);
        solutiongrid.add(2);
        solutiongrid.add(6);
        solutiongrid.add(9);
        solutiongrid.add(8);
        solutiongrid.add(7);
        solutiongrid.add(1);
        solutiongrid.add(3);

        testGrid = new Grid(testgrid);
        solutionGrid = new Grid(solutiongrid);
    }
}