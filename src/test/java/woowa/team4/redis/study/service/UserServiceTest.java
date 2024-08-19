package woowa.team4.redis.study.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void testSaveAndGetUser() {
        userService.saveUser("1", "홍길동", 30);
        assertEquals("홍길동", userService.getUserName("1"));
        assertEquals(30,userService.getUserAge("1"));
    }
}
