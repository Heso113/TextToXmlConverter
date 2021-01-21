package olsson.hampus.src.containers;

import java.util.ArrayList;
import java.util.List;

public class People {
    private List<Person> persons = new ArrayList<Person>();

    public People(List<Person> persons) {
        this.persons = persons;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public String generateXml() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<people>\n");
        for(Person person: persons) {
            stringBuilder.append(person.generateXml(1));
        }
        stringBuilder.append("</people>\n");
        return stringBuilder.toString();
    }
    
}
