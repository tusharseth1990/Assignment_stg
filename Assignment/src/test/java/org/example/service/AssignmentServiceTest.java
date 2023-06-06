package org.example.service;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AssignmentServiceTest {

    @Test
    void testFetchApiAndGetUniquePost_Success() {
        // Test with a valid API URL
        String apiUrl = "https://jsonplaceholder.typicode.com/posts/1";

        // Run the method under test
        String result = AssignmentService.fetchApiAndGetUniquePost(apiUrl);

        // Verify the result
        assertEquals("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto", result);
    }

    @Test
    void testFetchApiAndGetUniquePost_Failure() throws IOException{
        // Test with an invalid API URL
        String apiUrl = "https://jsonplaceholder.typicode.com/nonexistent";

        // Run the method under test
        String result = AssignmentService.fetchApiAndGetUniquePost(apiUrl);

        // Verify the result
        assertEquals("", result);
    }

    @Test
    void testFetchApiAndGetUniquePost_EmptyUrl() {
        // Test with a valid API URL
        String apiUrl = "";

        // Run the method under test
        String result = AssignmentService.fetchApiAndGetUniquePost(apiUrl);

        //String expected ="quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto";
        // Verify the result
        assertEquals("", result);

    }

    @Test
    void testCountEachCharacter() {
        // Test with a sample post body
        String test = "HelloWorld";

        // Run the method under test
        int result = AssignmentService.countEachCharacter(test);

        // Verify the result
        assertEquals(7, result);
    }

    @Test
    void testCountEachCharacterWithEmptyBody() {
        // Test with a sample post body
        String test = "";

        // Run the method under test
        int result = AssignmentService.countEachCharacter(test);

        // Verify the result
        assertEquals(0, result);
    }

    @Test
    void testCountEachCharacterWithOnlyNewLine() {
        // Test with a sample post body
        String test = "";

        // Run the method under test
        int result = AssignmentService.countEachCharacter(test);

        // Verify the result
        assertEquals(0, result);
    }


    @Test
    void testCountEachCharacterCaseSensitive() {
        // Test with a sample post body
        String test = "Hhhhttt";

        // Run the method under test
        int result = AssignmentService.countEachCharacter(test.toLowerCase());

        // Verify the result
        assertEquals(2, result);
    }

    @Test
    void testCountEachCharacterCaseSensitiveAndNewLine() {
        // Test with a sample post body
        String test = "Hhhhttt\n";

        // Run the method under test
        int result = AssignmentService.countEachCharacter(test.toLowerCase());

        // Verify the result
        assertEquals(2, result);
    }

    @Test
    void testCountEachCharacterCaseSensitiveNewLineAndSpace() {
        // Test with a sample post body
        String test = "Hhhh ttt\n";

        // Run the method under test
        int result = AssignmentService.countEachCharacter(test.toLowerCase());

        // Verify the result
        assertEquals(2, result);
    }



    @Test
    public void testFetchApiAndGetUniquePost_Success2()  {
        String url = "https://api.example.com/endpoint";
        String result = AssignmentService.fetchApiAndGetUniquePost(url);
        assertNotNull(result);
        // Additional assertions on the result if needed
    }

}



