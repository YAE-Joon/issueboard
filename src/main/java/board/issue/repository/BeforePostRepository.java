package board.issue.repository;

import board.issue.entity.BeforePost;
import board.issue.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BeforePostRepository {


    @PersistenceContext
    private EntityManager em;

    public void save(BeforePost beforePost){
        em.persist(beforePost);
    }

    public BeforePost findById(Long id){
        return em.find(BeforePost.class, id);
    }


    public List<BeforePost> findAll(){
        return em.createQuery("select m from BeforePost m", BeforePost.class).getResultList();
    }

}
