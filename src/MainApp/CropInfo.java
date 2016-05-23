package MainApp;
import javax.swing.*;

import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.sql.*;

public class CropInfo extends JFrame implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel mainlb;
	Font myfont;
	Font boxFont;
	Font valFont;
	private JTextField crop_name;


	JLabel crop_info;
	JLabel crop_selected;
	JLabel irrig_check ;
	private JLabel region_selected;
	private JTextField region_name;
	private JTextField irrig_ans;
	private JLabel tempt;
	private JTextField temp_min;
	private JLabel precp_check;
	private JTextField prec_min;
	private JLabel plant_date;
	private JTextField temp_max;
	private JLabel min_temp;
	private JLabel max_temp;
	private JTextField prec_max;
	private JLabel min_prec;
	private JLabel max_prec;
	private JTextField plant_min;
	private JTextField plant_max;
	private JLabel min_plant;
	private JLabel max_plant;
	private JLabel harvest_get;
	private JTextField harv_min;
	private JTextField harv_max;
	private JLabel min_harv;
	private JLabel max_harv;
	JButton fButton;

	public  Connection con=null;
	PreparedStatement st = null;
	ResultSet rt = null;
	private JTextField humidity_lev;



	public String region="";
	public String crop="";
	public int cropid=0;

	JButton btnBack;

	public CropInfo(String x,String y,int z){

		crop = x;
		region = y;
		cropid = z;

		getContentPane().setLayout(null);


		try
		{
			myfont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/font.otf")).deriveFont(40f);
			boxFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/font.otf")).deriveFont(17.47f);
			valFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/font.otf")).deriveFont(14f);
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

		crop_info = new JLabel("Crop Info W.R.T Region : ");
		crop_info.setBounds(250,39,480,71);
		crop_info.setFont(myfont);

		crop_info.setForeground(Color.WHITE);
		getContentPane().add(crop_info);

		crop_selected = new JLabel("Crop : ");
		crop_selected.setBounds(10, 144, 101, 44);
		crop_selected.setForeground(new Color ( 49,49,49));
		getContentPane().add(crop_selected);
		crop_selected.setFont(boxFont);

		crop_name = new JTextField();
		crop_name.setHorizontalAlignment(SwingConstants.CENTER);
		crop_name.setBounds(139, 150, 128, 32);
		getContentPane().add(crop_name);
		crop_name.setColumns(10);
		crop_name.setBackground(new Color (192,192,192));
		crop_name.setForeground(new Color(64,64,64));
		crop_name.setFocusable(false);
		crop_name.setFont(boxFont);
		crop_name.setBorder(null);
		crop_name.setText(crop);


		region_selected = new JLabel("Region : ");
		region_selected.setBounds(580, 144, 101, 44);
		getContentPane().add(region_selected);
		region_selected.setForeground(new Color ( 49,49,49));
		region_selected.setFont(boxFont);

		region_name = new JTextField();
		region_name.setHorizontalAlignment(SwingConstants.CENTER);
		region_name.setBackground(new Color (192,192,192));
		region_name.setForeground(new Color(64,64,64));
		region_name.setFocusable(false);
		region_name.setFont(boxFont);
		region_name.setBorder(null);
		region_name.setText(region);
		region_name.setBounds(705, 150, 128, 32);
		getContentPane().add(region_name);

		irrig_check = new JLabel("Irrigation : ");
		irrig_check.setBounds(10, 239, 119, 44);
		irrig_check.setForeground(new Color ( 49,49,49));
		irrig_check.setFont(boxFont);
		getContentPane().add(irrig_check);

		irrig_ans = new JTextField();
		irrig_ans.setHorizontalAlignment(SwingConstants.CENTER);
		irrig_ans.setBackground(new Color (192,192,192));
		irrig_ans.setForeground(new Color(64,64,64));
		irrig_ans.setFocusable(false);
		irrig_ans.setFont(boxFont);
		irrig_ans.setBorder(null);
		irrig_ans.setBounds(139, 245, 128, 32);
		getContentPane().add(irrig_ans);
		irrig_ans.setColumns(10);

		tempt = new JLabel("Temperature  :");
		tempt.setBounds(580, 247, 107, 29);
		tempt.setForeground(new Color ( 49,49,49));
		tempt.setFont(boxFont);
		getContentPane().add(tempt);

		temp_min = new JTextField();
		temp_min.setHorizontalAlignment(SwingConstants.CENTER);
		temp_min.setBounds(705, 245, 51, 32);
		getContentPane().add(temp_min);
		temp_min.setBackground(new Color (192,192,192));
		temp_min.setForeground(new Color(64,64,64));
		temp_min.setFocusable(false);
		temp_min.setFont(valFont);
		temp_min.setBorder(null);
		temp_min.setColumns(10);

		precp_check = new JLabel("Precipitation :");
		precp_check.setBounds(10, 352, 119, 32);
		precp_check.setForeground(new Color ( 49,49,49));
		precp_check.setFont(boxFont);
		getContentPane().add(precp_check);


		temp_max = new JTextField();
		temp_max.setHorizontalAlignment(SwingConstants.CENTER);
		temp_max.setBounds(788, 245, 51, 32);
		getContentPane().add(temp_max);
		temp_max.setBackground(new Color (192,192,192));
		temp_max.setForeground(new Color(64,64,64));
		temp_max.setFocusable(false);
		temp_max.setFont(valFont);
		temp_max.setBorder(null);
		temp_max.setColumns(10);

		min_temp = new JLabel("Min:");
		min_temp.setHorizontalAlignment(SwingConstants.CENTER);
		min_temp.setBounds(704, 217, 46, 14);
		min_temp.setForeground(new Color ( 49,49,49));
		min_temp.setFont(boxFont);
		getContentPane().add(min_temp);

		max_temp = new JLabel("Max:");
		max_temp.setHorizontalAlignment(SwingConstants.CENTER);
		max_temp.setBounds(787, 217, 46, 14);
		max_temp.setForeground(new Color ( 49,49,49));
		max_temp.setFont(boxFont);
		getContentPane().add(max_temp);


		prec_min = new JTextField();
		prec_min.setHorizontalAlignment(SwingConstants.CENTER);
		prec_min.setBounds(139, 352, 51, 32);
		prec_min.setBackground(new Color (192,192,192));
		prec_min.setForeground(new Color(64,64,64));
		prec_min.setFocusable(false);
		prec_min.setFont(valFont);
		prec_min.setBorder(null);
		getContentPane().add(prec_min);
		prec_min.setColumns(10);

		prec_max = new JTextField();
		prec_max.setHorizontalAlignment(SwingConstants.CENTER);
		prec_max.setBounds(222, 352, 51, 32);
		getContentPane().add(prec_max);
		prec_max.setBackground(new Color (192,192,192));
		prec_max.setForeground(new Color(64,64,64));
		prec_max.setFocusable(false);
		prec_max.setFont(valFont);
		prec_max.setBorder(null);
		prec_max.setColumns(10);

		min_prec = new JLabel("Min:");
		min_prec.setHorizontalAlignment(SwingConstants.CENTER);
		min_prec.setBounds(138, 324, 46, 14);
		min_prec.setForeground(new Color ( 49,49,49));
		min_prec.setFont(boxFont);
		getContentPane().add(min_prec);

		max_prec = new JLabel("Max:");
		max_prec.setHorizontalAlignment(SwingConstants.CENTER);
		max_prec.setBounds(221, 324, 46, 14);
		max_prec.setForeground(new Color ( 49,49,49));
		max_prec.setFont(boxFont);
		getContentPane().add(max_prec);


		plant_date = new JLabel("Planting Date :");
		plant_date.setBounds(580, 361, 119, 23);
		plant_date.setForeground(new Color ( 49,49,49));
		plant_date.setFont(boxFont);
		getContentPane().add(plant_date);

		plant_min = new JTextField();
		plant_min.setHorizontalAlignment(SwingConstants.CENTER);
		plant_min.setBounds(705, 352, 51, 32);
		plant_min.setBackground(new Color (192,192,192));
		plant_min.setForeground(new Color(64,64,64));
		plant_min.setFocusable(false);
		plant_min.setFont(valFont);
		plant_min.setBorder(null);
		getContentPane().add(plant_min);
		plant_min.setColumns(10);

		plant_max = new JTextField();
		plant_max.setHorizontalAlignment(SwingConstants.CENTER);
		plant_max.setColumns(10);
		plant_max.setBackground(new Color (192,192,192));
		plant_max.setForeground(new Color(64,64,64));
		plant_max.setFocusable(false);
		plant_max.setFont(valFont);
		plant_max.setBorder(null);
		plant_max.setBounds(788, 352, 51, 32);
		getContentPane().add(plant_max);

		min_plant = new JLabel("Min:");
		min_plant.setHorizontalAlignment(SwingConstants.CENTER);
		min_plant.setBounds(705, 324, 46, 14);
		min_plant.setForeground(new Color ( 49,49,49));
		min_plant.setFont(boxFont);
		getContentPane().add(min_plant);

		max_plant = new JLabel("Max:");
		max_plant.setHorizontalAlignment(SwingConstants.CENTER);
		max_plant.setForeground(new Color ( 49,49,49));
		max_plant.setFont(boxFont);
		max_plant.setBounds(788, 324, 46, 14);
		getContentPane().add(max_plant);

		harvest_get = new JLabel("Harvest Date :");
		harvest_get.setForeground(new Color ( 49,49,49));
		harvest_get.setFont(boxFont);
		harvest_get.setBounds(10, 462, 119, 23);
		getContentPane().add(harvest_get);

		harv_min = new JTextField();
		harv_min.setHorizontalAlignment(SwingConstants.CENTER);
		harv_min.setBackground(new Color (192,192,192));
		harv_min.setForeground(new Color(64,64,64));
		harv_min.setFont(valFont);
		harv_min.setFocusable(false);
		harv_min.setColumns(10);
		harv_min.setBorder(null);
		harv_min.setBounds(139, 453, 51, 32);
		getContentPane().add(harv_min);

		harv_max = new JTextField();
		harv_max.setHorizontalAlignment(SwingConstants.CENTER);
		harv_max.setBackground(new Color (192,192,192));
		harv_max.setForeground(new Color(64,64,64));
		harv_max.setFont(valFont);
		harv_max.setFocusable(false);
		harv_max.setColumns(10);
		harv_max.setBorder(null);
		harv_max.setBounds(222, 453, 51, 32);
		getContentPane().add(harv_max);

		min_harv = new JLabel("Min:");
		min_harv.setHorizontalAlignment(SwingConstants.CENTER);
		min_harv.setForeground(new Color ( 49,49,49));
		min_harv.setFont(boxFont);
		min_harv.setBounds(138, 428, 46, 14);
		getContentPane().add(min_harv);

		max_harv = new JLabel("Max:");
		max_harv.setHorizontalAlignment(SwingConstants.CENTER);
		max_harv.setForeground(new Color ( 49,49,49));
		max_harv.setFont(boxFont);
		max_harv.setBounds(221, 428, 46, 14);
		getContentPane().add(max_harv);


		JLabel lblcelsius = new JLabel("(Celsius)");
		lblcelsius.setForeground(new Color ( 49,49,49));
		lblcelsius.setFont(null);
		lblcelsius.setBounds(580, 267, 107, 29);
		getContentPane().add(lblcelsius);

		JLabel lblmm = new JLabel("(mm)");
		lblmm.setForeground(new Color ( 49,49,49));
		lblmm.setFont(null);
		lblmm.setBounds(10, 373, 119, 32);
		getContentPane().add(lblmm);

		JLabel humidity_get = new JLabel("Humidity  : ");
		humidity_get.setForeground(new Color ( 49,49,49));
		humidity_get.setFont(boxFont);
		humidity_get.setBounds(580, 453, 119, 23);
		getContentPane().add(humidity_get);

		JLabel label = new JLabel("(%)");
		label.setForeground(new Color ( 49,49,49));
		label.setFont(boxFont);
		label.setBounds(580, 470, 107, 29);
		getContentPane().add(label);

		humidity_lev = new JTextField();
		humidity_lev.setHorizontalAlignment(SwingConstants.CENTER);
		humidity_lev.setBackground(new Color (192,192,192));
		humidity_lev.setForeground(new Color(64,64,64));
		humidity_lev.setFont(boxFont);
		humidity_lev.setFocusable(false);
		humidity_lev.setColumns(10);
		humidity_lev.setBorder(null);
		humidity_lev.setBounds(705, 453, 128, 32);
		getContentPane().add(humidity_lev);

		fButton = new JButton();
		fButton.setBounds(355,488,178,70);
		fButton.setIcon(new ImageIcon("img/analyse.png"));
		fButton.setRolloverIcon(new ImageIcon("img/analyse_mo.png"));
		fButton.setCursor((new Cursor ( Cursor.HAND_CURSOR)));
		fButton.setOpaque(false);
		fButton.setContentAreaFilled(false);
		fButton.setBorderPainted(false);
		fButton.setFocusable(false);
		fButton.addMouseListener(this);
		getContentPane().add(fButton);


		mainlb = new JLabel ( new ImageIcon("img/main.jpg"));
		mainlb.setBounds(0,0,900,600);
		getContentPane().add(mainlb);

		String tab = "regions";
		
		if(cropid == 2){
			tab = "regions2";
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cropright", "root", "");
			st = con.prepareStatement("select * from crops natural join "+tab+ " where "+tab+".region = ? and cropid = ?;");
			st.setString(1, region);
			st.setInt(2, cropid);
			rt = st.executeQuery();
	

			while ( rt.next()){
				
				irrig_ans.setText(rt.getString("irrigation"));
				temp_min.setText(rt.getString("mintemp"));
				temp_max.setText(rt.getString("maxtemp"));
				plant_min.setText(rt.getString("minplant"));
				plant_max.setText(rt.getString("maxplant"));
				prec_min.setText(rt.getString("minprec"));
				prec_max.setText(rt.getString("maxprec"));
				harv_min.setText(rt.getString("minharvest"));
				harv_max.setText(rt.getString("maxharvest"));
				humidity_lev.setText(rt.getString("humiditylev"));


			}
			con.close();
		} catch (Exception ex) {
			System.out.println("Error " + ex);
		}





		addMouseListener(this);

		setBounds(150, 50, 900, 600);
		setUndecorated(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}


	public static void main (String []args){
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		System.out.print( "" + e.getX() + " " + e.getY());

		Object obj = e.getSource();

		if ( obj == fButton){
			this.dispose();
			
			new Analysis(crop);
			
			new Analysis();

		}

		if ( obj == btnBack){
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
