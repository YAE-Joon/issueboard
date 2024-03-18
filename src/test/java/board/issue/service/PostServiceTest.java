package board.issue.service;

import board.issue.entity.Post;
import board.issue.entity.Users;
import board.issue.repository.PostRepository;
import board.issue.repository.UsersRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
class PostServiceTest {

    @Autowired
    PostService postService;
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserService userService;

    @Test
    public void 생성(){
        //given
        Post post = new Post();
        Users users = new Users();
        users.setUserId("abcd1");
        users.setPassword("1234");
        users.setNickName("rakd");
        post.setTitle("제목");
        post.setBody("본문");

        //when
        Long saveId = userService.join(users);
        post.setUsers(users);
        //when
        Post post1 = postService.create(post);
        post1.setBody("본문2");
        postService.updating(post1);
        Post post2 =postService.read(post.getPostId());


        //then
        Assertions.assertThat(post1.getBody()).isEqualTo(post2.getBody());

    }

    @Test
    public void 삭제(){
        //given
        Post post = new Post();
        post.setBody("본문");
        post.setTitle("title");
        Users users = new Users();
        users.setUserId("abcd1");
        users.setPassword("1234");
        users.setNickName("rakd");
        userService.join(users);
        post.setUsers(users);
        postService.create(post);
        Long postId = post.getPostId();

        //when
        postService.delete(post.getPostId());
        //then
        Assertions.assertThat(postService.read(postId)).isNull();
    }

    @Test
    public void 이슈(){
        //given
        Post post = new Post();
        post.setBody("본문");
        post.setTitle("title");
        Users users = new Users();
        users.setUserId("abcd1");
        users.setPassword("1234");
        users.setNickName("rakd");
        userService.join(users);
        post.setUsers(users);
        post = postService.create(post);
        //when
        Post post1 = postService.issuePlus(post);
        Post post2 = postService.read(post1.getPostId());
        //then
        Assertions.assertThat(post1.getIssue()).isEqualTo(post2.getIssue());
    }
}