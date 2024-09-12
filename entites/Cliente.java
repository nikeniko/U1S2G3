package entites;

import java.util.Random;

public class Cliente {
    private long id;
    private String nome;
    private int livello;

    public Cliente(String nome, int livello) {
        this.nome = nome;
        this.livello = livello;
        Random rndm = new Random();
        this.id = rndm.nextLong();
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", livello=" + livello + "]";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLivello() {
        return livello;
    }

    public void setLivello(int livello) {
        this.livello = livello;
    }

    public long getId() {
        return id;
    }
}
