import entites.Cliente;
import entites.Ordine;
import entites.Prodotto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static List<Prodotto> magazzino = new ArrayList<>();
    static List<Cliente> clienti = new ArrayList<>();
    static List<Ordine> ordini = new ArrayList<>();

    public static void main(String[] args) {
        inizializzaMagazzino();
        creaClienti();
        effettuaOrdini();

        System.out.println("--------------------------------- PRODOTTI ----------------------------------");
        magazzino.forEach(System.out::println);
        System.out.println("--------------------------------- CLIENTI ----------------------------------");
        clienti.forEach(System.out::println);
        System.out.println("--------------------------------- ORDINI ----------------------------------");
        ordini.forEach(System.out::println);

        System.out.println("---------------------------------- ES 1 ------------------------------------");
        getLibri().forEach(System.out::println);
        System.out.println("---------------------------------- ES 2 ------------------------------------");
        getOrdiniBaby().forEach(System.out::println);
        System.out.println("---------------------------------- ES 3 ------------------------------------");
        getProdottiRagazziConSconto().forEach(System.out::println);
        System.out.println("---------------------------------- ES 4 ------------------------------------");
        getProdottiLivello2().forEach(System.out::println);
    }

    // 1
    public static List<Prodotto> getLibri() {
        return magazzino.stream().filter(prodotto -> prodotto.getCategoria().equals("Libri") && prodotto.getPrezzo() > 100).toList();
    }

    // 2
    public static List<Ordine> getOrdiniBaby() {
        return ordini.stream().filter(ordine -> ordine.getProdotti().stream().anyMatch(prodotto -> prodotto.getCategoria().equals("Baby"))).toList();
    }

    // 3
    public static List<Prodotto> getProdottiRagazziConSconto() {
        return magazzino.stream().filter(p -> p.getCategoria().equals("Ragazzi")).map(prodotto -> {
            prodotto.setPrezzo(prodotto.getPrezzo() * 0.90);
            return prodotto;
        }).toList();
    }

    // 4
    public static List<Prodotto> getProdottiLivello2() {
        List<Ordine> ordiniFiltrati = ordini.stream()
                .filter(ordine -> ordine.getCliente().getLivello() == 2
                        && ordine.getDataOrdine().isBefore(LocalDate.parse("2024-06-27"))
                        && ordine.getDataOrdine().isAfter(LocalDate.parse("2024-06-03")))
                .toList();

        List<Prodotto> prodotti = new ArrayList<>();

        for (Ordine ordine : ordiniFiltrati) {
            prodotti.addAll(ordine.getProdotti());
        }
        return prodotti;
    }

    public static void inizializzaMagazzino() {
        Prodotto tablet = new Prodotto("Tablet Pro", "Elettronica", 1200.0);
        Prodotto romanzo = new Prodotto("Il Signore degli Anelli", "Libri", 150);
        Prodotto thriller = new Prodotto("Il Codice Da Vinci", "Libri", 10);
        Prodotto fumetto = new Prodotto("Batman: Anno Uno", "Libri", 20);
        Prodotto giocattolo = new Prodotto("Giocattolo Educativo", "Baby", 25);
        Prodotto macchinaRacing = new Prodotto("Macchina da Corsa", "Ragazzi", 30);
        Prodotto aereoModello = new Prodotto("Aereo Radiocomandato", "Ragazzi", 45);
        Prodotto costruzioni = new Prodotto("Set di Costruzioni", "Ragazzi", 600);

        magazzino.addAll(Arrays.asList(tablet, romanzo, thriller, fumetto, giocattolo, macchinaRacing, aereoModello, costruzioni));
    }

    public static void creaClienti() {
        Cliente andrea = new Cliente("Andrea Conti", 1);
        Cliente beatrice = new Cliente("Beatrice Ferri", 2);
        Cliente carlo = new Cliente("Carlo Rossi", 3);
        Cliente domenica = new Cliente("Domenica Bianchi", 2);

        clienti.add(andrea);
        clienti.add(beatrice);
        clienti.add(carlo);
        clienti.add(domenica);
    }

    public static void effettuaOrdini() {
        Ordine ordineAndrea = new Ordine(clienti.get(0));
        Ordine ordineBeatrice = new Ordine(clienti.get(1));
        Ordine ordineCarlo = new Ordine(clienti.get(2));
        Ordine ordineDomenica = new Ordine(clienti.get(3));
        Ordine ordineCarlo2 = new Ordine(clienti.get(2));

        Prodotto tablet = magazzino.get(0);
        Prodotto romanzo = magazzino.get(1);
        Prodotto thriller = magazzino.get(2);
        Prodotto fumetto = magazzino.get(3);
        Prodotto giocattolo = magazzino.get(4);

        ordineAndrea.aggiungiProdotto(tablet);
        ordineAndrea.aggiungiProdotto(romanzo);
        ordineAndrea.aggiungiProdotto(giocattolo);

        ordineBeatrice.aggiungiProdotto(thriller);
        ordineBeatrice.aggiungiProdotto(fumetto);
        ordineBeatrice.aggiungiProdotto(tablet);

        ordineCarlo.aggiungiProdotto(romanzo);
        ordineCarlo.aggiungiProdotto(giocattolo);

        ordineDomenica.aggiungiProdotto(giocattolo);

        ordineCarlo2.aggiungiProdotto(tablet);

        ordini.add(ordineAndrea);
        ordini.add(ordineBeatrice);
        ordini.add(ordineCarlo);
        ordini.add(ordineDomenica);
        ordini.add(ordineCarlo2);
    }
}
