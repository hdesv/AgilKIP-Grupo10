package com.mycompany.myapp.process.bikePlanProcess;

import com.mycompany.myapp.service.dto.BikePlanProcessDTO;
import org.akip.service.dto.TaskInstanceDTO;

public class TaskUserContextDTO {

    private BikePlanProcessDTO bikePlanProcess;
    private TaskInstanceDTO taskInstance;

    public BikePlanProcessDTO getBikePlanProcess() {
        return bikePlanProcess;
    }

    public void setBikePlanProcess(BikePlanProcessDTO bikePlanProcess) {
        this.bikePlanProcess = bikePlanProcess;
    }

    public TaskInstanceDTO getTaskInstance() {
        return taskInstance;
    }

    public void setTaskInstance(TaskInstanceDTO taskInstance) {
        this.taskInstance = taskInstance;
    }
}
