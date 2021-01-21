package olsson.hampus.src.containers;

public class FamilyMember {
    private String name;
    private String birthYear;
    private Address address;
    private Phone phoneNumbers;

    public FamilyMember() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthYear() {
        return this.birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Phone getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public void setPhoneNumbers(Phone phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String generateXml(int numberOfIndents) {
        StringBuilder stringBuilder = new StringBuilder();
        String baseIndent = "";
        for (int i = 0; i <numberOfIndents; i++) {
            baseIndent += "\t";
        }
        stringBuilder.append(baseIndent).append("<family>\n");
        stringBuilder.append(baseIndent).append("\t").append("<name>").append(this.name).append("</name>\n");
        stringBuilder.append(baseIndent).append("\t").append("<born>").append(this.birthYear).append("</born>\n");
        if (this.address != null) {
            stringBuilder.append(this.address.generateXml(numberOfIndents + 1));
        }
        if (this.phoneNumbers != null) {
            stringBuilder.append(this.phoneNumbers.generateXml(numberOfIndents + 1));
        }
        stringBuilder.append(baseIndent).append("</family>\n");
        return stringBuilder.toString();
    }
}
