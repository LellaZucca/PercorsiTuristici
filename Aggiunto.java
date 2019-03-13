package percorsiTuristici;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Aggiunto
 */
@WebServlet("/Aggiunto")
public class Aggiunto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Aggiunto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int idpoi_inserito=Integer.parseInt(request.getParameter("idpoi"));
		int idpercorso_inserito=Integer.parseInt(request.getParameter("idpercorso"));
		
		Query mod=new Query();
		int controllo = mod.getAddPoi(idpoi_inserito,idpercorso_inserito);
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		if (controllo==1){
		out.println("<h1>P.O.I. AGGIUNTO CON SUCCESSO </h1>");
		out.println(" <br><br> <a href =\"http://localhost:8089/accesso/Informazioni\" ></a>");
		
		}
		else {
			out.println("<h1>P.O.I. HAI SBAGLIATO CON SUCCESSO </h1>");
		}
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
