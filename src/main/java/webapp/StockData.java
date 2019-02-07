package webapp;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class StockData {
	
	final static Logger logger = Logger.getLogger(StockData.class);
	
	public static ArrayList<StockRecord> loadData() throws IOException{
		
		ArrayList<StockRecord> stockData = new ArrayList();
		
		try  {
			Scanner scanner = new Scanner(new FileReader("podaci.csv"));
			String line;
			StockRecord record;
			 
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				String[] results = line.split(";");
				String ime = results[0];
				String prezime = results[1];
				String postanskiBroj = results[2];
				String grad = results[3];
				String telefon = results[4];
				record = new StockRecord(ime, prezime, postanskiBroj, grad, telefon);
				stockData.add(record);
				 
				logger.info("Proèitan podatak " + ime + " " + prezime + " " + postanskiBroj + " " + grad + " " + telefon);
			}// while (scanner.hasNextLine())
			
			scanner.close();
			
		}catch (Exception e){
			logger.error("Greška na èitanju podataka. Greška : " + e.getMessage());
		}
		return stockData;
	}// ArrayList<StockRecord> loadData()
}// class