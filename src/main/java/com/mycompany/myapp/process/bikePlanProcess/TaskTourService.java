package com.mycompany.myapp.process.bikePlanProcess;

import com.mycompany.myapp.repository.BikePlanProcessRepository;
import com.mycompany.myapp.service.BikePlanService;
import com.mycompany.myapp.service.dto.BikePlanDTO;
import com.mycompany.myapp.service.dto.BikePlanProcessDTO;
import com.mycompany.myapp.service.mapper.BikePlanProcessMapper;
import org.akip.repository.TaskInstanceRepository;
import org.akip.service.TaskInstanceService;
import org.akip.service.dto.TaskInstanceDTO;
import org.akip.service.mapper.TaskInstanceMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskTourService {

    private final TaskInstanceService taskInstanceService;

    private final BikePlanService bikePlanService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final BikePlanProcessRepository bikePlanProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskTourMapper taskTourMapper;

    private final BikePlanProcessMapper bikePlanProcessMapper;

    public TaskTourService(
        TaskInstanceService taskInstanceService,
        BikePlanService bikePlanService,
        TaskInstanceRepository taskInstanceRepository,
        BikePlanProcessRepository bikePlanProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskTourMapper taskTourMapper,
        BikePlanProcessMapper bikePlanProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.bikePlanService = bikePlanService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.bikePlanProcessRepository = bikePlanProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskTourMapper = taskTourMapper;
        this.bikePlanProcessMapper = bikePlanProcessMapper;
    }

    public TaskTourContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        BikePlanProcessDTO bikePlanProcess = bikePlanProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskTourMapper::toBikePlanProcessDTO)
            .orElseThrow();

        TaskTourContextDTO taskTourContext = new TaskTourContextDTO();
        taskTourContext.setTaskInstance(taskInstanceDTO);
        taskTourContext.setBikePlanProcess(bikePlanProcess);

        return taskTourContext;
    }

    public TaskTourContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskTourContextDTO taskTourContext) {
        BikePlanDTO bikePlanDTO = bikePlanService.findOne(taskTourContext.getBikePlanProcess().getBikePlan().getId()).orElseThrow();
        bikePlanDTO.setExperience(taskTourContext.getBikePlanProcess().getBikePlan().getExperience());
        bikePlanDTO.setNameClient(taskTourContext.getBikePlanProcess().getBikePlan().getNameClient());
        bikePlanDTO.setStartDate(taskTourContext.getBikePlanProcess().getBikePlan().getStartDate());
        bikePlanDTO.setEndDate(taskTourContext.getBikePlanProcess().getBikePlan().getEndDate());
        bikePlanDTO.setTourNumber(taskTourContext.getBikePlanProcess().getBikePlan().getTourNumber());
        bikePlanDTO.setTourCity(taskTourContext.getBikePlanProcess().getBikePlan().getTourCity());
        bikePlanService.save(bikePlanDTO);
    }

    public void complete(TaskTourContextDTO taskTourContext) {
        save(taskTourContext);
        BikePlanProcessDTO bikePlanProcess = bikePlanProcessRepository
            .findByProcessInstanceId(taskTourContext.getBikePlanProcess().getProcessInstance().getId())
            .map(bikePlanProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskTourContext.getTaskInstance(), bikePlanProcess);
    }
}
