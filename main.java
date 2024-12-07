import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class main {

    /**
     * Creates a file with the specified filename and writes the content
     * 
     * @param filename File created
     * @param content  The content to write
     * @throws IOException ERROR
     */
    public static void createAndWriteFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }


    public static void main(String[] args) {
        String filename = "College101.txt";
        try {
            // Test creating and writing to a file
            createAndWriteFile(filename, "This is college advice: \nGet good grades\nHave Funnn\nGraduiate on time");
            System.out.println("File created successfully.");


        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}