package board.issue.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String title;

    private String body;

    @ManyToOne
    @JoinColumn(name ="post_id")
    private Users users;

    private Long issue;

    private Long comment_id;


}
