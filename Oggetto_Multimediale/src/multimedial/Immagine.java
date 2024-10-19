package multimedial;
import interfacce.*;

public class Immagine extends ElementoMultimediale implements ShowImage,Brightness{
	//campo
	private int luminosita;

	//costruttore
	public Immagine(String titolo) {
		super(titolo);
		this.luminosita=0;//imposto il valore di default
	}
	
	//metodi interfaccia Brightness
		@Override
		public void brighter(int l) {
			luminosita+=l;//aggiungo il valore passato come parametro
			if (luminosita<=16) {//16 è la luminosita' massima
				System.out.print(getTitolo()+ " luminosita aggiornata: ");
				for (int i = 0; i < luminosita; i++) {
					System.out.print((char)42);//stampa '*' tante volte quanto e' stata impostata la luminosita'
				}
				System.out.println();
			}else
				System.out.println("Luminosita massima raggiunta");//se la luminosita' e' superiore a 16
		}

		@Override
		public void darker(int l) {
			if (l>=0) {//controllo che il parametro sia un intero positivo
				luminosita-=l;//decremento il valore di luminosita'
				System.out.print(getTitolo()+ " luminosita aggiornata: ");
				for (int i = luminosita; i > 0; i--) {
					System.out.print((char)42);//stampo il nuovo valore di luminosita'
				}
				System.out.println();
			}else
				System.out.println("Impossibile impostare una luminosita negativa!");//se la luminosita' e' negativa
		}

	//metodo interfaccia ShowImage
	@Override
	public void show() {
		System.out.println(getTitolo());//stampo il titolo del file immagine
	}

	@Override
	public String toString() {
		return super.toString()+" Immagine [luminosita=" + luminosita + "]";
	}

}
