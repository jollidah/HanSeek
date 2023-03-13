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

    public void printUserLog(Long id){
        User user = (User) getUserById(id);
        System.out.println("########################################\n");
        System.out.printf("%d/", user.getId());
        System.out.printf("%s/", user.getAnswerString());
        System.out.printf("%s/", user.getBestResult());
        System.out.printf("%s/", user.getAttendance());
        System.out.printf("%s/", user.getName());
        System.out.printf("%s/", user.getGender());
        System.out.printf("%s/", user.getNationality());
        System.out.printf("%s/", user.getEmail());
        System.out.printf("%s/", user.getVisit_length());
        System.out.println( user.getFeedback().strip() + "/");
        System.out.println("########################################\n");
    }

//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }

    public void deleteUser(Long id) {
        jpaRepository.deleteById(id);
    }
}
