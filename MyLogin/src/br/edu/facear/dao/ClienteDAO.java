package br.edu.facear.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.facear.model.Cliente;

public class ClienteDAO extends GenericDAO {
	private PreparedStatement ps;
	private String LOGIN_SQL ="SELECT * FROM TB_CLIENTE WHERE EMAIL = ? AND SENHA = ?;";
	private String LISTAR_CLIENTE="SELECT * FROM TB_CLIENTE;";
	
	public Cliente autenticar(String email, String senha) throws SQLException {
		Cliente c=null;
		//Abrir uma conexão
		openConnection();
		
		//Preparar o script
		ps = connect.prepareStatement(LOGIN_SQL);
		ps.setString(1, email);
		ps.setString(2, senha);
		
		ResultSet rs=ps.executeQuery();
		
		if(rs != null)
			while(rs.next()) {
				c=new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("email"), rs.getString("senha"));
			}
		
		//Fechar a conexão
		closeConnection();
		
		return c;
	}
	
	public ArrayList<Cliente> listarClientes() throws SQLException{
		ArrayList<Cliente> listaClientes=new ArrayList<Cliente>();
		
		//Abrir conexão
		openConnection();
		
		ps = connect.prepareStatement(LISTAR_CLIENTE);
		ResultSet rs=ps.executeQuery();
		
		if(rs != null) {
			while(rs.next()) {
				Cliente c=new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("email"), rs.getString("senha"));
				listaClientes.add(c);
			}
		}
		
		//Fechar conexão
		closeConnection();
		
		return listaClientes;
	}
}
