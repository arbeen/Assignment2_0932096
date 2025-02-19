package org.arbin;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Person> persons = null;
        List<BlogPost> blogPosts = null;

        try {
            // Read and deserialize JSON files
            persons = objectMapper.readValue(new File("person.json"), objectMapper.getTypeFactory().constructCollectionType(List.class, Person.class));
            blogPosts = objectMapper.readValue(new File("blogPosts.json"), objectMapper.getTypeFactory().constructCollectionType(List.class, BlogPost.class));

            // Create Blog instance
            Blog blog = new Blog(blogPosts, persons);

            // Call getPostsByAuthorAge and print the result
            List<String> postsByAge = blog.getPostsByAuthorAge(27);  // Example age
            System.out.println("Posts by author age 27: " + postsByAge);

            // Print total number of blog posts and contributors
            System.out.println("Total blog posts: " + blogPosts.size());
            System.out.println("Total contributors: " + persons.size());

        } catch (IOException e) {
            System.out.println("Error reading or parsing JSON files: " + e.getMessage());
        }

        // Handle missing or invalid data gracefully
    }
}
