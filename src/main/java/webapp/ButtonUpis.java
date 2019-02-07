package webapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet(urlPatterns="/ButtonUpis")
public class ButtonUpis extends HttpServlet{
	
	final static Logger logger = Logger.getLogger(Button.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		if(request.getParameter("spremi") != null) {
			logger.info("Pritisnut gumb spremi na ispis.jsp.");
			request.getRequestDispatcher("/upisPodataka").forward(request, response);
		}
		
		if(request.getParameter("ucitaj") != null) {
			logger.info("Pritisnut gumb uèitaj na ispis.jsp.");
			request.getRequestDispatcher("/PodaciServis").forward(request, response);
		}
	}
}
