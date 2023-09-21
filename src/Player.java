import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Player extends JPanel implements ActionListener {

    private Image img;
    private String strToPath;
    private int posX;
    private int posY;

    public Player() {
        loadImages("character.png");
        Timer timer = new Timer(250,this);
        timer.start();
        addKeyListener(new FieldKeyListener());
        setFocusable(true);
        requestFocus();
    }

    public void setPosition(int positionX, int positionY) {
        try {
            posX = positionX;
            posY = positionY;
        } catch (Exception e) {
            System.out.println("Error with changing position of player!");
        }

    }

    public void loadImages(String path) {
        try {
            strToPath = path;
            ImageIcon iiCharacter = new ImageIcon(path);
            int x = 0;
            int y = 0;
            int width = 16;
            int height = 16;
            Image image = iiCharacter.getImage();

            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = bufferedImage.createGraphics();
            g2d.drawImage(image, 0, 0, width, height, x, y, x + width, y + height, null);
            g2d.dispose();
            ImageIcon subIcon = new ImageIcon(bufferedImage);


            img = subIcon.getImage();

        } catch (Exception e) {
            System.out.println("Error with path to image of character!");
        }
    }

    public Image getImg() {
        return img;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, posX * 16, posY * 16, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    repaint();
    }

    class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            System.out.println("Key pressed");
            try {
                ImageIcon iiCharacter = new ImageIcon(strToPath);
                Random random = new Random();
                int rand = random.nextInt(2);
                int x;
                if (rand == 0)
                    x = 0;
                else
                    x = 16;
                int y = 0;
                switch (key) {
                    case KeyEvent.VK_LEFT:
                        y = 48;
                        break;
                    case KeyEvent.VK_RIGHT:
                        y=32;
                        break;
                    case KeyEvent.VK_UP:
                        y=16;
                        break;
                }
                int width = 16;
                int height = 16;
                Image image = iiCharacter.getImage();

                BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = bufferedImage.createGraphics();
                g2d.drawImage(image, 0, 0, width, height, x, y, x + width, y + height, null);
                g2d.dispose();
                ImageIcon subIcon = new ImageIcon(bufferedImage);
                img = subIcon.getImage();
                repaint();
            } catch (Exception ex) {
                System.out.println("Error with repainting left image of character!");
            }

        }
        @Override
        public void keyReleased(KeyEvent e)
        {
            super.keyPressed(e);
            System.out.println("Key pressed");
            try {
                Thread.sleep(100);
                ImageIcon iiCharacter = new ImageIcon(strToPath);
                Random random = new Random();
                int rand = random.nextInt(2);
                int x=0,y=0;
                int width = 16;
                int height = 16;
                Image image = iiCharacter.getImage();
                BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = bufferedImage.createGraphics();
                g2d.drawImage(image, 0, 0, width, height, x, y, x + width, y + height, null);
                g2d.dispose();
                ImageIcon subIcon = new ImageIcon(bufferedImage);
                img = subIcon.getImage();
                repaint();
            } catch (Exception ex) {
                System.out.println("Error with repainting left image of character!");
            }

        }
    }
}
