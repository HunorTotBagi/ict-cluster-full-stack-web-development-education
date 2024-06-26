package com.iktpreobuka.testing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iktpreobuka.testing.controllers.HomeController;

@SpringBootTest
public class AssertExampleTest {

	@Autowired
	protected HomeController homeController;
	
	@Test
	public void contextLoads() {
		assertThat(homeController).isNotNull();
	}
}
