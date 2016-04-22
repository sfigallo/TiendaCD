package Capa_de_Presentacion;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Capa_de_Control.Controlador;
import Capa_de_Entidades.TipoUsuario;
import Capa_de_Entidades.Usuario;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Inicio")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Inicio() {
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
		Usuario usu = new Usuario();
		Controlador con = new Controlador();
		if(request.getParameter("eventoIngresar")!=null){
			usu = con.buscarUsuario(request.getParameter("userregister"));
			if(usu!=null){
				String contraseña = usu.getContraseña();
				if(contraseña.equals(request.getParameter("password"))){
					request.getSession().setAttribute("usuario", usu);
					if(usu.getTipo().getCodTipoUsuario() == TipoUsuario.COD_ADMIN)
						request.getRequestDispatcher("discosAdmin.jsp").forward(request, response);
					if(usu.getTipo().getCodTipoUsuario() == TipoUsuario.COD_USER)
						request.getRequestDispatcher("discos.jsp").forward(request, response);
				}
				else{
					request.setAttribute("msjError", "La contraseña es incorrecta");
					request.getRequestDispatcher("inicio.jsp").forward(request, response);
				}
			}
			else{
				request.setAttribute("msjError", "El usuario es incorrecto");
				request.getRequestDispatcher("inicio.jsp").forward(request, response);
			}	
		}
		if(request.getParameter("eventoRegistrar")!=null){
			usu = con.buscarUsuario(request.getParameter("user"));
			if(usu == null){
				usu = new Usuario();
				usu.setUsuario(request.getParameter("user"));
				usu.setContraseña(request.getParameter("password"));
				usu.setNombre(request.getParameter("nombre"));
				usu.setApellido(request.getParameter("apellido"));
				usu.setFechaNac(Date.valueOf(request.getParameter("fechanac")));
				usu.setDni(Integer.parseInt(request.getParameter("dni")));
				con.nuevoUsuario(usu);
				request.getSession().setAttribute("usuario", usu);
				request.getRequestDispatcher("discos.jsp").forward(request, response);
			}
			else{
				request.setAttribute("msjError", "El usuario ya existe.");
				request.getRequestDispatcher("inicio.jsp").forward(request, response);
			}	
		}
	}

}
