package br.inatel.labs.labjpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.inatel.labs.labjpa.dto.TotalCompradoPorFornecedorDTO;
import br.inatel.labs.labjpa.repository.RelatorioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class RelatorioService{
	
	//@PersistenceContext
	//private EntityManager em;
	
	@Autowired
	private RelatorioRepository repository;
	
	public List<TotalCompradoPorFornecedorDTO> pesquisarTotalCompradoPorFornecedor() {
		/*
		 * String query =
		 * " select new br.inatel.labs.labjpa.dto.TotalCompradoPorFornecedorDTO " +
		 * "    ( f.razaoSocial " + "    , sum( i.quantidade * i.valorCompraProduto ) "
		 * + "    ) " + " from NotaCompraItem   i " + "    join i.notaCompra n " +
		 * "    join n.fornecedor f " + " group by f.razaoSocial " ;
		 * 
		 * return em.createQuery(query, TotalCompradoPorFornecedorDTO.class)
		 * .getResultList();
		 */
		return repository.pesquisarTotalCompradoPorFornecedor();
	}

	
	
}

