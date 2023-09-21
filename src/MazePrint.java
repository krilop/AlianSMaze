import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MazePrint extends JPanel implements ActionListener {
    private final int SIZE=640;
    private final int CELL_SIZE=16;
    private boolean inGame=true;
    private Cell[][] arrayOfCells;
    private Player pl=new Player();
    public MazePrint(){
        arrayOfCells=new Cell[SIZE/CELL_SIZE][SIZE/CELL_SIZE];
        //add(pl);
    }
    public Player getPl(){
        return pl;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(inGame){
            g.drawImage(pl.getImg(),pl.getPosX()*16,pl.getPosY()*16,this);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
