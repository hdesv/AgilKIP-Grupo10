import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskReserveService from './task-reserve.service';
import { TaskReserveContext } from './task-reserve.model';

const validations: any = {
  taskContext: {
    bikePlanProcess: {
      bikePlan: {
        name: {},
        startDate: {},
        endDate: {},
        confirmReserve: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskReserveExecuteComponent extends Vue {
  private taskReserveService: TaskReserveService = new TaskReserveService();
  private taskContext: TaskReserveContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskReserveService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskReserveService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
