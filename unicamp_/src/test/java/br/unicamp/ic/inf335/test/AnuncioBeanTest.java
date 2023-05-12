package br.unicamp.ic.inf335.test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.junit.Test;

import br.unicamp.ic.inf335.beans.AnuncioBean;
import br.unicamp.ic.inf335.beans.ProdutoBean;

public class AnuncioBeanTest {

	ProdutoBean produto = new ProdutoBean("CD00001","Celular Galaxy S10","128 Gb, Preto, com Carregador",1250.0,"Poucos riscos, estado de novo.");
	ArrayList<URL> fotosUrl = new ArrayList<URL>();
	AnuncioBean anuncio = new AnuncioBean(produto,fotosUrl, 0.2);
	
	@Test
	public void getProduto() {
		assertEquals(produto, anuncio.getProduto());
	}


	@Test
	public void setProduto() {
		ProdutoBean novoProduto = new ProdutoBean("CD00002","Prod 2 ...", "Bla Bla Bla",1100.0,"Bla Bla Bla");
		anuncio.setProduto(novoProduto);
		assertEquals("CD00002", anuncio.getProduto().getCodigo());
	}


	@Test
	public void getFotosUrl() throws MalformedURLException {
		URL url1 = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSkA-OsNFo7XIKkGECvIm-NoIsYJHNyQUfnng&usqp=CAU");
		URL url2 = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQOfojuknGlolErYhhu2RVimBHUPPIC1vSrQ&usqp=CAU");
		URL url3 = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRDlwgjsjux2dZbcv24QTJYjUEp8VLVR85iTw&usqp=CAU");
		fotosUrl.add(url1);
		fotosUrl.add(url2);
		fotosUrl.add(url3);
		assertEquals(3, anuncio.getFotosUrl().size());
	}

	@Test
	public void setFotosUrl() throws MalformedURLException {
		ArrayList<URL> fotosUrl2 = new ArrayList<URL>();
		
		URL url1 = new URL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSkA-OsNFo7XIKkGECvIm-NoIsYJHNyQUfnng&usqp=CAU");
		
		fotosUrl2.add(url1);
		
		anuncio.setFotosUrl(fotosUrl2);
		
		assertEquals(1, anuncio.getFotosUrl().size());
	}
	
	@Test
	public void getSerialversionuid() {
		assertEquals(1, anuncio.getSerialversionuid());
	}
}
