package br.edu.facear.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.facear.dao.CadastrarDAO;
import br.edu.facear.dao.ClienteDAO;
import br.edu.facear.model.Cliente;

public class ClienteService {
	public Cliente cadastrar(String nome, String cpf, String email, String senha) {
		CadastrarDAO dao=new CadastrarDAO();
		Cliente c=null;
		
		try {
			c=dao.cadastrar(nome, cpf, email, senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	public List<Cliente> listaClientes(){
		ClienteDAO dao=new ClienteDAO();
		List<Cliente> listaCliente=null;
		try {
			listaCliente = dao.listarClientes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaCliente;
	}
	
	public void alterar(String id, String nome, String cpf, String email, String senha) throws SQLException {
		ClienteDAO dao=new ClienteDAO();
		
		dao.alterar(id, nome, cpf, email, senha);
	}
	
	public void excluir(String id) throws SQLException {
		ClienteDAO dao=new ClienteDAO();
		
		dao.excluir(id);
	}
}
