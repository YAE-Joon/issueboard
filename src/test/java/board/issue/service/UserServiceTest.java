package board.issue.service;

import board.issue.entity.Users;
import board.issue.repository.UsersRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceTest {
    @Autowired UserService userService;
    @Autowired UsersRepository usersRepository;

    @Test
    public void 회원가입()throws Exception{
        //given
        Users users = new Users();
        users.setUserId("abcd");
        users.setPassword("1234");
        users.setNickName("rakd");


        //when
        Long saveId = userService.join(users);
        //then
        Assertions.assertThat(users).isEqualTo(usersRepository.findById(saveId));

    }
    @Test
    public void 중복_회원_예외()throws Exception{
        //given
        Users users = new Users();
        users.setUserId("kim");
        Users users2 = new Users();
        users2.setUserId("kim");

        //when
        try {
            userService.join(users);
            userService.join(users2);
        }catch(IllegalStateException e){
            return ;
        }
        //then
    }

}