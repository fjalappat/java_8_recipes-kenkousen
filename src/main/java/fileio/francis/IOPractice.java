package fileio.francis;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOPractice {

    public static List<Person> personList;

    static {
        personList = new ArrayList<>();
        personList.add(new Person(15, "female", "Cathy"));
        personList.add(new Person(23, "male", "Jake"));
        personList.add(new Person(73, "male", "Ryan"));
        System.out.println("Person List successfully created with 3 objects:");
        personList.stream().forEach(p -> System.out.println(p));
        System.out.println("-------------------------------------------------");
    }

    public static void main(String[] args) {
        IOPractice practice = new IOPractice();
        try {
            practice.practiceObjectStreams();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void practiceObjectStreams() throws IOException, ClassNotFoundException {
        File file = new File("IOPractice_personList.dat");
        writeObjectListToFile(file);
        readObjectListFromFile(file);
    }

    //  1. write Serializable classed to ObjectStream,only so object values are persisted properly
    //  2. Instance variables marked as transient are ephemeral(short lived) and hence will be persisted to stream/file with default value(i.e. 0 for primitive numbers and null for Objects)
    private void writeObjectListToFile(File outputFile) throws IOException {
        System.out.println("\n*************************\nEntering writeObjectListToFile()");
        try (ObjectOutputStream objOutStream = new ObjectOutputStream(new FileOutputStream(outputFile))) {
            objOutStream.writeObject(personList);
        }
        System.out.println("Object list successfully persisted to file:"+outputFile.getPath()+ " with file size(bytes)="+outputFile.length());
    }

    private void readObjectListFromFile(File inputFile) throws IOException, ClassNotFoundException {
        System.out.println("\n*************************\nEntering readObjectListFromFile()");
        try (ObjectInputStream objInStream = new ObjectInputStream(new FileInputStream(inputFile))){
            List<Person> list = (List<Person>) objInStream.readObject();
            System.out.println("De-serialization process complete, retrieved objects from Person list  below:");
            System.out.println("De-serialization process complete!");
            list.stream().forEach(p -> System.out.println(p));
        }
    }


}
