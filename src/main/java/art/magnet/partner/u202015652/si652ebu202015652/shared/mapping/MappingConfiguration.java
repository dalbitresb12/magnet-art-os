package art.magnet.partner.u202015652.si652ebu202015652.shared.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {
  @Bean
  public EnhancedModelMapper modelMapper() {
    return new EnhancedModelMapper();
  }
}
