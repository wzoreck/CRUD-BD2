package aplicacao.entidades;

public class Pessoa {
	private int id;
	private String nome;
	private String cpf;
	private float altura;
	private float peso;

	public Pessoa(String nome, String cpf, float altura, float peso) {
		this.nome = nome;
		this.cpf = cpf;
		this.altura = altura;
		this.peso = peso;
	}

	public Pessoa(int id, String nome, String cpf, float altura, float peso) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.altura = altura;
		this.peso = peso;
	}

	public void apresentaPessoa() {
		System.out.println("id: " + this.id);
		System.out.println("nome: " + this.nome);
		System.out.println("cpf: " + this.cpf);
		System.out.println("altura: " + this.altura);
		System.out.println("peso: " + this.peso);
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

}
