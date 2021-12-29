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
              <label class="form-control-label" v-text="$t('bikeApp.taskUser.experience')">experience</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="experience"
                id="bike-plan-experience"
                data-cy="experience"
                v-model="taskContext.bikePlanProcess.bikePlan.experience"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bikeApp.taskUser.nameClient')">nameClient</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="nameClient"
                id="bike-plan-nameClient"
                data-cy="nameClient"
                v-model="taskContext.bikePlanProcess.bikePlan.nameClient"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bikeApp.taskUser.phoneNumber')">phoneNumber</label>
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
              <label class="form-control-label" v-text="$t('bikeApp.taskUser.startDate')">startDate</label>
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
              <label class="form-control-label" v-text="$t('bikeApp.taskUser.endDate')">endDate</label>
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
              <label class="form-control-label" v-text="$t('bikeApp.taskUser.userName')">userName</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="userName"
                id="bike-plan-userName"
                data-cy="userName"
                v-model="taskContext.bikePlanProcess.bikePlan.userName"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bikeApp.taskUser.clienteNumber')">clienteNumber</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="clienteNumber"
                id="bike-plan-clienteNumber"
                data-cy="clienteNumber"
                v-model="taskContext.bikePlanProcess.bikePlan.clienteNumber"
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
          :to="`/process-definition/BikePlanProcess/task/TaskUser/${taskContext.taskInstance.id}/execute`"
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

<script lang="ts" src="./task-user-details.component.ts"></script>
