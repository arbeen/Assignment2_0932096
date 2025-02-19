package assignment2;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
@EqualsAndHashCode
public class Blog {
    private final List<BlogPost> posts;
    private final List<Person> contributors;

    public Blog(List<BlogPost> posts, List<Person> contributors) {
        this.posts = posts;
        this.contributors = contributors;
    }
    public List<String> getPostsByAuthorAge(Integer age) {
        // Filter BlogPosts by author age using Streams API, and handle invalid authorIds
        return posts.stream()
                .filter(post -> {
                    // Check if the authorId exists in the contributors list
                    boolean authorExists = contributors.stream()
                            .anyMatch(person -> person.getId().equals(post.getAuthorId()));
                    // If the author doesn't exist, we ignore this post
                    if (!authorExists) {
                        return false;
                    }

                    // If author exists, proceed with age validation
                    Person author = contributors.stream()
                            .filter(person -> person.getId().equals(post.getAuthorId()))
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException("Author not found"));
                    return author.getAge().equals(age);
                })
                .map(BlogPost::getId)
                .collect(Collectors.toList());
    }


}
