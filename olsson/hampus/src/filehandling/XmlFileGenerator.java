package olsson.hampus.src.filehandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import olsson.hampus.src.containers.People;

public class XmlFileGenerator {
    public static void generateXmlFile(People people, String filename) {
        try (BufferedWriter myBufferedWriter = new BufferedWriter(new FileWriter(filename))) {
            String xmlOutput = people.generateXml();
            myBufferedWriter.write(xmlOutput);
        } catch (IOException e) {
            System.out.println("ERROR: failed to open output file.");
        }
    }
}
