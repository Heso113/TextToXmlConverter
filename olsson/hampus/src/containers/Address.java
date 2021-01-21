package olsson.hampus.src.containers;

public class Address {
    private String street;
    private String city;
    private String zipCode;

	public Address() {

	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String generateXml(int numberOfIndents) {
		StringBuilder stringBuilder = new StringBuilder();
		String baseIndent = "";
		for (int i = 0; i < numberOfIndents; i++) {
			baseIndent += "\t";
		}
		stringBuilder.append(baseIndent).append("<address>\n");
		stringBuilder.append(baseIndent).append("\t").append("<street>").append(this.street).append("</street>\n");
		stringBuilder.append(baseIndent).append("\t").append("<city>").append(this.city).append("</city>\n");
		stringBuilder.append(baseIndent).append("\t").append("<zipcode>").append(this.zipCode).append("</zipcode>\n");
		stringBuilder.append(baseIndent).append("</address>\n");
		return stringBuilder.toString();
	}

}