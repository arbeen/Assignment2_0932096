import assignment2.Blog;
import assignment2.BlogPost;
import assignment2.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class BlogTest {

    @Test
    public void testGetPostsByAuthorAge() {
        // Creating Person instances using builder's withX methods
        Person author1 = Person.builder().withId("1").withFirstName("Arbin").withLastName("Shrestha").withAge(27).withGender("Male").build();
        Person author2 = Person.builder().withId("2").withFirstName("Tony").withLastName("Stark").withAge(40).withGender("Male").build();

        // Creating BlogPost instances
        BlogPost post1 = BlogPost.builder().withId("101").withAuthorId("1").withPostContent("Post 1 content").build();
        BlogPost post2 = BlogPost.builder().withId("102").withAuthorId("2").withPostContent("Post 2 content").build();

        // Creating Blog instance
        Blog blog = new Blog(List.of(post1, post2), List.of(author1, author2));

        // Test valid case
        List<String> postsByAge27 = blog.getPostsByAuthorAge(27);
        assertEquals(1, postsByAge27.size());
        assertTrue(postsByAge27.contains("101"), "Post ID should match for author age 27.");

        // Test for author not found
        List<String> postsByAge50 = blog.getPostsByAuthorAge(50);
        assertTrue(postsByAge50.isEmpty(), "No posts should be found for age 50.");
    }

    @Test
    public void testBlogHandlesMissingAuthorId() {
        // Creating Person and BlogPost instances using builder's withX methods
        Person author1 = Person.builder().withId("1").withFirstName("Arbin").withLastName("Shrestha").withAge(27).withGender("Male").build();
        BlogPost post1 = BlogPost.builder().withId("101").withAuthorId("999").withPostContent("Invalid author post").build();  // Invalid authorId

        // Creating Blog instance with invalid authorId
        Blog blog = new Blog(List.of(post1), List.of(author1));

        // No posts should be returned because the authorId is invalid
        List<String> posts = blog.getPostsByAuthorAge(27);
        assertTrue(posts.isEmpty(), "No posts should be found with invalid author ID.");
    }

    @Test
    public void testEmptyInput() {
        // Creating an empty Blog instance
        Blog blog = new Blog(List.of(), List.of());

        // Since there are no posts, it should return an empty list
        List<String> posts = blog.getPostsByAuthorAge(27);
        assertTrue(posts.isEmpty(), "The list of posts should be empty.");
    }

    @Test
    public void testInvalidData() {
        // Test to ensure the code gracefully handles invalid/empty data, such as null values in fields.
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Person person = Person.builder().withId(null).withFirstName("Arbin").withLastName("Shrestha").withAge(30).withGender("Male").build();
        });
        assertEquals("ID cannot be null.", exception.getMessage(), "Exception message should match.");
    }
}
