import java.awt.*;

/**
 * Created by Hollow on 01.07.14.
 */
public class Bullet implements Spell{
    public int x,y,direction;
    int bulletSpeed = 2;
    Rectangle bullet;

    public Bullet(int x,int y,int direction){
        this.x = x;
        this.y = y;
        this.direction = direction;

        bullet = new Rectangle(x,y,30,30);
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void advance(){
        bullet.x += bulletSpeed * direction;
    }

    public void draw(Graphics g, JavaGame game){
        g.setColor(Color.black);
        g.fillRect(bullet.x,bullet.y,bullet.width,bullet.height);
    }

}
