import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends JPanel {

    private Image img;

    private int posX;
    private int posY;

    public Player()
    {
        loadImages( "character.png");
    }

    public void setPosition(int positionX, int positionY)
    {
        try {
            posX=positionX;
            posY=positionY;
        }catch (Exception e)
        {
            System.out.println("Error with changing position of player!");
        }

    }
    public void loadImages(String path){
        try {
            ImageIcon iiCharacter= new ImageIcon(path);
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


            img=subIcon.getImage();

        }catch (Exception e)
        {
            System.out.println("Error with path to image of character!");
        }
    }
    public Image getImg(){
        return img;
    }
    public int getPosX(){
        return posX;
    }
    public int getPosY(){
        return posY;
    }

    /* Сделать смену иконки игрока для разного нажатия кнопок.
    int x = 10; // начальная координата X
    int y = 20; // начальная координата Y
    int width = 100; // ширина области изображения
    int height = 80; // высота области изображения

    ImageIcon icon = new ImageIcon("your_image.png"); // замените "your_image.png" на путь к вашему изображению
    Image subImage = icon.getImage().getSubimage(x, y, width, height);
    ImageIcon subIcon = new ImageIcon(subImage);


    * */

}
