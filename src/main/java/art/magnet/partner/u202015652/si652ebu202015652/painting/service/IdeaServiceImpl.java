package art.magnet.partner.u202015652.si652ebu202015652.painting.service;

import art.magnet.partner.u202015652.si652ebu202015652.painting.domain.model.entity.Idea;
import art.magnet.partner.u202015652.si652ebu202015652.painting.domain.persistence.IdeaRepository;
import art.magnet.partner.u202015652.si652ebu202015652.painting.domain.service.IdeaService;
import art.magnet.partner.u202015652.si652ebu202015652.shared.exception.ResourceValidationException;
import lombok.val;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class IdeaServiceImpl implements IdeaService {
  private static final String ENTITY = "Idea";

  private final IdeaRepository repository;

  private final Validator validator;

  public IdeaServiceImpl(IdeaRepository repository, Validator validator) {
    this.repository = repository;
    this.validator = validator;
  }

  @Override
  public List<Idea> getAll() {
    return repository.findAll();
  }

  @Override
  public Idea create(Idea request) {
    validateConstraints(request);

    val ideaWithProps = repository.findByTextQueryAndAuthorId(request.getTextQuery(), request.getAuthorId());

    if (ideaWithProps.isPresent()) {
      throw new ResourceValidationException(ENTITY, "An idea with the same text query and author ID already exists.");
    }

    return repository.save(request);
  }

  private <T> void validateConstraints(T request) {
    Set<ConstraintViolation<T>> violations = validator.validate(request);

    if (!violations.isEmpty()) {
      throw new ResourceValidationException(ENTITY, violations);
    }
  }
}
