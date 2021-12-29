import axios from 'axios';

import { IBikePlanProcess } from '@/shared/model/bike-plan-process.model';

const baseApiUrl = 'api/bike-plan-processes';

export default class BikePlanProcessService {
  public find(id: number): Promise<IBikePlanProcess> {
    return new Promise<IBikePlanProcess>((resolve, reject) => {
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

  public create(entity: IBikePlanProcess): Promise<IBikePlanProcess> {
    return new Promise<IBikePlanProcess>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}`, entity)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
