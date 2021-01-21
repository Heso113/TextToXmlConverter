package olsson.hampus.src.filehandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import olsson.hampus.src.containers.Address;
import olsson.hampus.src.containers.Person;

public class FileParser {
    public static List<Person> ParseDataFromFile(String filepath) {
        try {
            List<Person> persons = new ArrayList<Person>();
            BufferedReader myBufferedReader = new BufferedReader(new FileReader(filepath));
            String line;
            Person person = null;
            Person familyMember = null;
            while((line = myBufferedReader.readLine()) != null) {
                char character = line.charAt(0);
                line = line.substring(2);
                switch (character) {
                    case 'P':
                    {
                        if (person == null) {
                            person = new Person();
                        } else {
                            if (familyMember != null) {
                                person.getFamily().add(familyMember);
                                familyMember = null;
                            }
                            persons.add(person);
                            person = new Person();
                        }
                        person.setFirstName(parseField(line));
                        line = line.substring(line.indexOf('|') + 1);
                        person.setLastName(parseField(line));
                        break;
                    }
                    case 'T':
                    {
                        if (familyMember != null) {
                            familyMember.setMobilePhoneNumber(parseField(line));
                            line = line.substring(line.indexOf('|') + 1);
                            familyMember.setLandlineNumber(parseField(line));
                        } else {;
                            person.setMobilePhoneNumber(parseField(line));
                            line = line.substring(line.indexOf('|') + 1);
                            person.setLandlineNumber(parseField(line));
                        }
                        break;
                    }
                    case 'A':
                    {
                        Address address = new Address();
                        address.setStreet(parseField(line));
                        line = line.substring(line.indexOf('|') + 1);
                        address.setCity(parseField(line));
                        line = line.substring(line.indexOf('|') + 1);
                        address.setZipCode(parseField(line));
                        if (familyMember != null) {
                            familyMember.setAddress(address);
                        } else {
                            person.setAddress(address);
                        }
                        break;
                    }
                    case 'F':
                    {
                        if (familyMember != null) {
                            person.getFamily().add(familyMember);      
                        }
                        familyMember = new Person();

                        familyMember.setFirstName(parseField(line));
                        line = line.substring(line.indexOf('|') + 1);
                        familyMember.setBirthYear(parseField(line));
                        break;
                    }
                    default:
                    {
                        System.out.println("Error: invalid line prefix.");
                        break;
                    }
                }
            };
            persons.add(person);
            persons.stream().forEach(nextPerson -> printPerson(nextPerson));
            myBufferedReader.close();
            return persons;
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File could not be found!");
        } catch (IOException e) {
            System.out.println("ERROR: Error triggered by readLine()");
        }
        return null;
    }

    private static String parseField(String line) {
        if (line.length() <= 0) {
            System.out.println("ERROR: no more characters to read!");
            return null;
        }
        StringBuilder sBuilder = new StringBuilder();
        int index = 0;
        while (index < line.length() && line.charAt(index) != '|') {
            sBuilder.append(line.charAt(index));
            index++;
        }
        return sBuilder.toString(); 
    }

    private static void printPerson(Person person) {
        System.out.println("************************");
        System.out.println("Name: " + person.getFirstName() + " " + person.getLastName());
        System.out.println("Telephone: " + "M: " + person.getMobilePhoneNumber() + " P: " + person.getLandlineNumber());
        System.out.println("Address: " + person.getAddress().getCity() + " " + person.getAddress().getStreet() + " " + person.getAddress().getZipCode());
        System.out.println("FAMILY MEMBERS:");
        for (int i = 0; i < person.getFamily().size(); i++) {
          Person familyMember = person.getFamily().get(0);
          System.out.println("Name: " + familyMember.getFirstName());
          System.out.println("BirthYear: " + familyMember.getBirthYear());
          System.out.println("Telephone: " + "M: " + familyMember.getMobilePhoneNumber() + " P: " + familyMember.getLandlineNumber());
          System.out.println("Address: " + familyMember.getAddress().getCity() + " " + familyMember.getAddress().getStreet() + " " + familyMember.getAddress().getZipCode());
        }
        System.out.println("************************");
    }
}
