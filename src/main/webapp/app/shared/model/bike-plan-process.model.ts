import { IBikePlan } from '@/shared/model/bike-plan.model';

export interface IBikePlanProcess {
  id?: number;
  processInstance?: any | null;
  bikePlan?: IBikePlan | null;
}

export class BikePlanProcess implements IBikePlanProcess {
  constructor(public id?: number, public processInstance?: any | null, public bikePlan?: IBikePlan | null) {}
}
