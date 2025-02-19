package org.arbin;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@JsonDeserialize(builder = BlogPost.BlogPostBuilder.class)
public class BlogPost {
    private final String id;
    private final String authorId;
    private final String postContent;

    public static class BlogPostBuilder {
        public BlogPost build() {
            validate();
            return new BlogPost(id, authorId, postContent);
        }

        private void validate() {
            if (id == null) {
                throw new IllegalArgumentException("Post ID cannot be null.");
            }
            if (authorId == null) {
                throw new IllegalArgumentException("Author ID cannot be null.");
            }
        }
    }
}
