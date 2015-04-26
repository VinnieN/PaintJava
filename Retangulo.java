import java.awt.*;
import java.util.*;

public class Retangulo extends Figura
{
    protected Ponto inicio;
    protected int   width;
    protected int   height;
	
    public Retangulo (int x, int y, int w, int h)
    {
        this (x, y, w, h, Color.BLACK, Color.white);
    }
	
    public Retangulo (int x, int y, int w, int h, Color cor, Color cor2)
    {
        super (cor, cor2);

        this.inicio  = new Ponto (x,y);
        this.width   = w;
        this.height  = h;
    }

    public Retangulo (String s)
    {
        StringTokenizer quebrador = new StringTokenizer(s,":");

        quebrador.nextToken();

        int   x   = Integer.parseInt(quebrador.nextToken());
        int   y   = Integer.parseInt(quebrador.nextToken());

        int   w   = Integer.parseInt(quebrador.nextToken());
        int   h   = Integer.parseInt(quebrador.nextToken());

        Color cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                               Integer.parseInt(quebrador.nextToken()),  // G
                               Integer.parseInt(quebrador.nextToken())); // B
         
        Color cor2 = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                				Integer.parseInt(quebrador.nextToken()),  // G
                				Integer.parseInt(quebrador.nextToken())); // B

        this.inicio   = new Ponto (x,y,cor, cor2);
        this.width    = w;
        this.height   = h;
        this.cor      = cor;
        this.cor2     = cor2;
    }

    public void setInicio (int x, int y)
    {
        this.inicio = new Ponto (x,y,this.getCor(), this.cor2);
    }

    public void setWidth (int w)
    {
        this.width = w;
    }
    
    public void setHeight (int h)
    {
        this.height = h;
    }
    
    public Ponto getInicio ()
    {
        return this.inicio;
    }

    public int setWidth ()
    {
        return this.width;
    }
    
    public int setHeight()
    {
        return this.height;
    }

    public void torneSeVisivel (Graphics g)
    {
        g.setColor (this.cor);
        g.drawRect (this.inicio.getX()-width, this.inicio.getY()-height, width+1, height+1);
        
        g.setColor(this.cor2);
        g.fillRect(this.inicio.getX()-width+1, this.inicio.getY()-height+1, width, height);
			
    }

    public String toString()
    {
        return "c:" +
               this.inicio.getX() +
               ":" +
               this.inicio.getY() +
               ":" +
               this.width +
               ":" +
               this.height +
               ":" +
               this.getCor().getRed() +
               ":" +
               this.getCor().getGreen() +
               ":" +
               this.getCor().getBlue();
    }
}
