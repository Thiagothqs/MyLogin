package br.edu.facear.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.facear.model.Cliente;

public class CadastrarDAO extends GenericDAO {
	private PreparedStatement ps;
	private String CADASTRAR_SQL ="INSERT INTO TB_CLIENTE (NOME, CPF, EMAIL, SENHA) values(?, ?, ?, ?);";
	
	public Cliente cadastrar(String nome, String cpf, String email, String senha) throws SQLException {
		Cliente c=null;
		
		//Abrir conexão
		openConnection();
		
		//Preparar script
		ps = connect.prepareStatement(CADASTRAR_SQL);
		ps.setString(1, nome);
		ps.setString(2, cpf);
		ps.setString(3, email);
		ps.setString(4, senha);
		
		/*ResultSet rs=ps.executeQuery();
		
		if(rs!=null) {
			while(rs.next()) {
				c=new Cliente(rs.getInt("id"), rs.getString(rs.getString("nome")), rs.getString("cpf"), rs.getString("email"), rs.getString("senha"));
			}
		}*/
		
		//Fechar conexão
		closeConnection();
		
		return c;
	}
}
