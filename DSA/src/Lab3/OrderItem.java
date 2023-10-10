package Lab3;

public class OrderItem {
	private Product p;
	private int quality;

	public OrderItem(Product p, int quality) {
		super();
		this.p = p;
		this.quality = quality;
	}

	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}
	
}