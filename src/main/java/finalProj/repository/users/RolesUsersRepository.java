package finalProj.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import finalProj.domain.users.RolesUsers;

@Repository
public interface RolesUsersRepository extends JpaRepository<RolesUsers, Integer> {

}
