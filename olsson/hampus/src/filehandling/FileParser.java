package olsson.hampus.src.filehandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import olsson.hampus.src.containers.Address;
import olsson.hampus.src.containers.FamilyMember;
import olsson.hampus.src.containers.Person;
import olsson.hampus.src.containers.Phone;

public class FileParser {
    public static List<Person> parseDataFromFile(String filepath) {
        List<Person> persons = new ArrayList<Person>();
        try (BufferedReader myBufferedReader = new BufferedReader(new FileReader(filepath))) {
            String line;
            Person person = null;
            FamilyMember familyMember = null;
            while((line = myBufferedReader.readLine()) != null) {
                char character = line.charAt(0);
                switch (character) {
                    case 'P':
                    {
                        familyMember = null;
                        person = parsePerson(line);
                        persons.add(person);
                        break;
                    }
                    case 'T':
                    {
                        Phone phoneNumbers = parsePhone(line);
                        if (familyMember != null) {
                            familyMember.setPhoneNumbers(phoneNumbers);
                        } else {
                            person.setPhoneNumbers(phoneNumbers);
                        }
                        break;
                    }
                    case 'A':
                    {
                        Address address = parseAddress(line);
                        if (familyMember != null) {
                            familyMember.setAddress(address);
                        } else {
                            person.setAddress(address);
                        }
                        break;
                    }
                    case 'F':
                    {
                        familyMember = parseFamilyMember(line);
                        person.getFamilyMembers().add(familyMember);
                        break;
                    }
                    default:
                    {
                        System.out.println("Error: invalid line prefix.");
                        break;
                    }
                }
            };
            return persons;
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File could not be found!");
        } catch (IOException e) {
            System.out.println("ERROR: Error triggered by readLine()");
        }
        return persons;
    }

    private static Person parsePerson(String line) {
        String[] parts = line.split("\\|");
        Person person = new Person();
        if (parts.length > 1)
            person.setFirstName(parts[1]);
        if (parts.length > 2)
            person.setLastName(parts[2]);
        return person;
    }

    private static Address parseAddress(String line) {
        String[] parts = line.split("\\|");
        Address address = new Address();
        if (parts.length > 1)
            address.setStreet(parts[1]);
        if (parts.length > 2)
            address.setCity(parts[2]);
        if (parts.length > 3)
            address.setZipCode(parts[3]);
        return address;
    }

    private static Phone parsePhone(String line) {
        String[] parts = line.split("\\|");
        Phone phoneNumbers = new Phone();
        if (parts.length > 1)
            phoneNumbers.setMobilePhoneNumber(parts[1]);
        if (parts.length > 2)
            phoneNumbers.setLandlinePhoneNumber(parts[2]);
        return phoneNumbers;
    }

    private static FamilyMember parseFamilyMember(String line) {
        String[] parts = line.split("\\|");
        FamilyMember familyMember = new FamilyMember();
        if (parts.length > 1)
            familyMember.setName(parts[1]);      
        if (parts.length > 2)
            familyMember.setBirthYear(parts[2]);
        return familyMember;
    }
}
