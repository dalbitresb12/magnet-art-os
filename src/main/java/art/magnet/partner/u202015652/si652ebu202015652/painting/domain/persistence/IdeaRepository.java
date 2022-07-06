package art.magnet.partner.u202015652.si652ebu202015652.painting.domain.persistence;

import art.magnet.partner.u202015652.si652ebu202015652.painting.domain.model.entity.Idea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IdeaRepository extends JpaRepository<Idea, Long> {
  Optional<Idea> findByTextQueryAndAuthorId(String textQuery, Long authorId);
}
