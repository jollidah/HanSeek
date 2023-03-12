package HanSeek.Service;

import HanSeek.Database.User;
import HanSeek.Repository.JpaRepository;
import HanSeek.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final JpaRepository jpaRepository;

    @Autowired
    public UserService(JpaRepository userRepository) {
        this.jpaRepository = userRepository;
    }

    public User saveUser(User user) {
        return jpaRepository.save(user);
    }

    public Object getUserById(Long id) {
        return jpaRepository.findById(id).orElse(null);
    }

//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }

    public void deleteUser(Long id) {
        jpaRepository.deleteById(id);
    }
}
