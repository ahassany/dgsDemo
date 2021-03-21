package ps.hassany.dgsDemo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node("Movie")
@Getter
@Setter
public class MovieEntity {
  @Id private String title;
  private String tagline;

  @Relationship(type = "ACTED_IN", direction = Relationship.Direction.INCOMING)
  private List<RoleRelationship> actorsAndRoles;

  @Relationship(type = "DIRECTED", direction = Relationship.Direction.INCOMING)
  private List<PersonEntity> directors = new ArrayList<>();

  public MovieEntity(String title, String tagline) {
    this.title = title;
    this.tagline = tagline;
  }
}
