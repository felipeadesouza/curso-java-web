package br.com.tt.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConvertTest {

	@Test
	public void testCpf() {
		String cpf = new Convert().cpf("03279245691");
		assertEquals("032.792.456-91", cpf);
	}

}
