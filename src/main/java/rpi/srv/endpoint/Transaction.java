package rpi.srv.endpoint;

public class Transaction {

	private String id;
	
	private String type;
	private String date;
	private String amount;
	
	private String pan;
	private String pan_expdate;
    
	private String twitterId;
	
	private String productCat;
	private String product;
	private String NbrItems;
	
	private String merchant;
	private String location;
	
	public Transaction() {
		super();
	}
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getPan_expdate() {
		return pan_expdate;
	}
	public void setPan_expdate(String pan_expdate) {
		this.pan_expdate = pan_expdate;
	}
	public String getTwitterId() {
		return twitterId;
	}
	public void setTwitterId(String twitterId) {
		this.twitterId = twitterId;
	}
	public String getProductCat() {
		return productCat;
	}
	public void setProductCat(String productCat) {
		this.productCat = productCat;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getNbrItems() {
		return NbrItems;
	}
	public void setNbrItems(String nbrItems) {
		NbrItems = nbrItems;
	}
	public String getMerchant() {
		return merchant;
	}
	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}


	@Override
	public String toString() {
		return id + "," + type + "," + date + "," + amount + "," + pan + ","
				+ pan_expdate + "," + twitterId + "," + productCat + "," + product + ","
				+ NbrItems + "," + merchant + ","+ location;
	}
	
}
