package br.inatel.labs.labjpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;
import br.inatel.labs.labjpa.repository.FornecedorRepository;
import br.inatel.labs.labjpa.repository.NotaCompraItemRepository;
import br.inatel.labs.labjpa.repository.NotaCompraRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
@Transactional
public class NotaCompraService {

	
	//@PersistenceContext
	//private EntityManager em;
	
	@Autowired
	private NotaCompraRepository notaCompraRepository;
	
	@Autowired
	private NotaCompraItemRepository notaCompraItemRepository;
	
	public NotaCompra salvar(NotaCompra nc) {
		
		//return em.merge(nc);
		
		return notaCompraRepository.save(nc);
	}
	
	public Optional<NotaCompra> buscaCompraPeloId(Long id) {
		
		//return em.find(NotaCompra.class, id);
		return notaCompraRepository.findById(id);
	}
	
	public NotaCompra buscaCompraPeloIdComListItem(Long id) {
		
		//NotaCompra nota = em.find(NotaCompra.class, id);
		//nota.getListaNotaCompraItem().size(); //Provoca o proxy
		//return nota;
		Optional<NotaCompra> opNotaCompra = notaCompraRepository.findById(id);
		if(opNotaCompra.isPresent()) {
			NotaCompra notaCompra = opNotaCompra.get();
			notaCompra.getListaNotaCompraItem().size();
			return notaCompra;
		}
		else {
			
			throw new RuntimeException("Nenhuma nota encontrada!");
		}
		
	}
	
	public List<NotaCompra> listar(){
		
		//return em.createQuery("select nc from NotaCompra nc", NotaCompra.class).getResultList();
		return notaCompraRepository.findAll();
	}
	
	
	
	
	//Nota Compra Item
	public NotaCompraItem salvar(NotaCompraItem item) {
		
		//return em.merge(item);
		return notaCompraItemRepository.save(item);
	}
	
	public Optional<NotaCompraItem> buscaCompraItemPeloId(Long id) {
		
		//return em.find(NotaCompraItem.class, id);
		return notaCompraItemRepository.findById(id);
	}
	
	public List<NotaCompraItem> listarNotaCompraItem(){
		
		//return em.createQuery("select nc from NotaCompraItem nc", NotaCompraItem.class).getResultList();
		return notaCompraItemRepository.findAll();
	}
	
	
}
