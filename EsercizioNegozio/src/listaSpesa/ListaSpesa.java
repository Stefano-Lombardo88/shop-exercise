package listaSpesa;

import prodotti.Prodotti;

public class ListaSpesa {

	private Prodotti[] productsPurchased;
	private int articlesNumber;
	private int password;
	
	
	public void setPassword(int password) {
		this.password = password;
	}


	public int getPassword() {
		return password;
	}


	public Prodotti[] getProductsPurchased() {
		return productsPurchased;
	}


	public void setProductsPurchased(Prodotti[] productsPurchased) {
		this.productsPurchased = productsPurchased;
	}


	public int getArticlesNumber() {
		return articlesNumber;
	}


	public void setArticlesNumber(int articlesNumber) {
		this.articlesNumber = articlesNumber;
	}
	
	public ListaSpesa() {}
	

	//costruttore array carrello ListaSpesa
	public ListaSpesa(int arrayDimension) {
		setProductsPurchased(productsPurchased = new Prodotti[arrayDimension]);
		this.articlesNumber = 0;
	}

	// Metodo per verificare la password
    public boolean verifyPassword(int password) {
    	setPassword(47457);
    	return getPassword() == password;
    }

	
	//metodo per aggiungere prodotti al carrello
	public void addArticle(Prodotti article) {
		if(articlesNumber<productsPurchased.length) {
			productsPurchased[articlesNumber++]= article;
		}else {
			System.out.println("impossibile aggiungere articoli! Carrello pieno!");
		}
	}
	
	//metodo per cancellare prodotti carrello
	public void removeArticle(int arrayPosition) {
		try {
			productsPurchased[arrayPosition-1]= null;
			System.out.println("Prodotto rimosso da magazzino");
			System.out.println();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Nessun elemento presente alla posizione indicata!");
			System.out.println();
		}
	}
	
	//metodo per visionare dettaglio carello
	public void shoppingCartDetail() {
		int indice = 1;
		for (Prodotti prodotti : productsPurchased) {
			if (prodotti !=null) {
				System.out.println(indice+"."+prodotti.toString());
			}
			indice++;
		}
	}
	
	public Prodotti findProducts(int posizione) {
		posizione-=1;//decremento di 1 il valore passato come parametro perche' l'array parte da base 0
		if (posizione>=0 || posizione < productsPurchased.length-1) {//controllo che il valore inserito rientri nella lunghezza array
			return productsPurchased[posizione];
		}else
			System.out.println("Nessun file presente alla posizione indicata!");
			return null;
	}
	
}
