package percorsiTuristici;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Mod_Poi_in_Percorso
 */
@WebServlet("/Mod_Poi_in_Percorso")
public class Mod_Poi_in_Percorso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mod_Poi_in_Percorso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("METHOD GET");
		int idpoi_inserito=Integer.parseInt(request.getParameter("idpoi"));
		//System.out.println("id_un(GET):"+id_un_inserito);
		
		
		System.out.println("METHOD GET");
		int idpercorso_inserito=Integer.parseInt(request.getParameter("idpercorso"));
		//System.out.println("nuovonome(GET):"+nuovonome_inserito);
		
		
		PrintWriter out=response.getWriter();
	//	out.println("<html><body> GET parameter:"+idpoi_inserito+idpercorso_inserito+ "</body></html>");
	////////////////////////////////////////////////////////////////////////////////	
		Query mod=new Query();
		//mod.Control(idpoi_inserito,idpercorso_inserito);
		
///////////////////////////////////////////////////////////////////////////////////////////
		out.println("<html>");
		out.println("</head><br>");
		out.println("<body bgcolor=LIGHTCYAN ><br>");
		
if (mod.Control(idpoi_inserito,idpercorso_inserito))
			
		{    // risorse protette 
			
			out.println("<html>");
			out.println("<head><title> Poi esistente</title><br>");
			out.println("</head><br>");
			out.println("<body bgcolor=LIGHTCYAN ><br>");
			
			out.println("<h1>  P.O.I. ESISTENTE, VUOI MODIFICARE IL PERCORSO?  </h1>");
			
			out.println( "<FORM METHOD=\"GET\" ACTION=\"Rimosso\">");
			out.println("<input type=\"submit\" value=\"Rimuovi P.o.i. dal percorso\">");
			out.println("<input type=\"hidden\" name=\"idpoi\" value=\""+idpoi_inserito+"\">");
			out.println("<input type=\"hidden\" name=\"idpercorso\" value=\""+idpercorso_inserito+"\">");
			out.println("</form>");
			
			
			out.println( "<FORM METHOD=\"GET\" ACTION=\"NomeCambiato\">");
			out.println("<input type=\"submit\" value=\"Cambia nome al percorso\">");
			out.println("<input type=\"hidden\" name=\"idpercorso\" value=\""+idpercorso_inserito+"\">");
			out.println("<input type=\"hidden\" name=\"controllo\" value=\"primo\">");
			out.println("</form>");
			
			out.println("<a href=\"Informazioni\"> Torna al menù principale </a>");					
		}
		else {
			out.println("<html>");
			out.println("<h1>P.O.I. NON ESISTE VUOI AGGIUNGERLO? </h1>");
			out.println( "<FORM METHOD=GET ACTION=\"Aggiunto\">");
			out.println("<input type=\"submit\" value=\"Aggiungi P.o.i. al percorso\">");
			out.println("<input type=\"hidden\" name=\"idpoi\" value=\""+idpoi_inserito+"\">");
			out.println("<input type=\"hidden\" name=\"idpercorso\" value=\""+idpercorso_inserito+"\">");
			out.println("</form>");
			out.println(" <br><br> <a href =\"http://localhost:8089/accesso/Informazioni\">"
					+ "Torna al menù principale" + "</a>");
			out.println("</body></html>");
		}
	}
		
		
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
