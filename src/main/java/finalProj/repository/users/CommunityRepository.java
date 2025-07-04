package finalProj.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import finalProj.domain.users.Community;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Integer> {

}
