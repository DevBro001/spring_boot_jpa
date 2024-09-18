package uz.pdp.SpringDataJpaTest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.pdp.SpringDataJpaTest.dto.TaskDto;
import uz.pdp.SpringDataJpaTest.dto.UserDto;
import uz.pdp.SpringDataJpaTest.model.Task;
import uz.pdp.SpringDataJpaTest.model.User;

@Mapper
public interface UserMapper {
    UserDto toDto(User user);

    User toEntity(UserDto userDto);
}
