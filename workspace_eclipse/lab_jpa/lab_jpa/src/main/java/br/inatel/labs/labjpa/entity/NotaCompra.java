package br.inatel.labs.labjpa.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Entity
public class NotaCompra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//Lado dominado aponta pra o lado dominante (mappedBy é pra quando é bidirecional)
	@OneToMany(mappedBy = "notaCompra")
	private List<NotaCompraItem> listaNotaCompraItem;

	@ManyToOne
	private Fornecedor fornecedor;

	@NotNull
	@Past
	private LocalDate dataEmissao;

	public NotaCompra() {
		// TODO Auto-generated constructor stub
	}
	
	public NotaCompra(@NotNull @Past LocalDate dataEmissao,Fornecedor fornecedor) {
		super();
		this.fornecedor = fornecedor;
		this.dataEmissao = dataEmissao;
	}

	//Calcula o total da nota somando os totais de cada item
	public BigDecimal getCalculoTotalNota() {
		//stream cria uma copia interna do list - pode fazer operações encadeadas
		BigDecimal total = this.listaNotaCompraItem.stream()
	      .map( i -> i.getCalculoTotalItem() )
	      .reduce( BigDecimal.ZERO, BigDecimal::add );

		//Map - faz um outro steam dos valores dos itens
		//collect e reduce - tras de volta para o list e aplicar alguma operação a um valor
		
		//Ex: map faz o calculo (soma) todos os valores (uma stream cheio de valores) e o reduce doma de 2 a 2 e retorna um valor total
	   return total;

	}
	
	//Para gerar getters e setters é ctrl+3 -> ggas
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<NotaCompraItem> getListaNotaCompraItem() {
		return listaNotaCompraItem;
	}


	public void setListaNotaCompraItem(List<NotaCompraItem> listaNotaCompraItem) {
		this.listaNotaCompraItem = listaNotaCompraItem;
	}


	public Fornecedor getFornecedor() {
		return fornecedor;
	}


	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}


	public LocalDate getDataEmissao() {
		return dataEmissao;
	}


	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotaCompra other = (NotaCompra) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "NotaCompra [id=" + id + ", dataEmissao=" + dataEmissao + "]";
	}

	
	
}
