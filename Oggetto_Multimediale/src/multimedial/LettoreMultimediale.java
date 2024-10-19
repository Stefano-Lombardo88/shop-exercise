package multimedial;

public class LettoreMultimediale {
	
	//campi
	private ElementoMultimediale[] file;
	private boolean aggiunto = false;// variabile per determinare se il file e stato aggiunto all'array
	
	//costruttore array
	public LettoreMultimediale(int capacitaMassima) {
		this.file= new ElementoMultimediale[capacitaMassima];
	}
	//metodi
	public void aggiungielementoMultimediale(ElementoMultimediale e) {
		for (int i = 0; i < file.length; i++) {
			if(file[i]== null) { //controllo se la posizione dell'array e' libera
				file[i]= e;
				System.out.println("File aggiunto con successo");
				System.out.println();
				aggiunto = true; //indica che l'elemento e' stato correttamente aggiunto
				break;//esce dal ciclo
			}else
				aggiunto = false;
		}
		
		if (aggiunto == false) {// se l'array e' pieno passa a questa condizione
			System.out.println("Lettore multimediale pieno");
		}
	}
	
	public ElementoMultimediale trovaFile(int posizione) {
		posizione-=1;//decremento di 1 il valore passato come parametro perche' l'array parte da base 0
		if (posizione>=0 || posizione < file.length-1) {//controllo che il valore inserito rientri nella lunghezza array
			return file[posizione];
		}else
			System.out.println("Nessun file presente alla posizione indicata!");
			return null;
		
	}
	
	public void situazioneLettore() {
		int indice=1;//variabile che indica in che posizione dell'array e' l'oggetto inserito
		for (ElementoMultimediale elementoMultimediale : file) {
			if (elementoMultimediale!=null) {//stampo solo posizioni che contengono elementi
				System.out.println(indice+"."+elementoMultimediale.getTitolo());
				
			}
			indice++;//incremento posizione
		}
	}
}
