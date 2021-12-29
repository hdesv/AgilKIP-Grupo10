import axios from 'axios';
import { TaskReserveContext } from './task-reserve.model';

const baseApiUrl = 'api/bike-plan-process/task-reserve';

export default class TaskReserveService {
  public loadContext(taskId: number): Promise<TaskReserveContext> {
    return new Promise<TaskReserveContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public claim(taskId: number): Promise<TaskReserveContext> {
    return new Promise<TaskReserveContext>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${taskId}/claim`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public complete(taskReserveContext: TaskReserveContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskReserveContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
