package prodotti;

public class NonAlimentari extends Prodotti {
	private String material;

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public NonAlimentari(int barcode, float unitPrice, String description, String material) {
		super(barcode, unitPrice, description);
		this.material= material;
		
	}

	@Override
	public float applicaSconto() {
		if (material.equals("carta") || material.equals("vetro") || material.equals("plastica")) {
			float discount= (getUnitPrice()*10)/100;
			return getUnitPrice()-discount;
		}else {
			super.applicaSconto();
		}
		return 0;
	}

	@Override
	public String toString() {
		
		return super.toString()+", materiale= "+getMaterial();
	}
	
	

}
