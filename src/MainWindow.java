import javax.swing.*;

public class MainWindow extends JFrame {

    public MainWindow(){
        setTitle("MazeAliens");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(640,690);
        setLocation(650,200);
        MazePrint maze=new MazePrint();
        add(maze);
        add(maze.getPl());
        setVisible(true);

    }


    public static void main(String[] args)
    {
        MainWindow mw = new MainWindow();

    }
}
