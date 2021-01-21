package olsson.hampus.src.filehandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import olsson.hampus.src.containers.People;

public class XmlFileGenerator {
    public static boolean GenerateXmlFile(People people, String filename) {
        try (BufferedWriter myBufferedWriter = new BufferedWriter(new FileWriter(filename))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(people.generateXml());
            myBufferedWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            System.out.println("ERROR: failed to open output file.");
            return false;
        }       
        return true;
    }
}
