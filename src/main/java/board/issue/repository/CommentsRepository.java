package board.issue.repository;

import board.issue.entity.Comments;
import board.issue.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class CommentsRepository {


    @PersistenceContext
    private EntityManager em;

    public void save(Comments comments){
        em.persist(comments);

    }
    public void delete(Comments comments){
        em.remove(comments);
    }

}
