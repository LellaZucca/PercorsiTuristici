package percorsiTuristici;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/ServletCancellazionePercorsi")
public class ServletCancellazionePercorsi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCancellazionePercorsi() {
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
		int id_percorso = Integer.parseInt(request.getParameter("id_percorso"));
		boolean presente = q.confermaPercorso(id_percorso);
		if (presente){
			q.eliminaPercorso(id_percorso);	
			out.write("Percorso eliminato");
		}
		else
			out.write("Impossibile eliminare il percorso");	
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
