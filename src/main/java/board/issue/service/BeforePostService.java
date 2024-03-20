package board.issue.service;

import board.issue.entity.BeforePost;
import board.issue.entity.Post;
import board.issue.repository.BeforePostRepository;
import board.issue.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class BeforePostService {

    private final BeforePostRepository beforePostRepository;
    private final PostRepository postRepository;

    public Optional<BeforePost> create(Post post){
        Long top10Issue = postRepository.findPostTop10ByIssue();
        if (top10Issue < post.getIssue()) {
            BeforePost beforePost = new BeforePost();
            beforePost.setPost(post);
            beforePost.setTitle(post.getTitle());
            beforePost.setBody(post.getBody());
            beforePost.setUserId(post.getUsers().getUserId());
            beforePost.setIssue(post.getIssue());
            beforePost.setCommentId(post.getCommentId());
            beforePostRepository.save(beforePost);
            Optional<BeforePost> optionalBeforePost = Optional.ofNullable(beforePost);
            return optionalBeforePost;
        }else{
            Optional<BeforePost> optionalBeforePost = Optional.ofNullable(new BeforePost());
            return optionalBeforePost;
        }
    }
    public BeforePost read(Long beforePostId){
        BeforePost beforePost = beforePostRepository.findById(beforePostId);
        return beforePost;
        }

    }

