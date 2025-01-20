import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.JPanel;
public class pongGame extends JPanel implements MouseMotionListener{
    private ball gameBall;
    private Paddle userPaddle,pcPaddle;
    private int mouseY;
    private int userScore, pcScore;
    private ballMaker create;

    static final int WINDOW_WIDTH = 1280, WINDOW_HEIGHT = 1024;
        @Override 
        public void mouseDragged(MouseEvent e){

        }
        @Override 
        public void mouseMoved(MouseEvent e){
           mouseY = e.getY();
        }

    public void paintComponent(Graphics grapics){

        grapics.setColor(Color.BLACK);
        grapics.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        gameBall.paint(grapics); 
        userPaddle.paint(grapics);
        pcPaddle.paint(grapics);
        grapics.setColor(Color.WHITE);
        grapics.drawString("Score - User [ " + userScore + " ]   PC [ " + pcScore + " ]", WINDOW_WIDTH/2, 20   );
    }
    public pongGame(){
        create = new ballMaker(Color.YELLOW, WINDOW_WIDTH, WINDOW_HEIGHT);
        userPaddle = new Paddle(10, WINDOW_HEIGHT/2, 85, 3, Color.BLUE);
        pcPaddle = new Paddle(1250, WINDOW_HEIGHT/2, 85, 3, Color.RED);
        mouseY = 0;
        addMouseMotionListener(this);
        userScore = 0;
        pcScore = 0;

    }
    public void gameLogic(){

        gameBall.moveBall();
        userPaddle.moveTowards(mouseY);
        pcPaddle.moveTowards(gameBall.getY());
        if(userPaddle.checkCollision(gameBall)||pcPaddle.checkCollision(gameBall)){
            gameBall.reverseX();
        }
        gameBall.bounceOffEdges(0, WINDOW_HEIGHT);
        if(gameBall.getX() < 0){
            pcScore++;
            reset();
        } 
         if(gameBall.getX() > WINDOW_WIDTH){
            userScore++;
            reset();
        }
    }
    public void reset(){
        gameBall.setX(WINDOW_WIDTH/2);
        gameBall.setY(WINDOW_HEIGHT/2);
        gameBall.setCx(Random());
        gameBall.setCy(Random());
        gameBall.setBounce(0);
    }
    public int Random(){
        Random rand = new Random();
        int x = 0;
        
        while(x < 2 || x > -2 && x < 0){
            x = rand.nextInt(3) + 1;
        }
        return x;
    }
    
}
