package TestJUnit;

import static org.testng.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.Test;

import com.springboot.MainApplication;
import com.springboot.entities.Category;
import com.springboot.repository.CategoryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class testthu {
	@Autowired
	private CategoryRepository repository;
	
	
}
