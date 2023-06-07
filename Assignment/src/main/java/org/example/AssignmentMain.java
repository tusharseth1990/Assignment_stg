package org.example;

import org.example.service.AssignmentService;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class AssignmentMain {
    public static void main(String[] args) throws IOException {
        // String url = "https://jsonplaceholder.typicode.com/posts/17";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter url: ");
        String url = scanner.nextLine();
        if (!AssignmentService.isValidUrl(url) || url.length() == 0) {
            System.out.println("Invalid URL");
        } else {
            String body = AssignmentService.fetchApiAndGetUniquePost(url);
            Map<Character,Integer> map = AssignmentService.countEachCharacter(body);
        }
    }
}
