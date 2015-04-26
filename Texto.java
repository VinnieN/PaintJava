import java.awt.*;
import java.util.*;

public class Texto extends Figura
{
    protected Ponto inicio;
    protected String   string;
	
    public Texto (int x, int y,String texto)
    {
        this (x, y, texto, Color.BLACK, Color.white);
    }
	
    public Texto (int x, int y, String texto, Color cor, Color cor2)
    {
        super (cor, cor2);

        this.inicio  = new Ponto (x,y);
        this.string   = texto;
    }

    public Texto (String s)
    {
        StringTokenizer quebrador = new StringTokenizer(s,":");

        quebrador.nextToken();

        int   x   = Integer.parseInt(quebrador.nextToken());
        int   y   = Integer.parseInt(quebrador.nextToken());

        Color cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                               Integer.parseInt(quebrador.nextToken()),  // G
                               Integer.parseInt(quebrador.nextToken())); // B
         
        Color cor2 = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                				Integer.parseInt(quebrador.nextToken()),  // G
                				Integer.parseInt(quebrador.nextToken())); // B

        this.inicio   = new Ponto (x,y,cor, cor2);
        this.cor      = cor;
        this.cor2     = cor2;
    }

    public void setInicio (int x, int y)
    {
        this.inicio = new Ponto (x,y,this.getCor(), this.cor2);
    }

    public void setText (String texto)
    {
        this.string = texto;
    }
       
    public Ponto getInicio ()
    {
        return this.inicio;
    }

    public String setText ()
    {
        return this.string;
    }

    public void torneSeVisivel (Graphics g)
    {    	
            g.setColor (this.cor);
            g.drawString(this.string, this.inicio.getX(), this.inicio.getY());
            //g.drawRect (this.inicio.getX()-side, this.inicio.getY()-side, side, side);         
    }

    public String toString()
    {
        return "c:" +
               this.inicio.getX() +
               ":" +
               this.inicio.getY() +
               ":" +
               this.string.toString() +
               ":" +
               this.getCor().getRed() +
               ":" +
               this.getCor().getGreen() +
               ":" +
               this.getCor().getBlue();
    }
}
