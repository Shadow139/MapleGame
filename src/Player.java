import javax.swing.*;
import java.awt.*;

/**
 * Created by Hollow on 30.06.14.
 */
public class Player{
    int x,y,xDir,yDir,lastDir;
    int speed = 3;
    Image object;
    Rectangle boundingBox;

    boolean readyToFire,shot = false;

    SpellType spellType;
    Spell spell;

    public Player(){
        x = 500;
        y = 500;
        xDir = 0;
        yDir = 0;

        spellType = SpellType.SPELL_BULLET;

        ImageIcon icon = new ImageIcon("src/Graphics/BannedStory_character.png");
        object = icon.getImage();

        boundingBox = new Rectangle(x,y,icon.getIconWidth(),icon.getIconHeight());
    }

    public void setXDir(int xdir){
        xDir = xdir;
    }
    public void setYDir(int ydir){
        yDir = ydir;
    }

    public void move(){

        x += xDir * speed;
        y += yDir * speed;
        boundingBox.x += xDir * speed;
        boundingBox.y += yDir * speed;

        if(x < 0){
            x = JavaGame.width-20;
            boundingBox.x = JavaGame.width-20;
        }
        if(x > JavaGame.width){
            x = 20;
            boundingBox.x = 20;
        }
        if(y < 0){
            y = JavaGame.height-20;
            boundingBox.y = JavaGame.height-20;
        }
        if(y > JavaGame.height){
            y = 20;
            boundingBox.y = 20;
        }
    }
    public void castSpell(){
        if(spell == null){
            readyToFire = true;
        }
        if(readyToFire){
            int bx,by;
            if(lastDir == 1){
                bx = x + (int)boundingBox.getWidth();
                by = y + ((int)boundingBox.getHeight()/2);
            }else{
                bx = x;
                by = y + ((int)boundingBox.getHeight()/2);
            }
            if(spellType == SpellType.SPELL_BULLET){
                spell = new Bullet(bx,by,lastDir);
            }
            else if(spellType == SpellType.SPELL_FIREBALL){
                spell = new Fireball(bx,by,lastDir);
            }
            shot = true;
        }
    }

    public void shoot(){
        if(shot){
            spell.advance();
        }
    }

    public void draw(Graphics g, JavaGame game){
        g.drawImage(object,x,y,game);
        g.drawRect(x, y, object.getWidth(game), object.getHeight(game));

        if(shot){
            spell.draw(g,game);
          //  g.setColor(Color.black);
          //  g.fillRect(bullet.x,bullet.y,bullet.width,bullet.height);
        }
    }
}
