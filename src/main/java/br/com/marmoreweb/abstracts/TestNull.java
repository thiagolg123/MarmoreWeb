package br.com.marmoreweb.abstracts;

public class TestNull {

	public static <T> void test(T t){
		if(t == null || t.equals("")){
			throw new IllegalArgumentException("Parametro nulo");
		}
	}
}
