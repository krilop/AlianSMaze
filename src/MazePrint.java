import javax.swing.*;

public class MazePrint extends JPanel {
    private final int SIZE=640;
    private final int CELL_SIZE=16;

    private Cell[][] arrayOfCells;
    private Player pl=new Player();
    public MazePrint(){
        arrayOfCells=new Cell[SIZE/CELL_SIZE][SIZE/CELL_SIZE];

    }

}
