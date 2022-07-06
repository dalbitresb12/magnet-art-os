package art.magnet.partner.u202015652.si652ebu202015652.painting.api;

import art.magnet.partner.u202015652.si652ebu202015652.painting.domain.service.IdeaService;
import art.magnet.partner.u202015652.si652ebu202015652.painting.mapping.IdeaMapper;
import art.magnet.partner.u202015652.si652ebu202015652.painting.resource.IdeaRequest;
import art.magnet.partner.u202015652.si652ebu202015652.painting.resource.IdeaResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.val;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Ideas")
@RestController
@RequestMapping("api/v1/ideas")
public class IdeaController {
  private final IdeaService service;

  private final IdeaMapper mapper;

  public IdeaController(IdeaService service, IdeaMapper mapper) {
    this.service = service;
    this.mapper = mapper;
  }

  @Operation(summary = "Get Ideas", description = "Get All Ideas")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Ideas found", content = {
      @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = IdeaResource.class)))
    })
  })
  @GetMapping
  public List<IdeaResource> getAll() {
    val entities = service.getAll();
    return mapper.toResourceList(entities);
  }

  @Operation(summary = "Create Idea", description = "Create a new Idea")
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "The idea was successfully created", content = {
      @Content(mediaType = "application/json", schema = @Schema(implementation = IdeaResource.class))
    }),
    @ApiResponse(responseCode = "400", description = "Request data validation error", content = {
      @Content(mediaType = "application/json")
    })
  })
  @PostMapping
  public IdeaResource create(@RequestBody IdeaRequest request) {
    val mapped = mapper.toModel(request);
    val entity = service.create(mapped);
    return mapper.toResource(entity);
  }
}
