package br.unicamp.ic.inf335.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.unicamp.ic.inf335.beans.*;

public class ProdutoBeanTest {
	
	public ProdutoBean produto = new ProdutoBean("CD00001","Celular Galaxy S10","128 Gb, Preto, com Carregador",1250.0,"Poucos riscos, estado de novo.");
	
	@Test
	public void getCodigo() {
		assertEquals("CD00001", produto.getCodigo());
	}
	
	@Test
	public void setCodigo() {
		produto.setCodigo("abcde");
		assertEquals("abcde", produto.getCodigo());
	}
	
	@Test
	public void getNome() {
		assertEquals("Celular Galaxy S10", produto.getNome());
	}
	
	@Test
	public void setNome() {
		produto.setNome("novoProduto");
		assertEquals("novoProduto", produto.getNome());
	}
	
	@Test
	public void getDescricao() {
		assertEquals("128 Gb, Preto, com Carregador", produto.getDescricao());
	}
	
	@Test
	public void setDescricao() {
		produto.setDescricao("130 Gb, Branco, com Carregador");
		assertEquals("130 Gb, Branco, com Carregador", produto.getDescricao());
	}

	@Test
	public void getEstado() {
		assertEquals("Poucos riscos, estado de novo.", produto.getEstado());
	}
	
	@Test
	public void setEstado() {
		produto.setEstado("Produto muito velho, n�o comprem");
		assertEquals("Produto muito velho, n�o comprem", produto.getEstado());
	}
	
	@Test
	public void getSerialversionuid() {
		assertEquals(1, produto.getSerialversionuid());
	}
}
