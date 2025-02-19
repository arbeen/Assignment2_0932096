import assignment2.BlogPost;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BlogPostTest {

    @Test
    public void testValidBlogPost() {
        BlogPost blogPost = BlogPost.builder()
                .id("1")
                .authorId("1")
                .postContent("Arbin's Blog 1")
                .build();

        assertNotNull(blogPost);
        assertEquals("1", blogPost.getId(), "ID should match.");
        assertEquals("1", blogPost.getAuthorId(), "Author ID should match.");
        assertEquals("Arbin's Blog 1", blogPost.getPostContent(), "Post content should match.");
    }

    @Test
    public void testBlogPostWithNullId() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            BlogPost.builder()
                    .authorId("1")
                    .postContent("Arbin's Blog 1")
                    .build();
        });
        assertEquals("Post ID cannot be null.", exception.getMessage(), "Exception message should match.");
    }

    @Test
    public void testBlogPostWithNullAuthorId() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            BlogPost.builder()
                    .id("1")
                    .postContent("Arbin's Blog 1")
                    .build();
        });
        assertEquals("Author ID cannot be null.", exception.getMessage(), "Exception message should match.");
    }

}
