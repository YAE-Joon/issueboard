package board.issue.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentsId;

    private String content;

    @ManyToOne
    @JoinColumn(name ="post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name ="id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "beforepost_id")
    private BeforePost beforePost;
}
