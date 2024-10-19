package multimedial;
import interfacce.*;

public class Audio extends ElementoMultimediale implements Play {
	//campi
	private int durata;
	private int volume;
	
	//getter
	public int getDurata() {
		return durata;
	}
	
	//setter
	public void setDurata(int durata) {
		this.durata = durata;
		this.volume=0;//imposto il volume di default
	}
	
	//costruttore
	public Audio(String titolo, int durata) {
		super(titolo);
		this.durata=durata;
		
	}
	
	//metodi interfaccia Play
	@Override
	public void play() {
		for (int i = 0; i < getDurata(); i++) {
			System.out.println(getTitolo()); //stampa il titolo tante volte quanto e' la durata
		}
	}

	@Override
	public void louder(int v) {
		volume+=v;//aggiungo il valore passato come parametro
		if ((volume)<=16) {//16 e' il volume massimo impostabile
			if (v >= volume) {
				System.out.print(getTitolo()+ " volume aggiornato: ");
				for (int i = 0; i < volume; i++) {
					System.out.print((char)33);//stampa '!' tante volte quanto e' stato impostato il volume
				}
				System.out.println();
			}
		}else
			System.out.println("Volume massimo raggiunto");//se il volume e' superiore a 16
	}

	@Override
	public void weaker(int v) {
		if (v>=0) {// verifica se il parametro e intero positivo
			volume-=v;// decremento volume 
			System.out.print(getTitolo()+ " volume aggiornato: ");
			for (int i = volume; i > 0; i--) {
				System.out.print((char)33);//stampo il nuovo valore di volume
			}
			System.out.println();
		}else
			System.out.println("Impossibile impostare un volume negativo!");//se il volume e' negativo
	}

	@Override
	public String toString() {
		return super.toString()+" Audio [durata=" + durata + ", volume=" + volume + "]";
	}

}
