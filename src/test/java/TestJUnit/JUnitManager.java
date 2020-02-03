package TestJUnit;

import static org.testng.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.springboot.service.ManagerServiceImpl;
import com.springboot.vo.ManagerVo;

public class JUnitManager {
	
	Connection con;
	
	private ManagerVo vo;
	
	private ManagerServiceImpl managerService;
	
	@BeforeMethod
	public void setUp() throws Exception {
		vo = new ManagerVo();
		managerService = new ManagerServiceImpl();
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		managerService.deleteManager(vo.getId());
	}
	
	@BeforeClass
	public void openConnect() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=bookmanagement";
        con = DriverManager.getConnection(url, "sa", "12345");
    }

	@AfterClass
    public void closeConnect() throws SQLException {
        con.close();
        if (con.isClosed()) {
            System.out.println(con.toString() + " is closed");
        }

    }
	
	//Không thực hiện input vào textbox [Mã tài khoản], [Mật khẩu], [Tên quản lý], [Năm sinh], [Email], [Số điện thoại], [Địa chỉ]
	@Test
	public void TC001() {
		boolean result;
		vo.setId(null);
		vo.setPass(null);
		vo.setTen(null);
		vo.setNamsinh(null);
		vo.setEmail(null);
		vo.setSdt(null);
		vo.setDiachi(null);
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	//Chỉ thực hiện input textbox [Mã tài khoản], các textbox khác bỏ trống
	@Test
	public void TC002() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass(null);
		vo.setTen(null);
		vo.setNamsinh(null);
		vo.setEmail(null);
		vo.setSdt(null);
		vo.setDiachi(null);
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	//Chỉ thực hiện input textbox [Mật khẩu], các textbox khác bỏ trống
	@Test
	public void TC003() {
		boolean result;
		vo.setId(null);
		vo.setPass("12345");
		vo.setTen(null);
		vo.setNamsinh(null);
		vo.setEmail(null);
		vo.setSdt(null);
		vo.setDiachi(null);
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	//Chỉ thực hiện input textbox [Tên quản lý], các textbox khác bỏ trống
	@Test
	public void TC004() {
		boolean result;
		vo.setId(null);
		vo.setPass(null);
		vo.setTen("Phong Lan");
		vo.setNamsinh(null);
		vo.setEmail(null);
		vo.setSdt(null);
		vo.setDiachi(null);
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	//Chỉ thực hiện input textbox [Năm sinh], các textbox khác bỏ trống
	@Test
	public void TC005() {
		boolean result;
		vo.setId(null);
		vo.setPass(null);
		vo.setTen(null);
		vo.setNamsinh("1990");
		vo.setEmail(null);
		vo.setSdt(null);
		vo.setDiachi(null);
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	//Chỉ thực hiện input textbox [Email], các textbox khác bỏ trống
	@Test
	public void TC006() {
		boolean result;
		vo.setId(null);
		vo.setPass(null);
		vo.setTen(null);
		vo.setNamsinh(null);
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt(null);
		vo.setDiachi(null);
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	//Chỉ thực hiện input textbox [Số điện thoại], các textbox khác bỏ trống
	@Test
	public void TC007() {
		boolean result;
		vo.setId(null);
		vo.setPass(null);
		vo.setTen(null);
		vo.setNamsinh(null);
		vo.setEmail(null);
		vo.setSdt("0323566771");
		vo.setDiachi(null);
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	//Chỉ thực hiện input textbox [Địa chỉ], các textbox khác bỏ trống
	@Test
	public void TC008() {
		boolean result;
		vo.setId(null);
		vo.setPass(null);
		vo.setTen(null);
		vo.setNamsinh(null);
		vo.setEmail(null);
		vo.setSdt(null);
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input đầy đủ các textbox
	@Test
	public void TC009() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("88888");
		vo.setTen("Phong Lan");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, true);
	}
	
	//Thực hiện input textbox [Mã tài khoản] có độ dài 0 kí tự, các textbox khác thực hiện input đúng
	@Test
	public void TC010() {
		boolean result;
		vo.setId("");
		vo.setPass("88888");
		vo.setTen("Phong Lan");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input textbox [Mã tài khoản] có độ dài 1 kí tự, các textbox khác thực hiện input đúng
	@Test
	public void TC011() {
		boolean result;
		vo.setId("M");
		vo.setPass("88888");
		vo.setTen("Phong Lan");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, true);
	}
	
	//Thực hiện input textbox [Mã tài khoản] có độ dài 2 kí tự, các textbox khác thực hiện input đúng
	@Test
	public void TC012() {
		boolean result;
		vo.setId("MA");
		vo.setPass("88888");
		vo.setTen("Phong Lan");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, true);
	}
	
	//Thực hiện input textbox [Mã tài khoản] có độ dài 4 kí tự, các textbox khác thực hiện input đúng
	@Test
	public void TC013() {
		boolean result;
		vo.setId("MAN0");
		vo.setPass("88888");
		vo.setTen("Phong Lan");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, true);
	}
	
	//Thực hiện input textbox [Mã tài khoản] có độ dài 5 kí tự, các textbox khác thực hiện input đúng
	@Test
	public void TC014() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("88888");
		vo.setTen("Phong Lan");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, true);
	}
	
	//Thực hiện input textbox [Mã tài khoản] có độ dài 6 kí tự, các textbox khác thực hiện input đúng
	@Test
	public void TC015() {
		boolean result;
		vo.setId("MAN045");
		vo.setPass("88888");
		vo.setTen("Phong Lan");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input textbox [Mã tài khoản] chỉ có kí tự khoảng trắng, các textbox khác thực hiện input đúng
	@Test
	public void TC016() {
		boolean result;
		vo.setId("    ");
		vo.setPass("88888");
		vo.setTen("Phong Lan");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input textbox [Mã tài khoản] có chứa kí tự đặc biệt, các textbox khác thực hiện input đúng
	@Test
	public void TC017() {
		boolean result;
		vo.setId("!@#$");
		vo.setPass("88888");
		vo.setTen("Phong Lan");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input textbox [Mật khẩu] có độ dài 0 kí tự, các textbox khác thực hiện input đúng
	@Test
	public void TC018() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("");
		vo.setTen("Phong Lan");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input textbox [Mật khẩu] có độ dài 1 kí tự, các textbox khác thực hiện input đúng
	@Test
	public void TC019() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("1");
		vo.setTen("Phong Lan");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, true);
	}
	
	//Thực hiện input textbox [Mật khẩu] có độ dài 2 kí tự, các textbox khác thực hiện input đúng
	@Test
	public void TC020() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("12");
		vo.setTen("Phong Lan");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, true);
	}
	
	//Thực hiện input textbox [Mật khẩu] có độ dài 9 kí tự, các textbox khác thực hiện input đúng
	@Test
	public void TC021() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("123456789");
		vo.setTen("Phong Lan");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, true);
	}
	
	//Thực hiện input textbox [Mật khẩu] có độ dài 10 kí tự, các textbox khác thực hiện input đúng
	@Test
	public void TC022() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("1234567890");
		vo.setTen("Phong Lan");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, true);
	}
	
	//Thực hiện input textbox [Mật khẩu] có độ dài 11 kí tự, các textbox khác thực hiện input đúng
	@Test
	public void TC023() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("12345678901");
		vo.setTen("Phong Lan");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input textbox [Mật khẩu] chỉ chứa kí tự khoảng trắng, các textbox khác thực hiện input đúng
	@Test
	public void TC024() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("     ");
		vo.setTen("Phong Lan");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input textbox [Mật khẩu] có chứa kí tự đặc biệt, các textbox khác thực hiện input đúng
	@Test
	public void TC025() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("!@#$%^&*");
		vo.setTen("Phong Lan");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input textbox [Tên quản lý] có độ dài 0 kí tự, các textbox khác thực hiện input đúng
	@Test
	public void TC026() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("12345");
		vo.setTen("");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input textbox [Tên quản lý] có độ dài 1 kí tự, các textbox khác thực hiện input đúng
	@Test
	public void TC027() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("12345");
		vo.setTen("P");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, true);
	}
	
	//Thực hiện input textbox [Tên quản lý] có độ dài 2 kí tự, các textbox khác thực hiện input đúng
	@Test
	public void TC028() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("12345");
		vo.setTen("PH");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, true);
	}
	
	//Thực hiện input textbox [Tên quản lý] có độ dài 19 kí tự, các textbox khác thực hiện input đúng
	@Test
	public void TC029() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("12345");
		vo.setTen("QWERTYUIOPASDFGHJKL");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, true);
	}
	
	//Thực hiện input textbox [Tên quản lý] có độ dài 20 kí tự, các textbox khác thực hiện input đúng
	@Test
	public void TC030() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("12345");
		vo.setTen("QWERTYUIOPASDFGHJKLZ");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, true);
	}
	
	//Thực hiện input textbox [Tên quản lý] có độ dài 21 kí tự, các textbox khác thực hiện input đúng
	@Test
	public void TC031() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("12345");
		vo.setTen("QWERTYUIOPASDFGHJKLZX");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input textbox [Tên quản lý] chỉ chứa kí tự khoảng trắng, các textbox khác thực hiện input đúng
	@Test
	public void TC032() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("12345");
		vo.setTen("     ");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input textbox [Tên quản lý] có chứa kí tự đặc biệt, các textbox khác thực hiện input đúng
	@Test
	public void TC033() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("12345");
		vo.setTen("!@#$%^&*()");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input textbox [Năm sinh] có chứa kí tự chữ, các textbox khác thực hiện input đúng
	@Test
	public void TC034() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("12345");
		vo.setTen("Phong Lan");
		vo.setNamsinh("abcdeg");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input textbox [Năm sinh] có chứa kí tự đặc biệt, các textbox khác thực hiện input đúng
	@Test
	public void TC035() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("12345");
		vo.setTen("Phong Lan");
		vo.setNamsinh("!@#$%");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input textbox [Năm sinh] chỉ chứa khoảng trắng, các textbox khác thực hiện input đúng
	@Test
	public void TC036() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("12345");
		vo.setTen("Phong Lan");
		vo.setNamsinh("     ");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input textbox [Năm sinh] không đúng định dạng năm sinh, các textbox khác thực hiện input đúng
	@Test
	public void TC037() {
		boolean result = false;
		vo.setId("MAN04");
		vo.setPass("12345");
		vo.setTen("Phong Lan");
		vo.setNamsinh("2n1d");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input textbox [Địa chỉ] có độ dài 0 kí tự, các textbox khác thực hiện input đúng
	@Test
	public void TC038() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("12345");
		vo.setTen("Phong Lan");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("");
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input textbox [Địa chỉ] có độ dài 1 kí tự, các textbox khác thực hiện input đúng
	@Test
	public void TC039() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("12345");
		vo.setTen("Phong Lan");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("H");
		result = managerService.createManager(vo);
		assertEquals(result, true);
	}
	
	//Thực hiện input textbox [Địa chỉ] có độ dài 2 kí tự, các textbox khác thực hiện input đúng
	@Test
	public void TC040() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("12345");
		vo.setTen("Phong Lan");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà");
		result = managerService.createManager(vo);
		assertEquals(result, true);
	}
	
	//Thực hiện input textbox [Địa chỉ] có độ dài 29 kí tự, các textbox khác thực hiện input đúng
	@Test
	public void TC041() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("12345");
		vo.setTen("Phong Lan");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("qwertyuiopasdfghjklzxcvbnmqwe");
		result = managerService.createManager(vo);
		assertEquals(result, true);
	}
	
	//Thực hiện input textbox [Địa chỉ] có độ dài 30 kí tự, các textbox khác thực hiện input đúng
	@Test
	public void TC042() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("12345");
		vo.setTen("Phong Lan");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("qwertyuiopasdfghjklzxcvbnmqwer");
		result = managerService.createManager(vo);
		assertEquals(result, true);
	}
	
	//Thực hiện input textbox [Địa chỉ] có độ dài 31 kí tự, các textbox khác thực hiện input đúng
	@Test
	public void TC043() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("12345");
		vo.setTen("Phong Lan");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("qwertyuiopasdfghjklzxcvbnmqwert");
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input textbox [Địa chỉ] chỉ chứa kí tự khoảng trắng, các textbox khác thực hiện input đúng
	@Test
	public void TC044() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("12345");
		vo.setTen("Phong Lan");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("    ");
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input textbox [Địa chỉ] có chứa kí tự đặc biệt, các textbox khác thực hiện input đúng
	@Test
	public void TC045() {
		boolean result;
		vo.setId("MAN04");
		vo.setPass("12345");
		vo.setTen("Phong Lan");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("!@#$%^&*()");
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input [Mã tài khoản] đã tồn tại trong DB
	@Test
	public void TC046() {
		boolean result;
		vo.setId("MAN01");
		vo.setPass("12345");
		vo.setTen("Phong Lan");
		vo.setNamsinh("1990");
		vo.setEmail("phonglan@gmail.com");
		vo.setSdt("0323566771");
		vo.setDiachi("Hà Nội");
		result = managerService.createManager(vo);
		assertEquals(result, false);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
