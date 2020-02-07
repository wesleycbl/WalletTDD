package br.com.wallet;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/* seta o profiles de test criado em: application-test.properties */
@ActiveProfiles("test")
@SpringBootTest
class WalletApplicationTests {

	@Test
	void contextLoads() {
	}

}
