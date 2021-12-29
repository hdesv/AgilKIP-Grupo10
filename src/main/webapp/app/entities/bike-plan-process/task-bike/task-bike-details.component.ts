import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskBikeService from './task-bike.service';
import { TaskBikeContext } from './task-bike.model';

@Component
export default class TaskBikeDetailsComponent extends Vue {
  private taskBikeService: TaskBikeService = new TaskBikeService();
  private taskContext: TaskBikeContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskBikeService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
