package woowa.team4.redis.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Redis Map 자료구조
 * Redis의 Hash는 field-value 쌍의 컬렉션이다.
 * Java의 HashMap과 유사하다.
 * 하나의 Key 아래에 여러 개의 field-value쌍을 저장할 수 있어 객체를 표현하기 적합하다.
 */
@Service
public class UserService {

    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public UserService(RedisTemplate<String, Object> redisTemplate) {
         this.redisTemplate = redisTemplate;
    }

    public void saveUser(String userId, String name, int age) {
        String key = "user: " + userId;
        redisTemplate.opsForHash().put(key, "name", name);
        redisTemplate.opsForHash().put(key, "age", String.valueOf(age));
    }

    public String getUserName(String userId) {
        String key = "user: " + userId;
        return (String) redisTemplate.opsForHash().get(key, "name");
    }

    public Integer getUserAge(String userId) {
        String key = "user: " + userId;
        String age = (String) redisTemplate.opsForHash().get(key, "age");
        return age != null ? Integer.parseInt(age) : null;
    }
}
