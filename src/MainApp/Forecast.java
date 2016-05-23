package MainApp;
import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;



public class Forecast extends JFrame  implements MouseListener{

	JLabel mainlb;
	JLabel [] dateL;
	JLabel [] precpL;
	JLabel [] humdL;
	JLabel [] windsL;
	JLabel [] tempL;
	CropInfo crop_info;
	int x=255;
	ReadHTML readH;
	JButton btnBack;
	JLabel lb3;
	Font myfont;
	public String region="";
	JLabel lRegion;

	@SuppressWarnings("static-access")
	
	public Forecast(String s){
		region = s;
		addMouseListener(this);
		setLayout(null);

		try
		{
			myfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/font.otf")).deriveFont(30f);

			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); 
		}
		catch(Exception e)
		{
			System.out.println("There was an error reading image files!");
			System.out.println(e);
			System.exit(0);
		}

		lb3 = new JLabel();
		lb3.setBounds(320,30,400,100);
		lb3.setFont(myfont);
		lb3.setForeground(new Color (255,255,255));
		lb3.setText("Weather Forecast :");
		getContentPane().add(lb3);

		lRegion = new JLabel();
		lRegion.setBounds(590,30,400,100);
		lRegion.setFont(myfont);
		lRegion.setForeground(new Color (255,255,255));
		lRegion.setText(region);
		getContentPane().add(lRegion);



		dateL = new JLabel [10];
		precpL = new JLabel[10];
		humdL = new JLabel[10];
		windsL = new JLabel[10];
		tempL = new JLabel [10];

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

		dateL[0] = new JLabel();
		dateL[0].setBounds(225, 180, 100, 40);
		dateL[0].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		dateL[0].setForeground(Color.WHITE);
		add(dateL[0]);

		dateL[1] = new JLabel();
		dateL[1].setBounds(280, 180, 100, 40);
		dateL[1].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		dateL[1].setForeground(Color.WHITE);
		add(dateL[1]);

		dateL[2] = new JLabel();
		dateL[2].setBounds(335, 180, 100, 40);
		dateL[2].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		dateL[2].setForeground(Color.WHITE);
		add(dateL[2]);

		dateL[3] = new JLabel();
		dateL[3].setBounds(395, 180, 100, 40);
		dateL[3].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		dateL[3].setForeground(Color.WHITE);
		add(dateL[3]);

		dateL[4] = new JLabel();
		dateL[4].setBounds(452, 180, 100, 40);
		dateL[4].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		dateL[4].setForeground(Color.WHITE);
		add(dateL[4]);

		dateL[5] = new JLabel();
		dateL[5].setBounds(513, 180, 100, 40);
		dateL[5].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		dateL[5].setForeground(Color.WHITE);
		add(dateL[5]);

		dateL[6] = new JLabel();
		dateL[6].setBounds(573, 180, 100, 40);
		dateL[6].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		dateL[6].setForeground(Color.WHITE);
		add(dateL[6]);

		dateL[7] = new JLabel();
		dateL[7].setBounds(631, 180, 100, 40);
		dateL[7].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		dateL[7].setForeground(Color.WHITE);
		add(dateL[7]);

		dateL[8] = new JLabel();
		dateL[8].setBounds(690, 180, 100, 40);
		dateL[8].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		dateL[8].setForeground(Color.WHITE);
		add(dateL[8]);

		dateL[9] = new JLabel();
		dateL[9].setBounds(750, 180, 100, 40);
		dateL[9].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		dateL[9].setForeground(Color.WHITE);
		add(dateL[9]);


		precpL[0] = new JLabel();
		precpL[0].setBounds(225, 240, 40, 40);
		precpL[0].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		precpL[0].setForeground(new Color(63,97,60));
		//precpL[0].setText("Heere");

		add(precpL[0]);

		precpL[1] = new JLabel();
		precpL[1].setBounds(288, 240, 40, 40);
		precpL[1].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		precpL[1].setForeground(new Color(63,97,60));
		//precpL[1].setText("Heere");
		add(precpL[1]);

		precpL[2] = new JLabel();
		precpL[2].setBounds(347, 240, 40, 40);
		precpL[2].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		precpL[2].setForeground(new Color(63,97,60));
		//precpL[2].setText("Heere");
		add(precpL[2]);


		precpL[3] = new JLabel();
		precpL[3].setBounds(405, 240, 40, 40);
		precpL[3].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		precpL[3].setForeground(new Color(63,97,60));
		//precpL[3].setText("Heere");
		add(precpL[3]);

		precpL[4] = new JLabel();
		precpL[4].setBounds(463, 240, 40, 40);
		precpL[4].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		precpL[4].setForeground(new Color(63,97,60));
		//precpL[4].setText("Heere");
		add(precpL[4]);


