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
public class TaskBikeService {

    private final TaskInstanceService taskInstanceService;

    private final BikePlanService bikePlanService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final BikePlanProcessRepository bikePlanProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskBikeMapper taskBikeMapper;

    private final BikePlanProcessMapper bikePlanProcessMapper;

    public TaskBikeService(
        TaskInstanceService taskInstanceService,
        BikePlanService bikePlanService,
        TaskInstanceRepository taskInstanceRepository,
        BikePlanProcessRepository bikePlanProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskBikeMapper taskBikeMapper,
        BikePlanProcessMapper bikePlanProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.bikePlanService = bikePlanService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.bikePlanProcessRepository = bikePlanProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskBikeMapper = taskBikeMapper;
        this.bikePlanProcessMapper = bikePlanProcessMapper;
    }

    public TaskBikeContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        BikePlanProcessDTO bikePlanProcess = bikePlanProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskBikeMapper::toBikePlanProcessDTO)
            .orElseThrow();

        TaskBikeContextDTO taskBikeContext = new TaskBikeContextDTO();
        taskBikeContext.setTaskInstance(taskInstanceDTO);
        taskBikeContext.setBikePlanProcess(bikePlanProcess);

        return taskBikeContext;
    }

    public TaskBikeContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskBikeContextDTO taskBikeContext) {
        BikePlanDTO bikePlanDTO = bikePlanService.findOne(taskBikeContext.getBikePlanProcess().getBikePlan().getId()).orElseThrow();
        bikePlanDTO.setExperience(taskBikeContext.getBikePlanProcess().getBikePlan().getExperience());
        bikePlanDTO.setNameClient(taskBikeContext.getBikePlanProcess().getBikePlan().getNameClient());
        bikePlanDTO.setStartDate(taskBikeContext.getBikePlanProcess().getBikePlan().getStartDate());
        bikePlanDTO.setEndDate(taskBikeContext.getBikePlanProcess().getBikePlan().getEndDate());
        bikePlanDTO.setBikeNumber(taskBikeContext.getBikePlanProcess().getBikePlan().getBikeNumber());
        bikePlanService.save(bikePlanDTO);
    }

    public void complete(TaskBikeContextDTO taskBikeContext) {
        save(taskBikeContext);
        BikePlanProcessDTO bikePlanProcess = bikePlanProcessRepository
            .findByProcessInstanceId(taskBikeContext.getBikePlanProcess().getProcessInstance().getId())
            .map(bikePlanProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskBikeContext.getTaskInstance(), bikePlanProcess);
    }
}
