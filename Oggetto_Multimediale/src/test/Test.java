/*
Un Elemento Multimediale è una Immagine, un Filmato o una registrazione Audio 
identificato da un titolo (una stringa non vuota). 
Un elemento è riproducibile se ha una durata (un valore positivo di tipo int) e un metodo play().
﻿﻿Una registrazione Audio è riproducibile e ha associato anche un volume (un valore positivo di tipo int) e i metodi weaker() e louder() per regolarlo. Se riprodotta, ripete per un numero di volte pari alla durata la stampa del titolo concatenato a una sequenza di punti esclamativi di lunghezza pari al volume. Un Filmato è riproducibile e ha associato un volume regolabile analogo a quello delle registrazioni audio e anche una luminosità (un valore positivo di tipo int) e i metodi brighter() e darker() per regolarla. Se riprodotta, ripete per un numero di volte pari alla durata la stampa del titolo concatenato a una sequenza di punti esclamativi di lunghezza pari al volume e poi a una sequenza di asterischi di lunghezza pari alla luminosità. Una Immagine non è riproducibile, ma ha una luminosità regolabile analoga a quella dei filmati e un metodo show() che stampa il titolo concatenato a una sequenza di asterischi di lunghezza pari alla luminosità
﻿﻿Eseguire un oggetto multimediale significa invocarne il metodo show() se è un'immagine o il metodo play() se è riproducibile.
﻿﻿Organizzare opportunamente con classi astratte, interfacce e classi concrete il codice di un lettore multimediale che memorizza 5 elementi (creati con valori letti da tastiera) in un array e poi chiede ripetutamente all'utente quale oggetto eseguire (leggendo un intero da 1 a 5 oppure 0 per finire) e dopo ogni esecuzione fornisce la possibilità di regolarne eventuali parametri (volume / luminosità).
 */

package test;
import multimedial.*;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ElementoMultimediale file = null;
		int sceltaMenuPrincipale=0;
		String nomeFile = "";
		int durataFile =0;
		LettoreMultimediale lettore = new LettoreMultimediale(5);//inizializzazione array
		
		//menu benvenuto
		System.out.println("***Benvenuto in Lettore Multimediale***");
		System.out.println("\nScegli il tipo di file da inserire all'interno del Lettore:");
		
		//ciclo sul menuPrincipale
		uscita:
		while(true) {
			System.out.println("1.Audio"+"\n2.Video"+"\n3.Immagine"+"\n4.Consulta Lettore"+"\n0.Uscita Lettore");
			sceltaMenuPrincipale = scanner.nextInt();
			scanner.nextLine();// consumare newline
			switch (sceltaMenuPrincipale) {
			case 1: 
				System.out.print("Titolo file: ");
				nomeFile = scanner.nextLine();
				System.out.print("Durata in minuti: ");
				durataFile = scanner.nextInt();
				file = new Audio(nomeFile, durataFile);
				lettore.aggiungielementoMultimediale(file);
				break;
			case 2:
				System.out.print("Titolo file: ");
				nomeFile = scanner.nextLine();
				System.out.print("Durata in minuti: ");
				durataFile = scanner.nextInt();
				file = new Video(nomeFile, durataFile);
				lettore.aggiungielementoMultimediale(file);
				break;
			case 3:
				System.out.println("Inserisci il titolo del file immagine:");
				System.out.print("Nome file: ");
				nomeFile = scanner.nextLine();
				file = new Immagine(nomeFile);
				lettore.aggiungielementoMultimediale(file);
				break;
			case 4:
				 // sottoMenu per scegliere i file da visualizzare o riprodurre
                System.out.println("\nScegli un file da visualizzare o riprodurre:");
                lettore.situazioneLettore(); // mostra l'array popolato
                int sceltaSottoMenu = scanner.nextInt();
                scanner.nextLine(); // consumare newline

                ElementoMultimediale elemento = lettore.trovaFile(sceltaSottoMenu);
                if (elemento == null) {
                    System.out.println("Nessun file presente alla posizione indicata!");
                    break;
                }

                uscitaSottoMenu: 
                	while (true) {
                    if (elemento instanceof Audio) {
                        Audio audio = (Audio) elemento;
                        System.out.println("\n1.Play Audio\n2.Aumenta Volume\n3.Diminuisci Volume\n0.Torna Indietro");
                        int sceltaAudio = scanner.nextInt();
                        switch (sceltaAudio) {
                            case 1:
                            	System.out.println("Riproduco audio...");
                                audio.play();
                                break;
                            case 2:
                                System.out.print("Aumenta volume di: ");
                                int incremento = scanner.nextInt();
                                audio.louder(incremento);
                                break;
                            case 3:
                                System.out.print("Diminuisci volume di: ");
                                int decremento = scanner.nextInt();
                                audio.weaker(decremento);
                                break;
                            case 0:
                                break uscitaSottoMenu;
                        }
                    } else if (elemento instanceof Video) {
                        Video video = (Video) elemento;
                        System.out.println("\n1.Play Video\n2.Aumenta Volume\n3.Diminuisci Volume\n4.Aumenta Luminosità\n5.Diminuisci Luminosità\n0.Torna Indietro");
                        int sceltaVideo = scanner.nextInt();
                        switch (sceltaVideo) {
                            case 1:
                            	System.out.println("Riproduco video...");
                                video.play();
                                break;
                            case 2:
                                System.out.print("Aumenta volume di: ");
                                int incremento = scanner.nextInt();
                                video.louder(incremento);
                                break;
                            case 3:
                                System.out.print("Diminuisci volume di: ");
                                int decremento = scanner.nextInt();
                                video.weaker(decremento);
                                break;
                            case 4:
                                System.out.print("Aumenta luminosità di: ");
                                int aumentoLuminosita = scanner.nextInt();
                                video.brighter(aumentoLuminosita);
                                break;
                            case 5:
                                System.out.print("Diminuisci luminosità di: ");
                                int diminuzioneLuminosita = scanner.nextInt();
                                video.darker(diminuzioneLuminosita);
                                break;
                            case 0:
                                break uscitaSottoMenu;
                        }
                    } else if (elemento instanceof Immagine) {
                        Immagine immagine = (Immagine) elemento;
                        System.out.println("\n1.Mostra Immagine\n2.Aumenta Luminosità\n3.Diminuisci Luminosità\n0.Torna Indietro");
                        int sceltaImmagine = scanner.nextInt();
                        switch (sceltaImmagine) {
                            case 1:
                            	System.out.println("Ecco l'immagine...");
                                immagine.show();
                                break;
                            case 2:
                                System.out.print("Aumenta luminosità di: ");
                                int aumentoLuminosita = scanner.nextInt();
                                immagine.brighter(aumentoLuminosita);
                                break;
                            case 3:
                                System.out.print("Diminuisci luminosità di: ");
                                int diminuzioneLuminosita = scanner.nextInt();
                                immagine.darker(diminuzioneLuminosita);
                                break;
                            case 0:
                                break uscitaSottoMenu;
                        }
                    }
                }
                break;
			case 0:
				System.out.println("Arrivederci.");
				break uscita;//uscita menu e ciclo
			}
		}
		scanner.close();
	}

}
