package lucas.com.developer.web.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import lucas.com.developer.web.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
