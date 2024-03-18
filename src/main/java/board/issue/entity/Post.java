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
    @Column(name = "post_id")
    private Long postId;

    private String title;

    private String body;

    @ManyToOne
    @JoinColumn(name ="id")
    private Users users;

    @Column
    private Long issue =0L;

    private Long comment_id;


}
