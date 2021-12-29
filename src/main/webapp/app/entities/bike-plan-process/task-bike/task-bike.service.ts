import axios from 'axios';
import { TaskBikeContext } from './task-bike.model';

const baseApiUrl = 'api/bike-plan-process/task-bike';

export default class TaskBikeService {
  public loadContext(taskId: number): Promise<TaskBikeContext> {
    return new Promise<TaskBikeContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskBikeContext> {
    return new Promise<TaskBikeContext>((resolve, reject) => {
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

  public complete(taskBikeContext: TaskBikeContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskBikeContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
