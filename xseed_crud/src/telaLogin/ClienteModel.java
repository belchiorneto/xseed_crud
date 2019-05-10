package telaLogin;

import java.util.Date;

public class ClienteModel {
	private long id;
	private String name;
	private String adress;
	private double credit;
	private Date expiration;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public Date getExpiration() {
		return expiration;
	}
	public void setExpiration(Date date) {
		this.expiration = date;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}	
		
}
