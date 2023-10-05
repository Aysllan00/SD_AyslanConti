package br.inatel.labs.labjpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.labs.labjpa.entity.Fornecedor;

import br.inatel.labs.labjpa.repository.FornecedorRepository;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;

@Service
@Transactional
public class FornecedorService {

	//@PersistenceContext
	//private EntityManager em;
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	public Fornecedor salvar(Fornecedor f) {
		//f = em.merge(f);
		//return f;		
		
		return fornecedorRepository.save(f);
	}
	
	public Optional<Fornecedor> buscarPeloId(Long id) {
		
		//Fornecedor fornecedorEncontrado = em.find(Fornecedor.class, id);
		//return fornecedorEncontrado;
		return fornecedorRepository.findById(id);
	}
	
	public List<Fornecedor> listar(){
		
		//String jpql = "select f from Fornecedor f";
		//List<Fornecedor> fornecedores = em.createQuery(jpql, Fornecedor.class).getResultList();
		//return fornecedores;
		
		return fornecedorRepository.findAll();
	}
	
	public void remover(Fornecedor f) {
		//em.remove(em);
		fornecedorRepository.delete(f);
	}
}
