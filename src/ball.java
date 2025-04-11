import java.awt.*;

public class ball {
    private int   x, y, cx, cy, size, bounce; 
    private Color color;
    final static double  Mul = .5;
    public ball(int x, int y, int cx, int cy, Color color, int size){
        this.x = x;
        this.y = y;
        this.cx = cx;
        this.cy = cy;
        
        this.color = color;
        this.size = size;
    }

    public void paint(Graphics grapics){
        grapics.setColor(color);

        grapics.fillOval(x, y, size, size);
    }
    public void moveBall(){
        x += cx;
        y += cy;
    }

    public void bounceOffEdges(int top, int bottom){
        if (y > bottom - size){
            reverseY();
        }
        else if( y < top){
            reverseY();
            
        }
        
    }
    public int getY(){
        return y;
    }
    public int getX(){
        return x;
    }
    public int getCX(){
        return cx;
    }
    
    public void setCx(int i){
        this.cx = i;
    }
    public void setCy(int i){
        this.cy = i;
    }
    public void setX(int i){
        this.x = i;
    }
    public void setY(int i){
        this.y = i;
    }
    public void setBounce(int i){
        bounce = i;
    }
    public void reverseX(){
        if(cx > 0){cx += (Mul * Math.pow(bounce, 1.1));}
        else{cx -= (Mul * Math.pow(bounce, 1.1));}
        
        cx *= -1;
        bounce ++;
    }
    
    public void reverseY(){
        if(cy > 0){cy += (Mul * Math.pow(bounce, 1.1));}
        else{cy -= (Mul * Math.pow(bounce, 1.1));}
        cy *= -1;
        bounce ++;
    }
}
