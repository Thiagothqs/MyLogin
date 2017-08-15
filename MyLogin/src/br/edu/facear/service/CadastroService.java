package br.edu.facear.service;

import java.sql.SQLException;

import br.edu.facear.dao.CadastrarDAO;
import br.edu.facear.model.Cliente;

public class CadastroService {
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
}
