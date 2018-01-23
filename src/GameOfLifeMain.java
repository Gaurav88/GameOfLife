import com.game.domain.Cell;
import com.game.domain.CellState;
import com.game.domain.Universe;
import com.game.translator.InputTranslator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GameOfLifeMain {
    public static void main(String[] args) {
        String FILENAME = "F:\\BACKUP\\Softwares\\sample_workspace\\GameOfLife\\Input.txt";
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            String sCurrentLine;
            InputTranslator inputTranslator = new InputTranslator();
            Cell[][] inputCells = new Cell[10][10];
            int rowNum = 0;
            while ((sCurrentLine = br.readLine()) != null) {
                String[] row = sCurrentLine.split("");
                Cell[] cell = inputTranslator.convertToGameState(row);
                inputCells[rowNum++] = cell;
            }
            int colNum = inputCells[0].length;
            Universe universe = new Universe(colNum, rowNum);
            universe.setInputCells(inputCells);
            universe.startEvolution();
            /*Cell[][] outputCells = universe.getOutputCells();
            for (int row = 0; row < outputCells.length; row++) {
                for (int col = 0; col < outputCells[row].length; col++) {
                    if (outputCells[row][col] != null)
                        System.out.print(outputCells[row][col].getState().getDesc());
                }
                System.out.println();
            }*/
            System.out.println("Finish");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
