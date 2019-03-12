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
 * Servlet implementation class ServletPrincipale
 */
@WebServlet("/ServletLoginAmministratore")
public class ServletLoginAmministratore extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLoginAmministratore() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String un = request.getParameter("username");
		String pw = request.getParameter("password");
        HttpSession session = request.getSession();
        session.setAttribute("logon.isDone",  un);
        
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		LoginAmministratore lg = new LoginAmministratore(un, pw);
		if (lg.getUname()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
			out.println("<title> Amministrazione </title>");
			out.println("</head>");
			out.println("<body>");
			
			
			
			out.println("<h1>Scelta Gestione</h1>");
			out.println("<form method=\"get\" action=\"http://localhost:8088/percorsiTuristici/GestionePercorsi.html\">");
			out.println("<button type=\"submit\"> Gestione Percorsi</button>");
			out.println("</form>");
			out.println("<BR>");
			out.println("<form method=\"get\" action=\"http://localhost:8088/percorsiTuristici/GestioneUtenti.html\">");
			out.println("<button type=\"submit\"> Gestione Utenti</button>");
			out.println("</form>");
			
			try {
				String target = (String)session.getAttribute("login.target");
				if(target !=null) {
					response.sendRedirect(target);
					return;
				}
			} catch(Exception ignored) {}
			out.println("</body>");
			out.println("</html>");
		} else
			out.println("Username e password errati!");
		out.println("<BR>");
		out.println("<a href=\"http://localhost:8088/percorsiTuristici/SceltaLogin.html\"> Torna alla pagina inziale</a>");

	}
}