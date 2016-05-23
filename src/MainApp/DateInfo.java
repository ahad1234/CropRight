package MainApp;

public class DateInfo {

    public int date ;
    public String day;
    public String month; 
    public int temp ;
    public int humidity;
    public int precipitation;
    public String behavior ;
    public String windDirection;
    public int windSpeed;

    public void setDate( int d ) {
	date = d;
    }

    public void setDay(String Day ){
	
	day = Day;
    }

    public void setMonth(String M){
	
	month = M;
    }
    
    public void setTemp( int t){
	temp = t;

    }


    public void setHumidity( int h){

	humidity = h;
    }

    public void setPrecipitation (int p ){

	precipitation = p;

    }

    public void setWindSpeed ( int w ){

	windSpeed = w;

    }



}
