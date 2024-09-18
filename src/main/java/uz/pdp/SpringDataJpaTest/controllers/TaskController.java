package uz.pdp.SpringDataJpaTest.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.SpringDataJpaTest.dto.TaskDto;
import uz.pdp.SpringDataJpaTest.mapper.TaskMapper;
import uz.pdp.SpringDataJpaTest.model.Task;
import uz.pdp.SpringDataJpaTest.repositories.TaskRepository;
import uz.pdp.SpringDataJpaTest.utils.SecurityUtils;

@RestController
@RequestMapping("/task")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "TaskUI",description = "Bu yerda faqat tasklar ustida amallar bajariladi")
public class TaskController {


    private final TaskRepository taskRepository;
    private final SecurityUtils securityUtils;

    public TaskController(TaskRepository taskRepository, SecurityUtils securityUtils) {
        this.taskRepository = taskRepository;
        this.securityUtils = securityUtils;
    }

    @PostMapping("/create")
    public ResponseEntity<Task> create(@RequestBody TaskDto taskDto){
        TaskMapper mapper = Mappers.getMapper(TaskMapper.class);
        Task build = mapper.toEntity(taskDto);
        Task save = taskRepository.save(build);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/create/{id}")
    public ResponseEntity<TaskDto> create(@PathVariable Integer id){
        TaskMapper mapper = Mappers.getMapper(TaskMapper.class);
        Task task = taskRepository.findById(id).get();
        TaskDto build = mapper.toDto(task);
        return ResponseEntity.ok(build);
    }
}