		precpL[5] = new JLabel();
		precpL[5].setBounds(523, 240, 40, 40);
		precpL[5].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		precpL[5].setForeground(new Color(63,97,60));
		//precpL[5].setText("Heere");
		add(precpL[5]);

		precpL[6] = new JLabel();
		precpL[6].setBounds(583, 240, 40, 40);
		precpL[6].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		precpL[6].setForeground(new Color(63,97,60));
		//precpL[6].setText("Heere");
		add(precpL[6]);

		precpL[7] = new JLabel();
		precpL[7].setBounds(641, 240, 40, 40);
		precpL[7].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		precpL[7].setForeground(new Color(63,97,60));
		//precpL[7].setText("Heere");
		add(precpL[7]);


		precpL[8] = new JLabel();
		precpL[8].setBounds(701, 240, 40, 40);
		precpL[8].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		precpL[8].setForeground(new Color(63,97,60));
		//precpL[8].setText("Heere");
		add(precpL[8]);

		precpL[9] = new JLabel();
		precpL[9].setBounds(761, 240, 40, 40);
		precpL[9].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		precpL[9].setForeground(new Color(63,97,60));
		//precpL[9].setText("Heere");
		add(precpL[9]);


		tempL[0] = new JLabel();
		tempL[0].setBounds(225, 300, 40, 40);
		tempL[0].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		tempL[0].setForeground(new Color(63,97,60));
		//tempL[0].setText("Heere");
		add(tempL[0]);


		tempL[1] = new JLabel();
		tempL[1].setBounds(288, 300, 40, 40);
		tempL[1].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		tempL[1].setForeground(new Color(63,97,60));
		//tempL[1].setText("Heere");
		add(tempL[1]);

		tempL[2] = new JLabel();
		tempL[2].setBounds(347, 300, 40, 40);
		tempL[2].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		tempL[2].setForeground(new Color(63,97,60));
		//tempL[2].setText("Heere");
		add(tempL[2]);

		tempL[3] = new JLabel();
		tempL[3].setBounds(405, 300, 40, 40);
		tempL[3].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		tempL[3].setForeground(new Color(63,97,60));
		//tempL[3].setText("Heere");
		add(tempL[3]);


		tempL[4] = new JLabel();
		tempL[4].setBounds(463, 300, 40, 40);
		tempL[4].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		tempL[4].setForeground(new Color(63,97,60));
		//tempL[4].setText("Heere");
		add(tempL[4]);

		tempL[5] = new JLabel();
		tempL[5].setBounds(523, 300, 40, 40);
		tempL[5].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		tempL[5].setForeground(new Color(63,97,60));
		//tempL[5].setText("Heere");
		add(tempL[5]);

		tempL[6] = new JLabel();
		tempL[6].setBounds(583, 300, 40, 40);
		tempL[6].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		tempL[6].setForeground(new Color(63,97,60));
		//tempL[6].setText("Heere");
		add(tempL[6]);


		tempL[7] = new JLabel();
		tempL[7].setBounds(641, 300, 40, 40);
		tempL[7].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		tempL[7].setForeground(new Color(63,97,60));
		//tempL[7].setText("Heere");
		add(tempL[7]);


		tempL[8] = new JLabel();
		tempL[8].setBounds(701, 300, 40, 40);
		tempL[8].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		tempL[8].setForeground(new Color(63,97,60));
		//tempL[8].setText("Heere");
		add(tempL[8]);

		tempL[9] = new JLabel();
		tempL[9].setBounds(761, 300, 40, 40);
		tempL[9].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		tempL[9].setForeground(new Color(63,97,60));
		//tempL[9].setText("Heere");
		add(tempL[9]);

		windsL[0] = new JLabel();
		windsL[0].setBounds(225, 360, 40, 40);
		windsL[0].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		windsL[0].setForeground(new Color(63,97,60));
		//windsL[0].setText("Heere");
		add(windsL[0]);

		windsL[1] = new JLabel();
		windsL[1].setBounds(288, 360, 40, 40);
		windsL[1].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		windsL[1].setForeground(new Color(63,97,60));
		//windsL[1].setText("Heere");
		add(windsL[1]);

		windsL[2] = new JLabel();
		windsL[2].setBounds(347, 360, 40, 40);
		windsL[2].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		windsL[2].setForeground(new Color(63,97,60));
		//windsL[2].setText("Heere");
		add(windsL[2]);

		windsL[3] = new JLabel();
		windsL[3].setBounds(405, 360, 40, 40);
		windsL[3].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		windsL[3].setForeground(new Color(63,97,60));
		//windsL[3].setText("Heere");
		add(windsL[3]);

		windsL[4] = new JLabel();
		windsL[4].setBounds(463, 360, 40, 40);
		windsL[4].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		windsL[4].setForeground(new Color(63,97,60));
		//windsL[4].setText("Heere");
		add(windsL[4]);

