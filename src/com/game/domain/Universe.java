package com.game.domain;

import com.game.rules.UniverseEvolutionRules;

public class Universe {
    private Cell[][] inputCells;
    private Cell[][] outputCells;
    UniverseEvolutionRules universeEvolutionRules;
    int rowNum;
    int colNum;
    int startRow;

    public Universe(int colNum, int rowNum) {
        universeEvolutionRules = new UniverseEvolutionRules(rowNum, colNum);
        this.rowNum = rowNum;
        this.colNum = colNum;
        outputCells = createDeadGrid();
        startRow = 5;

    }

    public Cell[][] getInputCells() {
        return inputCells;
    }

    public void setInputCells(Cell[][] inputCells) {
        this.inputCells = inputCells;
    }

    public Cell[][] getOutputCells() {
        return outputCells;
    }

    public void setOutputCells(Cell[][] outputCells) {
        this.outputCells = outputCells;
    }

    public void startEvolution() {
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if (row == 0 && (universeEvolutionRules.checkRuleBoundaryRow(inputCells, row, col))) {
                    updateBoundayRow(row + startRow - 1, col);
                }
                if (universeEvolutionRules.checkGenericRule(inputCells, row, col)) {
                    outputCells[row + startRow][col].setState(CellState.Live);
                } else {
                    outputCells[row + startRow][col].setState(CellState.Dead);
                }
                if (row == rowNum - 1 && (universeEvolutionRules.checkRuleBoundaryRow(inputCells, row, col))) {
                    updateBoundayRow(startRow + rowNum, col);
                }
            }
        }
    }

    private void updateBoundayRow(int row, int col) {
        for (int i = 0; i < colNum; i++) {
            if (i == col) {
                outputCells[row][i].setState(CellState.Live);
            } else {
                outputCells[row][i].setState(CellState.Dead);
            }
        }
    }

    private Cell[][] createDeadGrid() {
        Cell[][] outputCells = new Cell[10][10];

        for (int row = 0; row < 10; row++) {
            Cell[] cellRow = new Cell[10];
            for (int col = 0; col < 10; col++) {
                Cell cell = new Cell();
                cell.setState(CellState.Tic);
                cellRow[col] = cell;
            }
            outputCells[row] = cellRow;
        }
        return outputCells;
    }
}
