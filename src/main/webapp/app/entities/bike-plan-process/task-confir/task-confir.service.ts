import axios from 'axios';
import { TaskConfirContext } from './task-confir.model';

const baseApiUrl = 'api/bike-plan-process/task-confir';

export default class TaskConfirService {
  public loadContext(taskId: number): Promise<TaskConfirContext> {
    return new Promise<TaskConfirContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskConfirContext> {
    return new Promise<TaskConfirContext>((resolve, reject) => {
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

  public complete(taskConfirContext: TaskConfirContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskConfirContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