		windsL[5] = new JLabel();
		windsL[5].setBounds(523, 360, 40, 40);
		windsL[5].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		windsL[5].setForeground(new Color(63,97,60));
		//windsL[5].setText("Heere");
		add(windsL[5]);

		windsL[6] = new JLabel();
		windsL[6].setBounds(583, 360, 40, 40);
		windsL[6].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		windsL[6].setForeground(new Color(63,97,60));
		//windsL[5].setText("Heere");
		add(windsL[6]);


		windsL[7] = new JLabel();
		windsL[7].setBounds(641, 360, 40, 40);
		windsL[7].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		windsL[7].setForeground(new Color(63,97,60));
		//windsL[5].setText("Heere");
		add(windsL[7]);


		windsL[8] = new JLabel();
		windsL[8].setBounds(701, 360, 40, 40);
		windsL[8].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		windsL[8].setForeground(new Color(63,97,60));
		//windsL[5].setText("Heere");
		add(windsL[8]);

		windsL[9] = new JLabel();
		windsL[9].setBounds(761, 360, 40, 40);
		windsL[9].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		windsL[9].setForeground(new Color(63,97,60));
		//windsL[5].setText("Heere");
		add(windsL[9]);

		humdL[0] = new JLabel();
		humdL[0].setBounds(225, 420, 40, 40);
		humdL[0].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		humdL[0].setForeground(new Color(63,97,60));
		//humdL[0].setText("Heere");
		add(humdL[0]);

		humdL[1] = new JLabel();
		humdL[1].setBounds(288, 420, 40, 40);
		humdL[1].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		humdL[1].setForeground(new Color(63,97,60));
		//humdL[0].setText("Heere");
		add(humdL[1]);

		humdL[2] = new JLabel();
		humdL[2].setBounds(347, 420, 40, 40);
		humdL[2].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		humdL[2].setForeground(new Color(63,97,60));
		//humdL[0].setText("Heere");
		add(humdL[2]);

		humdL[3] = new JLabel();
		humdL[3].setBounds(405, 420, 40, 40);
		humdL[3].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		humdL[3].setForeground(new Color(63,97,60));
		//humdL[0].setText("Heere");
		add(humdL[3]);

		humdL[4] = new JLabel();
		humdL[4].setBounds(463, 420, 40, 40);
		humdL[4].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		humdL[4].setForeground(new Color(63,97,60));
		//humdL[0].setText("Heere");
		add(humdL[4]);

		humdL[5] = new JLabel();
		humdL[5].setBounds(523, 420, 40, 40);
		humdL[5].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		humdL[5].setForeground(new Color(63,97,60));
		//humdL[0].setText("Heere");
		add(humdL[5]);

		humdL[6] = new JLabel();
		humdL[6].setBounds(583, 420, 40, 40);
		humdL[6].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		humdL[6].setForeground(new Color(63,97,60));
		//humdL[0].setText("Heere");
		add(humdL[6]);


		humdL[7] = new JLabel();
		humdL[7].setBounds(641, 420, 40, 40);
		humdL[7].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		humdL[7].setForeground(new Color(63,97,60));
		//humdL[0].setText("Heere");
		add(humdL[7]);

		humdL[8] = new JLabel();
		humdL[8].setBounds(701, 420, 40, 40);
		humdL[8].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		humdL[8].setForeground(new Color(63,97,60));
		//humdL[0].setText("Heere");
		add(humdL[8]);

		humdL[9] = new JLabel();
		humdL[9].setBounds(761, 420, 40, 40);
		humdL[9].setFont(new Font ("Andalus",Font.TRUETYPE_FONT,14));
		humdL[9].setForeground(new Color(63,97,60));
		//humdL[0].setText("Heere");
		add(humdL[9]);


		mainlb = new JLabel ( new ImageIcon("img/main_table.jpg"));
		mainlb.setBounds(0,0,900,600);
		add( mainlb);
		setBounds(150, 50, 900, 600);
		setUndecorated(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		new SiteDownload(region);
		new ReadHTML();


		for ( int i=0 ; i<10 ; i++){

			dateL[i].setText(readH.dInfo[i].date +" " + readH.dInfo[i].month);
			precpL[i].setText(""+readH.dInfo[i].precipitation);
			tempL[i].setText(""+readH.dInfo[i].temp);
			windsL[i].setText("" + readH.dInfo[i].windSpeed);
			humdL[i].setText("" + readH.dInfo[i].humidity);
		}





	}


	public static void main (String[]args){

		//new Forecast();

	}


	@Override
	public void mouseClicked(MouseEvent me) {
		// TODO Auto-generated method stub
		System.out.print("X : " + me.getX() + "Y: " +me.getY()); 

		if ( me.getSource() == btnBack){
			this.dispose();
			new AppPage();

		}
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
