package art.magnet.partner.u202015652.si652ebu202015652.painting.domain.model.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "ideas")
public class Idea {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String textQuery;

  @Column(nullable = false)
  private Integer initialSamples;

  @Column(nullable = false)
  private Long authorId;
}
