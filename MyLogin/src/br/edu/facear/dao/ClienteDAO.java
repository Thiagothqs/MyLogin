package br.edu.facear.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.facear.model.Cliente;
import br.edu.facear.service.ClienteService;

public class ClienteDAO extends GenericDAO {
	private PreparedStatement ps;
	private String LOGIN_SQL ="SELECT * FROM TB_CLIENTE WHERE EMAIL = ? AND SENHA = ?;";
	private String LISTAR_CLIENTE="SELECT * FROM TB_CLIENTE;";
	private String EXCLUIR_CLIENTE="DELETE FROM TB_CLIENTE WHERE ID=?;";
	private String ALTERAR_CLIENTE="UPDATE TB_CLIENTE SET NOME=?, CPF=?, EMAIL=?, SENHA=? WHERE ID=?;";
	private String CADASTRAR_SQL ="INSERT INTO TB_CLIENTE (NOME, CPF, EMAIL, SENHA) values(?, ?, ?, ?);";
	private String SELECIONA="SELECT * FROM TB_CLIENTE WHERE ID=?;";
	
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
	
	public void alterar(String id, String nome, String cpf, String email, String senha) throws SQLException {
		//Cliente c=new Cliente(id, nome, cpf, email, senha);
		
		System.out.println(id);
		
		Integer idCliente = Integer.parseInt(id);
		
		//Abrir conexão
		openConnection();
		
		ps = connect.prepareStatement(ALTERAR_CLIENTE);
		ps.setString(1, nome);
		ps.setString(2, cpf);
		ps.setString(3, email);
		ps.setString(4, senha);
		ps.setInt(5, idCliente);
		
		ps.execute();
		
		//Fechar conexão
		closeConnection();
	}
	
	public void excluir(String id) throws SQLException {
		Integer idCliente=Integer.parseInt(id);
		
		//Abrir conexão
		openConnection();
		
		ps = connect.prepareStatement(EXCLUIR_CLIENTE);
		ps.setInt(1, idCliente);
		
		ps.execute();
		
		//Fechar conexão
		closeConnection();
	}
	
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
		
		ResultSet rs=ps.executeQuery();
		
		if(rs!=null) {
			while(rs.next()) {
				c=new Cliente(rs.getInt("id"), rs.getString(rs.getString("nome")), rs.getString("cpf"), rs.getString("email"), rs.getString("senha"));
			}
		}
		
		//Fechar conexão
		closeConnection();
		
		return c;
	}
	public Cliente obterClientePorId(Integer id) throws SQLException {
		Cliente c=null;
		ClienteService service=new ClienteService();
		List<Cliente> listaCliente=service.listaClientes();
		
		openConnection();
		
		ps=connect.prepareStatement(SELECIONA);
		ps.setInt(1, id);
		
		for(int i=0;i<listaCliente.size();i++) {
			if(id==listaCliente.get(i).getId()) {
				c=listaCliente.get(i);
			}
		}
		
		closeConnection();
		
		return c;
	}
	
}
