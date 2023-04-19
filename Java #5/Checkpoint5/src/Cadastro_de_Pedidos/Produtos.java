package Cadastro_de_Pedidos;

public class Produtos {
	private String nome;
	private double quantidade;
	private double preco;
	
	public Produtos() {}
	
	public Produtos(String nome, double quantidade, double preco, String nomePessoa, int qtdProduto) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	//------------------------------GETTERS AND SETTERS------------------------------//
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}