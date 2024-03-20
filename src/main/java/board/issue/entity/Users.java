package board.issue.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class Users {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_id")
    @NotEmpty
    private String userId;

    @NotEmpty
    private String nickName;

    @NotEmpty
    private String password;


    @OneToMany(mappedBy ="users")
    private List<Post> postList = new ArrayList<>();

}
