package board.issue.service;

import board.issue.entity.BeforePost;
import board.issue.entity.Post;
import board.issue.entity.Users;
import jakarta.persistence.EntityNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static java.util.Optional.empty;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
class BeforePostServiceTest {
    @Autowired
    private BeforePostService beforePostService;
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @Test
    public void 이슈생성(){
        Users users = new Users();
        users.setUserId("abcd1");
        users.setPassword("1234");
        users.setNickName("rakd");
        Long saveId = userService.join(users);

        Post post1 = new Post();
        post1.setTitle("제목");
        post1.setBody("본문");
        post1.setIssue(1L);
        post1.setUsers(users);
        postService.create(post1);

        Post post2 = new Post();
        post2.setTitle("제목");
        post2.setBody("본문");
        post2.setIssue(2L);
        post2.setUsers(users);
        postService.create(post2);

        Post post3 = new Post();
        post3.setTitle("제목");
        post3.setBody("본문");
        post3.setIssue(3L);
        post3.setUsers(users);
        postService.create(post3);

        Post post4 = new Post();
        post4.setTitle("제목");
        post4.setBody("본문");
        post4.setIssue(4L);
        post4.setUsers(users);
        postService.create(post4);

        Post post5 = new Post();
        post5.setTitle("제목");
        post5.setBody("본문");
        post5.setIssue(5L);
        post5.setUsers(users);
        postService.create(post5);

        Post post6 = new Post();
        post6.setTitle("제목");
        post6.setBody("본문");
        post6.setIssue(6L);
        post6.setUsers(users);
        postService.create(post6);

        Post post7 = new Post();
        post7.setTitle("제목");
        post7.setBody("본문");
        post7.setIssue(7L);
        post7.setUsers(users);
        postService.create(post7);

        Post post8 = new Post();
        post8.setTitle("제목");
        post8.setBody("본문");
        post8.setIssue(8L);
        post8.setUsers(users);
        postService.create(post8);

        Post post9 = new Post();
        post9.setTitle("제목");
        post9.setBody("본문");
        post9.setIssue(9L);
        post9.setUsers(users);
        postService.create(post9);

        Post post10 = new Post();
        post10.setTitle("제목");
        post10.setBody("본문");
        post10.setIssue(10L);
        post10.setUsers(users);
        postService.create(post10);

        Post post11 = new Post();
        post11.setTitle("제목");
        post11.setBody("본문");
        post11.setIssue(11L);
        post11.setUsers(users);
        postService.create(post11);


        //when
        BeforePost beforePost1 = beforePostService.create(post10).get();
        BeforePost beforePost2 = beforePostService.create(post1).get();

        //then
        Assertions.assertThat(beforePost1).isEqualTo(beforePostService.read(beforePost1.getBeforePostId()));
        Assertions.assertThat(beforePost2.getBeforePostId()).isNull();
    }

}