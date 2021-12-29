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
              <label class="form-control-label" v-text="$t('bikeApp.taskReserve.name')" for="task-reserve-name">Name</label>
              <input
                type="text"
                class="form-control"
                name="name"
                id="task-reserve-name"
                readonly
                data-cy="name"
                :class="{
                  valid: !$v.taskContext.bikePlanProcess.bikePlan.name.$invalid,
                  invalid: $v.taskContext.bikePlanProcess.bikePlan.name.$invalid,
                }"
                v-model="$v.taskContext.bikePlanProcess.bikePlan.name.$model"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('bikeApp.taskReserve.startDate')" for="task-reserve-startDate">Start Date</label>
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-reserve-startDate"
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
              <label class="form-control-label" v-text="$t('bikeApp.taskReserve.endDate')" for="task-reserve-endDate">End Date</label>
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-reserve-endDate"
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
              <label class="form-control-label" v-text="$t('bikeApp.taskReserve.confirmReserve')" for="task-reserve-confirmReserve"
                >Confirm Reserve</label
              >
              <input
                type="text"
                class="form-control"
                name="confirmReserve"
                id="task-reserve-confirmReserve"
                data-cy="confirmReserve"
                :class="{
                  valid: !$v.taskContext.bikePlanProcess.bikePlan.confirmReserve.$invalid,
                  invalid: $v.taskContext.bikePlanProcess.bikePlan.confirmReserve.$invalid,
                }"
                v-model="$v.taskContext.bikePlanProcess.bikePlan.confirmReserve.$model"
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

<script lang="ts" src="./task-reserve-execute.component.ts"></script>
