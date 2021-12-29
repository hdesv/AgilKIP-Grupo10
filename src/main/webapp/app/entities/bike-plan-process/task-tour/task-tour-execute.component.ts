import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskTourService from './task-tour.service';
import { TaskTourContext } from './task-tour.model';

const validations: any = {
  taskContext: {
    bikePlanProcess: {
      bikePlan: {
        experience: {},
        nameClient: {},
        startDate: {},
        endDate: {},
        tourNumber: {},
        tourCity: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskTourExecuteComponent extends Vue {
  private taskTourService: TaskTourService = new TaskTourService();
  private taskContext: TaskTourContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskTourService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskTourService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
