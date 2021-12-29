package com.mycompany.myapp.process.bikePlanProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bike-plan-process/task-user")
public class TaskUserController {

    private final Logger log = LoggerFactory.getLogger(TaskUserController.class);

    private final TaskUserService taskUserService;

    public TaskUserController(TaskUserService taskUserService) {
        this.taskUserService = taskUserService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskUserContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskUserContextDTO taskUserContext = taskUserService.loadContext(id);
        return ResponseEntity.ok(taskUserContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskUserContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskUserContextDTO taskUserContext = taskUserService.claim(id);
        return ResponseEntity.ok(taskUserContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskUserContextDTO taskUserContext) {
        log.debug("REST request to complete BikePlanProcess.TaskUser {}", taskUserContext.getTaskInstance().getId());
        taskUserService.complete(taskUserContext);
        return ResponseEntity.noContent().build();
    }
}
