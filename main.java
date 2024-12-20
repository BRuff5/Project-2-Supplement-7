import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
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


     /**
     * Reads the content from file and returns it as a string.
     * 
     * @param filename The name of the file to read 
     * @return A string containing content
     * @throws IOException Error
     */

    public static String readFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        }
        return content.toString().trim();
    }

    /**
     * Appends the given content to the specified file.
     * 
     * @param filename The name of the file 
     * @param content  to append
     * @throws IOException IError
     */
    public static void appendToFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(content);
            writer.newLine(); //
        }
    }

    public static void main(String[] args) {
        String filename = "College101.txt";
        try {

            //Writing to a file
            createAndWriteFile(filename, "This is my college advice: \nGet good grades\nHave Funnn\nGraduiate on time");
            System.out.println("File created successfully.");

            //Read file
            String fileContent = readFile(filename);
            System.out.println("File content:\n" + fileContent);

            // Test appending to the file
            appendToFile(filename, "\nOne last thing: program TERMINATED");
            System.out.println("Appended successfull!!");

            // Verify the content after appending
            String updatedContent = readFile(filename);
            System.out.println("Updated file content:\n" + updatedContent);

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}