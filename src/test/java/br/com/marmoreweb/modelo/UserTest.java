package br.com.marmoreweb.modelo;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class UserTest {
		
	@Test(expected=IllegalArgumentException.class)
	public void testaAtribuicaoComParametroVazio(){
		User userParamNull = new User(null, "sdaf", null);
		
		assertNotNull(userParamNull);
	}
}
