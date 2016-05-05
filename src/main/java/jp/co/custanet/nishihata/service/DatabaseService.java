package jp.co.custanet.nishihata.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jp.co.custanet.nishihata.dto.TestDto;

public class DatabaseService {

	Connection con = null;

	public DatabaseService() throws NamingException, SQLException {
		InitialContext initCon = new InitialContext();
		DataSource ds = (DataSource) initCon.lookup("java:comp/env/jdbc/jweb");

		con = ds.getConnection();
	}

	public List<TestDto> getTest() {
		String sql = "SELECT id, kind, text FROM test WHERE id = ? ";
		PreparedStatement ps;

		List<TestDto> testlist = new ArrayList<TestDto>();

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, 1);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TestDto test = new TestDto();
				test.id = rs.getInt("id");
				test.kind = rs.getString("kind");
				test.text = rs.getString("text");

				testlist.add(test);

				System.out.println(rs.getInt("id") + ":" + rs.getString("kind")
						+ ":" + rs.getString("text"));

			}

			ps.close();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return testlist;
	}

}
