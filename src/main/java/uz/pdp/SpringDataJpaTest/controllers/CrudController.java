package uz.pdp.SpringDataJpaTest.controllers;

import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import uz.pdp.SpringDataJpaTest.dto.TaskDto;
import uz.pdp.SpringDataJpaTest.mapper.TaskMapper;
import uz.pdp.SpringDataJpaTest.model.Task;

@RestController("/crud")
@Slf4j
public class CrudController {


    @PostMapping("/create")
    public ResponseEntity<String> create(Integer taskId){

        log.error("shu {} task id bilan xatolik sodir bo`ldi",taskId);

        return ResponseEntity.ok("create");
    }

    @GetMapping("/update")
    public ResponseEntity<String> update(){
        for (int i = 0; i <100000 ; i++) {
            log.error("shu {} task id bilan xatolik sodir bo`ldi",3);
        }
        return ResponseEntity.ok("update");
    }
    @GetMapping("/delete")
    public ResponseEntity<String> delete(){
        /*log.error("shu {} task id bilan xatolik sodir bo`ldi",1);
        log.info("shu {} task id bilan xatolik sodir bo`ldi",1);
        log.warn("shu {} task id bilan xatolik sodir bo`ldi",1);
        */
        if (1==1){
            throw new RuntimeException("Some thing happened");
        }
        return ResponseEntity.ok("delte");
    }
    @GetMapping("/get")
    public ResponseEntity<String> get(){
        log.error("shu {} task id bilan xatolik sodir bo`ldi",2);
        return ResponseEntity.ok("get");
    }
}
