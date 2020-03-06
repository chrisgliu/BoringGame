package CLOO;
import java.awt.*;
public class Scene1 extends Scene{
    private SpritePlayer player = super.getPlayer();
    public Scene1(int W, int H) {
        super(W, H);
        setBackground(Color.black);
        setVisible(true);
    }
    public void updateSprite() {
        super.updateSprite();
        player=super.getPlayer();
    }
    public void update(Graphics window) { paint(window);}
    public void paint(Graphics window) { player.draw(window);}
}
