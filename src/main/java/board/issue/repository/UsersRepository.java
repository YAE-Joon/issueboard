package board.issue.repository;

import board.issue.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    public Optional<Users> findByUserId(String userId){
        Users user = em.createQuery("select m from Users m where m.userId = :userId", Users.class)
                .setParameter("userId", userId)
                .getSingleResult();
        return Optional.of(user);
    }

    public List<Users> findAll(){
        return em.createQuery("select m from Users m", Users.class).getResultList();
    }



}
