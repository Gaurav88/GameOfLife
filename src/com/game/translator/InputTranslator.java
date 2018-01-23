package com.game.translator;

import com.game.domain.Cell;
import com.game.domain.CellState;

public class InputTranslator {

    public Cell[] convertToGameState(String[] row) {
        Cell[] cellRow = new Cell[row.length];
        int i = 0;
        for (String str : row) {
            Cell cell = new Cell();
            if (str.equals("X")) {
                cell.setState(CellState.Live);
            } else if (str.equals("-")) {
                cell.setState(CellState.Dead);
            }
            cellRow[i++] = cell;
        }
        return cellRow;
    }
}
