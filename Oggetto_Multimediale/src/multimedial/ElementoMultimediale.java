package multimedial;

public abstract class ElementoMultimediale {
	//campo
	private String titolo;
	
	//getter
	public String getTitolo() {
		return titolo;
	}
	//setter
	public void setTitolo(String titolo) {
		this.titolo = titolo;
		
		
	}
	
	//costruttore
	public ElementoMultimediale(String titolo) {
		setTitolo(titolo);
	}
	
	//metodo
	@Override
	public String toString() {
		return "ElementoMultimediale [titolo=" + titolo + "]";
	}
}
