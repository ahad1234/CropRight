package TestCase;
import static org.junit.Assert.*;

import java.awt.Rectangle;
import java.awt.image.CropImageFilter;

import org.junit.Test;

import MainApp.AppPage;
import MainApp.CropInfo;
import MainApp.Forecast;
import MainApp.ReadHTML;

public class AppTests {

	AppPage aP = new AppPage();
	CropInfo cI ;
	ReadHTML rH;
	
	@Test
	public void test_Bounds(){
		
		Rectangle exp_B = new Rectangle(150, 50, 900, 600);
		
		if( aP.getBounds().contains(exp_B.getBounds())){
			
			System.out.println("----> Bounds Matched.");
			assertTrue(true);
		}
		else{
			assertFalse(true);
		}
		
	}
	
	@Test
	public void test_DB(){
		
		cI = new CropInfo("Wheat","Lahore",1);
		
		if( cI.con != null){
			System.out.println("---------> Database Connection OK!");
			assertTrue(true);
		}
		else {
			assertFalse(true);
		}
		
	}
	
	@Test
	public void test_File(){
		
		rH = new ReadHTML();
		
		if( rH.reader != null){
			
			System.out.println("--------> HTML File read Successfully.");
			assertTrue(true);
		}
		else {
			assertFalse(true);
		}
			
		
	}
	
	
	
	
}
