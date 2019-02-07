package webapp;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


@WebServlet(urlPatterns="/PodaciServis")
public class PodaciServis extends HttpServlet {
	
	final static Logger logger = Logger.getLogger(PodaciServis.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		logger.info("Dohvaæanje csv datoteke i ispis.");
		
		ArrayList<StockRecord> stockData = StockData.loadData();
		request.setAttribute("stockData", stockData);
		request.getRequestDispatcher("/WEB-INF/ispis.jsp").forward(request, response);
	
	}
}