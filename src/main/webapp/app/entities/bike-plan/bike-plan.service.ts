import axios from 'axios';

import { IBikePlan } from '@/shared/model/bike-plan.model';

const baseApiUrl = 'api/bike-plans';

export default class BikePlanService {
  public find(id: number): Promise<IBikePlan> {
    return new Promise<IBikePlan>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${id}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public retrieve(): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(baseApiUrl)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
