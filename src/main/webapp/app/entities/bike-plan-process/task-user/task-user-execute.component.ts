import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskUserService from './task-user.service';
import { TaskUserContext } from './task-user.model';

const validations: any = {
  taskContext: {
    bikePlanProcess: {
      bikePlan: {
        experience: {},
        nameClient: {},
        phoneNumber: {},
        startDate: {},
        endDate: {},
        userName: {},
        clienteNumber: {},
      },
    },
  },
};

@Component({
  validations,
})
export default class TaskUserExecuteComponent extends Vue {
  private taskUserService: TaskUserService = new TaskUserService();
  private taskContext: TaskUserContext = {};
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.claimTaskInstance(to.params.taskInstanceId);
      }
    });
  }

  public claimTaskInstance(taskInstanceId) {
    this.taskUserService.claim(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }

  public complete() {
    this.taskUserService.complete(this.taskContext).then(res => {
      this.$router.go(-1);
    });
  }

  public initRelationships(): void {}
}
