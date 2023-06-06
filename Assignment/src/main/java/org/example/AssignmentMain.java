package org.example;

import org.example.service.AssignmentService;

import java.util.Scanner;

public class AssignmentMain {
    public static void main(String[] args) {
        // String url = "https://jsonplaceholder.typicode.com/posts/17";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter url: ");
        String url = scanner.nextLine();
        if (!AssignmentService.isValidUrl(url) || url.length() == 0) {
            System.out.println("Invalid URL");
        } else {
            String body = AssignmentService.fetchApiAndGetUniquePost(url);
            int uniqueCount = AssignmentService.countEachCharacter(body);
            System.out.println("Unique Count = " + uniqueCount);
        }
    }

}
