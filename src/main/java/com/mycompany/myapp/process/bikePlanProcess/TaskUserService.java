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
public class TaskUserService {

    private final TaskInstanceService taskInstanceService;

    private final BikePlanService bikePlanService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final BikePlanProcessRepository bikePlanProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskUserMapper taskUserMapper;

    private final BikePlanProcessMapper bikePlanProcessMapper;

    public TaskUserService(
        TaskInstanceService taskInstanceService,
        BikePlanService bikePlanService,
        TaskInstanceRepository taskInstanceRepository,
        BikePlanProcessRepository bikePlanProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskUserMapper taskUserMapper,
        BikePlanProcessMapper bikePlanProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.bikePlanService = bikePlanService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.bikePlanProcessRepository = bikePlanProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskUserMapper = taskUserMapper;
        this.bikePlanProcessMapper = bikePlanProcessMapper;
    }

    public TaskUserContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        BikePlanProcessDTO bikePlanProcess = bikePlanProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskUserMapper::toBikePlanProcessDTO)
            .orElseThrow();

        TaskUserContextDTO taskUserContext = new TaskUserContextDTO();
        taskUserContext.setTaskInstance(taskInstanceDTO);
        taskUserContext.setBikePlanProcess(bikePlanProcess);

        return taskUserContext;
    }

    public TaskUserContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskUserContextDTO taskUserContext) {
        BikePlanDTO bikePlanDTO = bikePlanService.findOne(taskUserContext.getBikePlanProcess().getBikePlan().getId()).orElseThrow();
        bikePlanDTO.setExperience(taskUserContext.getBikePlanProcess().getBikePlan().getExperience());
        bikePlanDTO.setNameClient(taskUserContext.getBikePlanProcess().getBikePlan().getNameClient());
        bikePlanDTO.setPhoneNumber(taskUserContext.getBikePlanProcess().getBikePlan().getPhoneNumber());
        bikePlanDTO.setStartDate(taskUserContext.getBikePlanProcess().getBikePlan().getStartDate());
        bikePlanDTO.setEndDate(taskUserContext.getBikePlanProcess().getBikePlan().getEndDate());
        bikePlanDTO.setUserName(taskUserContext.getBikePlanProcess().getBikePlan().getUserName());
        bikePlanDTO.setClienteNumber(taskUserContext.getBikePlanProcess().getBikePlan().getClienteNumber());
        bikePlanService.save(bikePlanDTO);
    }

    public void complete(TaskUserContextDTO taskUserContext) {
        save(taskUserContext);
        BikePlanProcessDTO bikePlanProcess = bikePlanProcessRepository
            .findByProcessInstanceId(taskUserContext.getBikePlanProcess().getProcessInstance().getId())
            .map(bikePlanProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskUserContext.getTaskInstance(), bikePlanProcess);
    }
}
