package Capa_de_Presentacion;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Capa_de_Control.Controlador;
import Capa_de_Entidades.Autor;
import Capa_de_Entidades.Disco;
import Capa_de_Entidades.GeneroMusical;

/**
 * Servlet implementation class DiscosAdmin
 */
@WebServlet("/DiscosAdmin")
public class DiscosAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiscosAdmin() {
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
				ArrayList<Disco> discos = con.buscarDiscos(cadena);
				request.setAttribute("discos", discos);
			}
			request.getRequestDispatcher("discosAdmin.jsp").forward(request, response);
		}
		if(request.getParameter("buscarDisco")!=null){
			Disco disco = new Disco();
			int codigo = Integer.parseInt(request.getParameter("codigoDisco"));
			disco = con.buscarDisco(codigo);
			if(disco!=null)
				request.setAttribute("disco", disco);
			request.getRequestDispatcher("discos.jsp").forward(request, response);
		}
		if(request.getParameter("nuevoDisco")!=null){
			Disco disco = new Disco();
			disco.setTitulo(request.getParameter("tituloDisco"));
			disco.setAñoLanzamiento(Integer.parseInt(request.getParameter("añoDisco")));
			disco.setPrecio(Float.parseFloat(request.getParameter("precioDisco")));
			disco.setCantCopiasDisp(Integer.parseInt(request.getParameter("stockDisco")));
			Autor autor = con.buscarAutorxNombre(request.getParameter("selectAutor"));
			disco.setAutor(autor);
			GeneroMusical genero = con.buscarGeneroxDescripcion(request.getParameter("selectGenero"));
			disco.setGenero(genero);
			con.nuevoDisco(disco);
			request.getRequestDispatcher("discos.jsp").forward(request, response);
		}
		if(request.getParameter("modificarDisco")!=null){
			Disco disco = new Disco();
			int codigo = Integer.parseInt(request.getParameter("codigoDisco"));
			disco = con.buscarDisco(codigo);
			if(disco!=null){
				disco.setTitulo(request.getParameter("tituloDisco"));
				disco.setAñoLanzamiento(Integer.parseInt(request.getParameter("añoDisco")));
				disco.setPrecio(Float.parseFloat(request.getParameter("precioDisco")));
				disco.setCantCopiasDisp(Integer.parseInt(request.getParameter("stockDisco")));
				Autor autor = con.buscarAutorxNombre(request.getParameter("selectAutor"));
				disco.setAutor(autor);
				GeneroMusical genero = con.buscarGeneroxDescripcion(request.getParameter("selectGenero"));
				disco.setGenero(genero);
				con.modificarDisco(disco);
			}
			request.getRequestDispatcher("discos.jsp").forward(request, response);
		}
		if(request.getParameter("eliminarDisco")!=null){
			Disco disco = new Disco();
			int codigo = Integer.parseInt(request.getParameter("codigoDisco"));
			disco = con.buscarDisco(codigo);
			if(disco!=null)
				con.eliminarDisco(codigo);
		}
	}

}
