package lucas.com.developer.web.service;

import lucas.com.developer.web.entities.User;
import lucas.com.developer.web.repositorie.UserRepository;
import lucas.com.developer.web.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public User insert(User obj){
        return userRepository.save(obj);
    }
    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public User uptade(Long id, User obj){
        User user = userRepository.getReferenceById(id);
        uptadeData(user, obj);
        return userRepository.save(user);
    }

    public void uptadeData(User user, User obj){
       user.setName(obj.getName());
       user.setEmail(obj.getEmail());
       user.setPhone(obj.getPhone());
    }

}
