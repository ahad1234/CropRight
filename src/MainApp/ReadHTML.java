package MainApp;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.html.parser.ParserDelegator;
import javax.swing.text.html.HTMLEditorKit.ParserCallback;
import javax.swing.text.html.HTML.Tag;
import javax.swing.text.MutableAttributeSet;

public class ReadHTML {

	public FileReader reader;
	List<String> lines;
	int dateN =0;
	int humdCh=0;
	int precpCh=0;
	int tempt=0;
	int checkT =0;
	int checkS =0;

	static DateInfo dInfo[]  = new DateInfo[10];

	public ReadHTML(){     
		for ( int i=0; i<10 ; i++){

			dInfo[i] =  new DateInfo();
		}


		try {
			reader = new FileReader("scrappedsite\\Downloaded.html");
		}
		catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			lines = ReadHTML.extractText(reader);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int test = 0;
		Scanner sc;


		for (String line : lines) {
			test++;

			if ( line.startsWith("Speed:")){

				switch (checkS){

				case 0:
					sc = new Scanner (lines.get(test).replace("Mph", ""));
					dInfo[0].setWindSpeed(sc.nextInt());
					break;

				case 1:
					sc = new Scanner (lines.get(test).replace("Mph", ""));
					dInfo[1].setWindSpeed(sc.nextInt());
					break;

				case 2:
					sc = new Scanner (lines.get(test).replace("Mph", ""));
					dInfo[2].setWindSpeed(sc.nextInt());
					break;

				case 3:
					sc = new Scanner (lines.get(test).replace("Mph", ""));
					dInfo[3].setWindSpeed(sc.nextInt());
					break;

				case 4:
					sc = new Scanner (lines.get(test).replace("Mph", ""));
					dInfo[4].setWindSpeed(sc.nextInt());
					break;

				case 5:
					sc = new Scanner (lines.get(test).replace("Mph", ""));
					dInfo[5].setWindSpeed(sc.nextInt());
					break;

				case 6:
					sc = new Scanner (lines.get(test).replace("Mph", ""));
					dInfo[6].setWindSpeed(sc.nextInt());
					break;

				case 7:
					sc = new Scanner (lines.get(test).replace("Mph", ""));
					dInfo[7].setWindSpeed(sc.nextInt());
					break;

				case 8:
					sc = new Scanner (lines.get(test).replace("Mph", ""));
					dInfo[8].setWindSpeed(sc.nextInt());
					break;

				case 9:
					sc = new Scanner (lines.get(test).replace("Mph", ""));
					dInfo[9].setWindSpeed(sc.nextInt());
					break;

				default:

				}
				checkS++;
			}



			if (line.startsWith("Details") ){

				switch (checkT ){
				case 0:

					sc = new Scanner(lines.get(test+2).replace("F.",""));
					sc.useDelimiter("\\D+");

					try {
						tempt = sc.nextInt();
					}
					
					catch ( Exception e){
						
						sc = new Scanner(lines.get(test+1).replace("F.",""));
						sc.useDelimiter("\\D+");
						tempt = sc.nextInt();
					}
					dInfo[0].setTemp(((tempt-32)*5)/9);

					break;

				case 1:
					sc = new Scanner ( lines.get(test+1).replace("F.", ""));
					sc.useDelimiter("\\D+");
					tempt = sc.nextInt();
					dInfo[1].setTemp(((tempt-32)*5)/9);

					break;


				case 2:
					sc = new Scanner(lines.get(test+1).replace("F.",""));
					sc.useDelimiter("\\D+");
					tempt = sc.nextInt();
					dInfo[2].setTemp(((tempt-32)*5)/9);

					break;

				case 3:
					sc = new Scanner(lines.get(test+1).replace("F.",""));
					sc.useDelimiter("\\D+");
					tempt = sc.nextInt();
					dInfo[3].setTemp(((tempt-32)*5)/9);

					break;

				case 4 :
					sc = new Scanner(lines.get(test+1).replace("F.",""));
					sc.useDelimiter("\\D+");
					tempt = sc.nextInt();
					dInfo[4].setTemp(((tempt-32)*5)/9);

					break;

				case 5 :
					sc = new Scanner(lines.get(test+1).replace("F.",""));
					sc.useDelimiter("\\D+");
					tempt = sc.nextInt();
					dInfo[5].setTemp(((tempt-32)*5)/9);

					break;

				case 6 :
					sc = new Scanner(lines.get(test+1).replace("F.",""));
					sc.useDelimiter("\\D+");
					tempt = sc.nextInt();
					dInfo[6].setTemp(((tempt-32)*5)/9);

					break;

				case 7:
					sc = new Scanner(lines.get(test+1).replace("F.",""));
					sc.useDelimiter("\\D+");
					tempt = sc.nextInt();
					dInfo[7].setTemp(((tempt-32)*5)/9);

					break;

				case 8:
					sc = new Scanner(lines.get(test+1).replace("F.",""));
					sc.useDelimiter("\\D+");
					tempt = sc.nextInt();
					dInfo[8].setTemp(((tempt-32)*5)/9);

					break;

				case 9:
					sc = new Scanner(lines.get(test+1).replace("F.",""));
					sc.useDelimiter("\\D+");
					tempt = sc.nextInt();
					dInfo[9].setTemp(((tempt-32)*5)/9);

					break;

				default : 

				}


				sc = new Scanner(line);

				String day="";
				String month ="";
				int date;
				for ( int i=0 ; i<3; i++){

					day = sc.next();

				}
				day = day.replace(",","");

				sc = new Scanner(line);

				for (int i=0 ; i<4; i++){

					month = sc.next();
				}

				month = month.substring(0, 3);


				sc = new Scanner(line);
				sc.useDelimiter("\\D+");
				int x = sc.nextInt();
				date = x;


				switch (dateN){

				case 0 :

					dInfo[0].setDay(day);
					dInfo[0].setMonth(month);
					dInfo[0].setDate(date);
					System.out.print(dInfo[0].date);
					System.out.print(dInfo[0].day);
					System.out.print(dInfo[0].month);
					break;


				case 1 :

					dInfo[1].setDay(day);
					dInfo[1].setMonth(month);
					dInfo[1].setDate(date);
					System.out.print(dInfo[1].date);
					System.out.print(dInfo[1].day);
					System.out.print(dInfo[1].month);
					break;    	




				case 2 :

					dInfo[2].setDay(day);
					dInfo[2].setMonth(month);
					dInfo[2].setDate(date);
					System.out.print(dInfo[2].date);
					System.out.print(dInfo[2].day);
					System.out.print(dInfo[2].month);
					break;



				case 3:

					dInfo[3].setDay(day);
					dInfo[3].setMonth(month);
					dInfo[3].setDate(date);
					System.out.print(dInfo[3].date);
					System.out.print(dInfo[3].day);
					System.out.print(dInfo[3].month);
					break;

				case 4 :

					dInfo[4].setDay(day);
					dInfo[4].setMonth(month);
					dInfo[4].setDate(date);
					System.out.print(dInfo[4].date);
					System.out.print(dInfo[4].day);
					System.out.print(dInfo[4].month);
					break;

				case 5 :

					dInfo[5].setDay(day);
					dInfo[5].setMonth(month);
					dInfo[5].setDate(date);
					System.out.print(dInfo[5].date);
					System.out.print(dInfo[5].day);
					System.out.print(dInfo[5].month);
					break;


				case 6 :

					dInfo[6].setDay(day);
					dInfo[6].setMonth(month);
					dInfo[6].setDate(date);
					System.out.print(dInfo[6].date);
					System.out.print(dInfo[6].day);
					System.out.print(dInfo[6].month);
					break;



				case 7:

					dInfo[7].setDay(day);
					dInfo[7].setMonth(month);
					dInfo[7].setDate(date);
					System.out.print(dInfo[7].date);
					System.out.print(dInfo[7].day);
					System.out.print(dInfo[7].month);
					break;    	



				case 8 :

					dInfo[8].setDay(day);
					dInfo[8].setMonth(month);
					dInfo[8].setDate(date);
					System.out.print(dInfo[8].date);
					System.out.print(dInfo[8].day);
					System.out.print(dInfo[8].month);
					break; 


				case 9 :

					dInfo[9].setDay(day);
					dInfo[9].setMonth(month);
					dInfo[9].setDate(date);
					System.out.print(dInfo[9].date);
					System.out.print(dInfo[9].day);
					System.out.print(dInfo[9].month);
					break;


				default:

				}

				System.out.println(line);

				for ( int i = test+1 ; i< test+7 ; i++ ){

					System.out.println(lines.get(i));

					if ( Character.isWhitespace(lines.get(i).charAt(0))){
						lines.get(i).trim();
					}


					if ( lines.get(i).startsWith("Relative")){
						String temp = lines.get(i).replace("%", "");
						sc = new Scanner(lines.get(i));
						sc.useDelimiter("\\D+");
						int humd = sc.nextInt();



						switch (humdCh){

						case 0:
							dInfo[0].setHumidity(humd);
							System.out.println(dInfo[0].humidity);
							break;

						case 1 :
							dInfo[1].setHumidity(humd);
							System.out.println(dInfo[1].humidity);
							break;

						case 2:
							dInfo[2].setHumidity(humd);
							System.out.println(dInfo[2].humidity);
							break;

						case 3:
							dInfo[3].setHumidity(humd);
							System.out.println(dInfo[3].humidity);
							break;

						case 4:    
							dInfo[4].setHumidity(humd);
							System.out.println(dInfo[4].humidity);
							break;

						case 5:
							dInfo[5].setHumidity(humd);
							System.out.println(dInfo[5].humidity);
							break;

						case 6:
							dInfo[6].setHumidity(humd);
							System.out.println(dInfo[6].humidity);
							break;

						case 7:
							dInfo[7].setHumidity(humd);
							System.out.println(dInfo[7].humidity);
							break;

						case 8:    
							dInfo[8].setHumidity(humd);
							System.out.println(dInfo[8].humidity);
							break;

						case 9:
							dInfo[9].setHumidity(humd);
							System.out.println(dInfo[9].humidity);
							break;

						default:    
						}
						humdCh++;
					}

					if ( lines.get(i).startsWith("Precipitation")){
						String temp = lines.get(i).replace("%", "");
						sc = new Scanner(lines.get(i));
						sc.useDelimiter("\\D+");
						int precp = sc.nextInt();



						switch (precpCh){

						case 0:
							dInfo[0].setPrecipitation(precp);;
							System.out.println(dInfo[0].precipitation);
							break;

						case 1 :
							dInfo[1].setPrecipitation(precp);;
							System.out.println(dInfo[1].precipitation);
							break;

						case 2:
							dInfo[2].setPrecipitation(precp);;
							System.out.println(dInfo[2].precipitation);
							break;

						case 3:
							dInfo[3].setPrecipitation(precp);;
							System.out.println(dInfo[3].precipitation);
							break;

						case 4:    
							dInfo[4].setPrecipitation(precp);;
							System.out.println(dInfo[4].precipitation);
							break;

						case 5:
							dInfo[5].setPrecipitation(precp);;
							System.out.println(dInfo[5].precipitation);
							break;

						case 6:
							dInfo[6].setPrecipitation(precp);;
							System.out.println(dInfo[6].precipitation);
							break;

						case 7:
							dInfo[7].setPrecipitation(precp);;
							System.out.println(dInfo[7].precipitation);
							break;

						case 8:    
							dInfo[8].setPrecipitation(precp);;
							System.out.println(dInfo[8].precipitation);
							break;

						case 9:
							dInfo[9].setPrecipitation(precp);
							System.out.println(dInfo[9].precipitation);
							break;

						default:    
						}
						precpCh++;
					}



				}

				checkT++;
				dateN++;
			}
		}
	}
	public static List<String> extractText(Reader reader) throws IOException {
		final ArrayList<String> list = new ArrayList<String>();

		ParserDelegator parserDelegator = new ParserDelegator();
		ParserCallback parserCallback = new ParserCallback() {
			public void handleText(final char[] data, final int pos) {
				list.add(new String(data));
			}
			public void handleStartTag(Tag tag, MutableAttributeSet attribute, int pos) { }
			public void handleEndTag(Tag t, final int pos) {  }
			public void handleSimpleTag(Tag t, MutableAttributeSet a, final int pos) { }
			public void handleComment(final char[] data, final int pos) { }
			public void handleError(final java.lang.String errMsg, final int pos) { }

		};
		parserDelegator.parse(reader, parserCallback, true);
		return list;
	}

	public final static void main(String[] args) {
		//new ReadHTML();

	}

}

