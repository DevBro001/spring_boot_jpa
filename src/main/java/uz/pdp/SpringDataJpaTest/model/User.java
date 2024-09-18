package uz.pdp.SpringDataJpaTest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity{

    private String name;
    private String username;
    private String password;

    @Builder
    public User(Integer id, Integer createdBy, LocalDateTime createdDate, LocalDateTime updatedDate, Integer updatedBy, String name, String username, String password) {
        super(id, createdBy, createdDate, updatedDate, updatedBy);
        this.name = name;
        this.username = username;
        this.password = password;
    }
}
