import java.awt.*;
import java.util.*;

public class Ponto extends Figura
{
    private int x,  y;

    public Ponto (int x, int y)
    {
        this (x, y, Color.BLACK, Color.getColor(null));
    }
	  
    public Ponto (int x, int y, Color cor, Color cor2)
    {
        super (cor, cor2);

  	this.x = x;
        this.y = y;
    }

    public Ponto (String s)
    {
        StringTokenizer quebrador = new StringTokenizer(s,":");

        quebrador.nextToken();

        this.x = Integer.parseInt(quebrador.nextToken());
        this.y = Integer.parseInt(quebrador.nextToken());

        this.cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                              Integer.parseInt(quebrador.nextToken()),  // G
                              Integer.parseInt(quebrador.nextToken())); // B
    }

    public void setX (int x)
    {
        this.x = x;
    }
	  
    public void setY (int y)
    {
        this.y = y;
    }
	  
    public int getX ()
    {
        return this.x;
    }
	  
    public int getY ()
    {
  	return this.y;
    }
	  
    public void torneSeVisivel (Graphics g)
    {
  	g.setColor (this.cor);
  	g.drawLine (this.x,this.y,this.x,this.y);
    }

    public String toString()
    {
        return "p:" +
               this.x +
               ":" +
               this.y +
               ":" +
               this.getCor().getRed() +
               ":" +
               this.getCor().getGreen() +
               ":" +
               this.getCor().getBlue();
    }
}
