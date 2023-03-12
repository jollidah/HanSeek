package HanSeek.Repository;

import HanSeek.Database.User;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;
import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepository implements JpaRepository<User, Long> {
    private static Map<Long, User> Store = new HashMap<>();

    @Override
    public User save(User user){
        Store.put(user.getId(), user);
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.of(Store.get(id));
    }

    @Override
    public void deleteById(Long id) {
        Store.remove(id);
        return;
    }
}
