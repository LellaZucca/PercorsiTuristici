package percorsiTuristici;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCancellazioneUtenti
 */
@WebServlet("/ServletCancellazioneUtenti")
public class ServletCancellazioneUtenti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCancellazioneUtenti() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Query q = new Query();
		PrintWriter out = response.getWriter();
		out.write("<html>");
		out.write("<body>");
		int id_un = Integer.parseInt(request.getParameter("id_utente"));
		boolean presente = q.confermaUtente(id_un);
		if (presente){
			q.eliminaPercorso(id_un);	
			out.write("Utente eliminato");
		}
		else
			out.write("Impossibile eliminare l'utente");
				
		out.write("</body>");
		out.write("</html>");
		//response.sendRedirect("ServletPrincipale");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
