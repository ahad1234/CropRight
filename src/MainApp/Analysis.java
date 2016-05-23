package MainApp;
import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;




public class Analysis extends JFrame implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel mainlb;
	Font lFont;
	JLabel cropP;
	private JButton btnExit;
	String crop_name="";
	JLabel opDatesP;
	JLabel opDatesS;
	Font myFont;
	JLabel [] lDatesP;
	JLabel [] lDatesS;
	int [] pDate;
	String [] pMonth;
	int [] sDate;
	String [] sMonth;

	ReadHTML readh;
	JLabel rainL;
	JLabel sunL;

	JLabel []tDate;
	JLabel [] tMonth;

	int countP=0;
	int countS=0;

	JLabel noPlant;
	JLabel noSpray;

	static String forCrop = "";

	Analysis(String fC){
		forCrop = fC;
	}


	Analysis(){

		lDatesP = new JLabel[10];
		lDatesS = new JLabel [10];

		getContentPane().setLayout(null);

		try
		{

			lFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/font.otf")).deriveFont(40f);
			myFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/font.otf")).deriveFont(21f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); 

		}

		catch(Exception e)
		{
			System.out.println("There was an error reading image files!");
			System.out.println(e);
			System.exit(0);
		}


		btnExit = new JButton();
		btnExit.setBounds(-21, -2, 155, 150);
		btnExit.addMouseListener(this);
		btnExit.setIcon(new ImageIcon("img/back.png"));
		btnExit.setRolloverIcon(new ImageIcon("img/back.png"));
		btnExit.setCursor((new Cursor ( Cursor.HAND_CURSOR)));
		btnExit.setOpaque(false);
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.setFocusable(false);
		getContentPane().add(btnExit);


		cropP = new JLabel ("Analysis: ");
		cropP.setHorizontalAlignment(SwingConstants.CENTER);
		cropP.setForeground(Color.WHITE);
		cropP.setFont(lFont);
		cropP.setBounds(250,39,400,71);
		getContentPane().add(cropP);

		opDatesP = new JLabel ("Optimum dates for Planting "+ forCrop + ":" );
		opDatesP.setBounds(10,110,320,100);
		opDatesP.setFont(myFont);
		opDatesP.setForeground(new Color(65,99,64));
		add(opDatesP);


		opDatesS = new JLabel ("Optimum dates for Spraying Pesticides :");
		opDatesS.setBounds(10,390,380,100);
		opDatesS.setFont(myFont);
		opDatesS.setForeground(new Color(65,99,64));
		add(opDatesS);

		lDatesP[0] = new JLabel();
		lDatesP[0].setBounds(20,215,70,40);
		lDatesP[0].setForeground(new Color(60,160,87));
		lDatesP[0].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,14));
		add(lDatesP[0]);

		lDatesP[1] = new JLabel();
		lDatesP[1].setBounds(85,215,70,40);
		lDatesP[1].setForeground(new Color(60,160,87));
		lDatesP[1].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,14));
		add(lDatesP[1]);

		lDatesP[2] = new JLabel();
		lDatesP[2].setBounds(145,215,70,40);
		lDatesP[2].setForeground(new Color(60,160,87));
		lDatesP[2].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,14));
		add(lDatesP[2]);

		lDatesP[3] = new JLabel();
		lDatesP[3].setBounds(205,215,70,40);
		lDatesP[3].setForeground(new Color(60,160,87));
		lDatesP[3].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,14));
		add(lDatesP[3]);


		lDatesP[4] = new JLabel();
		lDatesP[4].setBounds(260,215,70,40);
		lDatesP[4].setForeground(new Color(60,160,87));
		lDatesP[4].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,14));
		add(lDatesP[4]);

		lDatesP[5] = new JLabel();
		lDatesP[5].setBounds(320,215,70,40);
		lDatesP[5].setForeground(new Color(60,160,87));
		lDatesP[5].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,14));
		add(lDatesP[5]);

		lDatesP[6] = new JLabel();
		lDatesP[6].setBounds(375,215,70,40);
		lDatesP[6].setForeground(new Color(60,160,87));
		lDatesP[6].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,14));
		add(lDatesP[6]);

		lDatesP[7] = new JLabel();
		lDatesP[7].setBounds(435,215,70,40);
		lDatesP[7].setForeground(new Color(60,160,87));
		lDatesP[7].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,14));
		add(lDatesP[7]);

		lDatesP[8] = new JLabel();
		lDatesP[8].setBounds(490,215,70,40);
		lDatesP[8].setForeground(new Color(60,160,87));
		lDatesP[8].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,14));
		add(lDatesP[8]);

		lDatesP[9] = new JLabel();
		lDatesP[9].setBounds(545,215,70,40);
		lDatesP[9].setForeground(new Color(60,160,87));
		lDatesP[9].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,14));
		add(lDatesP[9]);


		lDatesS[0] = new JLabel();
		lDatesS[0].setBounds(20,498,70,40);
		lDatesS[0].setForeground(new Color(60,160,87));
		lDatesS[0].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,14));
		add(lDatesS[0]);

		lDatesS[1] = new JLabel();
		lDatesS[1].setBounds(85,498,70,40);
		lDatesS[1].setForeground(new Color(60,160,87));
		lDatesS[1].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,14));
		add(lDatesS[1]);

		lDatesS[2] = new JLabel();
		lDatesS[2].setBounds(145,498,70,40);
		lDatesS[2].setForeground(new Color(60,160,87));
		lDatesS[2].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,14));
		add(lDatesS[2]);

		lDatesS[3] = new JLabel();
		lDatesS[3].setBounds(205,498,70,40);
		lDatesS[3].setForeground(new Color(60,160,87));
		lDatesS[3].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,14));
		add(lDatesS[3]);


		lDatesS[4] = new JLabel();
		lDatesS[4].setBounds(260,498,70,40);
		lDatesS[4].setForeground(new Color(60,160,87));
		lDatesS[4].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,14));
		add(lDatesS[4]);

		lDatesS[5] = new JLabel();
		lDatesS[5].setBounds(320,498,70,40);
		lDatesS[5].setForeground(new Color(60,160,87));
		lDatesS[5].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,14));
		add(lDatesS[5]);

		lDatesS[6] = new JLabel();
		lDatesS[6].setBounds(375,498,70,40);
		lDatesS[6].setForeground(new Color(60,160,87));
		lDatesS[6].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,14));
		add(lDatesS[6]);

		lDatesS[7] = new JLabel();
		lDatesS[7].setBounds(435,498,70,40);
		lDatesS[7].setForeground(new Color(60,160,87));
		lDatesS[7].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,14));
		add(lDatesS[7]);

		lDatesS[8] = new JLabel();
		lDatesS[8].setBounds(490,498,70,40);
		lDatesS[8].setForeground(new Color(60,160,87));
		lDatesS[8].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,14));
		add(lDatesS[8]);

		lDatesS[9] = new JLabel();
		lDatesS[9].setBounds(545,498,70,40);
		lDatesS[9].setForeground(new Color(60,160,87));
		lDatesS[9].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,14));
		add(lDatesS[9]);

		pDate = new int [10];
		pMonth = new String[10];
		sDate = new int[10];
		sMonth = new String [10];

		noPlant = new JLabel("No Optimum Dates");
		noSpray = new JLabel ("No Optimum Dates");

		noPlant.setFont(myFont);
		noPlant.setBounds(170,132,200,200);
		noPlant.setForeground(new Color(65,99,64));


		noSpray.setFont(myFont);
		noSpray.setBounds(170,420,200,200);
		noSpray.setForeground(new Color(65,99,64));


		for ( int i =0 ; i<10 ; i++){

			if ( ReadHTML.dInfo[i].precipitation < 11 ){

				pDate[i] = ReadHTML.dInfo[i].date;
				pMonth[i] = ReadHTML.dInfo[i].month;
				System.out.print("" + pDate[i] +" " +  pMonth[i]);
				lDatesP[i].setText("" + pDate[i] + " " +pMonth[i]);
				countP++;


			}



			if ( ReadHTML.dInfo[i].windSpeed < 11 && ReadHTML.dInfo[i].precipitation < 11) {  
				sDate[i] = ReadHTML.dInfo[i].date;
				sMonth[i] = ReadHTML.dInfo[i].month;
				lDatesS[i].setText("" + sDate[i]+" "+ sMonth[i]);
				countS++;

			}	

		}


		if ( countP == 0){
			add(noPlant);
		}

		if ( countS == 0){

			add(noSpray);
		}

		rainL = new JLabel(new ImageIcon("img/rain.gif"));
		rainL.setBounds(770,455,80,80);
		add(rainL);

		sunL = new JLabel (new ImageIcon("img/sun.gif"));
		sunL.setBounds(780,515,55,55);
		add(sunL);

		tDate = new JLabel[10];
		tMonth = new JLabel[10];

		tDate[0]  = new JLabel();
		tDate[0].setBackground(new Color(255,255,0));
		tDate[0].setOpaque(true);
		tDate[0].setBounds(648,333,35,30);
		tDate[0].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,12));
		//tDate[0].setForeground(new Color(48,48,48));
		add(tDate[0]);

		tDate[1]  = new JLabel();
		//tDate[1].setBackground(new Color(255,25,40));
		tDate[1].setOpaque(true);
		tDate[1].setBounds(695,333,35,30);
		tDate[1].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,12));
		//tDate[1].setForeground(Color.WHITE);
		add(tDate[1]);

		tDate[2]  = new JLabel();
		//tDate[2].setBackground(new Color(255,25,40));
		tDate[2].setOpaque(true);
		tDate[2].setBounds(742,333,35,30);
		tDate[2].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,12));
		//tDate[2].setForeground(Color.WHITE);
		add(tDate[2]);


		tDate[3]  = new JLabel();
		//tDate[3].setBackground(new Color(255,25,40));
		tDate[3].setOpaque(true);
		tDate[3].setBounds(788,333,35,30);
		tDate[3].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,12));
		//tDate[3].setForeground(Color.WHITE);
		add(tDate[3]);

		tDate[4]  = new JLabel();
		//tDate[4].setBackground(new Color(255,25,40));
		tDate[4].setOpaque(true);
		tDate[4].setBounds(830,333,35,30);
		tDate[4].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,12));
		//tDate[4].setForeground(Color.WHITE);
		add(tDate[4]);

		tDate[5]  = new JLabel();
		tDate[5].setBackground(new Color(255,25,40));
		tDate[5].setOpaque(true);
		tDate[5].setBounds(648,375,35,30);
		tDate[5].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,12));
		//tDate[5].setForeground(Color.WHITE);
		add(tDate[5]);

		tDate[6]  = new JLabel();
		//tDate[6].setBackground(new Color(255,25,40));
		tDate[6].setOpaque(true);
		tDate[6].setBounds(695,375,35,30);
		tDate[6].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,12));
		//tDate[6].setForeground(Color.WHITE);
		add(tDate[6]);

		tDate[7]  = new JLabel();
		//tDate[7].setBackground(new Color(255,25,40));
		tDate[7].setOpaque(true);
		tDate[7].setBounds(742,375,35,30);
		tDate[7].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,12));
		//tDate[7].setForeground(Color.WHITE);
		add(tDate[7]);

		tDate[8]  = new JLabel();
		//tDate[8].setBackground(new Color(255,25,40));
		tDate[8].setOpaque(true);
		tDate[8].setBounds(788,375,35,30);
		tDate[8].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,12));
		//tDate[8].setForeground(Color.WHITE);
		add(tDate[8]);

		tDate[9]  = new JLabel();
		//tDate[9].setBackground(new Color(255,25,40));
		tDate[9].setOpaque(true);
		tDate[9].setBounds(830,375,35,30);
		tDate[9].setFont(new Font ("Andalus",Font.ROMAN_BASELINE,12));
		//tDate[9].setForeground(Color.WHITE);
		add(tDate[9]);



		for ( int i=0 ; i< 10 ; i++){

			if ( ReadHTML.dInfo[i].precipitation >=11){
				tDate[i].setText(""+ReadHTML.dInfo[i].date + " " + ReadHTML.dInfo[i].month);
				tDate[i].setBackground(new Color(255,25,40));
				tDate[i].setForeground(Color.WHITE);
			}

			else {


				tDate[i].setText(""+ReadHTML.dInfo[i].date + " " + ReadHTML.dInfo[i].month);
				tDate[i].setBackground(new Color(255,255,0));
				tDate[i].setForeground(new Color(48,48,48));
			}
		}


		mainlb = new JLabel ( new ImageIcon("img/mainF.jpg"));
		mainlb.setBounds(0,0,900,600);
		getContentPane().add( mainlb);
		addMouseListener(this);






		setBounds(150, 50, 900, 600);
		setUndecorated(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);




	}


	public static void main (String[]args){

		new Analysis();

	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.print("X: " + e.getX() + "Y: " + e.getY());

		if ( e.getSource() == btnExit){
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
