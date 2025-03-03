package assignment2;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Builder(builderClassName = "BlogPostBuilder", setterPrefix = "with")
public class BlogPost {
    private final String id;
    private final String authorId;
    private final String postContent;

    private BlogPost(
            @JsonProperty("id") String id,
            @JsonProperty("authorId") String authorId,
            @JsonProperty("postContent") String postContent) {
        validate(id, authorId);
        this.id = id;
        this.authorId = authorId;
        this.postContent = postContent;
    }

    public static class BlogPostBuilder {
        public BlogPost build() {
            validate(id, authorId);
            return new BlogPost(id, authorId, postContent);
        }
    }

    private static void validate(String id, String authorId) {
        if (id == null) {
            throw new IllegalArgumentException("Post ID cannot be null.");
        }
        if (authorId == null) {
            throw new IllegalArgumentException("Author ID cannot be null.");
        }
    }
}
