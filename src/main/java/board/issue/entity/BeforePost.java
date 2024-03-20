package board.issue.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class BeforePost {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long beforePostId;

    @OneToOne
    @JoinColumn(name ="post_id")
    private Post post;

    private String title;

    private String body;

    private String userId;

    private Long issue;

    private Long CommentId;

    private LocalDateTime createdAt;

}
