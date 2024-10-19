package prodotti;

import java.time.LocalDate;

public class Alimentari extends Prodotti {
	private LocalDate expiryDay;

	public LocalDate getExpiryDay() {
		return expiryDay;
	}

	public void setExpiryDay(LocalDate expiryDay) {
		this.expiryDay = expiryDay;
	}
	
	public Alimentari(int barcode, float unitPrice, String description, LocalDate expiryDay) {
		super(barcode, unitPrice, description);
		this.expiryDay= expiryDay;
	}

	@Override
	public float applicaSconto() {
		LocalDate today = LocalDate.now();
		long remainingDays = (getExpiryDay().toEpochDay()-today.toEpochDay());
		if (remainingDays<10) {
			float discount= (getUnitPrice()*20)/100;
			return getUnitPrice()-discount;
		}else {
			return super.applicaSconto();
		}
	}

	@Override
	public String toString() {
		
		return super.toString()+ ", scadenza= "+getExpiryDay();
	}
	
	

}
