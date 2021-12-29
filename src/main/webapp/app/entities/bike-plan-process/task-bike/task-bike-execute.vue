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
              <label class="form-control-label" v-text="$t('bikeApp.taskBike.experience')" for="task-bike-experience">Experience</label>
              <input
                type="text"
                class="form-control"
                name="experience"
                id="task-bike-experience"
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
              <label class="form-control-label" v-text="$t('bikeApp.taskBike.nameClient')" for="task-bike-nameClient">Name Client</label>
              <input
                type="text"
                class="form-control"
                name="nameClient"
                id="task-bike-nameClient"
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
              <label class="form-control-label" v-text="$t('bikeApp.taskBike.startDate')" for="task-bike-startDate">Start Date</label>
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-bike-startDate"
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
              <label class="form-control-label" v-text="$t('bikeApp.taskBike.endDate')" for="task-bike-endDate">End Date</label>
              <b-input-group class="mb-3">
                <b-form-input
                  id="task-bike-endDate"
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
              <label class="form-control-label" v-text="$t('bikeApp.taskBike.bikeNumber')" for="task-bike-bikeNumber">Bike Number</label>
              <input
                type="number"
                class="form-control"
                name="bikeNumber"
                id="task-bike-bikeNumber"
                data-cy="bikeNumber"
                :class="{
                  valid: !$v.taskContext.bikePlanProcess.bikePlan.bikeNumber.$invalid,
                  invalid: $v.taskContext.bikePlanProcess.bikePlan.bikeNumber.$invalid,
                }"
                v-model.number="$v.taskContext.bikePlanProcess.bikePlan.bikeNumber.$model"
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

<script lang="ts" src="./task-bike-execute.component.ts"></script>
