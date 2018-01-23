package com.game.rules;

import com.game.domain.Cell;
import com.game.domain.CellState;

public class UniverseEvolutionRules {
    int rowNum;
    int colNum;

    public UniverseEvolutionRules(int rowNum, int colNum) {
        this.rowNum = rowNum;
        this.colNum = colNum;
    }

    public boolean checkGenericRule(Cell[][] inputCells, int row, int col) {
        int numOfLivingNeighbours = countLivingPopulation(inputCells, row, col);
        if ((numOfLivingNeighbours == 2 && inputCells[row][col].getState().equals(CellState.Live)) || (numOfLivingNeighbours == 3)) {
            return true;
        }
        return false;
    }

    public boolean checkRuleBoundaryRow(Cell[][] inputCells, int row, int col) {
        if (inputCells[row][col].getState() == CellState.Live && countBoundaryRowAliveNeighbours(inputCells, row, col) == 2) {
            return true;
        }
        return false;
    }

    private int countBoundaryRowAliveNeighbours(Cell[][] inputCells, int row, int col) {
        int numOfNeighbours = 0;
        if (col - 1 >= 0 && inputCells[row][col - 1].getState().equals(CellState.Live)) {
            numOfNeighbours++;
        }
        if (col + 1 < colNum && inputCells[row][col + 1].getState().equals(CellState.Live)) {
            numOfNeighbours++;
        }
        return numOfNeighbours;
    }

    private int countLivingPopulation(Cell[][] inputCells, int row, int col) {
        int numOfNeighbours = 0;
        if ((row >= 0) && (col >= 0)) {
            numOfNeighbours = countBoundaryRowAliveNeighbours(inputCells, row, col);
            if (row - 1 >= 0 && col - 1 >= 0 && inputCells[row - 1][col - 1].getState().equals(CellState.Live)) {
                numOfNeighbours++;
            }
            if (row - 1 >= 0 && inputCells[row - 1][col].getState().equals(CellState.Live)) {
                numOfNeighbours++;
            }
            if (row - 1 >= 0 && col + 1 < colNum && inputCells[row - 1][col + 1].getState().equals(CellState.Live)) {
                numOfNeighbours++;
            }
            if (row + 1 < rowNum && col - 1 >= 0 && inputCells[row + 1][col - 1].getState().equals(CellState.Live)) {
                numOfNeighbours++;
            }
            if (row + 1 < rowNum && inputCells[row + 1][col].getState().equals(CellState.Live)) {
                numOfNeighbours++;
            }
            if (row + 1 < rowNum && col + 1 < colNum && inputCells[row + 1][col + 1].getState().equals(CellState.Live)) {
                numOfNeighbours++;
            }
        }
        return numOfNeighbours;
    }
}
