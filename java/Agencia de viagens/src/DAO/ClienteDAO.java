package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Cliente;
import DAO.ConexcaoDAO;

public class ClienteDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Cliente cliente) {

		String sql = "INSERT INTO cliente (Nome,Email,Telefone,Senha,Id_cliente)" + " VALUE(?,?,?,?,?)";

		try {
			conn = ConexcaoDAO.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getEmail());
			pstm.setString(3, cliente.getTelefone());
			pstm.setString(4, cliente.getSenha());
			pstm.setInt(5, cliente.getId());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void removeById(int Id) {

		String sql = "DELETE FROM cliente WHERE Id_cliente=?";

		try {
			conn = ConexcaoDAO.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, Id);
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Cliente cliente) {

		String sql = "UPDATE cliente SET Nome = ?,Email =?, Telefone = ?, Senha =?"
				+ "WHERE Id_cliente=?";

		try {
			conn = ConexcaoDAO.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getEmail());
			pstm.setString(3, cliente.getTelefone());
			pstm.setString(4, cliente.getSenha());
			pstm.setInt(5, cliente.getId());
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public List<Cliente> getCliente() {

		String sql = "SELECT * FROM cliente";

		List<Cliente> cli = new ArrayList<Cliente>();
		ResultSet rset = null;

		try {
			conn = ConexcaoDAO.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Cliente c = new Cliente();

				c.setNome(rset.getString("Nome"));
				c.setSenha(rset.getString("Senha"));
				c.setTelefone(rset.getString("Telefone"));
				c.setEmail(rset.getString("Email"));
                c.setId(rset.getInt("Id_cliente"));
				cli.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cli;
	}

	public Cliente cliByCpf(String cpf) {
		String sql = "SELECT * FROM cliente WHERE CPF_cli=?";

		ResultSet rset = null;
		Cliente cliente = new Cliente();

		try {
			conn = ConexcaoDAO.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,cpf);
			rset = pstm.executeQuery();
			rset.next();

			cliente.setNome(rset.getString("Nome"));
			cliente.setEmail(rset.getString("Email"));
			cliente.setTelefone(rset.getString("Telefone"));
			cliente.setSenha(rset.getString("Senha"));
			cliente.setId(rset.getInt("Id_cliente"));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cliente;
	}
}