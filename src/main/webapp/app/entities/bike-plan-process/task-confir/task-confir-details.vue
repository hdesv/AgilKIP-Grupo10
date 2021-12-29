<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <h2 id="page-heading" data-cy="TaskInstanceHeading">
        <span v-text="$t('bikeApp.taskInstance.details.title')" id="task-instance-heading">Task Details</span>
      </h2>
      <div v-if="taskContext.taskInstance">
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bikeApp.taskConfir.name')">name</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="name"
                id="bike-plan-name"
                data-cy="name"
                v-model="taskContext.bikePlanProcess.bikePlan.name"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bikeApp.taskConfir.phoneNumber')">phoneNumber</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="phoneNumber"
                id="bike-plan-phoneNumber"
                data-cy="phoneNumber"
                v-model="taskContext.bikePlanProcess.bikePlan.phoneNumber"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bikeApp.taskConfir.startDate')">startDate</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="startDate"
                id="bike-plan-startDate"
                data-cy="startDate"
                v-model="taskContext.bikePlanProcess.bikePlan.startDate"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bikeApp.taskConfir.endDate')">endDate</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="endDate"
                id="bike-plan-endDate"
                data-cy="endDate"
                v-model="taskContext.bikePlanProcess.bikePlan.endDate"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bikeApp.taskConfir.confirm')">confirm</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="confirm"
                id="bike-plan-confirm"
                data-cy="confirm"
                v-model="taskContext.bikePlanProcess.bikePlan.confirm"
              />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>

        <router-link
          v-if="taskContext.taskInstance.status == 'NEW' || taskContext.taskInstance.status == 'ASSIGNED'"
          :to="`/process-definition/BikePlanProcess/task/TaskConfir/${taskContext.taskInstance.id}/execute`"
          tag="button"
          class="btn btn-primary"
          data-cy="entityDetailsButton"
        >
          <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;Execute
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./task-confir-details.component.ts"></script>
