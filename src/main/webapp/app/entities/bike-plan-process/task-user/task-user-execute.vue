<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="taskContext.taskInstance">
        <h2 id="page-heading" data-cy="TaskInstanceHeading">
          <span v-text="$t('bikeApp.taskInstance.execute.title')" id="task-instance-heading">Task Execution</span>
        </h2>
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bikeApp.taskUser.experience')" for="task-user-experience">Experience</label>
              <input
                type="text"
                class="form-control"
                name="experience"
                id="task-user-experience"
                readonly
                data-cy="experience"
                :class="{
                  valid: !$v.taskContext.bikePlanProcess.bikePlan.experience.$invalid,
                  invalid: $v.taskContext.bikePlanProcess.bikePlan.experience.$invalid,
                }"
                v-model="$v.taskContext.bikePlanProcess.bikePlan.experience.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bikeApp.taskUser.nameClient')" for="task-user-nameClient">Name Client</label>
              <input
                type="text"
                class="form-control"
                name="nameClient"
                id="task-user-nameClient"
                readonly
                data-cy="nameClient"
                :class="{
                  valid: !$v.taskContext.bikePlanProcess.bikePlan.nameClient.$invalid,
                  invalid: $v.taskContext.bikePlanProcess.bikePlan.nameClient.$invalid,
                }"
                v-model="$v.taskContext.bikePlanProcess.bikePlan.nameClient.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bikeApp.taskUser.phoneNumber')" for="task-user-phoneNumber">Phone Number</label>
              <input
                type="number"
                class="form-control"
                name="phoneNumber"
                id="task-user-phoneNumber"
                readonly
                data-cy="phoneNumber"
                :class="{
                  valid: !$v.taskContext.bikePlanProcess.bikePlan.phoneNumber.$invalid,
                  invalid: $v.taskContext.bikePlanProcess.bikePlan.phoneNumber.$invalid,
                }"
                v-model.number="$v.taskContext.bikePlanProcess.bikePlan.phoneNumber.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bikeApp.taskUser.startDate')" for="task-user-startDate">Start Date</label>
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-user-startDate"
                  readonly
                  data-cy="startDate"
                  type="text"
                  class="form-control"
                  name="startDate"
                  :class="{
                    valid: !$v.taskContext.bikePlanProcess.bikePlan.startDate.$invalid,
                    invalid: $v.taskContext.bikePlanProcess.bikePlan.startDate.$invalid,
                  }"
                  v-model="$v.taskContext.bikePlanProcess.bikePlan.startDate.$model"
                />
              </b-input-group>
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bikeApp.taskUser.endDate')" for="task-user-endDate">End Date</label>
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-user-endDate"
                  readonly
                  data-cy="endDate"
                  type="text"
                  class="form-control"
                  name="endDate"
                  :class="{
                    valid: !$v.taskContext.bikePlanProcess.bikePlan.endDate.$invalid,
                    invalid: $v.taskContext.bikePlanProcess.bikePlan.endDate.$invalid,
                  }"
                  v-model="$v.taskContext.bikePlanProcess.bikePlan.endDate.$model"
                />
              </b-input-group>
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bikeApp.taskUser.userName')" for="task-user-userName">User Name</label>
              <input
                type="text"
                class="form-control"
                name="userName"
                id="task-user-userName"
                data-cy="userName"
                :class="{
                  valid: !$v.taskContext.bikePlanProcess.bikePlan.userName.$invalid,
                  invalid: $v.taskContext.bikePlanProcess.bikePlan.userName.$invalid,
                }"
                v-model="$v.taskContext.bikePlanProcess.bikePlan.userName.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bikeApp.taskUser.clienteNumber')" for="task-user-clienteNumber"
                >Cliente Number</label
              >
              <input
                type="number"
                class="form-control"
                name="clienteNumber"
                id="task-user-clienteNumber"
                data-cy="clienteNumber"
                :class="{
                  valid: !$v.taskContext.bikePlanProcess.bikePlan.clienteNumber.$invalid,
                  invalid: $v.taskContext.bikePlanProcess.bikePlan.clienteNumber.$invalid,
                }"
                v-model.number="$v.taskContext.bikePlanProcess.bikePlan.clienteNumber.$model"
              />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <button type="submit" v-on:click.prevent="complete()" class="btn btn-success" data-cy="complete">
          <font-awesome-icon icon="check-circle"></font-awesome-icon>&nbsp;Complete
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./task-user-execute.component.ts"></script>
