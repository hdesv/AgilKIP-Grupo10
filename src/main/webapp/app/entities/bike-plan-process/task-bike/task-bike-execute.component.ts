import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskBikeService from './task-bike.service';
import { TaskBikeContext } from './task-bike.model';

const validations: any = {
  taskContext: {
    bikePlanProcess: {
      bikePlan: {
        experience: {},
        nameClient: {},
        startDate: {},
        endDate: {},
        bikeNumber: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskBikeExecuteComponent extends Vue {
  private taskBikeService: TaskBikeService = new TaskBikeService();
  private taskContext: TaskBikeContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskBikeService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskBikeService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
