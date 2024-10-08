package uz.pdp.SpringDataJpaTest.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "task")
@Getter
@Setter
@NoArgsConstructor

public class Task extends BaseEntity{

    private String name;

    @Column(columnDefinition = "text")
    private String description;

    @Column(name = "dead_line")
    private LocalDate deadLine;

    @Builder
    public Task(String name, String description, LocalDate deadLine) {
        this.name = name;
        this.description = description;
        this.deadLine = deadLine;
    }
}


