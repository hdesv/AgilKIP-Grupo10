import { Component, Vue, Inject } from 'vue-property-decorator';

import { IBikePlanProcess, BikePlanProcess } from '@/shared/model/bike-plan-process.model';

import { ProcessInstance, ProcessDefinitionService } from 'akip-vue-community';

import { BikePlan } from '@/shared/model/bike-plan.model';
import BikePlanProcessService from './bike-plan-process.service';

const validations: any = {
  bikePlanProcess: {
    bikePlan: {
      experience: {},
      nameClient: {},
      phoneNumber: {},
      userEmail: {},
      startDate: {},
      endDate: {},
      wantTour: {},
    },
  },
};

@Component({
  validations,
})
export default class BikePlanStartFormInitComponent extends Vue {
  @Inject('bikePlanProcessService') private bikePlanProcessService: () => BikePlanProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'BikePlanProcess';
  public bikePlanProcess: IBikePlanProcess = new BikePlanProcess();

  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      vm.initBikePlanStartForm();
      vm.initRelationships();
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;

    this.bikePlanProcessService()
      .create(this.bikePlanProcess)
      .then(param => {
        this.isSaving = false;
        this.$router.go(-1);
        const message = this.$t('bikeApp.bikePlanStartForm.created', { param: param.id });
        this.$root.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Success',
          variant: 'success',
          solid: true,
          autoHideDelay: 5000,
        });
      });
  }

  public initBikePlanStartForm(): void {
    this.bikePlanProcess.bikePlan = new BikePlan();
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(res => {
      this.bikePlanProcess.processInstance = new ProcessInstance();
      this.bikePlanProcess.processInstance.processDefinition = res;
    });
  }
}
