package board.issue.service;

import board.issue.entity.Users;
import board.issue.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)//읽기 전용
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

    public void validateDuplicateMember(Users users){
        List<Users> findUsers = usersRepository.findByUserId(users.getUserId());
        if(!findUsers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public List<Users> findUsers() {
        return usersRepository.findAll();
    }

}
