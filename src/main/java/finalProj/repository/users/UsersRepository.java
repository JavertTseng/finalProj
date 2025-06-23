package finalProj.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import finalProj.domain.users.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

}
