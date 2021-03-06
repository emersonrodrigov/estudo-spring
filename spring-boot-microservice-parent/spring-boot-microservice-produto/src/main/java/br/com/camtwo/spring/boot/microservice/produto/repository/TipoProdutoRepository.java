package br.com.camtwo.spring.boot.microservice.produto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.camtwo.spring.boot.microservice.produto.model.TipoProduto;



public interface TipoProdutoRepository 
			extends JpaRepository<TipoProduto, Long> {

	List<TipoProduto> findByNomeLike(String nome);
	
	@Query("select tp from TipoProduto tp where tp.valorMinimo < ?1")
	List<TipoProduto> buscarValorMinimoMenorQue(Double valorMinimo);

	@Query("select new br.com.camtwo.spring.boot.microservice.produto.repository.LabelValue(tp.nome, tp.codigo) "
			+ "from TipoProduto tp where tp.nome like ?1")
	List<LabelValue> findAutoComplete(String termo);
}
