
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.JPanel;

public class pongGame extends JPanel implements MouseMotionListener {

    private Paddle userPaddle, pcPaddle;
    private int mouseY;
    private ballMaker create;

    static final int WINDOW_WIDTH = 1280, WINDOW_HEIGHT = 1024;

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseY = e.getY();
    }

    public pongGame() {
        userPaddle = new Paddle(10, WINDOW_HEIGHT / 2, 85, 10, Color.BLUE);
        pcPaddle = new Paddle(1250, WINDOW_HEIGHT / 2, 85, 10, Color.RED);
        create = new ballMaker( WINDOW_WIDTH, WINDOW_HEIGHT, 20, userPaddle ,pcPaddle);
        mouseY = 0;
        addMouseMotionListener(this);
    }

    public void paintComponent(Graphics grapics) {
        grapics.setColor(Color.BLACK);
        grapics.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        create.paint(grapics);

        userPaddle.paint(grapics);
        pcPaddle.paint(grapics);
        grapics.setColor(Color.WHITE);
        grapics.drawString("Score - User [ " + create.getUserScore() + " ]   PC [ " + create.getPcScore() + " ]", WINDOW_WIDTH / 2, 20);
    }

    public void gameLogic() {

        // gameBall.moveBall();
        create.logic();

        userPaddle.moveTowards(mouseY);

    }


    public int Random() {
        Random rand = new Random();
        int x = 0;

        while (x < 2 || x > -2 && x < 0) {
            x = rand.nextInt(3) + 1;
        }
        return x;
    }

}
