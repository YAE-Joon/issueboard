package board.issue.service;

import board.issue.entity.Users;
import board.issue.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UserService {

    @Autowired
    private final UsersRepository usersRepository;


    //회원 가입
    @Transactional
    public Long join(Users users){
        validateDuplicateMember(users);//중복 회원 검증
        usersRepository.save(users);
        return users.getId();
    }

    //로그인
    public Users login(String userId,String password){
        Optional<Users> optionalUser = usersRepository.findByUserId(userId);
        return optionalUser.filter(m->m.getPassword().equals(password)).orElse(null);
    }

    public void validateDuplicateMember(Users users){
        Optional<Users> findUsers = usersRepository.findByUserId(users.getUserId());
        if(!findUsers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public Users findById(Long id){
        Users userFindById = usersRepository.findById(id);
        return  userFindById;
    }
    public List<Users> findUsers() {
        return usersRepository.findAll();
    }

}
