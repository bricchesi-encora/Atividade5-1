package br.unicamp.ic.inf335.test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.junit.Test;

import br.unicamp.ic.inf335.beans.AnuncianteBean;
import br.unicamp.ic.inf335.beans.AnuncioBean;
import br.unicamp.ic.inf335.beans.ProdutoBean;

public class AnuncianteBeanTest {
	
	ArrayList<AnuncioBean> anuncios;
	AnuncianteBean anunciante;
	
	ArrayList<ProdutoBean> criarProdutos() {
		ProdutoBean produto1 = new ProdutoBean("CD00001","Celular Galaxy S10", "128 Gb, Preto, com Carregador",1200.0,"Poucos riscos, estado de novo.");
		ProdutoBean produto2 = new ProdutoBean("CD00002","Prod 2 ...", "Bla Bla Bla",1100.0,"Bla Bla Bla");
		ProdutoBean produto3 = new ProdutoBean("CD00003","Prod 3 ...", "Bla Bla Bla",120.0,"Bla Bla Bla");
		
		ArrayList<ProdutoBean> produtos = new ArrayList<ProdutoBean>();
		produtos.add(produto1);
		produtos.add(produto2);
		produtos.add(produto3);
		
		return produtos;
	}
	
	
	ArrayList<URL> fotosUrl = new ArrayList<URL>();

	ArrayList<URL> criarFotoUrl() throws MalformedURLException {
		URL url1 = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSkA-OsNFo7XIKkGECvIm-NoIsYJHNyQUfnng&usqp=CAU");
		URL url2 = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQOfojuknGlolErYhhu2RVimBHUPPIC1vSrQ&usqp=CAU");
		URL url3 = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDlwgjsjux2dZbcv24QTJYjUEp8VLVR85iTw&usqp=CAU");
		
		fotosUrl.add(url1);
		fotosUrl.add(url2);
		fotosUrl.add(url3);
		
		return fotosUrl;
	}
	
	
	ArrayList<AnuncioBean> criarAnuncios() throws MalformedURLException{
		anuncios = new ArrayList<AnuncioBean>();
		
		ArrayList<ProdutoBean> produtos = criarProdutos();
		ArrayList<URL> fotosUrl = criarFotoUrl();
		
		anuncios.add(new AnuncioBean(produtos.get(0), fotosUrl, 0.0));
		anuncios.add(new AnuncioBean(produtos.get(1), fotosUrl, 0.1));
		anuncios.add(new AnuncioBean(produtos.get(2), fotosUrl, 0.2));
		
		return anuncios;
	}
	

	public void criarAnunciante() throws MalformedURLException {
		anuncios = criarAnuncios();
		anunciante = new AnuncianteBean("Gerson","344.522.456-66", anuncios);
	}
	
	@Test
	public void getAnuncios() throws MalformedURLException {
		criarAnunciante();
		ArrayList<AnuncioBean> anuncios = criarAnuncios();
		
		assertEquals(anuncios.get(0).getProduto().getNome(), anunciante.getAnuncios().get(0).getProduto().getNome());
	}
	
	@Test
	public void setAnuncios() throws MalformedURLException {
		criarAnunciante();
		ArrayList<AnuncioBean> anuncios = criarAnuncios();
		anuncios.remove(0);
		
		anunciante.setAnuncios(anuncios);
		assertEquals(2, anunciante.getAnuncios().size());
	}
	
	@Test
	public void adicionarAnuncio() throws MalformedURLException {
		criarAnunciante();
		ArrayList<AnuncioBean> anuncios = criarAnuncios();

		anunciante.addAnuncio(anuncios.get(0));
		
		assertEquals(4, anunciante.getAnuncios().size());
	}
	
	@Test
	public void removerAnuncio() throws MalformedURLException {
		criarAnunciante();
		ArrayList<AnuncioBean> anuncios = criarAnuncios();

		anunciante.removeAnuncio(0);
		
		assertEquals(2, anunciante.getAnuncios().size());
	}
}
