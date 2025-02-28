import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PessoaTest {

	// Teste 1.1: Criando um objeto Pessoa válido.
	@Test
	void testPessoaValida() throws Exception {
		Pessoa pessoa = new Pessoa("Pedro Miguel", 27);
		assertEquals("Pedro Miguel", pessoa.getNome());
		assertEquals(27, pessoa.getIdade());
	}

	// Teste 1.2: Criando um objeto Pessoa inválido, sem sobrenome.
	@Test
	void testPessoaSemSobrenome() {
		Exception exception = assertThrows(Exception.class, () -> {
			new Pessoa("Ivanilson", 21);
		});
		assertEquals("Deve ser informado o sobrenome", exception.getMessage());
	}

	// Teste 2.1: Criando um objeto Pessoa válido, com o nome maior que 5
	// caracteres.
	@Test
	void testNomeValido() throws Exception {
		Pessoa pessoa = new Pessoa("Felipe Silva", 35);
		assertEquals("Felipe Silva", pessoa.getNome());
		assertEquals(35, pessoa.getIdade());
	}

	// Teste 2.2: Criando um objeto Pessoa inválido com o nome menor ou igual a 5
	// caracteres.
	@Test
	void testNomeInvalido5Carac() {
		Exception exception = assertThrows(Exception.class, () -> {
			new Pessoa("Jon S", 17);
		});
		assertEquals("Nome e sobrenome devem possuir mais do que 5 caracteres", exception.getMessage());

	}

	// Teste 3.1: Criando um objeto Pessoa com o nome válido (Sem caracteres
	// especiais).
	@Test
	void testNomeSemSimbolos() throws Exception {
		Pessoa pessoa = new Pessoa("Maria Jose", 29);
		assertEquals("Maria Jose", pessoa.getNome());
		assertEquals(29, pessoa.getIdade());
	}

	// Teste 3.2: Criando um objeto pessoa com caractere especial no nome.
	@Test
	void testNomeComCaracteresEspeciais() {
		Exception exception = assertThrows(Exception.class, () -> {
			new Pessoa("@Luiza Donavon", 18);
		});
		assertEquals("Caracter inválido encontrado!", exception.getMessage());

	}

	// Teste 4.1: Criando um objeto Pessoa com a idade negativa (Menor que 0).
	@Test
	void testIdadeNegativa() {
		Exception exception = assertThrows(Exception.class, () -> {
			new Pessoa("Ana Vitoria", -1);
		});
		assertEquals("Idade não pode ser negativa", exception.getMessage());
	}

	// Teste 4.2: Criando um objeto Pessoa com a idade maior que 100.
	@Test
	void testIdadeMaiorQueCem() {
		Exception exception = assertThrows(Exception.class, () -> {
			new Pessoa("Chico Cesar", 101);
		});
		assertEquals("Idade não pode ser maior que 100", exception.getMessage());
	}

	// Teste 5: Testando o valor Limite da idade 0.
	@Test
	void testIdadeIgualZero() throws Exception {
		Pessoa pessoa = new Pessoa("Fabio Junior", 0);
		assertEquals("Fabio Junior", pessoa.getNome());
		assertEquals(0, pessoa.getIdade());
	}

	// Teste 5: Testando o valor Limite da idade 100
	@Test
	void testIdadeIgualCem() throws Exception {
		Pessoa pessoa = new Pessoa("Jose Luiz", 100);
		assertEquals("Jose Luiz", pessoa.getNome());
		assertEquals(100, pessoa.getIdade());
	}

	// Erros encontrados no código:

	/*
	 * Primeiro erro: O objeto consegue ser criado com o primeiro caractere em
	 * branco e quaisquer cinco ou mais outros caracteres, ferindo a regra de
	 * negócio 3; Que afirma que nomes e sobrenomes devem ser compostos
	 * esclusivamente por letras do alfabeto.
	 * 
	 */
	@Test
	void bugEspacoPrimeiroCaractere() throws Exception {
		Exception exception = assertThrows(Exception.class, () -> {
			new Pessoa(" ?@#5!", 20);
		});
		assertEquals("Caracter inválido encontrado!", exception.getMessage());
	}

	/*
	 * Segundo: Se colocados 5 caracteres válidos e o último sendo um espaço em
	 * branco, o objeto consegue ser criado, sem precisar ser um nome composto.
	 */
	@Test
	void bugSobrenomeDescessario() throws Exception {
		Exception exception = assertThrows(Exception.class, () -> {
			new Pessoa("maria ", 53);
		});
		assertEquals("Deve ser informado o sobrenome", exception.getMessage());
	}

}