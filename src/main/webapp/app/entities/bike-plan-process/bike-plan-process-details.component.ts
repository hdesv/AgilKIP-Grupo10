import { Component, Vue, Inject } from 'vue-property-decorator';

import { IBikePlanProcess } from '@/shared/model/bike-plan-process.model';
import BikePlanProcessService from './bike-plan-process.service';

@Component
export default class BikePlanProcessDetailsComponent extends Vue {
  @Inject('bikePlanProcessService') private bikePlanProcessService: () => BikePlanProcessService;
  public bikePlanProcess: IBikePlanProcess = {};

  public isFetching: boolean = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.processInstanceId) {
        vm.retrieveBikePlanProcess(to.params.processInstanceId);
      }
    });
  }

  public retrieveBikePlanProcess(bikePlanProcessId) {
    this.isFetching = true;
    this.bikePlanProcessService()
      .find(bikePlanProcessId)
      .then(
        res => {
          this.bikePlanProcess = res;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public previousState() {
    this.$router.go(-1);
  }
}
