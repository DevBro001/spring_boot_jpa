package uz.pdp.SpringDataJpaTest.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;
    private String username;
    private String password;
}
