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
import Capa_de_Entidades.Venta;

/**
 * Servlet implementation class Discos
 */
@WebServlet("/Discos")
public class Discos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Discos() {
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
		ArrayList<Disco> carrito = new ArrayList<Disco>();
		if(request.getParameter("eventoBuscar")!=null){
			String cadena = request.getParameter("buscar");
			if (!cadena.isEmpty()) {
				ArrayList<Disco> discos = new ArrayList<Disco>();
				discos = con.buscarDiscos(cadena);
				request.getSession().setAttribute("buscados", discos);
			}
			request.getRequestDispatcher("discos.jsp").forward(request, response);
		}
		if(request.getParameter("eventoValorar")!=null){
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			if(usuario!=null){
				int n = Integer.parseInt(request.getParameter("numero"));
				Disco disco;
				ArrayList<Disco> buscados = (ArrayList<Disco>) request.getSession().getAttribute("buscados");
				if(buscados.isEmpty())
					disco = con.getDiscos().get(n);
				else
					disco = buscados.get(n);
				ArrayList<Venta> ventas = con.getVentasxUsuario(usuario);
				boolean mismoDisco = false;
				int i=0;
				if(ventas != null){
					while(mismoDisco==false || i<ventas.size()){
						int j=0;
						while(j<ventas.get(i).getDiscos().size() || mismoDisco==false){
							mismoDisco = (disco==ventas.get(i).getDiscos().get(j));
							j++;
						}
						i++;
					}
				}
				if(mismoDisco==false){
					int valor = Integer.parseInt(request.getParameter("valor"));
					con.valorarDisco(usuario,disco,valor);
				}
			}
			request.getRequestDispatcher("discos.jsp").forward(request, response);
		}
		if(request.getParameter("eventoComprar")!=null){
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			if(usuario!=null){
				int n = Integer.parseInt(request.getParameter("numero"));
				Disco disco;
				ArrayList<Disco> buscados = (ArrayList<Disco>) request.getSession().getAttribute("buscados");
				if(buscados.isEmpty())
					disco = con.getDiscos().get(n);
				else
					disco = buscados.get(n);
				if((request.getSession().getAttribute("carrito"))!=null)
					carrito = (ArrayList<Disco>) request.getSession().getAttribute("carrito");
				carrito.add(disco);
				request.getSession().setAttribute("carrito", carrito);
			}
			request.getRequestDispatcher("discos.jsp").forward(request, response);
		}
	}
}
