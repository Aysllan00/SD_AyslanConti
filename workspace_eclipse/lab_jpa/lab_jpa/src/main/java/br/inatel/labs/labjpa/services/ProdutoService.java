package br.inatel.labs.labjpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.labs.labjpa.entity.Produto;
import br.inatel.labs.labjpa.repository.ProdutoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
@Transactional
public class ProdutoService {

	//@PersistenceContext
	//private EntityManager em;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto salvar(Produto p) {
		
		return produtoRepository.save(p);
		
		//p = em.merge(p);
		//return p;
	}
	
	public Optional<Produto> buscarPeloId(Long id) {
		
		return produtoRepository.findById(id);
		
		//Produto produtoEncontrado = em.find(Produto.class, id); //Ve a estrutura do produto e faz um select atraves do id
		//return produtoEncontrado;
	}
	
	public List<Produto> listar(){
		
		return produtoRepository.findAll();
				
		//List<Produto> produtos = em.createQuery("select p from Produto p", Produto.class).getResultList();
		//return produtos;
	}
	
	public void remove(Produto p) {
		
		produtoRepository.delete(p);
		//p = em.merge(p); //provoca a transição para o estado Managed
		//em.remove(p); //depois do managed posso remover
	}
}
