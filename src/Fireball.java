import javax.swing.*;
import java.awt.*;

/**
 * Created by Hollow on 01.07.14.
 */
public class Fireball implements Spell{
    int x,y,spellDirection;
    int bulletSpeed = 2;
    Image fireball;

    public Fireball(int x,int y, int spellDirection){

        this.spellDirection = spellDirection;
        ImageIcon icon;

        if(spellDirection == 1){
            icon = new ImageIcon("src/Graphics/BannedStory_Fireball_right_lvl1.png");
            fireball = icon.getImage();
            this.x = x;
            this.y = y - (icon.getIconHeight()/2);
        }else{
            icon = new ImageIcon("src/Graphics/BannedStory_Fireball_left_lvl1.png");
            fireball = icon.getImage();
            this.x = x - icon.getIconWidth();
            this.y = y - (icon.getIconHeight()/2);
        }

    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void advance(){
    x += bulletSpeed * spellDirection;
}

    public void draw(Graphics g, JavaGame game){
        g.drawImage(fireball,x,y,game);
    }
}
