import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.my.sql.MyConnection;

class PrepareStatmentTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		conn = MyConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String cName = "커피";
		
		String selectSQL = "SELECT prod_no, prod_name, prod_price, p.category_no pc_no, category_name FROM product p JOIN category c ON p.category_no=c.category_no WHERE category_name=?";
		pstmt = conn.prepareStatement(selectSQL);
		/**
		 * 바인드 변수 값 설정.
		 */
		pstmt.setString(1, cName);
		conn.prepareStatement(selectSQL);
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			String prod_no = rs.getString("prod_no");
			String prod_name = rs.getString("prod_name");
			int prod_price = rs.getInt("prod_price");
			//카테고리는 별칭명에서 p.을 붙이면 안됨.
			String category_no = rs.getString("pc_no");
			String category_name = rs.getString("category_name");
			System.out.println("prod_no : "+ prod_no + "prod_name : " +prod_name +"prod_price : "+ prod_price + "category_no : "+ category_no+"category_name : "+ category_name );

		}
		/*String selectSQL = "SELECT * FROM product";
		stmt = conn.createStatement();
		stmt.executeQuery(selectSQL);
		rs = stmt.executeQuery(selectSQL);
		while (rs.next()) {

		}*/

		String updateSQL = "UPDATE product SET prod_price = prod_price*1.1 WHERE prod_no=?";
//		/**
//		 * DML 문장을 수행할 경우 문장 수행 된 결과 수만큼 반환
//		 * DDL 문장을 수행할 경우0을 반환
//		 */
		pstmt = conn.prepareStatement(updateSQL);
		pstmt.setString(1, "F001");
		int rowcnt = pstmt.executeUpdate();
//		System.out.println(rowcnt);

			MyConnection.closeConnection(conn, pstmt, rs);
	}

}
