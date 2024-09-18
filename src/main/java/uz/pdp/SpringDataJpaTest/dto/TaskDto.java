package uz.pdp.SpringDataJpaTest.dto;

import jakarta.persistence.Column;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;
import org.apache.catalina.User;
import uz.pdp.SpringDataJpaTest.model.Task;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private Integer id;
    private String title;
    private String description;
    private String deadLine;
    private List<UserDto> userList;
}
