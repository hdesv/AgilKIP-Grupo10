package com.mycompany.myapp.process.bikePlanProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bike-plan-process/task-bike")
public class TaskBikeController {

    private final Logger log = LoggerFactory.getLogger(TaskBikeController.class);

    private final TaskBikeService taskBikeService;

    public TaskBikeController(TaskBikeService taskBikeService) {
        this.taskBikeService = taskBikeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskBikeContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskBikeContextDTO taskBikeContext = taskBikeService.loadContext(id);
        return ResponseEntity.ok(taskBikeContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskBikeContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskBikeContextDTO taskBikeContext = taskBikeService.claim(id);
        return ResponseEntity.ok(taskBikeContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskBikeContextDTO taskBikeContext) {
        log.debug("REST request to complete BikePlanProcess.TaskBike {}", taskBikeContext.getTaskInstance().getId());
        taskBikeService.complete(taskBikeContext);
        return ResponseEntity.noContent().build();
    }
}
