package uz.pdp.SpringDataJpaTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringDataJpaTestApplicationTests {

	private final UserService userService;

	public SpringDataJpaTestApplicationTests(UserService userService) {
		this.userService = userService;
	}

	@Test
	void contextLoads() {
//		userService.m1();
	}

}
