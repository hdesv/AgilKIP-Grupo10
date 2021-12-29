import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskConfirService from './task-confir.service';
import { TaskConfirContext } from './task-confir.model';

@Component
export default class TaskConfirDetailsComponent extends Vue {
  private taskConfirService: TaskConfirService = new TaskConfirService();
  private taskContext: TaskConfirContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskConfirService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
