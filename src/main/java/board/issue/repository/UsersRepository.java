package board.issue.repository;

import board.issue.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Users users){
        em.persist(users);
    }

    public Users findById(Long id){
        return em.find(Users.class, id);
    }

    public List<Users> findByUserId(String userId){
        return em.createQuery("select m from Users m where m.userId = :userId", Users.class)
                .setParameter("userId",userId)
                .getResultList();
    }

    public List<Users> findAll(){
        return em.createQuery("select m from Users m", Users.class).getResultList();
    }



}
