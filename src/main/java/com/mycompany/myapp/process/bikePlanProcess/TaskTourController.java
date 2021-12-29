package com.mycompany.myapp.process.bikePlanProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bike-plan-process/task-tour")
public class TaskTourController {

    private final Logger log = LoggerFactory.getLogger(TaskTourController.class);

    private final TaskTourService taskTourService;

    public TaskTourController(TaskTourService taskTourService) {
        this.taskTourService = taskTourService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskTourContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskTourContextDTO taskTourContext = taskTourService.loadContext(id);
        return ResponseEntity.ok(taskTourContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskTourContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskTourContextDTO taskTourContext = taskTourService.claim(id);
        return ResponseEntity.ok(taskTourContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskTourContextDTO taskTourContext) {
        log.debug("REST request to complete BikePlanProcess.TaskTour {}", taskTourContext.getTaskInstance().getId());
        taskTourService.complete(taskTourContext);
        return ResponseEntity.noContent().build();
    }
}
