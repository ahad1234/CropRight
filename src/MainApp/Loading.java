package MainApp;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
class Loading extends JFrame

{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    JLabel mainlb;
    JLabel load;
    JLabel loadL;
    Font myFont;

    public Loading()

    {

	try
	{
	    myFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/font.otf")).deriveFont(22f);


	    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); 

	}

	catch(Exception e){}

	setLayout (null);
	mainlb = new JLabel ( new ImageIcon("img/load.jpg"));
	mainlb.setBounds(0,0,650,300);
	load  = new JLabel(new ImageIcon("img/test2.gif"));
	load.setBounds(240,80,70,80);
	loadL = new JLabel ( "Gathering Forecast...");
	loadL.setFont(myFont);
	loadL.setForeground(Color.WHITE);
	loadL.setBounds(190,120,200,100);
	add(loadL);

	add( load);
	add( mainlb);
	LPanel lp = new LPanel();
	add(lp);

	setBounds(350,300,550,200);
	setUndecorated(true);
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
    }
}


class LPanel extends JPanel

{
    BufferedImage splash;


    {
	try

	{

	    splash = ImageIO.read(new File("img/load.jpg")); //steps
	
	}

	catch(Exception e)
	{
	    System.out.println("There was an error reading image files!");
	    System.out.println(e);
	    System.exit(0);
	}
    }

    LPanel()

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

