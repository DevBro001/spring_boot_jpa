package uz.pdp.SpringDataJpaTest.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import uz.pdp.SpringDataJpaTest.dto.TaskDto;
import uz.pdp.SpringDataJpaTest.model.Task;

@Mapper(uses = UserMapper.class)
public interface TaskMapper {

    @Mappings(value = {
            @Mapping(source = "name", target = "title"),
            @Mapping(source = "users", target = "userList"),
            @Mapping(source = "deadLine",target = "deadLine", dateFormat = "dd MM yyyy")
    }
    )
    TaskDto toDto(Task task);

    @InheritInverseConfiguration
    Task toEntity(TaskDto task);

}
