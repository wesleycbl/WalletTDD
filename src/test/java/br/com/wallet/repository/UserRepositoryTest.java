package br.com.wallet.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.wallet.entity.User;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class UserRepositoryTest {
	
	private static final String EMAIL = "email@teste.com";
	
	@Autowired
	UserRepository repository;
	
	@Before
	public void setUp() {
		//cria um usuario default
		User u = new User();
		u.setName("Set up User");
		u.setPassoword("root123");
		u.setEmail(EMAIL);
		
		repository.save(u);
	}
	
	@After
	public void tearDown() {
		//apaga todos os dados após finalizar teste
		repository.deleteAll();
	}
	
	
	@Test
	public void testSave() {
		User u = new User();
		u.setName("Teste");
		u.setPassoword("123456");
		u.setEmail("teste@teste.com");
		
		User response = repository.save(u);
		
		assertNotNull(response);
		
	}
	
	@Test
	public void testFindByEmail() {
		Optional<User> response = repository.findByEmailEquals(EMAIL);
		assertTrue(response.isPresent()); //verificar se existe algum usuario para efetuar a busca.
		assertEquals(response.get().getEmail(), EMAIL); //verifica se encontrou o email informado.
	}
	
}
