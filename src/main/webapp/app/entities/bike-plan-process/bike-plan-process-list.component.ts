import { Component, Vue, Inject } from 'vue-property-decorator';
import { IBikePlanProcess } from '@/shared/model/bike-plan-process.model';

import { ProcessDefinition, ProcessDefinitionService } from 'akip-vue-community';

import BikePlanProcessService from './bike-plan-process.service';

@Component
export default class BikePlanProcessListComponent extends Vue {
  @Inject('bikePlanProcessService') private bikePlanProcessService: () => BikePlanProcessService;

  private processDefinitionService: ProcessDefinitionService = new ProcessDefinitionService();

  public bpmnProcessDefinitionId: string = 'BikePlanProcess';
  public processDefinition: ProcessDefinition = new ProcessDefinition();
  public bikePlanProcessList: IBikePlanProcess[] = [];

  public isFetchingProcessDefinition = false;
  public isFetchingProcessInstances = false;

  public mounted(): void {
    this.init();
  }

  public init(): void {
    this.retrieveProcessDefinition();
    this.retrieveProcessInstances();
  }

  public retrieveProcessDefinition() {
    this.isFetchingProcessDefinition = true;
    this.processDefinitionService.find(this.bpmnProcessDefinitionId).then(
      res => {
        this.processDefinition = res;
        this.isFetchingProcessDefinition = false;
      },
      err => {
        this.isFetchingProcessDefinition = false;
      }
    );
  }

  public retrieveProcessInstances(): void {
    this.isFetchingProcessInstances = true;
    this.bikePlanProcessService()
      .retrieve()
      .then(
        res => {
          this.bikePlanProcessList = res.data;
          this.isFetchingProcessInstances = false;
        },
        err => {
          this.isFetchingProcessInstances = false;
        }
      );
  }

  get isFetching(): boolean {
    return this.isFetchingProcessDefinition && this.isFetchingProcessInstances;
  }

  public handleSyncList(): void {
    this.retrieveProcessInstances();
  }

  public previousState(): void {
    this.$router.go(-1);
  }
}
