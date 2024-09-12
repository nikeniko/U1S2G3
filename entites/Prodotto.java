package entites;

import java.util.Random;

public class Prodotto {
	private long id;
	private String nome;
	private String categoria;
	private double prezzo;

	public Prodotto(String nome, String categoria, double prezzo) {
		this.nome = nome;
		this.categoria = categoria;
		this.prezzo = prezzo;
		Random rndm = new Random();
		this.id = rndm.nextLong();
	}

	@Override
	public String toString() {
		return "Prodotto [id=" + id + ", nome=" + nome + ", categoria=" + categoria + ", prezzo=" + prezzo + "]";
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
}
