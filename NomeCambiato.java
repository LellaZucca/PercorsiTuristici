package percorsiTuristici;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NomeCambiato
 */
@WebServlet("/NomeCambiato")
public class NomeCambiato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NomeCambiato() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String idp = (request.getParameter("idpercorso"));
		String ctr = (request.getParameter("controllo"));
		PrintWriter out=response.getWriter();
		if (ctr.equals("primo")){
		out.println("<html>");
		out.println("<body>");
		//out.println("<h1>P.O.I. NOME CAMBIATO CON SUCCESSO </h1>");
		out.println(" <br><br> <a href =\"http://localhost:8089/accesso/Informazioni\" ></a>");

		out.println("<h3>Modifica nome percorso</h3><br>"
		+ "<form name=\"formPOST\" action=\"NomeCambiato\" method=\"post\"><br>"		
		+ "Nuovo nome percorso: <input type=\"text\" name=\"nuovonomepercorso\"/><br>"
		+"<input type=\"hidden\" name=\"id_pe\" value=\""+idp+"\">"
		+"<input type=\"hidden\" name=\"controllo\" value=\"secondo\"/>"
		+ "<input type=\"submit\" value=\"INVIO\"></form></body></html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String idpercorso_inserito=request.getParameter("id_pe");
		String nuovonomepercorso_inserito=(request.getParameter("nuovonomepercorso"));
		String ctr=(request.getParameter("controllo"));
		if (ctr.equals("secondo")){
		Query mod=new Query();
		
		boolean cambiato = mod.ModificaPercorso(idpercorso_inserito,nuovonomepercorso_inserito);
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		if (cambiato) 
			out.println("Nome cambiato con successo");
		else
			out.println("Errore");
		out.println("</body></html>");
		}
		
	}

}
