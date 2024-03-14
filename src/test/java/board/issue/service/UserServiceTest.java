package board.issue.service;

import board.issue.entity.Users;
import board.issue.repository.UsersRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

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

        //when

        //then
    }

}