import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore

// prettier-ignore
const BikePlan = () => import('@/entities/bike-plan/bike-plan.vue');
// prettier-ignore
const BikePlanDetails = () => import('@/entities/bike-plan/bike-plan-details.vue');
// prettier-ignore
const BikePlanProcessDetails = () => import('@/entities/bike-plan-process/bike-plan-process-details.vue');
// prettier-ignore
const BikePlanProcessList = () => import('@/entities/bike-plan-process/bike-plan-process-list.vue');
// prettier-ignore
const BikePlanStartFormInit = () => import('@/entities/bike-plan-process/bike-plan-start-form-init.vue');
// prettier-ignore
const BikePlanProcess_TaskBikeDetails = () => import('@/entities/bike-plan-process/task-bike/task-bike-details.vue');
// prettier-ignore
const BikePlanProcess_TaskBikeExecute = () => import('@/entities/bike-plan-process/task-bike/task-bike-execute.vue');
// prettier-ignore
const BikePlanProcess_TaskTourDetails = () => import('@/entities/bike-plan-process/task-tour/task-tour-details.vue');
// prettier-ignore
const BikePlanProcess_TaskTourExecute = () => import('@/entities/bike-plan-process/task-tour/task-tour-execute.vue');
// prettier-ignore
const BikePlanProcess_TaskUserDetails = () => import('@/entities/bike-plan-process/task-user/task-user-details.vue');
// prettier-ignore
const BikePlanProcess_TaskUserExecute = () => import('@/entities/bike-plan-process/task-user/task-user-execute.vue');
// prettier-ignore
const BikePlanProcess_TaskConfirDetails = () => import('@/entities/bike-plan-process/task-confir/task-confir-details.vue');
// prettier-ignore
const BikePlanProcess_TaskConfirExecute = () => import('@/entities/bike-plan-process/task-confir/task-confir-execute.vue');
// prettier-ignore
const BikePlanProcess_TaskReserveDetails = () => import('@/entities/bike-plan-process/task-reserve/task-reserve-details.vue');
// prettier-ignore
const BikePlanProcess_TaskReserveExecute = () => import('@/entities/bike-plan-process/task-reserve/task-reserve-execute.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default [
  {
    path: '/bike-plan',
    name: 'BikePlan',
    component: BikePlan,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/bike-plan/:bikePlanId/view',
    name: 'BikePlanView',
    component: BikePlanDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/BikePlanProcess/instance/:processInstanceId/view',
    name: 'BikePlanProcessView',
    component: BikePlanProcessDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/BikePlanProcess/instances',
    name: 'BikePlanProcessList',
    component: BikePlanProcessList,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/BikePlanProcess/init',
    name: 'BikePlanStartFormInit',
    component: BikePlanStartFormInit,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/BikePlanProcess/task/TaskBike/:taskInstanceId/view',
    name: 'BikePlanProcess_TaskBikeDetails',
    component: BikePlanProcess_TaskBikeDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/BikePlanProcess/task/TaskBike/:taskInstanceId/execute',
    name: 'BikePlanProcess_TaskBikeExecute',
    component: BikePlanProcess_TaskBikeExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/BikePlanProcess/task/TaskTour/:taskInstanceId/view',
    name: 'BikePlanProcess_TaskTourDetails',
    component: BikePlanProcess_TaskTourDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/BikePlanProcess/task/TaskTour/:taskInstanceId/execute',
    name: 'BikePlanProcess_TaskTourExecute',
    component: BikePlanProcess_TaskTourExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/BikePlanProcess/task/TaskUser/:taskInstanceId/view',
    name: 'BikePlanProcess_TaskUserDetails',
    component: BikePlanProcess_TaskUserDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/BikePlanProcess/task/TaskUser/:taskInstanceId/execute',
    name: 'BikePlanProcess_TaskUserExecute',
    component: BikePlanProcess_TaskUserExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/BikePlanProcess/task/TaskConfir/:taskInstanceId/view',
    name: 'BikePlanProcess_TaskConfirDetails',
    component: BikePlanProcess_TaskConfirDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/BikePlanProcess/task/TaskConfir/:taskInstanceId/execute',
    name: 'BikePlanProcess_TaskConfirExecute',
    component: BikePlanProcess_TaskConfirExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/BikePlanProcess/task/TaskReserve/:taskInstanceId/view',
    name: 'BikePlanProcess_TaskReserveDetails',
    component: BikePlanProcess_TaskReserveDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/BikePlanProcess/task/TaskReserve/:taskInstanceId/execute',
    name: 'BikePlanProcess_TaskReserveExecute',
    component: BikePlanProcess_TaskReserveExecute,
    meta: { authorities: [Authority.USER] },
  },
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
