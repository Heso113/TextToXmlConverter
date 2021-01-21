package olsson.hampus.src;

import java.util.List;

import olsson.hampus.src.containers.People;
import olsson.hampus.src.containers.Person;
import olsson.hampus.src.filehandling.FileParser;
import olsson.hampus.src.filehandling.XmlFileGenerator;

public class Application {
    public static void main(String[] args) {
        List<Person> persons = FileParser.ParseDataFromFile("./resources/input.txt");
        XmlFileGenerator.GenerateXmlFile(new People(persons), "./output/output.xml");
    }
}