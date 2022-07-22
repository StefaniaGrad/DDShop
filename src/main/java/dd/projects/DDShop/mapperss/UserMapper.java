package dd.projects.DDShop.mapperss;

import dd.projects.DDShop.DTOs.UserCreateDTO;
import dd.projects.DDShop.DTOs.UserDTO;
import dd.projects.DDShop.enitities.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface UserMapper {
    User UserDTOToUser (UserDTO userDTO);
    UserDTO UserToUserDTo(User user);

    User UserCreateDTOToUser(UserCreateDTO userCreateDTO);

    UserCreateDTO UserToUserCreateDTO(User user);
}
