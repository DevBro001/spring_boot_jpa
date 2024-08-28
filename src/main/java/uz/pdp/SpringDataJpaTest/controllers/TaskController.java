package uz.pdp.SpringDataJpaTest.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.SpringDataJpaTest.model.Task;
import uz.pdp.SpringDataJpaTest.repositories.TaskRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {


    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<Task> create(@RequestBody Task task){
        Task save = taskRepository.save(task);
        return ResponseEntity.ok(save);
    }
    @DeleteMapping("/delete/{taskId}")
    public void delete(@PathVariable("taskId") Integer taskId){
         taskRepository.deleteById(taskId);
    }

    @GetMapping("/get-by-name/{name}")
    public ResponseEntity<List<Task>> getByName(@PathVariable("name") String name){
        List<Task> byName = taskRepository.findByName(name);
        return ResponseEntity.ok(byName);
    }
    @DeleteMapping("/delete-by-name/{name}/{deadLine}")
    public void deleteByName(@PathVariable("name") String name, @PathVariable("deadLine")LocalDate deadLine){
        taskRepository.deleteByNameAndDeadLine(name,deadLine);
    }
}
