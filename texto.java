import java.awt.*;
import java.util.*;

public class Quadrado extends Figura
{
    protected Ponto inicio;
    protected int   side;
	
    public Quadrado (int x, int y, int l)
    {
        this (x, y, l, Color.BLACK, Color.white);
    }
	
    public Quadrado (int x, int y, int l, Color cor, Color cor2)
    {
        super (cor, cor2);

        this.inicio  = new Ponto (x,y);
        this.side   = l;
    }

    public Quadrado (String s)
    {
        StringTokenizer quebrador = new StringTokenizer(s,":");

        quebrador.nextToken();

        int   x   = Integer.parseInt(quebrador.nextToken());
        int   y   = Integer.parseInt(quebrador.nextToken());

        int   l   = Integer.parseInt(quebrador.nextToken());

        Color cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                               Integer.parseInt(quebrador.nextToken()),  // G
                               Integer.parseInt(quebrador.nextToken())); // B
         
        Color cor2 = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                				Integer.parseInt(quebrador.nextToken()),  // G
                				Integer.parseInt(quebrador.nextToken())); // B

        this.inicio   = new Ponto (x,y,cor, cor2);
        this.side    = l;
        this.cor      = cor;
        this.cor2     = cor2;
    }

    public void setInicio (int x, int y)
    {
        this.inicio = new Ponto (x,y,this.getCor(), this.cor2);
    }

    public void setSide (int l)
    {
        this.side = l;
    }
       
    public Ponto getInicio ()
    {
        return this.inicio;
    }

    public int setSide ()
    {
        return this.side;
    }

    public void torneSeVisivel (Graphics g)
    {
    	float aux = this.inicio.getX();
    	
        if (aux > 0) 
        {
            g.setColor (this.cor);
            g.drawRect (this.inicio.getX()-side, this.inicio.getY()-side, side, side);
            
            g.setColor(this.cor2);
            g.fillRect(this.inicio.getX()-side+1, this.inicio.getY()-side+1, side-1, side-1);	
        }
    }

    public String toString()
    {
        return "c:" +
               this.inicio.getX() +
               ":" +
               this.inicio.getY() +
               ":" +
               this.side +
               ":" +
               this.getCor().getRed() +
               ":" +
               this.getCor().getGreen() +
               ":" +
               this.getCor().getBlue();
    }
}
