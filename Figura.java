import java.awt.*;

public abstract class Figura // implements Cloneable
{
    protected Color cor;
    protected Color cor2;
	  
    protected Figura ()
    {
        this (Color.BLACK, Color.white);
    }
	  
    protected Figura (Color cor, Color cor2)
    {
        this.setCores (cor, cor2);
        //this.setCor2 (cor2);
    }
	  
    public void setCores (Color cor, Color cor2)
    {
        this.cor = cor;
        this.cor2 = cor2;
    }
    /*public void setCor2 (Color cor2)
    {
    	this.cor2 = cor2;
    }*/
	  
    public Color getCor()
    {
    	return this.cor;
    }
    
    public Color getCor2()
    {
    	return this.cor2;
    }

  //public abstract Object  clone          ();
  //public abstract boolean equals         (Object obj);
  //public abstract int     hashCode       ();
    public abstract String  toString       ();
    public abstract void    torneSeVisivel (Graphics g);
}
