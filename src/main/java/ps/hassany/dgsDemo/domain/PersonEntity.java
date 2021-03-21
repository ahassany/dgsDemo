package ps.hassany.dgsDemo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Person")
@Getter
@Setter
@AllArgsConstructor
public class PersonEntity {
  @Id private String name;

  private Integer born;
}
