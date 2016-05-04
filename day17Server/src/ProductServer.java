import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.my.dao.ProductDAOInterface;
import com.my.dao.ProductDAOOracle;
import com.my.dto.Category;
import com.my.dto.Product;
import com.my.exception.AddException;

/**
 * 서버 용도로 사용
 * 
 * @author Administrator
 *
 */
public class ProductServer {
	public static final int PORT = 5431;
	ServerSocket ss;
	Socket s;
	DataInputStream dis;
	ProductDAOInterface productDAO;

	public ProductServer() {
		try {
			productDAO = new ProductDAOOracle();

			// client의 접속을 기다린다.
			ss = new ServerSocket(PORT);
			s = ss.accept();
			String client = s.getInetAddress().getHostName();
			System.out.println(client + "가 접속 했습니다.");
			
			dis = new DataInputStream(s.getInputStream());
			
			// 작업 구분
			int gubun = dis.readInt();

			switch (gubun) {
			case 1: // 상품등록
				String prod_no = dis.readUTF();
				String prod_name = dis.readUTF();
				int prod_price = dis.readInt();
				String prod_mf_dt = dis.readUTF();
				String category_no = dis.readUTF();
				Category c = new Category();
				c.setCategory_name(category_no);

				try {
					productDAO.add(new Product(prod_no, prod_name, prod_price, prod_mf_dt, c));
				} catch (AddException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2: // 상품전체 검색

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:

				break;

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ProductServer();
	}

}
