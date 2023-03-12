package HanSeek.Repository;

import HanSeek.Database.User;
import org.hibernate.mapping.List;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaRepository<T, T1> {
    User save(User user);

    Optional<User> findById(Long id);



    void deleteById(Long id);
}
