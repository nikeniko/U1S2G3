package entites;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ordine {
    private long id;
    private String stato;
    private LocalDate dataOrdine;
    private LocalDate dataConsegna;
    private List<Prodotto> prodotti;
    private Cliente cliente;

    public Ordine(Cliente cliente) {
        Random rndm = new Random();
        this.id = rndm.nextLong();
        this.cliente = cliente;
        this.stato = "Creato";
        this.dataOrdine = LocalDate.now();
        this.dataConsegna = LocalDate.now().plusWeeks(1);
        this.prodotti = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Ordine [id=" + id + ", stato=" + stato + ", dataOrdine=" + dataOrdine + ", dataConsegna=" + dataConsegna
                + ", prodotti=" + prodotti + ", cliente=" + cliente + "]";
    }

    public double getTotale() {
        return this.prodotti.stream().mapToDouble(Prodotto::getPrezzo).sum();
    }

    public long getId() {
        return id;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public LocalDate getDataOrdine() {
        return dataOrdine;
    }

    public LocalDate getDataConsegna() {
        return dataConsegna;
    }

    public void setDataConsegna(LocalDate dataConsegna) {
        this.dataConsegna = dataConsegna;
    }

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public void aggiungiProdotto(Prodotto p) {
        prodotti.add(p);
    }

    public Cliente getCliente() {
        return cliente;
    }
}
