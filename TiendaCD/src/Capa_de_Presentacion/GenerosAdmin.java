package Capa_de_Presentacion;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Capa_de_Control.Controlador;
import Capa_de_Entidades.GeneroMusical;

/**
 * Servlet implementation class GenerosAdmin
 */
@WebServlet("/GenerosAdmin")
public class GenerosAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerosAdmin() {
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
				ArrayList<GeneroMusical> generos = con.buscarGeneros(cadena);
				request.setAttribute("generos", generos);
			}
			request.getRequestDispatcher("generosAdmin.jsp").forward(request, response);
		}
		if(request.getParameter("buscarGenero")!=null){
			GeneroMusical genero = new GeneroMusical();
			int codigo = Integer.parseInt(request.getParameter("codigoGenero"));
			genero = con.buscarGenero(codigo);
			if(genero!=null)
				request.setAttribute("genero", genero);
			request.getRequestDispatcher("generosAdmin.jsp").forward(request, response);
		}
		if(request.getParameter("nuevoGenero")!=null){
			GeneroMusical genero = new GeneroMusical();
			genero.setDescGenero(request.getParameter("descGenero"));
			con.nuevoGenero(genero);
			request.getRequestDispatcher("generosAdmin.jsp").forward(request, response);
		}
		if(request.getParameter("modificarGenero")!=null){
			GeneroMusical genero = new GeneroMusical();
			int codigo = Integer.parseInt(request.getParameter("codigoGenero"));
			genero = con.buscarGenero(codigo);
			if(genero!=null){
				genero.setDescGenero(request.getParameter("descGenero"));
				con.modificarGenero(genero);
			}
			request.getRequestDispatcher("generosAdmin.jsp").forward(request, response);
		}
	}

}
