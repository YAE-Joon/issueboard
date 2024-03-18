package board.issue.service;

import board.issue.entity.Comments;
import board.issue.repository.CommentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@AllArgsConstructor
public class CommentsService {

   private final CommentsRepository commentsRepository;

    public Comments save(Comments comments){
        commentsRepository.save(comments);
        return  comments;
    }

    public void delete(Comments comments){
        commentsRepository.delete(comments);
    }
}
