package Capa_de_Presentacion;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Capa_de_Control.Controlador;
import Capa_de_Entidades.Disco;
import Capa_de_Entidades.Usuario;

/**
 * Servlet implementation class Carrito
 */
@WebServlet("/Carrito")
public class Carrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Carrito() {
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
		if(request.getParameter("eventoEliminar")!=null){
			ArrayList<Disco> carrito = (ArrayList<Disco>) request.getSession().getAttribute("carrito");
			int n = Integer.parseInt(request.getParameter("numero"));
			carrito.remove(n);
			request.getSession().setAttribute("carrito", carrito);
			request.getRequestDispatcher("carrito.jsp").forward(request, response);
		}
		
		if(request.getParameter("confirmarCompra")!=null){
			float monto = Float.valueOf(request.getParameter("monto"));
			int descuento = Integer.parseInt(request.getParameter("descuento"));
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			ArrayList<Disco> carrito = (ArrayList<Disco>) request.getSession().getAttribute("carrito");
			con.nuevaVenta(monto, usuario, descuento, carrito);
			carrito = new ArrayList<Disco>();
			request.getSession().setAttribute("carrito", carrito);
			request.getRequestDispatcher("NoContemplado.html").forward(request, response);
		}
	}

}
