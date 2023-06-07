package org.example.service;

import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.example.service.AssignmentService.fetchApiAndGetUniquePost;
import static org.junit.jupiter.api.Assertions.*;

class AssignmentServiceTest {

    @Test
    void testFetchApiAndGetUniquePost_Success() throws IOException{
        // Test with a valid API URL
        String apiUrl = "https://jsonplaceholder.typicode.com/posts/1";

        // Run the method under test
        String result = fetchApiAndGetUniquePost(apiUrl);

        // Verify the result
        assertEquals("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto", result);
    }

    @Test
    void testFetchApiAndGetUniquePost_Failure() throws IOException{
        // Test with an invalid API URL
        String apiUrl = "https://jsonplaceholder.typicode.com/nonexistent";

        // Run the method under test
        String result = fetchApiAndGetUniquePost(apiUrl);

        // Verify the result
        assertEquals("", result);
    }

    @Test
    void testCountEachCharacter() {
        // Test with a sample post body
        String test = "HelloWorld";

        // Run the method under test
        Map<Character,Integer> result = AssignmentService.countEachCharacter(test);

        // Verify the result
        assertEquals(7, result.size());
    }

    @Test
    void testCountEachCharacterWithEmptyBody() {
        // Test with a sample post body
        String test = "";

        // Run the method under test
        Map<Character,Integer> result = AssignmentService.countEachCharacter(test);

        // Verify the result
        assertTrue(result.isEmpty());
    }

    @Test
    void testCountEachCharacterCaseSensitive() {
        // Test with a sample post body
        String test = "Hhhhttt";

        // Run the method under test
        Map<Character,Integer> result = AssignmentService.countEachCharacter(test.toLowerCase());

        // Verify the result
        assertEquals(4, result.get('h'));
        assertEquals(3, result.get('t'));
    }

    @Test
    void testCountEachCharacterCaseSensitiveAndNewLine() {
        // Test with a sample post body
        String test = "hhhhtest\n";

        // Run the method under test
        Map<Character,Integer> result = AssignmentService.countEachCharacter(test.toLowerCase());

        // Verify the result
        assertEquals(4, result.get('h'));
        assertFalse(result.containsKey("\n"));

    }

    @Test
    void testCountEachCharacterCaseSensitiveWithDuplicateChars() {
        // Test with a sample post body
        String test = "Hhhh ttt\n";

        // Run the method under test
        Map<Character,Integer> result = AssignmentService.countEachCharacter(test.toLowerCase());

        // Verify the result
        assertEquals(4, result.get('h'));
        assertEquals(3, result.get('t'));
        assertFalse(result.containsKey("\s"));
        assertFalse(result.containsKey("\n"));
    }

    @Test
    public void testCharacterCount_EmptyString() {
        String input = "";
        Map<Character, Integer> characterCount = AssignmentService.countEachCharacter(input);
        assertTrue(characterCount.isEmpty());
    }

    @Test
    public void testCharacterCount_RepeatedCharacters() {
        String input = "Hello World";
        Map<Character, Integer> characterCount = AssignmentService.countEachCharacter(input);
        assertEquals(3, characterCount.get('l'));
        assertEquals(2, characterCount.get('o'));
    }

    @Test
    public void testCharacterCount_UniqueCharacters() {
        String input = "qwerty";
        Map<Character, Integer> characterCount = AssignmentService.countEachCharacter(input);
        assertEquals(6, characterCount.size());
        assertEquals(1, characterCount.get('q'));
        assertEquals(1, characterCount.get('r'));
        assertEquals(1, characterCount.get('y'));
    }

}



