package ps.hassany.dgsDemo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.List;

@RelationshipProperties
@Getter
@Setter
@AllArgsConstructor
public class RoleRelationship {
  @Id @GeneratedValue private Long id;
  private List<String> roles;

  @TargetNode private PersonEntity person;
}
