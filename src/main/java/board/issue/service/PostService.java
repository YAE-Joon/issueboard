package board.issue.service;

import board.issue.entity.Post;
import board.issue.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;


    public Post create(Post post){
        postRepository.save(post);
        return post;
    }

    public Post updating(Post post){
        postRepository.update(post.getPostId(),post);
        return post;
    }

    public Post read(Long postId){
        Optional<Post> post = postRepository.findByPostId(postId);
        Post readPost = post.orElse(null);
        return readPost;
    }

    public Post issuePlus(Post post){

        Long issueCount = post.getIssue();
        issueCount++;
        post.setIssue(issueCount);
        postRepository.save(post);
        return post;
    }

    public void delete(Long postId){
        postRepository.delete(postId);
    }
}
