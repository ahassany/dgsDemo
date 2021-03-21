package ps.hassany.dgsDemo.service.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ps.hassany.dgsDemo.domain.RoleRelationship;
import ps.hassany.dgsDemo.types.Role;

import java.util.List;

@Mapper(componentModel = "spring", uses = PersonMapper.class)
public interface RoleMapper {
  @Mapping(source = "roleRelationship.person", target = "actor")
  @Mapping(source = "roleRelationship.roles", target = "roles")
  Role toRole(RoleRelationship roleRelationship);

  List<Role> toRoles(List<RoleRelationship> roleRelationships);
}
