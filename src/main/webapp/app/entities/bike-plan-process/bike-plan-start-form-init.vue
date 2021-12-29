<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="bikeApp.bikePlanStartForm.home.createOrEditLabel"
          data-cy="BikePlanStartFormCreateUpdateHeading"
          v-text="$t('bikeApp.bikePlanStartForm.home.createOrEditLabel')"
        >
          Create or edit a BikePlanStartForm
        </h2>
        <div v-if="bikePlanProcess.processInstance">
          <akip-show-process-definition :processDefinition="bikePlanProcess.processInstance.processDefinition">
            <template v-slot:body>
              <hr />
              <div v-if="bikePlanProcess.bikePlan">
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('bikeApp.bikePlanStartForm.experience')"
                    for="bike-plan-start-form-experience"
                    >Experience</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="experience"
                    id="bike-plan-start-form-experience"
                    data-cy="experience"
                    :class="{
                      valid: !$v.bikePlanProcess.bikePlan.experience.$invalid,
                      invalid: $v.bikePlanProcess.bikePlan.experience.$invalid,
                    }"
                    v-model="$v.bikePlanProcess.bikePlan.experience.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('bikeApp.bikePlanStartForm.nameClient')"
                    for="bike-plan-start-form-nameClient"
                    >Name Client</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="nameClient"
                    id="bike-plan-start-form-nameClient"
                    data-cy="nameClient"
                    :class="{
                      valid: !$v.bikePlanProcess.bikePlan.nameClient.$invalid,
                      invalid: $v.bikePlanProcess.bikePlan.nameClient.$invalid,
                    }"
                    v-model="$v.bikePlanProcess.bikePlan.nameClient.$model"
                  />
                </div>
                <div class="form-group">
                  <label
                    class="form-control-label"
                    v-text="$t('bikeApp.bikePlanStartForm.phoneNumber')"
                    for="bike-plan-start-form-phoneNumber"
                    >Phone Number</label
                  >
                  <input
                    type="number"
                    class="form-control"
                    name="phoneNumber"
                    id="bike-plan-start-form-phoneNumber"
                    data-cy="phoneNumber"
                    :class="{
                      valid: !$v.bikePlanProcess.bikePlan.phoneNumber.$invalid,
                      invalid: $v.bikePlanProcess.bikePlan.phoneNumber.$invalid,
                    }"
                    v-model.number="$v.bikePlanProcess.bikePlan.phoneNumber.$model"
                  />
                </div>
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('bikeApp.bikePlanStartForm.userEmail')" for="bike-plan-start-form-userEmail"
                    >User Email</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="userEmail"
                    id="bike-plan-start-form-userEmail"
                    data-cy="userEmail"
                    :class="{
                      valid: !$v.bikePlanProcess.bikePlan.userEmail.$invalid,
                      invalid: $v.bikePlanProcess.bikePlan.userEmail.$invalid,
                    }"
                    v-model="$v.bikePlanProcess.bikePlan.userEmail.$model"
                  />
                </div>
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('bikeApp.bikePlanStartForm.startDate')" for="bike-plan-start-form-startDate"
                    >Start Date</label
                  >
                  <b-input-group class="mb-3">
                    <b-input-group-prepend>
                      <b-form-datepicker
                        aria-controls="bike-plan-start-form-startDate"
                        v-model="$v.bikePlanProcess.bikePlan.startDate.$model"
                        name="startDate"
                        class="form-control"
                        :locale="currentLanguage"
                        button-only
                        today-button
                        reset-button
                        close-button
                      >
                      </b-form-datepicker>
                    </b-input-group-prepend>
                    <b-form-input
                      id="bike-plan-start-form-startDate"
                      data-cy="startDate"
                      type="text"
                      class="form-control"
                      name="startDate"
                      :class="{
                        valid: !$v.bikePlanProcess.bikePlan.startDate.$invalid,
                        invalid: $v.bikePlanProcess.bikePlan.startDate.$invalid,
                      }"
                      v-model="$v.bikePlanProcess.bikePlan.startDate.$model"
                    />
                  </b-input-group>
                </div>
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('bikeApp.bikePlanStartForm.endDate')" for="bike-plan-start-form-endDate"
                    >End Date</label
                  >
                  <b-input-group class="mb-3">
                    <b-input-group-prepend>
                      <b-form-datepicker
                        aria-controls="bike-plan-start-form-endDate"
                        v-model="$v.bikePlanProcess.bikePlan.endDate.$model"
                        name="endDate"
                        class="form-control"
                        :locale="currentLanguage"
                        button-only
                        today-button
                        reset-button
                        close-button
                      >
                      </b-form-datepicker>
                    </b-input-group-prepend>
                    <b-form-input
                      id="bike-plan-start-form-endDate"
                      data-cy="endDate"
                      type="text"
                      class="form-control"
                      name="endDate"
                      :class="{
                        valid: !$v.bikePlanProcess.bikePlan.endDate.$invalid,
                        invalid: $v.bikePlanProcess.bikePlan.endDate.$invalid,
                      }"
                      v-model="$v.bikePlanProcess.bikePlan.endDate.$model"
                    />
                  </b-input-group>
                </div>
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('bikeApp.bikePlanStartForm.wantTour')" for="bike-plan-start-form-wantTour"
                    >Want Tour</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    name="wantTour"
                    id="bike-plan-start-form-wantTour"
                    data-cy="wantTour"
                    :class="{
                      valid: !$v.bikePlanProcess.bikePlan.wantTour.$invalid,
                      invalid: $v.bikePlanProcess.bikePlan.wantTour.$invalid,
                    }"
                    v-model="$v.bikePlanProcess.bikePlan.wantTour.$model"
                  />
                </div>
              </div>
            </template>
          </akip-show-process-definition>
          <br />
          <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.bikePlanProcess.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;<span>Start</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./bike-plan-start-form-init.component.ts"></script>
