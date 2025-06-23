package finalProj.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import finalProj.domain.users.Accounts;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Integer> {

}
