import javax.swing.*;
import java.awt.*;

/**
 * Created by Hollow on 30.06.14.
 */
public class JavaGame extends JFrame {

    static int width = 1024;
    static int height = 768;

    Player player;
    private Image dbImage;
    private Graphics dbGraphic;


    public JavaGame(){

        //window properties
        setTitle("testGame");
        setSize(width,height);
        setBackground(Color.WHITE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //assets
        player = new Player();

        //keylisteners
        addKeyListener(new PlayerControls(this,player));

    }

    public void paint(Graphics g){
        dbImage = createImage(getWidth(),getHeight());
        dbGraphic = dbImage.getGraphics();
        paintComponents(dbGraphic);

        g.drawImage(dbImage,0,0,this);
    }

    public void paintComponents(Graphics g){

        Rectangle r1 = new Rectangle(300,300,150,150);
        g.setColor(Color.RED);
        g.fillRect(r1.x,r1.y,r1.width,r1.height);

        if(player.boundingBox.intersects(r1)){
            g.setColor(Color.black);
            g.drawString("Collision", 300,300);
        }

        player.draw(g,this);

        repaint();
    }

    public static void main(String[] args){

        JavaGame mainWindow = new JavaGame();


    }
}
