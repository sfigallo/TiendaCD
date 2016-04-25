package Capa_de_Presentacion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Capa_de_Control.Controlador;
import Capa_de_Entidades.Descuento;

/**
 * Servlet implementation class DescuentosAdmin
 */
@WebServlet("/DescuentosAdmin")
public class DescuentosAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DescuentosAdmin() {
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
		if(request.getParameter("buscarDescuento")!=null){
			Descuento descuento = new Descuento();
			int codigo = Integer.parseInt(request.getParameter("codigoDto"));
			descuento = con.getDescuento(codigo);
			if(descuento != null){
				request.setAttribute("codigoDto", descuento.getCodDescuento());
				request.setAttribute("monto", descuento.getMontoASuperar());
				request.setAttribute("porcentaje", descuento.getPorcentaje());
			}
			request.getRequestDispatcher("descuentosAdmin.jsp").forward(request, response);	
		}
		
		if(request.getParameter("nuevoDescuento")!=null){
			Descuento descuento = new Descuento();
			descuento.setMontoASuperar(Float.valueOf(request.getParameter("monto")));
			float porc = Float.valueOf(request.getParameter("porcentaje")) * 100;
			descuento.setPorcentaje(porc);
			con.nuevoDescuento(descuento);
			request.getRequestDispatcher("descuentosAdmin.jsp").forward(request, response);
		}
		
		if(request.getParameter("modificarDescuento")!=null){
			Descuento descuento = new Descuento();
			int codigo = Integer.parseInt(request.getParameter("codigoDto"));
			descuento = con.getDescuento(codigo);
			if(descuento != null){
				descuento.setMontoASuperar(Float.valueOf(request.getParameter("monto")));
				descuento.setPorcentaje(Float.valueOf(request.getParameter("porcentaje")));
				con.modificarDescuento(descuento);
			}
			request.getRequestDispatcher("descuentosAdmin.jsp").forward(request, response);
		}
	}

}
