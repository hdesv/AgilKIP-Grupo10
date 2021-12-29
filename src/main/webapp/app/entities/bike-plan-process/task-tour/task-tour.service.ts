import axios from 'axios';
import { TaskTourContext } from './task-tour.model';

const baseApiUrl = 'api/bike-plan-process/task-tour';

export default class TaskTourService {
  public loadContext(taskId: number): Promise<TaskTourContext> {
    return new Promise<TaskTourContext>((resolve, reject) => {
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

  public claim(taskId: number): Promise<TaskTourContext> {
    return new Promise<TaskTourContext>((resolve, reject) => {
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

  public complete(taskTourContext: TaskTourContext): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}/complete`, taskTourContext)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
