import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IBikePlan } from '@/shared/model/bike-plan.model';

import BikePlanService from './bike-plan.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class BikePlan extends Vue {
  @Inject('bikePlanService') private bikePlanService: () => BikePlanService;
  private removeId: number = null;

  public bikePlans: IBikePlan[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllBikePlans();
  }

  public clear(): void {
    this.retrieveAllBikePlans();
  }

  public retrieveAllBikePlans(): void {
    this.isFetching = true;

    this.bikePlanService()
      .retrieve()
      .then(
        res => {
          this.bikePlans = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
