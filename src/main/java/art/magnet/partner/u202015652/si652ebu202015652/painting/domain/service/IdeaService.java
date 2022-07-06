package art.magnet.partner.u202015652.si652ebu202015652.painting.domain.service;

import art.magnet.partner.u202015652.si652ebu202015652.painting.domain.model.entity.Idea;

import java.util.List;

public interface IdeaService {
  List<Idea> getAll();
  Idea create(Idea request);
}
