import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.imageio.*;

import java.io.*;
import java.util.*;

public class Janela extends JFrame // implements Cloneable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton btnPonto      = new JButton ("Ponto"),
                    btnLinha      = new JButton ("Linha"),
                    btnCirculo    = new JButton ("Circulo"),
                    btnElipse     = new JButton ("Elipse"),
                    btnRetangulo  = new JButton ("Retangulo"),
                    btnQuadrado   = new JButton ("Quadrado"),
                    btnTexto      = new JButton ("Texto"),
                    btnCores      = new JButton ("Contorno"),
                    btnCores2     = new JButton ("Preenchimento"),
                    btnAbrir      = new JButton ("Abrir"),
                    btnSalvar     = new JButton ("Salvar"),
                    btnApagar     = new JButton ("Apagar"),
                    btnSair       = new JButton ("Sair");

    private MeuJPanel pnlDesenho = new MeuJPanel ();
    
    private JLabel statusBar1 = new JLabel ("Mensagem:"),
                   statusBar2 = new JLabel ("Coordenada:");

    boolean esperaPonto, esperaInicioReta, esperaFimReta, esperaInicioCirculo, esperaFimCirculo, esperaInicioElipse, esperaFimElipse,
    		esperaInicioRet, esperaFimRet, esperaInicioQuadrado, esperaFimQuadrado, esperaInicioTexto, esperaFimTexto;

    private Color corAtual = Color.black;
    private Color corAtual2 = Color.WHITE;
    private String stringTexto    = null;
    private Ponto p1;
    
    private Vector<Figura> figuras = new Vector<Figura>();

    public Janela ()
    {
        super("Editor Gráfico");

        try
        {
            Image btnPontoImg = ImageIO.read(getClass().getResource("resources/ponto.jpg"));
            btnPonto.setIcon(new ImageIcon(btnPontoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo ponto.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnLinhaImg = ImageIO.read(getClass().getResource("resources/linha.jpg"));
            btnLinha.setIcon(new ImageIcon(btnLinhaImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo linha.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnCirculoImg = ImageIO.read(getClass().getResource("resources/circulo.jpg"));
            btnCirculo.setIcon(new ImageIcon(btnCirculoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo circulo.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnElipseImg = ImageIO.read(getClass().getResource("resources/elipse.jpg"));
            btnElipse.setIcon(new ImageIcon(btnElipseImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo elipse.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnRetanguloImg = ImageIO.read(getClass().getResource("resources/retangulo.jpg"));
            btnRetangulo.setIcon(new ImageIcon(btnRetanguloImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo elipse.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        try
        {
            Image btnQuadradoImg = ImageIO.read(getClass().getResource("resources/quadrado.jpg"));
            btnQuadrado.setIcon(new ImageIcon(btnQuadradoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo elipse.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        try
        {
            Image btnTextoImg = ImageIO.read(getClass().getResource("resources/texto.jpg"));
            btnTexto.setIcon(new ImageIcon(btnTextoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo elipse.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        try
        {
            Image btnCoresImg = ImageIO.read(getClass().getResource("resources/cores.jpg"));
            btnCores.setIcon(new ImageIcon(btnCoresImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo cores.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        
        try
        {
            Image btnCoresImg = ImageIO.read(getClass().getResource("resources/cores.jpg"));
            btnCores2.setIcon(new ImageIcon(btnCoresImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo cores.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }
        

        try
        {
            Image btnAbrirImg = ImageIO.read(getClass().getResource("resources/abrir.jpg"));
            btnAbrir.setIcon(new ImageIcon(btnAbrirImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo abrir.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnSalvarImg = ImageIO.read(getClass().getResource("resources/salvar.jpg"));
            btnSalvar.setIcon(new ImageIcon(btnSalvarImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo salvar.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnApagarImg = ImageIO.read(getClass().getResource("resources/apagar.jpg"));
            btnApagar.setIcon(new ImageIcon(btnApagarImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo apagar.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnSairImg = ImageIO.read(getClass().getResource("resources/sair.jpg"));
            btnSair.setIcon(new ImageIcon(btnSairImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo sair.jpg não foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        btnPonto.addActionListener (new DesenhoDePonto());
        btnLinha.addActionListener (new DesenhoDeReta ());
        btnCirculo.addActionListener(new DesenhoDeCirculo());
        btnElipse.addActionListener(new DesenhoDeElipse());
        btnCores.addActionListener(new EscolhaDaCor());
        btnCores2.addActionListener(new EscolhaDaCor2());
        btnSair.addActionListener(new FechamentoDeJanela1());
        btnRetangulo.addActionListener(new DesenhoDoRetangulo());
        btnQuadrado.addActionListener(new DesenhoDoQuadrado());
        btnTexto.addActionListener(new EscreveTexto());
        
        JPanel     pnlBotoes = new JPanel();
        FlowLayout flwBotoes = new FlowLayout(); 
        pnlBotoes.setLayout (flwBotoes);

        pnlBotoes.add (btnAbrir);
        pnlBotoes.add (btnSalvar);
        pnlBotoes.add (btnPonto);
        pnlBotoes.add (btnLinha);
        pnlBotoes.add (btnCirculo);
        pnlBotoes.add (btnElipse);
        pnlBotoes.add (btnRetangulo);
        pnlBotoes.add (btnQuadrado);
        pnlBotoes.add (btnTexto);
        pnlBotoes.add (btnCores);
        pnlBotoes.add (btnCores2);
        pnlBotoes.add (btnApagar);
        pnlBotoes.add (btnSair);

        JPanel     pnlStatus = new JPanel();
        GridLayout grdStatus = new GridLayout(1,2);
        pnlStatus.setLayout(grdStatus);

        pnlStatus.add(statusBar1);
        pnlStatus.add(statusBar2);

        Container cntForm = this.getContentPane();
        cntForm.setLayout (new BorderLayout());
        cntForm.add (pnlBotoes,  BorderLayout.NORTH);
        cntForm.add (pnlDesenho, BorderLayout.CENTER);
        cntForm.add (pnlStatus,  BorderLayout.SOUTH);
        
        this.addWindowListener (new FechamentoDeJanela());

        this.setSize (700,500);
        this.setVisible (true);
    }
            
    private class MeuJPanel extends    JPanel 
                            implements MouseListener,
                                       MouseMotionListener
    {
		private static final long serialVersionUID = 1L;

		public MeuJPanel()
        {
            super();

            this.addMouseListener       (this);
            this.addMouseMotionListener (this);
        }

        public void paint (Graphics g)
        {
            for (int i=0 ; i<figuras.size(); i++)
                figuras.get(i).torneSeVisivel(g);
        }
        
        public void mousePressed (MouseEvent e)
        {
            if (esperaPonto)
            {
                figuras.add (new Ponto (e.getX(), e.getY(), corAtual, corAtual2));
                figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                esperaPonto = true;
            }
            else
                if (esperaInicioReta)
                {
                    p1 = new Ponto (e.getX(), e.getY(), corAtual, corAtual2);
                    esperaPonto = false;
                    esperaInicioReta = false;
                    esperaFimReta = true;
                    esperaInicioCirculo = false;
                    esperaFimCirculo = false;
                    esperaInicioElipse = false;
                    esperaFimElipse = false;
                    esperaInicioRet = false;
                    esperaFimRet    = false;
                    esperaInicioQuadrado = false;
                    esperaFimQuadrado    = false;
                    esperaInicioTexto  = false;
                    esperaFimTexto    =  false;
                    
                    statusBar1.setText("Mensagem: clique o ponto final da reta");    
                 }
                 else
                    if (esperaFimReta)
                    {
                        esperaPonto = false;
                        esperaInicioReta = true;
                        esperaFimReta = false;
                        esperaInicioCirculo = false;
                        esperaFimCirculo = false;
                        esperaInicioElipse = false;
                        esperaFimElipse = false;
                        esperaInicioRet = false;
                        esperaFimRet    = false; 
                        esperaInicioQuadrado = false;
                        esperaFimQuadrado = false;
                        esperaInicioTexto  = false;
                        esperaFimTexto    =  false;

                        figuras.add (new Linha(p1.getX(), p1.getY(), e.getX(), e.getY(), corAtual, corAtual2));
                        figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                        statusBar1.setText("Mensagem:");    
                    }
                    else
                    	if (esperaInicioCirculo)
                    	{
                            esperaPonto = false;
                            p1 = new Ponto (e.getX(), e.getY(), corAtual, corAtual2);
                            esperaInicioReta = false;
                            esperaFimReta = false;
                            esperaInicioCirculo = false;
                            esperaFimCirculo = true;
                            esperaInicioElipse = false;
                            esperaFimElipse = false;
                            esperaInicioRet = false;
                            esperaFimRet    = false;
                            esperaInicioQuadrado = false;
                            esperaFimQuadrado = false;
                                                       
                            statusBar1.setText("Mensagem: clique o ponto final do circulo");  
                    	}
                    	else        
                    		if(esperaFimCirculo)
                    		{
                                esperaPonto = false;
                                esperaInicioReta = false;
                                esperaFimReta = false;
                                esperaInicioCirculo = true;
                                esperaFimCirculo = false;
                                esperaInicioElipse = false;
                                esperaFimElipse = false;
                                esperaInicioRet = false;
                                esperaFimRet    = false;
                                esperaInicioQuadrado = false;
                                esperaFimQuadrado = false;
                                esperaInicioTexto  = false;
                                esperaFimTexto    =  false;
                                
                                double raio = Math.sqrt((e.getX() - p1.getX())*(e.getX() - p1.getX()) + (e.getY() - p1.getY())*(e.getY() - p1.getY()));
                                
                                if (raio < 0)
                                	raio = Math.sqrt((e.getX() - p1.getX())*(p1.getX() - e.getX()) + (p1.getY() - e.getY())*(p1.getY() - e.getY()));
                                
                                figuras.add (new Circulo(p1.getX(), p1.getY(), (int)raio, corAtual, corAtual2));
                                figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                                statusBar1.setText("Mensagem:");
                    		}
                    		else
                    			if(esperaInicioElipse)
                    			{
                                    esperaPonto = false;
                                    p1 = new Ponto (e.getX(), e.getY(), corAtual, corAtual2);
                                    esperaInicioReta = false;
                                    esperaFimReta = false;
                                    esperaInicioCirculo = false;
                                    esperaFimCirculo = false;
                                    esperaInicioElipse = false;
                                    esperaFimElipse = true;
                                    esperaInicioRet = false;
                                    esperaFimRet    = false;
                                    esperaInicioQuadrado = false;
                                    esperaFimQuadrado = false;
                                    esperaInicioTexto  = false;
                                    esperaFimTexto    =  false;
                                    
                                    statusBar1.setText("Mensagem: clique o ponto final da Elipse");  
                    			}
                    			else
                    				if(esperaFimElipse)
                    				{
                                        esperaPonto = false;
                                        esperaInicioReta = false;
                                        esperaFimReta = false;
                                        esperaInicioCirculo = false;
                                        esperaFimCirculo = false;
                                        esperaInicioElipse = true;
                                        esperaFimElipse = false;
                                        esperaInicioRet = false;
                                        esperaFimRet    = false;
                                        esperaInicioQuadrado = false;
                                        esperaFimQuadrado = false;
                                        esperaInicioTexto  = false;
                                        esperaFimTexto    =  false;
                                        
                                        float aux = e.getX() -p1.getX();
                                        
                                        if (aux > 0)
                                        	figuras.add (new Elipse(p1.getX(), p1.getY(), e.getX() - p1.getX(), e.getY() - p1.getY(), corAtual, corAtual2));
                                        else
                                        	figuras.add (new Elipse(p1.getX(), p1.getY(), p1.getX() - e.getX(), p1.getY() - e.getY(), corAtual, corAtual2));
                                      
                                        figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                                        statusBar1.setText("Mensagem:");           
                    				}
                    				else
                    					if(esperaInicioRet)
                    					{
                                            esperaPonto = false;
                                            p1 = new Ponto (e.getX(), e.getY(), corAtual, corAtual2);
                                            esperaInicioReta = false;
                                            esperaFimReta = false;
                                            esperaInicioCirculo = false;
                                            esperaFimCirculo = false;
                                            esperaInicioElipse = false;
                                            esperaFimElipse = false;
                                            esperaInicioRet = false;
                                            esperaFimRet    = true;
                                            esperaInicioQuadrado = false;
                                            esperaFimQuadrado = false;
                                            esperaInicioTexto  = false;
                                            esperaFimTexto    =  false;
                                            
                                            statusBar1.setText("Mensagem: clique o ponto final do retangulo");  
                    					}
                    					else
                    						if(esperaFimRet)
                    						{
                                                esperaPonto = false;
                                                esperaInicioReta = false;
                                                esperaFimReta = false;
                                                esperaInicioCirculo = false;
                                                esperaFimCirculo = false;
                                                esperaInicioElipse = false;
                                                esperaFimElipse = false;
                                                esperaInicioRet = true;
                                                esperaFimRet    = false;
                                                esperaInicioQuadrado = false;
                                                esperaFimQuadrado = false;
                                                esperaInicioTexto  = false;
                                                esperaFimTexto    =  false;
                                                
                                               
                                                figuras.add (new Retangulo(p1.getX(), p1.getY(), p1.getX() - e.getX(), p1.getY() - e.getY(), corAtual, corAtual2));
                                                //figuras.add (new Retangulo(p1.getX(), p1.getY(), e.getX() - p1.getX(), p1.getY() - e.getY(), corAtual, corAtual2));
                                              
                                                figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                                                statusBar1.setText("Mensagem:");   
                    						}
                    						else
                    							if(esperaInicioQuadrado)
                    							{
                                                    esperaPonto = false;
                                                    p1 = new Ponto (e.getX(), e.getY(), corAtual, corAtual2);
                                                    esperaInicioReta = false;
                                                    esperaFimReta = false;
                                                    esperaInicioCirculo = false;
                                                    esperaFimCirculo = false;
                                                    esperaInicioElipse = false;
                                                    esperaFimElipse = false;
                                                    esperaInicioRet = false;
                                                    esperaFimRet    = false;
                                                    esperaInicioQuadrado = false;
                                                    esperaFimQuadrado = true;
                                                    esperaInicioTexto  = false;
                                                    esperaFimTexto    =  false;
                                                    
                                                    statusBar1.setText("Mensagem: clique o ponto final do Quadrado");
                                            	}
                    							else
                    								if(esperaFimQuadrado)
                    								{
                                                        esperaPonto = false;
                                                        esperaInicioReta = false;
                                                        esperaFimReta = false;
                                                        esperaInicioCirculo = false;
                                                        esperaFimCirculo = false;
                                                        esperaInicioElipse = false;
                                                        esperaFimElipse = false;
                                                        esperaInicioRet = false;
                                                        esperaFimRet    = false;
                                                        esperaInicioQuadrado = true;
                                                        esperaFimQuadrado = false;
                                                        esperaInicioTexto  = false;
                                                        esperaFimTexto    =  false;
                                                        
                                                        figuras.add (new Quadrado(p1.getX(), p1.getY(), p1.getX() - e.getX(), corAtual, corAtual2));
                                                        //figuras.add (new Quadrado(p1.getX(), p1.getY(), e.getX() - p1.getX(), corAtual, corAtual2));
                                                        
                                                        figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                                                        statusBar1.setText("Mensagem:");   
                    								}
                    								else
                    									if(esperaInicioTexto)
                    									{
                                                            esperaPonto = false;
                                                            p1 = new Ponto (e.getX(), e.getY(), corAtual, corAtual2);
                                                            stringTexto = JOptionPane.showInputDialog(null, "Texto:", "Digite alguma coisa", JOptionPane.PLAIN_MESSAGE);
                                                            esperaInicioReta = false;
                                                            esperaFimReta = false;
                                                            esperaInicioCirculo = false;
                                                            esperaFimCirculo = false;
                                                            esperaInicioElipse = false;
                                                            esperaFimElipse = false;
                                                            esperaInicioRet = false;
                                                            esperaFimRet    = false;
                                                            esperaInicioQuadrado = false;
                                                            esperaFimQuadrado = false;
                                                            esperaInicioTexto  = true;
                                                           
                                                            figuras.add (new Texto(p1.getX(), p1.getY(), stringTexto, corAtual, corAtual2));
                                                            figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                                                            
                                                            statusBar1.setText("Mensagem: Digite o texto a ser exibido");
                    									}
                    									/*else
                    										if(esperaFimTexto)
                    										{
                                                                esperaPonto = false;
                                                                esperaInicioReta = false;
                                                                esperaFimReta = false;
                                                                esperaInicioCirculo = false;
                                                                esperaFimCirculo = false;
                                                                esperaInicioElipse = false;
                                                                esperaFimElipse = false;
                                                                esperaInicioRet = false;
                                                                esperaFimRet    = false;
                                                                esperaInicioQuadrado = false;
                                                                esperaFimQuadrado = false;
                                                                esperaInicioTexto  = true;
                                                                esperaFimTexto    =  false;
                                                                                                                       		                                                                
                                                                //figuras.add (new Texto(p1.getX(), p1.getY(), stringTexto, corAtual, corAtual2));
                                                                //figuras.add (new Quadrado(p1.getX(), p1.getY(), e.getX() - p1.getX(), corAtual, corAtual2));
                                                                
                                                                //figuras.get(figuras.size()-1).torneSeVisivel(pnlDesenho.getGraphics());
                                                                statusBar1.setText("Mensagem:");   
                    										}*/
                    						
        }
        
        public void mouseReleased (MouseEvent e)
        {}
        
        public void mouseClicked (MouseEvent e)
        {}
        
        public void mouseEntered (MouseEvent e)
        {}

        public void mouseExited (MouseEvent e)
        {}
        
        public void mouseDragged(MouseEvent e)
        {}

        public void mouseMoved(MouseEvent e)
        {
            statusBar2.setText("Coordenada: "+e.getX()+","+e.getY());
        }
    }

    private class DesenhoDePonto implements ActionListener
    {
          public void actionPerformed (ActionEvent e)    
          {
              esperaPonto      = true;
              esperaInicioReta = false;
              esperaFimReta    = false;
              esperaInicioCirculo = false;
              esperaFimCirculo = true;
              esperaInicioElipse = false;
              esperaFimElipse = false;
              esperaInicioRet = false;
              esperaFimRet    = false;
              esperaInicioQuadrado = false;
              esperaFimQuadrado = false;
              esperaInicioTexto = false;
              esperaFimTexto    = false;

              statusBar1.setText("Mensagem: clique o local do ponto desejado");
          }
    }

    private class DesenhoDeReta implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
            esperaPonto      = false;
            esperaInicioReta = true;
            esperaFimReta    = false;
            esperaInicioCirculo = false;
            esperaFimCirculo = true;
            esperaInicioElipse = false;
            esperaFimElipse = false;
            esperaInicioRet = false;
            esperaFimRet    = false;
            esperaInicioQuadrado = false;
            esperaFimQuadrado = false;
            esperaInicioTexto = false;
            esperaFimTexto    = false;


            statusBar1.setText("Mensagem: clique o ponto inicial da reta");
        }
    }

    private class DesenhoDeCirculo implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
            esperaPonto      = false;
            esperaInicioReta = false;
            esperaFimReta    = false;
            esperaInicioCirculo = true;
            esperaFimCirculo = false;
            esperaInicioElipse = false;
            esperaFimElipse = false;
            esperaInicioRet = false;
            esperaFimRet    = false;
            esperaInicioQuadrado = false;
            esperaFimQuadrado = false;
            esperaInicioTexto = false;
            esperaFimTexto    = false;


            statusBar1.setText("Mensagem: clique o ponto inicial do Circulo");
        }
    }
    private class DesenhoDeElipse implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
            esperaPonto      = false;
            esperaInicioReta = false;
            esperaFimReta    = false;
            esperaInicioCirculo = false;
            esperaFimCirculo = false;
            esperaInicioElipse = true;
            esperaFimElipse = false;
            esperaInicioRet = false;
            esperaFimRet    = false;
            esperaInicioQuadrado = false;
            esperaFimQuadrado = false;
            esperaInicioTexto = false;
            esperaFimTexto    = false;


            statusBar1.setText("Mensagem: clique o ponto inicial da Elipse");
        }
    }
    
    private class DesenhoDoRetangulo implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
            esperaPonto      = false;
            esperaInicioReta = false;
            esperaFimReta    = false;
            esperaInicioCirculo = false;
            esperaFimCirculo = false;
            esperaInicioElipse = false;
            esperaFimElipse = false;
            esperaInicioRet = true;
            esperaFimRet    = false;
            esperaInicioQuadrado = false;
            esperaFimQuadrado = false;
            esperaInicioTexto = false;
            esperaFimTexto    = false;

            statusBar1.setText("Mensagem: clique o ponto inicial da Retangulo");
        }
    }
    
    private class DesenhoDoQuadrado implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
            esperaPonto      = false;
            esperaInicioReta = false;
            esperaFimReta    = false;
            esperaInicioCirculo = false;
            esperaFimCirculo = false;
            esperaInicioElipse = false;
            esperaFimElipse = false;
            esperaInicioRet = false;
            esperaFimRet    = false;
            esperaInicioQuadrado = true;
            esperaFimQuadrado = false;
            esperaInicioTexto = false;
            esperaFimTexto    = false;


            statusBar1.setText("Mensagem: clique o ponto inicial do Quadrado");
        }
    }
    
    @SuppressWarnings("serial")//Deixa de lado os warinings da classe abaixo
	private class EscreveTexto extends JFrame implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
            esperaPonto      = false;
            esperaInicioReta = false;
            esperaFimReta    = false;
            esperaInicioCirculo = false;
            esperaFimCirculo = false;
            esperaInicioElipse = false;
            esperaFimElipse = false;
            esperaInicioRet = false;
            esperaFimRet    = false;
            esperaInicioQuadrado = false;
            esperaFimQuadrado = false;
            esperaInicioTexto = true;
            esperaFimTexto    = false;
                                    
            statusBar1.setText("Mensagem: clique o ponto inicial do Quadrado");
        }
    }
    
    private class EscolhaDaCor implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
        	Color cl = JColorChooser.showDialog(btnCores, "Selecione a Cor", Color.yellow);
        	corAtual = cl;
        }
    }

    private class EscolhaDaCor2 implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
        	Color cl = JColorChooser.showDialog(btnCores2, "Selecione a Cor", Color.yellow);
        	corAtual2 = cl;
        }
    }
//Fechamendo da janela funciona da mesma forma
    private class FechamentoDeJanela1 implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
        	System.exit(0);
        }
    }
        
    private class FechamentoDeJanela extends WindowAdapter
    {
        public void windowClosing (WindowEvent e)
        {
            System.exit(0);
        }
    }

  //public Object  clone    ();
  //public         Janela   (Janela modelo);
  //public boolean equals   (Object obj);
  //public int     hashCode ();
  //public String  toString ();
}
