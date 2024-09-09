import it.unisa.dao.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
        DipendenteDAO dipendenteDAO = new DipendenteDAO();
        MagazzinoDAO magazzinoDAO = new MagazzinoDAO();
        ProdottoDAO prodottoDAO = new ProdottoDAO();
        PuntoVenditaDAO puntoVenditaDAO = new PuntoVenditaDAO();
        VideogameDAO videogameDAO = new VideogameDAO();
        ConsoleDAO consoleDAO = new ConsoleDAO();
        AccessorioDAO accessorioDAO = new AccessorioDAO();
        AcquistoDAO acquistoDAO = new AcquistoDAO();
        TitolareDAO titolareDAO = new TitolareDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Scegli un'operazione:");
            System.out.println("1. Inserire un cliente");
            System.out.println("2. Inserire un dipendente");
            System.out.println("3. Inserire un punto vendita");
            System.out.println("4. Inserire una console");
            System.out.println("5. Inserire un videogame");
            System.out.println("6. Inserire un accessorio");
            System.out.println("7. Selezionare tutti i prodotti presso un punto vendita");
            System.out.println("8. Selezionare tutti i videogames con una data di rilascio");
            System.out.println("9. Selezionare un determinato cliente");
            System.out.println("10. Rimuovere un cliente");
            System.out.println("11. Selezionare i dipendenti che hanno lavorato di piu nell'ultima settimana");
            System.out.println("12. Rimuovere un dipendente");
            System.out.println("13. Elencare i prodotti che non sono disponibili in un determinato punto vendita");
            System.out.println("14. Selezionare gli acquisti con un totale maggiore di X");
            System.out.println("15. Selezionare il titolare di un punto vendita");
            System.out.println("16. Aggiungere un magazzino");
            System.out.println("17. Selezionare tutti i punti vendita con i titolari");
            System.out.println("18. Selezionare gli ordini in stato consegnato");
            System.out.println("0. Esci");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consuma newline

            switch (choice) {
                case 1: // inserisci un cliente
                    System.out.println("Inserisci codice fiscale:");
                    String codiceFiscale = scanner.nextLine();
                    //controlla se codice fiscale ha 16 caratteri
                    if (codiceFiscale.length() != 16) {
                        System.out.println("Il codice fiscale deve avere 16 caratteri.");
                        break;
                    }
                    System.out.println("Inserisci nome:");
                    String nome = scanner.nextLine();
                    System.out.println("Inserisci cognome:");
                    String cognome = scanner.nextLine();
                    System.out.println("Inserisci data di nascita (YYYY-MM-DD):");
                    String data = scanner.nextLine();
                    clienteDAO.inserireCliente(codiceFiscale, nome, cognome, java.sql.Date.valueOf(data));
                    break;
                case 2: //Inserie un dipendente
                    System.out.println("Inserisci l'id del dipendente:");
                    String dipendenteId = scanner.nextLine();
                    System.out.println("Inserisci nome:");
                    nome = scanner.nextLine();
                    System.out.println("Inserisci cognome:");
                    cognome = scanner.nextLine();
                    System.out.println("Inserisci data di nascita (YYYY-MM-DD):");
                    data = scanner.nextLine();
                    System.out.println("Inserisci ore settimanali:");
                    int ore = scanner.nextInt();
                    System.out.println("Inserisci id del punto vendita:");
                    int puntoVenditaId = scanner.nextInt();
                    dipendenteDAO.inserireDipendente(dipendenteId, nome, cognome, java.sql.Date.valueOf(data), ore, puntoVenditaId);
                    break;
                case 3: //Inserire un punto vendita
                    System.out.println("Inserisci provincia:");
                    String provincia = scanner.nextLine();
                    System.out.println("Inserisci città:");
                    String citta = scanner.nextLine();
                    System.out.println("Inserisci via:");
                    String via = scanner.nextLine();
                    System.out.println("Inserisci civico:");
                    String civico = scanner.nextLine();
                    System.out.println("Inserisci numero di dipendenti:");
                    int numeroDipendenti = scanner.nextInt();
                    puntoVenditaDAO.inserirePuntoVendita(provincia, citta, via, civico, numeroDipendenti);
                    break;
                case 4: //Inserire una console
                    System.out.println("Vuoi inserire una console o linkarla ad un prodotto esistente?" +
                            "\n1. Inserire una nuova console" +
                            "\n2. Linkare ad un prodotto esistente");
                    int scelta = scanner.nextInt();
                    scanner.nextLine();  // Consuma newline
                    switch (scelta) {
                        case 1:
                            System.out.println("Inserisci nome della console:");
                            nome = scanner.nextLine();
                            System.out.println("Inserisci anno di rilascio:");
                            int anno = scanner.nextInt();
                            System.out.println("Inserisci codice a barre del prodotto:");
                            scanner.nextLine();  // Consuma newline
                            String codiceABarre = scanner.nextLine();
                            System.out.println("Inserisci prezzo:");
                            float prezzo = scanner.nextFloat();
                            prodottoDAO.inserireProdotto(nome, codiceABarre, prezzo);
                            consoleDAO.inserireConsole(nome, anno, codiceABarre);
                            break;
                        case 2:
                            prodottoDAO.selezionaTuttiProdotti();
                            System.out.println("Inserisci nome della console:");
                            nome = scanner.nextLine();
                            System.out.println("Inserisci anno di rilascio:");
                            anno = scanner.nextInt();
                            System.out.println("Inserisci codice a barre del prodotto:");
                            scanner.nextLine();  // Consuma newline
                            codiceABarre = scanner.nextLine();
                            consoleDAO.inserireConsole(nome, anno, codiceABarre);
                            break;
                        default:
                            System.out.println("Scelta non valida.");
                    }
                    break;
                case 5: //Inserire un videogame
                    System.out.println("Vuoi inserire un videogame o linkarlo ad un prodotto esistente?" +
                            "\n1. Inserire un nuovo videogame" +
                            "\n2. Linkare ad un prodotto esistente");
                    int sceltaVideogame = scanner.nextInt();
                    scanner.nextLine();  // Consuma newline
                    switch(sceltaVideogame) {
                        case 1:
                            System.out.println("Inserisci nome del videogame:");
                            nome = scanner.nextLine();
                            System.out.println("Inserisci piattaforma:");
                            String piattaforma = scanner.nextLine();
                            System.out.println("Inserisci data di uscita (YYYY-MM-DD):");
                            data = scanner.nextLine();
                            System.out.println("Inserisci condizione (nuovo/usato):");
                            String condizione = scanner.nextLine();
                            System.out.println("Inserisci codice a barre del prodotto:");
                            String codiceABarre = scanner.nextLine();
                            System.out.println("Inserisci prezzo:");
                            float prezzo = scanner.nextFloat();
                            prodottoDAO.inserireProdotto(nome, codiceABarre, prezzo);
                            videogameDAO.inserireVideogame(nome, piattaforma, java.sql.Date.valueOf(data), condizione, codiceABarre);
                            break;
                        case 2:
                            prodottoDAO.selezionaTuttiProdotti();
                    System.out.println("Inserisci nome del videogame:");
                    nome = scanner.nextLine();
                    System.out.println("Inserisci piattaforma:");
                    piattaforma = scanner.nextLine();
                    System.out.println("Inserisci data di uscita (YYYY-MM-DD):");
                    data = scanner.nextLine();
                    System.out.println("Inserisci condizione (nuovo/usato):");
                    condizione = scanner.nextLine();
                    System.out.println("Inserisci codice a barre del prodotto:");
                     codiceABarre = scanner.nextLine();
                    videogameDAO.inserireVideogame(nome, piattaforma, java.sql.Date.valueOf(data), condizione, codiceABarre);
                    break;
                    default:
                        System.out.println("Scelta non valida.");
                }
                break;
                case 6: //Inserire un accessorio
                    consoleDAO.selezionaTutteConsole();
                    System.out.println("Inserisci nome dell'accessorio:");
                    nome = scanner.nextLine();
                    System.out.println("Inserisci codice a barre della console:");
                    String codiceABarreConsole = scanner.nextLine();
                    accessorioDAO.inserireAccessorio(nome, codiceABarreConsole);
                    break;
                case 7: //Selezionare tutti i prodotti di un punto vendita
                    System.out.println("Inserisci l'ID del punto vendita:");
                    puntoVenditaId = scanner.nextInt();
                    prodottoDAO.selezionareProdottiPerPuntoVendita(puntoVenditaId);
                    break;

                case 8: //Selezionare tutti i videogames con data rilascio X
                    System.out.println("Inserisci l'anno di uscita:");
                    int anno = scanner.nextInt();
                    videogameDAO.selezionareVideogamesPerAnno(anno);
                    break;
                case 9: //Seleziona un determinato cliente
                    System.out.println("Inserisci codice fiscale del cliente:");
                    codiceFiscale = scanner.nextLine();
                    clienteDAO.selezionareCliente(codiceFiscale);
                    break;

                case 10: // Rimuovere un cliente
                    System.out.println("Inserisci codice fiscale del cliente da rimuovere:");
                    codiceFiscale = scanner.nextLine();
                    clienteDAO.rimuovereCliente(codiceFiscale);
                    break;
                case 11: // Dipendenti che hanno lavorato di piu nell'ultima settimana
                    dipendenteDAO.selezionareDipendentiPerOreLavorate();
                    break;
                case 12: //rimuovere un dipendente
                    System.out.println("Inserisci ID del dipendente da rimuovere:");
                    int id = scanner.nextInt();
                    dipendenteDAO.rimuovereDipendente(id);
                    break;
                case 13: //Elencare i prodotti che non sono disponibili
                    System.out.println("Inserisci l'ID del punto vendita:");
                    puntoVenditaId = scanner.nextInt();
                    puntoVenditaDAO.selezionareProdottiNonDisponibiliPerPuntoVendita(puntoVenditaId);
                    break;

                case 14: //Selezionare gli acquisti con totale maggiore di X
                    System.out.println("Inserisci il totale minimo:");
                    float totale = scanner.nextFloat();
                    acquistoDAO.selezionareAcquistiPerTotaleMaggiore(totale);
                    break;
                case 15: //Selezionare il titolare di un punto vendita
                    System.out.println("Inserisci l'ID del punto vendita:");
                    puntoVenditaId = scanner.nextInt();
                    titolareDAO.selezionareTitolarePerPuntoVendita(puntoVenditaId);
                    break;

                case 16: //Aggiungere un magazzino
                    System.out.println("Inserisci provincia:");
                    provincia = scanner.nextLine();
                    System.out.println("Inserisci città:");
                    citta = scanner.nextLine();
                    System.out.println("Inserisci via:");
                    via = scanner.nextLine();
                    System.out.println("Inserisci civico:");
                    civico = scanner.nextLine();
                    magazzinoDAO.aggiungereMagazzino(provincia, citta, via, civico);
                    break;

                case 17: //Selezionare tutti i punti vendita con i titolari
                    puntoVenditaDAO.selezionarePuntiVenditaConTitolari();
                    break;
                case 18: //Seleziona gli ordini in stato consegnato
                    acquistoDAO.selezionareOrdiniConsegnati();
                    break;

                case 0:
                    System.out.println("Uscita...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Scelta non valida.");
            }
        }
    }
}
