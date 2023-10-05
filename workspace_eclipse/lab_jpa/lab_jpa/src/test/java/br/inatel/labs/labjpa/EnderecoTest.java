package br.inatel.labs.labjpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.inatel.labs.labjpa.entity.Endereco;
import br.inatel.labs.labjpa.services.EnderecoService;

@SpringBootTest
public class EnderecoTest {

	@Autowired
	private EnderecoService service;
	
	@Test
	public void testarUUIDGeradoPeloJPAListener() {
		
		Endereco e = new Endereco();
		e.setRua("Av. Nogueira");
		e.setNumero("511");
		e.setCidade("Santa Rita");
		e.setUf("MG");
		
	
		e = service.salvar(e);
		
		System.out.println(e);
		
	}
}
