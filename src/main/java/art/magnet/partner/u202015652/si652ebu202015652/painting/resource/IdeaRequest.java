package art.magnet.partner.u202015652.si652ebu202015652.painting.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class IdeaRequest {
  @NotNull
  @NotBlank
  private Integer initialSamples;

  @NotNull
  @NotBlank
  private Long authorId;

  @NotNull
  @NotBlank
  private String textQuery;
}
