package prodotti;

public class Prodotti {
	private int barcode;
	private float unitPrice;
	private String description;
	
	public int getBarcode() {
		return barcode;
	}
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Prodotti(int barcode, float unitPrice, String description) {
		this.barcode = barcode;
		this.unitPrice = unitPrice;
		this.description = description;
	}
	
	public float applicaSconto() {
		float discount= (getUnitPrice()*5)/100;
		return getUnitPrice()-discount;
	}
	@Override
	public String toString() {
		return "barcode= " + barcode + ", description= " + description+", unitPrice= " + unitPrice;
	}
	
}
