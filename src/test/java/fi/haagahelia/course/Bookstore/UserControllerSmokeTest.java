package fi.haagahelia.course.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.course.Bookstore.web.UserController;



@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerSmokeTest {
	
	  @Autowired
	  private UserController controller;

	  @Test
	  public void contexLoads() throws Exception {
	    assertThat(controller).isNotNull();
	  }
	}
