package listaSpesa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import prodotti.Alimentari;
import prodotti.NonAlimentari;
import prodotti.Prodotti;

public class mainListaSpesa {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaSpesa menagerList = null;
        ListaSpesa userCart = null;
        
        //Menu principale
        menu:
        while (true) {
            System.out.println("***Benvenuto nell' App Lista Spesa***");
            System.out.println("1. Entra come gestore\n2. Entra come acquirente\n0. Esci");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    int tentativo = 1;
                    boolean isCorrect = false;
                    ListaSpesa listaGestore = new ListaSpesa();
                    
                    //Ciclo per la verifica della password
                    while (tentativo <= 3 && !isCorrect) {
                        System.out.print("Inserisci password (tentativo: " + tentativo + "): ");
                        try {
                            int password = scanner.nextInt();
                            scanner.nextLine();

                            if (listaGestore.verifyPassword(password)) {
                                isCorrect = true;
                                break;
                            } else {
                                System.err.println("Password Errata!");
                                tentativo++;
                            }
                        } catch (InputMismatchException e) {
                            System.err.println("Input non valido. Inserisci un numero intero.");
                            scanner.nextLine();
                            tentativo++;
                        }
                    }


                    if (!isCorrect) {
                        System.out.println("Tentativi esauriti!Necessario riavviare programma.");
                        break menu;
                    }
                    
                    //Inizializzazione Magazzino
                    System.out.println("Inserisci il numero di prodotti da inserire a magazzino:");
                    int capacita = 0;
                    while(true) {
                    	try {
                    		capacita = scanner.nextInt();
                    		scanner.nextLine();
                    		break;
                    	}catch(InputMismatchException e) {
                    		System.err.println("Input non valido. Inserisci un numero.");
                            scanner.nextLine();
                    		}
                    }
                    menagerList = new ListaSpesa(capacita);
                    System.out.println("Capacità magazzino: " + capacita);
                    System.out.println();
                    
                    //Sottomenu per gestione magazzino
                    sottomenu:
                    while (true) {
                        System.out.println("Scegli il tipo di prodotto da inserire nel Magazzino:");
                        System.out.println("1. Alimentari\n2. Non Alimentari\n3. Dettaglio Magazzino\n0. Menu' principale");
                        int number = 0;
                        while(true) {
                        	try {
                        		number = scanner.nextInt();
                        		scanner.nextLine();
                        		break;
                        	}catch(InputMismatchException e) {
                        		System.err.println("Input non valido. Inserisci un numero.");
                                scanner.nextLine();
                        		}
                        }
                        
                        switch (number) {
                            case 1://Inserimento prodotto Alimentare
                                System.out.println("Inserisci il codice a barre:");
                                int code = 0;
                                while(true) {
                                	try {
                                		code = scanner.nextInt();
    	                                scanner.nextLine();
    	                                break;
									} catch(InputMismatchException e) {
		                        		System.err.println("Input non valido. Inserisci un numero.");
		                                scanner.nextLine();
		                        		}
                                }
	                                
                                System.out.println("Inserisci la descrizione del prodotto:");
                                String description = scanner.nextLine();
                                System.out.println("Inserisci il prezzo:");
                                float price = 0;
                                while(true) {
                                	try {
                                		price = scanner.nextFloat();
                                        scanner.nextLine();
                                        break;
									} catch(InputMismatchException e) {
		                        		System.err.println("Input non valido. Inserisci una cifra separata dalla ','.");
		                                scanner.nextLine();
		                        		}
                                }
                                
                                System.out.println("Inserisci la data di scadenza nel seguente formato 'dd-MM-yyyy'");
                                String expiryString = "";
                                while(true) {
	                                try {
	                                	expiryString = scanner.nextLine();
	                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	                                    LocalDate expiry = LocalDate.parse(expiryString, formatter);
	                                    Alimentari food = new Alimentari(code, price, description, expiry);
	                                    menagerList.addArticle(food);
	                                    System.out.println("Articolo '" + food.getDescription() + "' aggiunto a magazzino");
	                                    System.out.println();
	                                    break;
	                                } catch (DateTimeParseException e) {
	                                    System.err.println("Formato data non valido. Riprova.");
	                                }
                                }
                                break;

                            case 2://Inserimento Prodotto NonAlimentare
                            	System.out.println("Inserisci il codice a barre:");
                                code = 0;
                                while(true) {
                                	try {
                                		code = scanner.nextInt();
    	                                scanner.nextLine();
    	                                break;
									} catch(InputMismatchException e) {
		                        		System.err.println("Input non valido. Inserisci un numero.");
		                                scanner.nextLine();
		                        		}
                                }
	                                
                                System.out.println("Inserisci la descrizione del prodotto:");
                                description = scanner.nextLine();
                                System.out.println("Inserisci il prezzo:");
                                price = 0;
                                while(true) {
                                	try {
                                		price = scanner.nextFloat();
                                        scanner.nextLine();
                                        break;
									} catch(InputMismatchException e) {
		                        		System.err.println("Input non valido. Inserisci una cifra separata dalla ','.");
		                                scanner.nextLine();
		                        		}
                                }
                                System.out.println("Di che materiale è composto?");
                                System.out.println("Inserisci la descrizione del prodotto:");
                                String material = scanner.nextLine();
                                NonAlimentari noFood = new NonAlimentari(code, price, description, material);
                                menagerList.addArticle(noFood);
                                System.out.println("Articolo '" + noFood.getDescription() + "' aggiunto a magazzino");
                                System.out.println();
                                break;

                            case 3://Visualizza dettaglio Magazzino
                                System.out.println("Contenuto Magazzino:");
                                System.out.println();
                                menagerList.shoppingCartDetail();
                                System.out.println();
                                break;

                            case 0://Torna al menu principale
                                break sottomenu;
                        }
                    }
                    break;

                case 2://parte Acquirente
                    System.out.println("***Benvenuto Acquirente***");
                    while(true) {
                    	try {
                    		userCart = new ListaSpesa(menagerList.getProductsPurchased().length);
                            System.out.println("Il tuo carrello può contenere massimo " + userCart.getProductsPurchased().length + " prodotti");
                            System.out.println();
                            break;
    					} catch (NullPointerException e) {
    						System.err.println("Magazzino vuoto, non e' possibile acquistare prodotti. Chiedere al gestore di inserire prodotti.");
    						break;
    					}
                    }
                    
                    //Menu utente
                    menuUtente:
                    while (true) {
                        System.out.println("1. Acquista prodotti\n2. Vedi contenuto carrello\n3. Vai alla cassa\n0. Esci");
                        int scelta2 = scanner.nextInt();
                        scanner.nextLine();

                        if (menagerList == null) {
                            System.err.println("Ripeto: Il magazzino non è stato inizializzato. Accedere come gestore per popolare il magazzino.");
                            break;
                        }

                        switch (scelta2) {
                            case 1://Aggiungi i prodotti al carrello
                            	uscitaProdottiCarrello:
                            	while (true) {
                                    System.out.println("Scegli il prodotto da inserire nel carrello:");
                                    menagerList.shoppingCartDetail();
                                    System.out.println("0. Torna indietro");
                                    System.out.println();
                                    int sceltaProdotti = scanner.nextInt();
                                    scanner.nextLine();

                                    if (sceltaProdotti == 0) {
                                        break uscitaProdottiCarrello; // Esce dal ciclo interno e torna al menu utente
                                    }

                                    Prodotti prodottoScelto = menagerList.findProducts(sceltaProdotti);
                                    if (prodottoScelto != null) {
                                        userCart.addArticle(prodottoScelto);
                                        System.out.println("Articolo '" + prodottoScelto.toString() + "' aggiunto al carrello");
                                        System.out.println();
                                        menagerList.removeArticle(sceltaProdotti);
                                    } else {
                                        System.out.println("Prodotto non trovato. Riprova.");
                                        System.out.println();
                                    }
                                }
                                break;

                            case 2: //Visualizza e gestisce il contenuto del carrello
                            	uscitaCarrello:
                            	while(true) {
	                            	System.out.println("Contenuto Carrello:");
	                            	System.out.println();
	                            	System.out.println("Seleziona il prodotto da eliminare\n0.torna indietro");
	                            	System.out.println();
	                            	userCart.shoppingCartDetail();
	                                System.out.println();
	                                int eliminaArticolo = scanner.nextInt();
	                                scanner.nextLine();
	                                if (eliminaArticolo != 0) {
	                                    // Trova l'articolo da rimuovere prima di rimuoverlo dal carrello
	                                    Prodotti articoloDaRimuovere = userCart.findProducts(eliminaArticolo);
	                                    if (articoloDaRimuovere != null) {
	                                        userCart.removeArticle(eliminaArticolo);
	                                        
	                                        // Aggiungi l'articolo rimosso al magazzino
	                                        boolean addedToMagazzino = false;
	                                        for (int i = 0; i < menagerList.getProductsPurchased().length; i++) {
	                                            if (menagerList.getProductsPurchased()[i] == null) {
	                                                menagerList.getProductsPurchased()[i] = articoloDaRimuovere;
	                                                addedToMagazzino = true;
	                                                break;
	                                            }
	                                        }
	                                        
	                                        if (addedToMagazzino) {
	                                            System.out.println("Articolo '" + articoloDaRimuovere.getDescription() + "' riaggiunto a magazzino.");
	                                            System.out.println();
	                                        } else {
	                                            System.err.println("Magazzino pieno. Non è stato possibile riaggiungere l'articolo.");
	                                            System.out.println();
	                                        }
	                                    } else {
	                                        System.err.println("Articolo non trovato nel carrello.");
	                                        System.out.println();
	                                    }
	                                    break;
	                                } else {
	                                    break uscitaCarrello;
	                                }
	                            }
                                break;
                                
                            case 3://procede alla cassa
                            	System.out.println("Ha la tessera?\n1.Si'\n2.No");
                            	float totale = 0f;
                            	int tessera = scanner.nextInt();
                            	scanner.nextLine();
                            	if (tessera == 1) {
                            		float totaleRisparmiato =0;
                            		float totale2 = 0;
									for (Prodotti prodottiCarrello : userCart.getProductsPurchased()) {
										if (prodottiCarrello != null) {
								            totale += prodottiCarrello.applicaSconto();
								            totale2 += (prodottiCarrello.getUnitPrice() - (prodottiCarrello.getUnitPrice() * 5) / 100);
								        }
										
									}
									totaleRisparmiato = totale2-totale;
									System.out.println("totale intero: "+totale2+" euro\nTotale da pagare: "+totale+" euro");
									System.out.println("Hai Risparmiato: "+totaleRisparmiato+" euro");
								}else if (tessera == 2) {
									for (Prodotti prodottiCarrello : userCart.getProductsPurchased()) {
										if (prodottiCarrello != null) {
								            totale += prodottiCarrello.getUnitPrice();
								        }
									}
									System.out.println("Totale da pagare: "+totale+" euro");
								}
                            	break;

                            case 0:
                                break menuUtente;
                        }
                    }
                    break;
                case 0:
                	System.out.println("Grazie e arrivederci.");
                	break menu;

                default:
                    System.err.println("Immissione errata");
            }
        }
         scanner.close(); 
    }
}