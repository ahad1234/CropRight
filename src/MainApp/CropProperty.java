package MainApp;
import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class CropProperty extends JFrame implements MouseListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    JLabel mainlb;
    JTextPane textPane;
    Font paneFont;
    Font lFont;
    Scanner sc;
    JLabel cropP;
    private JButton btnBack;
    String crop_name="";

    CropProperty(String crop_get){
	
	crop_name = crop_get;

	getContentPane().setLayout(null);

	try
	{
	    paneFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/font.otf")).deriveFont(18.15f);
	    lFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/font.otf")).deriveFont(40f);
	    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); 

	}

	catch(Exception e)
	{
	    System.out.println("There was an error reading image files!");
	    System.out.println(e);
	    System.exit(0);
	}


	btnBack = new JButton();
	btnBack.setBounds(-21, -2, 155, 150);
	btnBack.addMouseListener(this);
	btnBack.setIcon(new ImageIcon("img/back.png"));
	btnBack.setRolloverIcon(new ImageIcon("img/back.png"));
	btnBack.setCursor((new Cursor ( Cursor.HAND_CURSOR)));
	btnBack.setOpaque(false);
	btnBack.setContentAreaFilled(false);
	btnBack.setBorderPainted(false);
	btnBack.setFocusable(false);
	getContentPane().add(btnBack);


	cropP = new JLabel ("Crop Properties: ");
	cropP.setHorizontalAlignment(SwingConstants.CENTER);
	cropP.setForeground(Color.WHITE);
	cropP.setFont(lFont);
	cropP.setBounds(250,39,400,71);
	getContentPane().add(cropP);


	textPane = new JTextPane();
	textPane.setBounds(10, 131, 874, 411);
	getContentPane().add(textPane);
	textPane.setForeground(Color.BLACK);
	textPane.setOpaque(false);
	textPane.setFont(paneFont);
	textPane.setEditable(false);


	mainlb = new JLabel ( new ImageIcon("img/maintest.jpg"));
	mainlb.setBounds(0,0,900,600);
	getContentPane().add( mainlb);




	try {
	    if ( crop_name.matches("Wheat")){
	    sc = new Scanner(  new File ("cropdata/Wheat.txt"));
	    }
	    
	    if ( crop_name.matches("Maize")){
		 sc = new Scanner(  new File ("cropdata/Maize.txt"));
	    }
	}
	catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	while ( sc.hasNext()){
	    textPane.setText(textPane.getText() + sc.nextLine() + "\n");
	}


	setBounds(150, 50, 900, 600);
	setUndecorated(false);
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);




    }


    public static void main (String[]args){

	//new CropProperties(String crop_get);

    }


    @Override
    public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
	if ( e.getSource() == btnBack){
	    this.dispose();
	    new AppPage();
	    
	}
	
    }


    @Override
    public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
    }


    @Override
    public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
    }


    @Override
    public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
    }


    @Override
    public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
    }
}
