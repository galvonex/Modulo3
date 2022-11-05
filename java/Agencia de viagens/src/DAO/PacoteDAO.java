package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Cliente;
import Model.PACOTE;

public class PacoteDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(PACOTE pacote) {

		String sql = "INSERT INTO pacote (Id_pacote,Destino,DataIda,DataVolta,ValorTransporte,ValorHospedagem,ValoresExtra.)" + " VALUE(?,?,?,?,?,?,?)";

		try {
			conn = ConexcaoDAO.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
            pstm.setInt(1, pacote.getId("Id_pacote));
			pstm.setString(2, pacote.getDestino("Destino"));
			pstm.setString(3, pacote.getDataIda("DataIda"));
			pstm.setString(4, pacote.getDataVolta("DataVolta"));
			pstm.setString(5, pacote.getValorTransporte("ValorTransporte"));
			pstm.setInt(6, pacote.getValorHospedagem("ValorHospedagem"));
			pstm.setint(7, pacote.getValoresExtra("ValoresExtra"));

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

		String sql = "DELETE FROM pacote WHERE Id_pacote=?";

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

	public void update(PACOTE pacote) {

		String sql = "UPDATE pacote SET Id_pacote = ?, Destino =?, DataIda = ?, DataVolta = ?, ValorTransporte = ?, ValorHospedagem = ?, ValoresExtras = ?"
				+ "WHERE Id_pacote =?";

		try {
			conn = ConexcaoDAO.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			
			pstm.setInt(1, pacote.getId("Id_pacote"));
			pstm.setString(2, pacote.getDestino("Destino"));
			pstm.setString(3, pacote.getDataIda("DataIda"));
			pstm.setString(4, pacote.getDataVolta("DataVolta"));
			pstm.setString(5, pacote.getValorTransporte("ValorTransporte"));
			pstm.setString(6, pacote.getValorHospedagem("ValorHospedagem"));
			pstm.setString(7, pacote.getValoresExtra("ValoresExtra"));
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

	public List<PACOTE> getPACOTE() {

		String sql = "SELECT * FROM pacote";

		List<PACOTE> pac = new ArrayList<PACOTE>();
		ResultSet rset = null;

		try {
			conn = ConexcaoDAO.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				PACOTE p = new PACOTE();

				p.setDestino(rset.getString("Nome"));
				p.setDataIda(rset.getString("Email"));
				p.setDataVolta(rset.getString("Telefone"));
				p.setValoresTransporte(rset.getString("Senha"));
				p.setValorHospedagem(rset.getString("ValorHospedagem));
				p.setId(rset.getString("Id_cliente"));

				pac.add(p);
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
		return pac;
	}

	public PACOTE cliByCpf(String cpf) {
		String sql = "SELECT * FROM pacote WHERE Id_pacote=?";

		ResultSet rset = null;
		PACOTE pacote = new PACOTE();

		try {
			conn = ConexcaoDAO.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,cpf);
			rset = pstm.executeQuery();
			rset.next();

			pacote.setDestino(rset.getString("Destino"));
			pacote.setDataIda(rset.getString("DataIda"));
			pacote.setDataVolta(rset.getString("DataVolta"));
			pacote.setValorTransporte(rset.getString("ValorTransporte"));
			pacote.setValorHospedagem(rset.getString("ValorHospedagem));
			pacote.setValoresExtra(rset.getString("ValoresExtra));
			pacote.setId(rset.getString("Id_pacote"));
			
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
		return pacote;
	}
}