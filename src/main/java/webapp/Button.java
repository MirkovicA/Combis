package webapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet(urlPatterns="/Button")
public class Button extends HttpServlet{
	
	final static Logger logger = Logger.getLogger(Button.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		if(request.getParameter("spremi") != null) {
			logger.info("Pritisnut gumb spremi na pocetna.jsp, vra�anje na po�etnu i ispis gre�ke. ---> Potrebno je u�itati podatke da bi se mogli spremiti u bazu." );
			request.setAttribute("poruka", "Potrebno je u�itati podatke da bi se mogli spremiti u bazu.");
			request.getRequestDispatcher("/WEB-INF/pocetna.jsp").forward(request, response);
		}
		
		if(request.getParameter("ucitaj") != null) {
			logger.info("Pritisnut gumb u�itaj na pocetna.jsp.");
			request.getRequestDispatcher("/PodaciServis").forward(request, response);
		}
	}
}
