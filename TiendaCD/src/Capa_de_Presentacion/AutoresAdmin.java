package Capa_de_Presentacion;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Capa_de_Control.Controlador;
import Capa_de_Entidades.Autor;
import Capa_de_Entidades.GeneroMusical;

/**
 * Servlet implementation class AutoresAdmin
 */
@WebServlet("/AutoresAdmin")
public class AutoresAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoresAdmin() {
        super();
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
		Controlador con = new Controlador();
		if(request.getParameter("eventoBuscar")!=null){
			String cadena = request.getParameter("titBuscar");
			if (!cadena.isEmpty()) {
				ArrayList<Autor> autores = con.buscarAutores(cadena);
				request.setAttribute("autores", autores);
			}
			request.getRequestDispatcher("autoresAdmin.jsp").forward(request, response);
		}
		if(request.getParameter("buscarAutor")!=null){
			Autor autor = new Autor();
			int codigo = Integer.parseInt(request.getParameter("codigoAutor"));
			autor = con.buscarAutor(codigo);
			if(autor!=null)
				request.setAttribute("nombreAutor", autor.getNombreAutor());
				request.setAttribute("codigoAutor", autor.getCodAutor());
			request.getRequestDispatcher("autoresAdmin.jsp").forward(request, response);
		}
		if(request.getParameter("nuevoAutor")!=null){
			Autor autor = new Autor();
			autor.setNombreAutor(request.getParameter("nombreAutor"));
			con.nuevoAutor(autor);
			request.getRequestDispatcher("autoresAdmin.jsp").forward(request, response);
		}
		if(request.getParameter("modificarAutor")!=null){
			Autor autor = new Autor();
			int codigo = Integer.parseInt(request.getParameter("codigoAutor"));
			autor = con.buscarAutor(codigo);
			if(autor!=null){
				autor.setNombreAutor(request.getParameter("nombreAutor"));
				con.modificarAutor(autor);
			}
			request.getRequestDispatcher("autoresAdmin.jsp").forward(request, response);
		}
	}

}
