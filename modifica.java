package percorsiTuristici;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class modifica
 */
@WebServlet("/modifica")
public class modifica extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public modifica() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("METHOD GET");
		int id_un_inserito=Integer.parseInt(request.getParameter("id_un"));
		System.out.println("id_un(GET):"+id_un_inserito);
		
		
		System.out.println("METHOD GET");
		String nuovonome_inserito=request.getParameter("nuovonome");
		System.out.println("nuovonome(GET):"+nuovonome_inserito);
		
		
		PrintWriter out=response.getWriter();
		out.println("<html><body> GET parameter:"+id_un_inserito+nuovonome_inserito+ "</body></html>");
		
		Query mod=new Query();
		mod.ModificaUtente(id_un_inserito,nuovonome_inserito);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
