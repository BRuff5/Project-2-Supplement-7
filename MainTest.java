import org.junit.*;

import java.io.File;
import java.io.IOException;

public class MainTest {

    private final String testFilename = "testCollege101.txt";
    private final String testContent = "This is my college advice: \nGet good grades\nHave fun\nGraduate on time";

    //Test
    public void testCreateAndWriteFile() throws IOException {
        // Call the method to create and write to the file
        main.createAndWriteFile(testFilename, testContent);
        
        // Verify that the file is created
        File file = new File(testFilename);
        assertTrue("File should be created", file.exists());
        
        // Verify the content of the file
        String content = main.readFile(testFilename);
        assertEquals("Content should match the expected content", testContent.trim(), content);
    }

    //Test
    public void testReadFile() throws IOException {
        // Create the file first
        main.createAndWriteFile(testFilename, testContent);
        
        // Now read the file
        String content = main.readFile(testFilename);
        
        // Ensure the content is as expected
        assertEquals("Content should match the expected content", testContent.trim(), content);
    }

    // Cleanup test file after tests are run
    //Test
    public void cleanup() {
        File file = new File(testFilename);
        if (file.exists()) {
            file.delete(); // Delete the test file after tests
        }
    }

    private void assertTrue(String file_should_be_created, boolean exists) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void assertEquals(String content_should_match_the_expected_content, String trim, String content) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}