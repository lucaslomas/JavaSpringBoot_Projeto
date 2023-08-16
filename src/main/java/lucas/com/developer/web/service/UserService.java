package lucas.com.developer.web.service;

import jakarta.persistence.EntityNotFoundException;
import lucas.com.developer.web.entities.User;
import lucas.com.developer.web.repositorie.UserRepository;
import lucas.com.developer.web.service.exceptions.DataBaseException;
import lucas.com.developer.web.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

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
        try {
            User user = findById(id);
            userRepository.delete(user);
        }catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }
    }

    public User uptade(Long id, User obj){
        try {
            User user = userRepository.getReferenceById(id);
            uptadeData(user, obj);
            return userRepository.save(user);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    public void uptadeData(User user, User obj){
       user.setName(obj.getName());
       user.setEmail(obj.getEmail());
       user.setPhone(obj.getPhone());
    }

}
