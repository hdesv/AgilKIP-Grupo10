import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskUserService from './task-user.service';
import { TaskUserContext } from './task-user.model';

@Component
export default class TaskUserDetailsComponent extends Vue {
  private taskUserService: TaskUserService = new TaskUserService();
  private taskContext: TaskUserContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskUserService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
