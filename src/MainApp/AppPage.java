package MainApp;
//Main access page of the software


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.*;
import java.awt.image.BufferedImage;






public class AppPage extends JFrame implements MouseListener 

{
	/**
	 * 3
	 */
	private static final long serialVersionUID = 1L;
	//declaring components
	public JComboBox<String> regionBox;
	public JComboBox<String> CropBox;
	JLabel mainlb;

	JButton jb;
	Font myfont;
	Font boxFont;
	JLabel lb2;
	AppCalendar apCal;
	SimpleDateFormat formatter=null;
	Date date_get;
	String user_date;
	JButton btnShowForecast;
	JButton btnCropProperties ;
	JLabel lb3;
	static boolean fCheck = false;

	int interval;
	Timer timer;
	boolean check = false;
	public static Loading ld;
	Forecast fs;
	String region="";

	static CropInfo cropI;

	JLabel regionL;

	@SuppressWarnings("deprecation")
	
	public AppPage(){

		setTitle("MainPage");
		regionBox = new JComboBox<String>();
		CropBox = new JComboBox<String>();
		addMouseListener(this);

		getContentPane().setLayout(null);
		;
		//manipulating components

		int bxC = -370, byC = 100;

		jb = new JButton();

		jb.setBounds(730 + bxC,350+ byC,175,120);
		jb.setIcon(new ImageIcon("img/analyse.png"));
		jb.setRolloverIcon(new ImageIcon("img/analyse_mo.png"));
		jb.setCursor((new Cursor ( Cursor.HAND_CURSOR)));
		jb.setOpaque(false);
		jb.setContentAreaFilled(false);
		jb.setBorderPainted(false);
		jb.setFocusable(false);
		getContentPane().add(jb);
		jb.addMouseListener(this);

		try
		{
			myfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/font.otf")).deriveFont(30f);
			boxFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/font.otf")).deriveFont(16f);

		}

		catch(Exception e)
		{
			System.out.println("There was an error reading image files!");
			System.out.println(e);
			System.exit(0);
		}

		lb3 = new JLabel();
		lb3.setBounds(30,30,400,100);
		lb3.setFont(myfont);
		lb3.setForeground(new Color (255,255,255));
		lb3.setText("1.Enter Crop Data");
		getContentPane().add(lb3);




		regionBox.setBounds(35,220,220,30);
		regionBox.setCursor(new Cursor ( Cursor.HAND_CURSOR));
		regionBox.addItem("Select Region:");
		regionBox.addItem("Rawalpindi");
		regionBox.addItem("Lahore");
		regionBox.addItem("Sialkot");
		regionBox.addItem("Multan");
		regionBox.setForeground(Color.BLACK);
		regionBox.setFocusable(false);
		regionBox.setFont(boxFont);

		JButton btn = (JButton)regionBox.getComponent(0);



		try {
			
			BufferedImage editImage  = ImageIO.read(new File ("img/dropd.png"));
			btn.setIcon(new ImageIcon(editImage));

		}
		catch (Exception eo){}

		getContentPane().add(regionBox);


		lb2 = new JLabel();
		lb2.setBounds(590,105,400,100);
		lb2.setFont(myfont);
		lb2.setForeground(new Color (63,99,63));
		lb2.setText("Current Date : ");
		getContentPane().add(lb2);


		regionL = new JLabel();
		regionL.setBounds(35,105,400,100);
		regionL.setFont(myfont);
		regionL.setForeground(new Color (63,99,63));
		regionL.setText("Select Region : ");
		getContentPane().add(regionL);



		CropBox.setBounds(35,370,220,30);
		CropBox.setCursor(new Cursor ( Cursor.HAND_CURSOR));
		CropBox.addItem("Select Crop:");
		CropBox.addItem("Wheat");
		CropBox.addItem("Maize");
		CropBox.addItem("Corn");
		CropBox.addItem("Barley");

		CropBox.setFont(boxFont);
		CropBox.setForeground(Color.BLACK);
		CropBox.setFocusable(false);
		getContentPane().add(CropBox);
		JButton btn2 = (JButton)CropBox.getComponent(0);



		try {


			BufferedImage editImage  = ImageIO.read(new File ("img/dropd.png"));
			btn2.setIcon(new ImageIcon(editImage));

		}
		catch (Exception eo){}




		apCal = new AppCalendar();
		apCal.setBounds(590,220,220,30);
		
		formatter = new SimpleDateFormat("dd-MM-yyyy");
		date_get=apCal.picker.getDate();
		user_date = formatter.format(date_get);


		System.out.print(""+user_date);
		getContentPane().add(apCal);

		getContentPane().setLayout(null);

		btnCropProperties = new JButton("Crop Properties");
		btnCropProperties.setBounds(30, 474, 175, 73);
		btnCropProperties.addMouseListener(this);
		btnCropProperties.setIcon(new ImageIcon("img/showi.png"));
		btnCropProperties.setRolloverIcon(new ImageIcon("img/showi_mo.png"));
		btnCropProperties.setCursor((new Cursor ( Cursor.HAND_CURSOR)));
		btnCropProperties.setOpaque(false);
		btnCropProperties.setContentAreaFilled(false);
		btnCropProperties.setBorderPainted(false);
		btnCropProperties.setFocusable(false);
		getContentPane().add(btnCropProperties);

		btnShowForecast = new JButton("Show Forecast");
		btnShowForecast.setBounds(676, 477, 175, 66);
		btnShowForecast.addMouseListener(this);
		btnShowForecast.setIcon(new ImageIcon("img/viewf.png"));
		btnShowForecast.setRolloverIcon(new ImageIcon("img/viewf_mo.png"));
		btnShowForecast.setCursor((new Cursor ( Cursor.HAND_CURSOR)));
		btnShowForecast.setOpaque(false);
		btnShowForecast.setContentAreaFilled(false);
		btnShowForecast.setBorderPainted(false);
		btnShowForecast.setFocusable(false);
		getContentPane().add(btnShowForecast);

		
		mainlb = new JLabel ( new ImageIcon("img/main.jpg"));
		mainlb.setBounds(0,0,900,600);
		getContentPane().add(mainlb);
		setBounds(150, 50, 900, 600);
		setUndecorated(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	
	}

	public static void main(String[] args)

	{

		Splash ss = new Splash();	

		try
		{
			Thread.sleep(4800);
		}
		catch(Exception e)
		{
		}

		ss.dispose();
		new AppPage();
	}





	@Override
	public void mouseClicked(MouseEvent me) {
		// TODO Auto-generated method stub

		Object obj1 = me.getSource();

		if (obj1 == jb){


			
				if ( regionBox.getSelectedIndex() == 0 ){

					JOptionPane.showMessageDialog(null, "Select any region to proceed!","No Region Selected" , 0);


				}
				else {

					if ( fCheck == false){
						JOptionPane.showMessageDialog(null, "Forecast Weather First! ","No Forecast" , 0);
					}
					else {
						
						System.out.println("-------------->> IND: " + CropBox.getSelectedIndex());
						new CropInfo((String)CropBox.getSelectedItem(),(String)regionBox.getSelectedItem(),CropBox.getSelectedIndex());
						this.dispose();
					}
				}
			}

		


		if ( obj1 == btnCropProperties){

			if ( CropBox.getSelectedIndex() == 0){
				JOptionPane.showMessageDialog(null, "Select any crop to proceed!","No Crop Selected" , 0);

			}


			else {

				this.dispose();
				new CropProperty((String) CropBox.getSelectedItem());
			}

		}

		if ( obj1 == btnShowForecast)
		{
			if ( regionBox.getSelectedIndex() == 0){

				JOptionPane.showMessageDialog(null, "Select any region to proceed!","No Region Selected" , 0);

			}
			else {

				fCheck = true;
				ld = new Loading();
				String secs = "8";
				int delay = 1000;
				int period = 1000;
				timer = new Timer();
				interval = Integer.parseInt(secs);
				timer.scheduleAtFixedRate(new TimerTask() {

					public void run() {
						System.out.println(setInterval());

					}
				}, delay, period);



			}
		}
	}


	int setInterval() {
		if (interval == 1){
			timer.cancel();
			ld.dispose();
			this.dispose();
			fs.setVisible(true);

		}


		if ( interval == 5){

			region = (String)regionBox.getSelectedItem();
			fs = new Forecast(region);
			fs.setVisible(false);
		}
		return --interval;
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}



