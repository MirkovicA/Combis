package webapp;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet(urlPatterns="/upisPodataka")
public class upisPodataka extends HttpServlet{
	
	final static Logger logger = Logger.getLogger(upisPodataka.class);
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
	}
		
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		Connection con = null;
		PreparedStatement pst, check;
		int count = 0;
		String dbIme = null, dbPrezime = null, dbPostanskiBroj = null, dbGrad = null, dbTelefon = null;
		String ime = null, prezime = null, postanskiBroj = null, grad = null, telefon = null;
		String dbImeConflict = null, dbPrezimeConflict = null, dbPostanskiBrojConflict = null, dbGradConflict = null, dbTelefonConflict = null;
		
		try {
			con = MyConnectionProvider.getCon();
			
			logger.info("Uspješno povezano s bazom.");
			
			String sqlSelectCount = "select * from podaci";
			check = con.prepareStatement(sqlSelectCount);
			ResultSet rsCount = check.executeQuery();
			
			logger.info("Brojanje redova u bazi.");
			while(rsCount.next()) {
				count++;
			}
			
			Scanner scanner = new Scanner(new FileReader("podaci.csv"));
			String line;
			
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				String[] results = line.split(";");
				ime = results[0];
				prezime = results[1];
				postanskiBroj = results[2];
				grad = results[3];
				telefon = results[4];
					 
				if(count != 0) {
					logger.info("Ako u bazi ima podataka provjera.");
					
					String sqlSelect = "select * from podaci";
					check = con.prepareStatement(sqlSelect);
					ResultSet rs = check.executeQuery();
					
					logger.info("Spremanje podataka iz baze u varijable za usporedbu.");
                    while (rs.next()) {
                    	dbIme = rs.getString("ime");
						dbPrezime = rs.getString("prezime");
						dbPostanskiBroj = rs.getString("postanskibroj");
						dbGrad = rs.getString("grad");
						dbTelefon = rs.getString("telefon");
						
						if(dbIme.contentEquals(ime) && dbPrezime.contentEquals(prezime) && dbPostanskiBroj.contentEquals(postanskiBroj) && dbGrad.contentEquals(grad) && dbTelefon.contentEquals(telefon)) {
							dbImeConflict = ime;
							dbPrezimeConflict = prezime;
							dbPostanskiBrojConflict = postanskiBroj;
							dbGradConflict = grad;
							dbTelefonConflict = telefon;
								
							logger.info("Usporedba da li se podudaraju podaci u bazi i csv datoteci, te ako se podudaraju spremanje rezultata u nove varijable.");
						}//if(dbIme.contentEquals(ime).....
					}//while(rs.next());
						
               	    if(!dbImeConflict.contentEquals(ime) || !dbPrezimeConflict.contentEquals(prezime) || !dbPostanskiBrojConflict.contentEquals(postanskiBroj) || !dbGradConflict.contentEquals(grad) || !dbTelefonConflict.contentEquals(telefon)) {
               	    	logger.info("Ako se podatak iz csv datoteke ne podudara s bazom provjera da li je ispravan poštanski broj. Ako je, spremanje podatka u bazu.");
                    	if(postanskiBroj.length() == 5) {
                    		String sql="insert into podaci values(?,?,?,?,?)";
  							pst = con.prepareStatement(sql);
  							
  							pst.setString(1, ime);
  							pst.setString(2, prezime);
  							pst.setString(3, postanskiBroj);
  							pst.setString(4, grad);
  							pst.setString(5, telefon);
  							pst.executeUpdate();
  							
  							logger.info("Uspješno spremljeno: "+ ime + " " + prezime + " " + postanskiBroj + " " + grad + " " + telefon + ".");
  							response.getWriter().println("Uspjesno spremljeno: "+ ime + " " + prezime + " " + postanskiBroj + " " + grad + " " + telefon + "!\n");
                    	}//if(postanskiBroj.length() == 5)
                    	else {
                    		logger.info("Greška, provjerite poštanski broj: " + ime + " " + prezime + " " + postanskiBroj + " " + grad + " " + telefon + "!");
                    		response.getWriter().println("Greska, provjerite postanski broj: " + ime + " " + prezime + " " + postanskiBroj + " " + grad + " " + telefon + "!\n");
                    	}// else if(postanskiBroj.length() == 5)
  					}//if(!dbImeConflict.contentEquals(ime)
               	    else {
               	    	logger.info("Greška, " + ime + " " + prezime + " " + postanskiBroj + " " + grad + " " + telefon + " postoji u bazi!");
  						response.getWriter().println("Greska, korisnik " + ime + " " + prezime + " " + postanskiBroj + " " + grad + " " + telefon + " postoji u bazi!\n");
  					}//else if(!dbImeConflict.contentEquals(ime)
                }//if(count != 0)
				else {
					logger.info("Ako nema podataka u bazi provjera ispravnosti poštanskog broja i uspis u bazu.");
					if(postanskiBroj.length() == 5) {
						String sql="insert into podaci values(?,?,?,?,?)";
						pst = con.prepareStatement(sql);
								
						pst.setString(1, ime);
						pst.setString(2, prezime);
						pst.setString(3, postanskiBroj);
						pst.setString(4, grad);
						pst.setString(5, telefon);
						pst.executeUpdate();
								
						logger.info("Uspješno spremljeno: " + ime + " " + prezime + " " + postanskiBroj + " " + grad + " " + telefon +".");
						response.getWriter().println("Uspjesno spremljeno: " + ime + " " + prezime + " " + postanskiBroj + " " + grad + " " + telefon +"!\n");
                  	}// if(postanskiBroj.length() == 5)
                  	else {
                  		logger.info("Greška, provjerite poštanski broj: " + ime + " " + prezime + " " + postanskiBroj + " " + grad + " " + telefon + "!");
                  		response.getWriter().println("Greska, provjerite postanski broj: " + ime + " " + prezime + " " + postanskiBroj + " " + grad + " " + telefon + "!\n");
                  	}// else if(postanskiBroj.length() == 5)
				}// elseif(count != 0)
            }// while (scanner.hasNextLine())
			
			con.close();
			scanner.close();
			
			 
		} catch(Exception e) {
			logger.error("Greška u upisu podataka. " + e.getMessage());
		}
	}// doPost()

}// class