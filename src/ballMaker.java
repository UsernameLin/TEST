
import java.awt.*;
import java.util.Random;
public class ballMaker {
        private ball gameBall;
        

        
        public ballMaker(int WINDOW_WIDTH, int WINDOW_HEIGHT, int id){
            gameBall = new ball(WINDOW_WIDTH/2, WINDOW_HEIGHT/2, Random(),Random(),id, Color.YELLOW,10);

        }
        public void paint(Graphics grapics){
            gameBall.paint(grapics);
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
