import { Component, Vue, Inject } from 'vue-property-decorator';

import TaskTourService from './task-tour.service';
import { TaskTourContext } from './task-tour.model';

@Component
export default class TaskTourDetailsComponent extends Vue {
  private taskTourService: TaskTourService = new TaskTourService();
  private taskContext: TaskTourContext = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.taskInstanceId) {
        vm.retrieveContext(to.params.taskInstanceId);
      }
    });
  }

  public retrieveContext(taskInstanceId) {
    this.taskTourService.loadContext(taskInstanceId).then(res => {
      this.taskContext = res;
    });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
