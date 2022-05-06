package utfpr.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utfpr.app.BDVeiculos;
import utfpr.app.Carga;
import utfpr.app.Passeio;
import utfpr.app.Veiculo;

class BDVeiculosTest {
	
	private BDVeiculos repositorio;
	
	@BeforeEach
	private void inicializar() {
		
		this.repositorio = new BDVeiculos();
	}
	
	@Test
	void inclusaoDeItemNaListaDeCarrosDePasseio() {
		
		Veiculo passeio = new Passeio();
		passeio.setPlaca("XPTO");		
		
		repositorio.adicionaVeiculo(passeio);
		
		assertEquals(repositorio.getCarrosDePasseio().size(), 1);
	}
	
	@Test
	void inclusaoDeItemNaListaDeCarrosDeCarga() {
		
		Veiculo carga = new Carga();
		carga.setPlaca("XPTO");		
		
		repositorio.adicionaVeiculo(carga);
		
		assertEquals(repositorio.getCarrosDeCarga().size(), 1);
	}
	
	@Test
	void exclusaoDeItemNaListaDeCarrosDePasseio() {
		
		Veiculo passeio = new Passeio();
		passeio.setPlaca("XPTO");		
		
		repositorio.adicionaVeiculo(passeio);
		
		assertEquals(repositorio.removeVeiculo(passeio), true);
		
		assertEquals(repositorio.getCarrosDePasseio().size(), 0);
		
	}
	
	@Test
	void exclusaoDeItemNaListaDeCarrosDeCarga() {
		
		Veiculo carga = new Carga();
		carga.setPlaca("XPTO");		
		
		repositorio.adicionaVeiculo(carga);
		
		assertEquals(repositorio.removeVeiculo(carga), true);
		
		assertEquals(repositorio.getCarrosDeCarga().size(), 0);
		
	}
	
	@Test
	void exclusaoDeItemInexistente() {
		
		Veiculo carga = new Carga();
		carga.setPlaca("XPTO");				
		
		assertEquals(repositorio.removeVeiculo(carga), false);
	}

}
