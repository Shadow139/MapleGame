import java.awt.*;

/**
 * Created by Hollow on 01.07.14.
 */
public interface Spell {
    public int getX();
    public int getY();
    public void advance();
    public void draw(Graphics g, JavaGame game);

}
