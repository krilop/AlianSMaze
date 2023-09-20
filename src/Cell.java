import javax.swing.*;
import java.awt.*;

public class Cell extends JPanel {

    private boolean upBorder;
    private boolean downBorder;
    private boolean leftBorder;
    private boolean rightBorder;
    private short typeOfCell;
    private int lengthToExit;

    private Image img;
    public Cell() {
    }

    public void setBorders(boolean up, boolean down, boolean left, boolean right) {
        try {
            upBorder = up;
            downBorder = down;
            leftBorder = left;
            rightBorder = right;
        } catch (Exception e) {
            System.out.println("Error with values of borders!");
        }
    }

    public void setLengthToExit(int length) {
        try {
            lengthToExit = length;
        } catch (Exception e) {
            System.out.println("Error with length of cell!");
        }

    }
    public void setTypeOfCell(short type)
    {
        try{
            typeOfCell=type;
        }catch (Exception e)
        {
            System.out.println("Error with type of cell!");
        }
    }

}
