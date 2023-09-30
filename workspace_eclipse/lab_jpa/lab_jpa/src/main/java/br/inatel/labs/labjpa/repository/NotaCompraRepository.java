package br.inatel.labs.labjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.Produto;

@Repository
public interface NotaCompraRepository extends JpaRepository<NotaCompra, Long>{

}