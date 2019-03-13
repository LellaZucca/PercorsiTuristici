package percorsiTuristici;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class modificapercorso
 */
@WebServlet("/modificapercorso")
public class modificapercorso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modificapercorso() {
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
		int id_pe_inserito=Integer.parseInt(request.getParameter("id_pe"));
		System.out.println("id_un(GET):"+id_pe_inserito);
		
		
		System.out.println("METHOD GET");
		String nuovonomepercorso_inserito=request.getParameter("nuovonomepercorso");
		System.out.println("nuovonome(GET):"+nuovonomepercorso_inserito);
		
		
		PrintWriter out=response.getWriter();
		out.println("<html><body> GET parameter:"+id_pe_inserito+nuovonomepercorso_inserito+ "</body></html>");
		
	
		
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
