package test.game.com.game.test;

import com.game.domain.Cell;
import com.game.domain.CellState;
import com.game.domain.Universe;
import com.game.translator.InputTranslator;
import org.junit.Test;

public class GameOfLifeTest {

    InputTranslator inputTranslator = new InputTranslator();

    @Test
    public void blockPatterTest() {
        String[][] stringInputCells = {{"X", "X"}, {"X", "X"}};
        Universe universe = new Universe(stringInputCells[0].length, stringInputCells.length);
        Cell[][] inputCells = stringToCellConvertor(stringInputCells);
        runAndPrint(inputCells, universe);

    }

    @Test
    public void boatPatterTest() {
        String[][] stringInputCells = {{"X", "X", "-"}, {"X", "-", "X"}, {"-", "X", "-"}};
        Universe universe = new Universe(stringInputCells[0].length, stringInputCells.length);
        Cell[][] inputCells = stringToCellConvertor(stringInputCells);
        runAndPrint(inputCells, universe);

    }

    @Test
    public void blinkerPatterTest() {
        String[][] stringInputCells = {{"-", "X", "-"}, {"-", "X", "-"}, {"-", "X", "-"}};
        Universe universe = new Universe(stringInputCells[0].length, stringInputCells.length);
        Cell[][] inputCells = stringToCellConvertor(stringInputCells);
        runAndPrint(inputCells, universe);

    }

    @Test
    public void toadPatterTest() {
        String[][] stringInputCells = {{"-", "X", "X", "X"}, {"X", "X", "X", "-"}};
        Universe universe = new Universe(stringInputCells[0].length, stringInputCells.length);
        Cell[][] inputCells = stringToCellConvertor(stringInputCells);
        runAndPrint(inputCells, universe);

    }

    @Test
    public void toadInversePatterTest() {
        String[][] stringInputCells = {{"-", "-", "X", "-"}, {"X", "-", "-", "X"}, {"X", "-", "-", "X"}, {"-", "X", "-", "-"}};
        Universe universe = new Universe(stringInputCells[0].length, stringInputCells.length);
        Cell[][] inputCells = stringToCellConvertor(stringInputCells);
        runAndPrint(inputCells, universe);

    }

    private Cell[][] stringToCellConvertor(String[][] stringInputCells) {
        Cell[][] inputCell = new Cell[10][10];
        for (int row = 0; row < stringInputCells.length; row++) {
            Cell[] cell = inputTranslator.convertToGameState(stringInputCells[row]);
            inputCell[row] = cell;
        }
        return inputCell;
    }

    private void runAndPrint(Cell[][] inputCells, Universe universe) {
        universe.setInputCells(inputCells);
        universe.startEvolution();
        Cell[][] outputCells = universe.getOutputCells();
        for (int row = 0; row < outputCells.length; row++) {
            for (int col = 0; col < outputCells[row].length; col++) {
                if (outputCells[row][col] != null && outputCells[row][col].getState() != CellState.Tic)
                    System.out.print(outputCells[row][col].getState().getDesc());
            }
            System.out.println();
        }
    }
}
