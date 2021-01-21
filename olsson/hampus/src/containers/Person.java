package olsson.hampus.src.containers;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String firstName;
    private String lastName;

    private Phone phoneNumbers;
    private Address address;
    private List<FamilyMember> familyMembers = new ArrayList<FamilyMember>();

    public Person() {

    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Phone getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Phone phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<FamilyMember> getFamilyMembers() {
        return this.familyMembers;
    }

    public void setFamily(List<FamilyMember> familyMembers) {
        this.familyMembers = familyMembers;
    }  

    public String generateXml(int numberOfIndents) {
        StringBuilder stringBuilder = new StringBuilder();
        String baseIndent = "";
        for (int i = 0; i < numberOfIndents; i++) {
            baseIndent += "\t";
        }
        stringBuilder.append(baseIndent).append("<person>\n");
        stringBuilder.append(baseIndent).append("\t").append("<firstname>").append(this.firstName).append("</firstname>\n");
        stringBuilder.append(baseIndent).append("\t").append("<lastname>").append(this.lastName).append("</lastname>\n");
        if(this.address != null) {
            stringBuilder.append(this.address.generateXml(numberOfIndents + 1));
        }
        if(this.phoneNumbers != null) {
            stringBuilder.append(this.phoneNumbers.generateXml(numberOfIndents + 1));
        }
        if(this.familyMembers.size() > 0) {
            for (int j = 0; j < this.familyMembers.size(); j++) {
                stringBuilder.append(this.familyMembers.get(j).generateXml(numberOfIndents + 1));
            }
        }
        stringBuilder.append(baseIndent).append("</person>\n");
        return stringBuilder.toString();
    }
}
