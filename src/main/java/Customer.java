import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utils.StringUtils;

public class Customer {
	public static Map<String,Customer> customers = new HashMap<String,Customer>();
	private String id;
	private String firstname;
	private String lastname;
	private String telephone;
	private String street1; 
	private String street2; 
	private String city;
	private String state; 
	private String zipcode; 
	private String country; 
	private String mail;

	public Customer(String id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Customer(String id, String firstname, String lastname, String telephone, String street1, String street2, String city , String 	state , String zipcode , String country, String mail) {
		this(id,firstname,lastname);
		 this.telephone = telephone; 
		 this.street1 =  street1;
		 this.street2 = street2 ;
		 this.city = city;
		 this.state  = state;
		 this.zipcode = zipcode;
		 this.country = country; 
		 this.mail = mail;
	}

	public String getId() {
		return id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public boolean checkId(String id) {
		return !StringUtils.isEmptyOrNull(id);
	}


	public boolean checkData() {
		if(checkId(id) && !StringUtils.isEmptyOrNull(firstname) &&  !StringUtils.isEmptyOrNull(lastname)
				&& !StringUtils.isEmptyOrNull(telephone)&&  !StringUtils.isEmptyOrNull(street1) && !StringUtils.isEmptyOrNull(street2)
				&& !StringUtils.isEmptyOrNull(city) && !StringUtils.isEmptyOrNull(state) && !StringUtils.isEmptyOrNull(zipcode) 
				&& !StringUtils.isEmptyOrNull(country) && !StringUtils.isEmptyOrNull(mail))
					return true;
			return false;
	}
	
	public String getCheckDataError() {
		if(StringUtils.isEmptyOrNull(this.id))
			return "Invalid id";
		if(StringUtils.isEmptyOrNull(this.firstname))
			return "Invalid first name";
		if(StringUtils.isEmptyOrNull(this.lastname))
			return "Invalid last name";
		return null;
	}
	
	
	public boolean checkMail() {
		if(this.mail.length() <= 6) {
			return false;
		}
		if(this.mail.length() >= "engagelejeuquejelegagne@duel-de-mots.fr".length()) {
			return false;
		}
		if(this.mail.endsWith("x.com")) {
			return false;
		}

		if(this.mail.endsWith("us")) {
			return false;
		}
		Pattern VALID_EMAIL_ADDRESS_REGEX = 
			    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(this.mail);
        return matcher.matches();
	}
	
	public static Customer find(String id) {
		if(Customer.customers.containsKey(id)) {
			return Customer.customers.get(id);
		}
		return null;
	}
	
	public static boolean remove(String id) {
		Customer customer= Customer.find(id);
		if(customer == null) {
			return false;
		}
		Customer.customers.remove(customer.id);
		return true;
	}
	
	public static boolean insert(Customer customer) {
		Customer.customers.put(customer.id,customer);
		return true;
	}
	

	private int getUniqueId() {
		String s = null;
		int result = 0;
		do {
			result = (int) (Math.random() * 100000);
			s = Integer.toString(result);
			if ( Customer.find(s) == null )
				return result;
		} while ( true );
	}


}
