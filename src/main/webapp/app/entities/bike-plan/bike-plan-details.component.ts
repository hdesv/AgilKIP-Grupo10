import { Component, Vue, Inject } from 'vue-property-decorator';

import { IBikePlan } from '@/shared/model/bike-plan.model';
import BikePlanService from './bike-plan.service';

@Component
export default class BikePlanDetails extends Vue {
  @Inject('bikePlanService') private bikePlanService: () => BikePlanService;
  public bikePlan: IBikePlan = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.bikePlanId) {
        vm.retrieveBikePlan(to.params.bikePlanId);
      }
    });
  }

  public retrieveBikePlan(bikePlanId) {
    this.bikePlanService()
      .find(bikePlanId)
      .then(res => {
        this.bikePlan = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
