import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class PlayerControls extends KeyAdapter implements Runnable{

    JavaGame game;
    Player player;

    public PlayerControls(JavaGame incomingGame,Player incomingPlayer){
        game = incomingGame;
        player = incomingPlayer;

        Thread t1 = new Thread(this);
        t1.start();

    }

    @Override
    public void run() {
        try{
            while(true){

                player.move();
                player.shoot();

                Thread.sleep(5);
            }
        }catch(Exception e){
            System.out.println("Error Occured!");
        }
    }

    public void keyPressed(KeyEvent e){
        int keyCode = e.getKeyCode();
        if(keyCode == e.VK_UP || keyCode == e.VK_W){
            player.setYDir(-1);
        }
        if(keyCode == e.VK_DOWN || keyCode == e.VK_S){
            player.setYDir(+1);
        }
        if(keyCode == e.VK_RIGHT || keyCode == e.VK_D){
            player.setXDir(+1);
            player.lastDir = 1;
        }
        if(keyCode == e.VK_LEFT || keyCode == e.VK_A){
            player.setXDir(-1);
            player.lastDir = -1;
        }
        if(keyCode == e.VK_SHIFT){
            player.speed = 5;
        }
        if(keyCode == e.VK_SPACE){
            player.castSpell();
        }
        if(keyCode == e.VK_Q){
            player.spellType = SpellType.SPELL_BULLET;
        }
        if(keyCode == e.VK_E){
            player.spellType = SpellType.SPELL_FIREBALL;
        }

    }

    public void keyReleased(KeyEvent e){
        int keyCode = e.getKeyCode();

        if(keyCode == e.VK_UP || keyCode == e.VK_W){
            player.setYDir(0);
        }
        if(keyCode == e.VK_DOWN || keyCode == e.VK_S){
            player.setYDir(0);
        }
        if(keyCode == e.VK_RIGHT || keyCode == e.VK_D){
            player.setXDir(0);
        }
        if(keyCode == e.VK_LEFT || keyCode == e.VK_A){
            player.setXDir(0);
        }
        if(keyCode == e.VK_SHIFT){
            player.speed = 3;
        }
        if(keyCode == e.VK_SPACE){
           // player.readyToFire = false;
            if(player.spell.getX() <= -5 || player.spell.getX() >= JavaGame.width +5){
              //  player.spell = null;
                player.shot = false;
                player.readyToFire = true;
            }
        }
    }

}


