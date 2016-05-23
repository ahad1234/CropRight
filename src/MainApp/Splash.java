package MainApp;
//splash screen code goes here

import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
import java.lang.Math;
import java.awt.event.*;





class Splash extends JFrame

{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    JLabel loading;

    public Splash()

    {
	loading = new JLabel ( new ImageIcon ("img/loadingfinal.gif"));
	loading.setBounds(295,480,230,30);
	add(loading);
	
	setLayout(null);
	setBounds(150, 50, 900, 600);
	setUndecorated(true);
	setResizable(false);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	SPanel spnl = new SPanel();
	
	add(spnl);

	setVisible(true);
    }
}


class SPanel extends JPanel

{
    BufferedImage splash;
   

    {
	try

	{

	    splash = ImageIO.read(new File("img/bg.jpg")); //steps

	}

	catch(Exception e)
	{
	    System.out.println("There was an error reading image files!");
	    System.out.println(e);
	    System.exit(0);
	}
    }

    SPanel()

    {		

	setLayout(null);
	setBounds(0,0,900,600);
	
    }
    
    public void paintComponent(Graphics g)

    {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;
	
	g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);  
	g2d.drawImage(splash,0,0,900,600, null);

    }


}