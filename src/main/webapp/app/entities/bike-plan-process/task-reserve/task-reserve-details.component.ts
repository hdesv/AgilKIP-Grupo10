import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskReserveService from './task-reserve.service';
import { TaskReserveContext } from './task-reserve.model';

@Component
export default class TaskReserveDetailsComponent extends Vue {
  private taskReserveService: TaskReserveService = new TaskReserveService();
  private taskContext: TaskReserveContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskReserveService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
