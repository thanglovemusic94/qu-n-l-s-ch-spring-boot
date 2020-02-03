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


import com.springboot.service.CategoryServiceImpl;
import com.springboot.vo.CategoryVo;

public class JUnitCategory{
	
	Connection con;
	
	private CategoryVo vo;
	
	
	private CategoryServiceImpl categoryService;
	
	@BeforeMethod
	public void setUp() throws Exception {
		vo = new CategoryVo();
		categoryService = new CategoryServiceImpl();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		categoryService.deleteCategory(vo.getId());

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
	
	// Bỏ trống Mã danh mục, tên danh mục
	@Test
	public void TC001() {
		boolean result;
		vo.setId(null);
		vo.setName(null);
		result = categoryService.createCategory(vo);
		 assertEquals(result, false); 
	}
	
	//Chỉ thực hiện input textbox [Mã danh mục]
	@Test
	public void TC002() {
		boolean result;
		vo.setId("KNSVK");
		vo.setName(null);
		result = categoryService.createCategory(vo);
		 assertEquals(result, false); 
	}
	
	//Chỉ thực hiện input textbox [Tên danh mục]
	@Test
	public void TC003() {
		boolean result;
		vo.setId(null);
		vo.setName("Kỹ năng sống vui khỏe");
		result = categoryService.createCategory(vo);
		 assertEquals(result, false); 
	}
	
	//Thực hiện input đầy đủ textbox [Mã danh mục] và textbox [Tên danh mục]
	@Test (groups="Luong")
	public void TC004() {
		boolean result;
		vo.setId("KNSVK");
		vo.setName("Kỹ năng sống vui khỏe");
		result = categoryService.createCategory(vo);
		assertEquals(result, true);
	}
	
	//Thực hiện input textbox [Mã danh mục] có độ dài 0 kí tự, textbox [Tên danh mục] thực hiện input đúng
	@Test
	public void TC005() {
		boolean result;
		vo.setId("");
		vo.setName("Kỹ năng sống vui khỏe");
		result = categoryService.createCategory(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input textbox [Mã danh mục] có độ dài 1 kí tự, textbox [Tên danh mục] thực hiện input đúng
	@Test
	public void TC006() {
		boolean result;
		vo.setId("T");
		vo.setName("Tình cảm");
		result = categoryService.createCategory(vo);
		assertEquals(result, true);
	}
	
	//Thực hiện input textbox [Mã danh mục] có độ dài 2 kí tự, textbox [Tên danh mục] thực hiện input đúng
	@Test
	public void TC007() {
		boolean result;
		vo.setId("TC");
		vo.setName("Tình cảm");
		result = categoryService.createCategory(vo);
		assertEquals(result, true);
	}
	
	//Thực hiện input textbox [Mã danh mục] có độ dài 4 kí tự, textbox [Tên danh mục] thực hiện input đúng
	@Test
	public void TC008() {
		boolean result;
		vo.setId("TCDS");
		vo.setName("Tình cảm đời sống");
		result = categoryService.createCategory(vo);
		assertEquals(result, true);
	}
	
	//Thực hiện input textbox [Mã danh mục] có độ dài 5 kí tự, textbox [Tên danh mục] thực hiện input đúng
	@Test
	public void TC009() {
		boolean result;
		vo.setId("KNSVK");
		vo.setName("Kỹ năng sống vui khỏe");
		result = categoryService.createCategory(vo);
		assertEquals(result, true);
	}
	
	//Thực hiện input textbox [Mã danh mục] có độ dài 6 kí tự, textbox [Tên danh mục] thực hiện input đúng
	@Test
	public void TC010() {
		boolean result;
		vo.setId("ABCDEG");
		vo.setName("Kỹ năng sống vui khỏe");
		result = categoryService.createCategory(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input textbox [Mã danh mục] chỉ chứa ký tự khoảng trắng, textbox [Tên danh mục] thực hiện input đúng
	@Test
	public void TC011() {
		boolean result;
		vo.setId("    ");
		vo.setName("Kỹ năng sống vui khỏe");
		result = categoryService.createCategory(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input textbox [Mã danh mục] có chứa ký tự đặc biệt, textbox [Tên danh mục] thực hiện input đúng
	@Test
	public void TC012() {
		boolean result;
		vo.setId("!@#$%");
		vo.setName("Kỹ năng sống vui khỏe");
		result = categoryService.createCategory(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input textbox [Tên danh mục] có độ dài 0 kí tự, textbox [Mã danh mục thực hiện input đúng
	@Test
	public void TC013() {
		boolean result;
		vo.setId("ABCD");
		vo.setName("");
		result = categoryService.createCategory(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input textbox [Tên danh mục] có độ dài 1 kí tự, textbox [Mã danh mục thực hiện input đúng
	@Test
	public void TC014() {
		boolean result;
		vo.setId("ABCD");
		vo.setName("A");
		result = categoryService.createCategory(vo);
		assertEquals(result, true);
	}
	
	//Thực hiện input textbox [Tên danh mục] có độ dài 2 kí tự, textbox [Mã danh mục thực hiện input đúng
	@Test
	public void TC015() {
		boolean result;
		vo.setId("ABCD");
		vo.setName("An");
		result = categoryService.createCategory(vo);
		assertEquals(result, true);
	}
	
	//Thực hiện input textbox [Tên danh mục] có độ dài 29 kí tự, textbox [Mã danh mục thực hiện input đúng
	@Test
	public void TC016() {
		boolean result;
		vo.setId("ABCD");
		vo.setName("ABCABCABCABCABCABCABCABCABCAB");
		result = categoryService.createCategory(vo);
		assertEquals(result, true);
	}
	
	//Thực hiện input textbox [Tên danh mục] có độ dài 30 kí tự, textbox [Mã danh mục thực hiện input đúng
	@Test
	public void TC017() {
		boolean result;
		vo.setId("ABCD");
		vo.setName("ABCABCABCABCABCABCABCABCABCABC");
		result = categoryService.createCategory(vo);
		assertEquals(result, true);
	}
	
	//Thực hiện input textbox [Tên danh mục] có độ dài 31 kí tự, textbox [Mã danh mục thực hiện input đúng
	@Test
	public void TC018() {
		boolean result;
		vo.setId("ABCD");
		vo.setName("ABCABCABCABCABCABCABCABCABCABCA");
		result = categoryService.createCategory(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input textbox [Tên danh mục] chỉ chứa ký tự khoảng trắng, textbox [Mã danh mục thực hiện input đúng
	@Test
	public void TC019() {
		boolean result;
		vo.setId("ABCD");
		vo.setName("     ");
		result = categoryService.createCategory(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input textbox [Tên danh mục] có chứa ký tự đặc biệt, textbox [Mã danh mục thực hiện input đúng
	@Test
	public void TC020() {
		boolean result;
		vo.setId("ABCD");
		vo.setName("!@#$%^&*()");
		result = categoryService.createCategory(vo);
		assertEquals(result, false);
	}
	
	//Thực hiện input [Mã danh mục] đã tồn tại trong DB
	@Test
	public void TC021() {
		boolean result;
		vo.setId("VH");
		vo.setName("Văn hóa");
		result = categoryService.createCategory(vo);
		assertEquals(result, false);
	}
	
}
