public class Pessoa {
	public String nome = "";
	public int idade;

	public Pessoa(String nome, int idade) throws Exception {
		this.setNome(nome);
		this.setIdade(idade);
	}

	protected void setNome(String nome) throws Exception {
		boolean nomeComposto = false;
		if (nome.length() <= 5)
			throw new Exception("Nome e sobrenome devem possuir mais do que 5 caracteres");

		for (int i = 0; i < nome.length(); i++) {
			if (nome.charAt(i) == ' ') {
				nomeComposto = true;
				break;
			} else if (!Character.isAlphabetic(nome.charAt(i))) {
				throw new Exception("Caracter inválido encontrado!");
			}
		}
		if (!nomeComposto)
			throw new Exception("Deve ser informado o sobrenome");
		this.nome = nome;
	}

	public String getNome() {
		System.out.println(this.nome);
		return this.nome;
	}

	public int getIdade() {
		return this.idade;
	}

	protected void setIdade(int idade) throws Exception {
		if (idade < 0)
			throw new Exception("Idade não pode ser negativa");
		if (idade > 100)
			throw new Exception("Idade não pode ser maior que 100");
		this.idade = idade;
	}
}