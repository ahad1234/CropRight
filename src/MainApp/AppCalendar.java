package MainApp;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;


public class AppCalendar extends JPanel {


    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    JXDatePicker picker;
    Font boxFont;

    AppCalendar(){


	try
	{

	    boxFont = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/font.otf")).deriveFont(16f);

	    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); 

	} 
	catch (Exception e){}

	this.setLayout(null);



	picker = new JXDatePicker();
	picker.setDate(Calendar.getInstance().getTime());
	picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
	picker.setBounds(0,0, 220,30);

	picker.setBorder(null);	
	picker.setFont(boxFont);

	JTextField tf = (JTextField) picker.getComponent(0);
	tf.setBackground(new Color(238,238,238));
	tf.setForeground(Color.BLACK);


	JButton btn = (JButton) picker.getComponent(1);
	try {


	    BufferedImage editImage  = ImageIO.read(new File ("img/calendar-icon.png"));
	    btn.setIcon(new ImageIcon(editImage));

	}
	catch (Exception eo){}
	btn.setFocusable(false);
	btn.setOpaque(false);
	btn.setBorderPainted(false);
	btn.setBackground(Color.GRAY);




	this.add(picker);

	this.setVisible(true);









    }


    public static void main(String[] args) {



    }
}