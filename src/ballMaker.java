
import java.awt.*;
import java.util.Random;
import java.util.function.Consumer;

public class ballMaker {

    public ball gameBall[];
    private int numBalls;
    private final Paddle m_User;
    private final Paddle m_Pc;
    private final int winHeight;
    private final int winWidth;
    private int userScore, pcScore;

    public ballMaker( int WINDOW_WIDTH, int WINDOW_HEIGHT, int numberBall, Paddle user, Paddle pc) {
        gameBall = new ball[numberBall];
        for (int i = 0; i < gameBall.length; i++) {
            gameBall[i] = new ball(WINDOW_WIDTH / 2, WINDOW_HEIGHT / 2, Random(), Random(), getRandColor(), 10);
        }
        m_Pc = pc;
        m_User = user;
        winHeight = WINDOW_HEIGHT;
        winWidth = WINDOW_WIDTH;
        numberBall = numBalls;
        userScore = 0;
        pcScore = 0;

    }

    public void paint(Graphics grapics) {
        ballUpdater(ball -> {
            ball.paint(grapics);
        });
        // for(int i = 0; i < gameBall.length; i++){
        //     gameBall[i].paint(grapics);
        // }

    }

    private int Random() {
        Random rand = new Random();
        int x = 0;

        while (x == 0) {
            x = rand.nextInt(-3, 3) * 3;
        }
        return x;
    }
    private Color getRandColor(){
        Color color = Color.CYAN;
        Random rand = new Random();
        int i = rand.nextInt(12);
        switch(i){
            case 1:color = Color.BLUE;
            break;
            case 2:color = Color.CYAN;
            break;
            case 3:color = Color.DARK_GRAY;
            break;
            case 4:color = Color.GRAY;
            break;
            case 5:color = Color.GREEN;
            break;
            case 6:color = Color.LIGHT_GRAY;
            break;
            case 7:color = Color.MAGENTA;
            break;
            case 8:color = Color.ORANGE;
            break;
            case 9:color = Color.PINK;
            break;
            case 10:color = Color.RED;
            break;
            case 11:color = Color.WHITE;
            break;
            case 0:color = Color.YELLOW;
            break;
        }

        return color; 
    }

    private void ballUpdater(Consumer<ball> body) {
        for (int i = 0; i < gameBall.length; i++) {
            body.accept(gameBall[i]);
        }
    }

    public void move() {
        ballUpdater(ball -> {
            ball.moveBall();
        });
    }

    public void logic() {
        move();
        m_Pc.moveTowards(gameBall[closerBall()].getY());
        ballUpdater(ball -> {
            if (m_User.checkCollision(ball) || m_Pc.checkCollision(ball)) {
                ball.reverseX();
            }
            ball.bounceOffEdges(0, winHeight);
            if (ball.getX() < 0) {
                pcScore++;
                reset(ball);
            }
            if (ball.getX() > winWidth) {
                userScore++;
                reset(ball);
            }
        });
    }

    public int closerBall() {
        int x = 0;
        int id = 0;
        for (int i = 0; i < gameBall.length; i++) {
            if (gameBall[i].getCX() > 0) {
                if (x < gameBall[i].getX()) {
                    x = gameBall[i].getX();
                    id = i;
                }
            }
        }
        return id;
    }

    public void reset(ball ball) {
        ball.setX(winWidth / 2);
        ball.setY(winHeight / 2);
        ball.setCx(Random());
        ball.setCy(Random());
        ball.setBounce(0);
    }

    public int getUserScore() {
        return userScore;
    }

    public int getPcScore() {
        return pcScore;
    }
}
