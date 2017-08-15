package br.edu.facear.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nimbusds.oauth2.sdk.Request;

import br.edu.facear.model.Cliente;
import br.edu.facear.service.CadastroService;

/**
 * Servlet implementation class CadastrarServlet
 */
@WebServlet("/CadastrarServlet")
public class CadastrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Acesso negado!!!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome=request.getParameter("nome");
		String cpf=request.getParameter("cpf");
		String email=request.getParameter("email");
		String senha=request.getParameter("senha");
		
		CadastroService service=new CadastroService();
		
		//Obter do Banco de Dados
		Cliente c=service.cadastrar(nome, cpf, email, senha);
		
		//Colocar na área de memória da sessão
		request.setAttribute("cliente", c);
		
		String nextPage="/cadastro.html";
		
		if(c!=null)
			nextPage="/principal.jsp";
		
		Request
	}

}
