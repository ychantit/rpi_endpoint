package rpi.srv.endpoint;

public class Transaction {

	private String terminal_id;
	private String terminal_country;
	
	private String card_type;
	private String card_scheme;
	private String card_issuing_country;
	
	private String vertical;
	
	private String id;
	
	private String type;
	private String date;
	private String amount;
	
	private String pan;
	private String pan_expdate;
    
	private String twitterId;
	
	private String productCat;
	private String product;
	private String nbrItems;
	
	private String merchant;
	private String location;
	
	public String getTerminal_id() {
		return terminal_id;
	}


	public void setTerminal_id(String terminal_id) {
		this.terminal_id = terminal_id;
	}


	public String getTerminal_country() {
		return terminal_country;
	}


	public void setTerminal_country(String terminal_country) {
		this.terminal_country = terminal_country;
	}


	public String getCard_type() {
		return card_type;
	}


	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}


	public String getCard_scheme() {
		return card_scheme;
	}


	public void setCard_scheme(String card_scheme) {
		this.card_scheme = card_scheme;
	}


	public String getCard_issuing_country() {
		return card_issuing_country;
	}


	public void setCard_issuing_country(String card_issuing_country) {
		this.card_issuing_country = card_issuing_country;
	}


	public String getVertical() {
		return vertical;
	}


	public void setVertical(String vertical) {
		this.vertical = vertical;
	}

	
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
		return nbrItems;
	}
	public void setNbrItems(String nbrItems) {
		this.nbrItems = nbrItems;
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
		return terminal_id + "," + terminal_country + "," + card_type + "," + card_scheme + "," +
				card_issuing_country + "," + vertical + "," +
				id + "," + type + "," + date + "," + amount + "," + pan + ","
				+ pan_expdate + "," + twitterId + "," + productCat + "," + product + ","
				+ nbrItems + "," + merchant + ","+ location;
	}
	
}
