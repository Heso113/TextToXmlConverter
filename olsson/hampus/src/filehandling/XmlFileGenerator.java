package olsson.hampus.src.filehandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import olsson.hampus.src.containers.Address;
import olsson.hampus.src.containers.Person;

public class XmlFileGenerator {
    public static boolean GenerateXmlFile(List<Person> persons, String filename) {
        try (BufferedWriter myBufferedWriter = new BufferedWriter(new FileWriter(filename))) {
            StringBuilder stringBuilder = new StringBuilder();
            appendStartTag(stringBuilder, "people", 0);
            for (int i = 0; i < persons.size(); i++) {
                appendPerson(stringBuilder, persons.get(i), 1);
            }
            appendEndTag(stringBuilder, "people", 0);
            myBufferedWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            System.out.println("ERROR: failed to open output file.");
            return false;
        }       
        return true;
    }

    private static void appendPerson(StringBuilder stringBuilder, Person person, int numberOfIndents) {
        appendStartTag(stringBuilder, "person", numberOfIndents);
        appendFullLine(stringBuilder, "firstname", numberOfIndents + 1, person.getFirstName());
        appendFullLine(stringBuilder, "lastname", numberOfIndents + 1, person.getLastName());
        if (person.getAddress() != null) {
            appendAddress(stringBuilder, numberOfIndents + 1, person.getAddress());
        }
        if (person.getMobilePhoneNumber() != null || person.getLandlineNumber() != null) {
            appendPhone(stringBuilder, numberOfIndents + 1, person.getMobilePhoneNumber(), person.getLandlineNumber());
        }
        if (person.getFamily().size() > 0) {
            for (int i = 0; i < person.getFamily().size(); i++) {
                appendFamilyMember(stringBuilder, person.getFamily().get(i), numberOfIndents + 1);
            }
        }
        appendEndTag(stringBuilder, "person", numberOfIndents);
    }

    private static void appendFamilyMember(StringBuilder stringBuilder, Person familyMember, int numberOfIndents) {
        appendStartTag(stringBuilder, "family", numberOfIndents);
        appendFullLine(stringBuilder, "name", numberOfIndents + 1, familyMember.getFirstName());
        appendFullLine(stringBuilder, "born", numberOfIndents + 1, familyMember.getBirthYear());
        if (familyMember.getAddress() != null) {
            appendAddress(stringBuilder, numberOfIndents + 1, familyMember.getAddress());
        }
        if (familyMember.getLandlineNumber() != null || familyMember.getMobilePhoneNumber() != null) {
            appendPhone(stringBuilder, numberOfIndents + 1, familyMember.getMobilePhoneNumber(), familyMember.getLandlineNumber());
        }
        appendEndTag(stringBuilder, "family", numberOfIndents);
    }

    private static void appendFullLine(StringBuilder stringBuilder, String tag, int numberOfIndents, String value) {
        appendIndents(stringBuilder, numberOfIndents);
        stringBuilder.append("<").append(tag).append(">").append(value).append("</").append(tag).append(">\n");
    }

    private static void appendStartTag(StringBuilder stringBuilder, String tag, int numberOfIndents) {
        appendIndents(stringBuilder, numberOfIndents);
        stringBuilder.append("<").append(tag).append(">\n");
    }

    private static void appendEndTag(StringBuilder stringBuilder, String tag, int numberOfIndents) {
        appendIndents(stringBuilder, numberOfIndents);
        stringBuilder.append("</").append(tag).append(">\n");
    }

    private static void appendIndents(StringBuilder stringBuilder, int numberOfIndents) {
        for(int i = 0; i < numberOfIndents; i ++) {
            stringBuilder.append("\t");
        }
    }

    private static void appendAddress(StringBuilder stringBuilder, int numberOfIndents, Address address) {
        appendStartTag(stringBuilder,   "address",  numberOfIndents);
        appendFullLine(stringBuilder,   "street",   numberOfIndents + 1, address.getStreet());
        appendFullLine(stringBuilder,   "city",     numberOfIndents + 1, address.getCity());
        appendFullLine(stringBuilder,   "zipcode",  numberOfIndents + 1, address.getZipCode());
        appendEndTag(stringBuilder,     "address",  numberOfIndents);
    }

    private static void appendPhone(StringBuilder stringBuilder, int numberOfIndents, String mobile, String landline) {
        appendStartTag(stringBuilder, "phone", numberOfIndents);
        if (mobile != null) {
            appendFullLine(stringBuilder, "mobile", numberOfIndents + 1, mobile);
        }
        if (landline != null) {
            appendFullLine(stringBuilder, "landline", numberOfIndents + 1, landline);
        }
        appendEndTag(stringBuilder, "phone", numberOfIndents);
    }
    
}
