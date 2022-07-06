package art.magnet.partner.u202015652.si652ebu202015652.painting.mapping;

import art.magnet.partner.u202015652.si652ebu202015652.painting.domain.model.entity.Idea;
import art.magnet.partner.u202015652.si652ebu202015652.painting.resource.IdeaRequest;
import art.magnet.partner.u202015652.si652ebu202015652.painting.resource.IdeaResource;
import art.magnet.partner.u202015652.si652ebu202015652.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class IdeaMapper implements Serializable {
  @Autowired
  EnhancedModelMapper mapper;

  public IdeaResource toResource(Idea model) {
    return mapper.map(model, IdeaResource.class);
  }

  public List<IdeaResource> toResourceList(List<Idea> models) {
    return mapper.mapList(models, IdeaResource.class);
  }

  public Idea toModel(IdeaRequest request) {
    return mapper.map(request, Idea.class);
  }
}
