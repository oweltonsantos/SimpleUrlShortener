package br.com.logique.urlshortener.Controller;

import java.io.IOException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

/**
 * Servlet implementation class InserirUrlController
 */
public class InserirUrlController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public InserirUrlController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String msg = "OK!!!";
		try {
			UrlController urlController = new UrlController();
			if(!urlController.create(request.getParameter("url")))
					msg = "NOK!!!";
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		//response.sendRedirect("index.jsp");
	}

}
