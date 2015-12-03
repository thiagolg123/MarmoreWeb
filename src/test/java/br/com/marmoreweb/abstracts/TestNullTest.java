package br.com.marmoreweb.abstracts;

import org.junit.Test;

import br.com.marmoreweb.modelo.Cheque;

public class TestNullTest {

	@Test(expected=IllegalArgumentException.class)
	public void testaAtribuicaoDeNull(){
		Cheque cheque = new Cheque();
		cheque = null;
		
		TestNull.test(cheque);
	}
}
