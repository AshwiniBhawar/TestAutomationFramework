package com.qa.pojo;

public class AddressPOJO {
	
	private String company;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String zipcode;
	private String homePhoneNumber;
	private String mobileNumber;
	private String otherInformation;
	private String addressAlias;
	private String state;
	
	public AddressPOJO(String company, String addressLine1, String addressLine2, String city, String zipcode,
			String homePhoneNumber, String mobileNumber, String otherInformation, String addressAlias, String state) {
		this.company = company;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.zipcode = zipcode;
		this.homePhoneNumber = homePhoneNumber;
		this.mobileNumber = mobileNumber;
		this.otherInformation = otherInformation;
		this.addressAlias = addressAlias;
		this.state = state;
	}

	public String getCompany() {
		return company;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public String getCity() {
		return city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getOtherInformation() {
		return otherInformation;
	}

	public String getAddressAlias() {
		return addressAlias;
	}

	public String getState() {
		return state;
	}

	@Override
	public String toString() {
		return "AddressPOJO [company=" + company + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", city=" + city + ", zipcode=" + zipcode + ", homePhoneNumber=" + homePhoneNumber + ", mobileNumber="
				+ mobileNumber + ", otherInformation=" + otherInformation + ", addressAlias=" + addressAlias
				+ ", state=" + state + "]";
	}
		

}
