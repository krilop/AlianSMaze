import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MazePrint extends JPanel implements ActionListener {
    private final int SIZE=640;
    private final int CELL_SIZE=16;
    private boolean inGame=true;
    private Cell[][] arrayOfCells;
    private Player pl=new Player();
    public MazePrint(){
        arrayOfCells=new Cell[SIZE/CELL_SIZE][SIZE/CELL_SIZE];
        generateMaze(arrayOfCells);
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
    private void createBorders(Cell[] arrayOfCells)
    {
        for (int i = 0; i<SIZE/CELL_SIZE-1;i++)
        {
            if(arrayOfCells[i].getLengthToExit()==arrayOfCells[i+1].getLengthToExit())
            {
                arrayOfCells[i].setRightBorder(true);
                arrayOfCells[i+1].setLeftBorder(true);
                continue;
            }
            Random rand = new Random();
            int amIWantToCreate = rand.nextInt(2);
            if(amIWantToCreate==1)
            {
                arrayOfCells[i].setRightBorder(true);
                arrayOfCells[i+1].setLeftBorder(true);
            }
            else {
                arrayOfCells[i+1].setLengthToExit(arrayOfCells[i].getLengthToExit());
            }
        }
        for (int i = 0; i<SIZE/CELL_SIZE;i++)
            arrayOfCells[i].setDownBorder(true);
        for (int i=0; i<SIZE/CELL_SIZE;i++)
        {
            int cnt=0;
            int tmpValue=arrayOfCells[i].getLengthToExit();
            while(tmpValue==arrayOfCells[i].getLengthToExit())
            {
                cnt++;
                i++;
            }

            boolean flagBorderDown=true;
            //Тут проблема со скаканием должна быть
            while(flagBorderDown)
                for (int j=i-cnt;j<cnt;j++)
                {
                    Random rand = new Random();
                    int amIWantToBrake = rand.nextInt(2);
                    if(amIWantToBrake==1)
                    {
                        arrayOfCells[i].setDownBorder(false);
                        flagBorderDown=false;
                    }
                }

        }


    }
    private void generateMaze(Cell[][] arrayOfCells)
    {
        for (int i = 0; i<SIZE/CELL_SIZE;i++)
            for (int j=0; j<SIZE/CELL_SIZE;i++)
                arrayOfCells[i][j]=new Cell();

        arrayOfCells[0][0].setBorders(true, false, true, false);
        for (int i =1; i<SIZE/CELL_SIZE;i++)
            arrayOfCells[0][i].setUpBorder(true);
        arrayOfCells[0][SIZE/CELL_SIZE-1].setBorders(true, false, false,true);
        for (int i = 0; i<SIZE/CELL_SIZE;i++)
            arrayOfCells[0][i].setLengthToExit(i+1);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
