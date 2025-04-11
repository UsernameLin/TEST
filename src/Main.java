
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class Main {

    static JFrame frame = new JFrame("Pong");
    public static void main(String[] args) throws Exception {
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setSize(1290,1039);

        

        pongGame game = new pongGame();
        

        frame.add(game);

        frame.setVisible(true);
        Timer timer = new Timer(30, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

                game.gameLogic();

                game.repaint();

            }
        });
        timer.start();
    }
}
