<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="bikePlanProcess.processInstance">
        <h2 class="jh-entity-heading" data-cy="bikePlanProcessDetailsHeading">
          <span v-text="$t('bikeApp.bikePlanProcess.detail.title')">BikePlanProcess</span> {{ bikePlanProcess.id }}
        </h2>
        <akip-show-process-instance :processInstance="bikePlanProcess.processInstance">
          <template v-slot:title>
            <span v-text="$t('bikeApp.bikePlanProcess.detail.title')">BikePlanProcess</span> #{{ bikePlanProcess.id }}
          </template>
          <template v-slot:details>
            <div class="card" v-if="bikePlanProcess.bikePlan">
              <h5 class="card-header">
                <span class="title"> Bike Plan #{{ bikePlanProcess.bikePlan.id }} </span>
              </h5>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('bikeApp.bikePlanProcess.experience')">experience</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="experience"
                    id="bike-plan-experience"
                    data-cy="experience"
                    v-model="bikePlanProcess.bikePlan.experience"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('bikeApp.bikePlanProcess.nameClient')">nameClient</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="nameClient"
                    id="bike-plan-nameClient"
                    data-cy="nameClient"
                    v-model="bikePlanProcess.bikePlan.nameClient"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('bikeApp.bikePlanProcess.phoneNumber')">phoneNumber</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="phoneNumber"
                    id="bike-plan-phoneNumber"
                    data-cy="phoneNumber"
                    v-model="bikePlanProcess.bikePlan.phoneNumber"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('bikeApp.bikePlanProcess.userEmail')">userEmail</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="userEmail"
                    id="bike-plan-userEmail"
                    data-cy="userEmail"
                    v-model="bikePlanProcess.bikePlan.userEmail"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('bikeApp.bikePlanProcess.startDate')">startDate</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="startDate"
                    id="bike-plan-startDate"
                    data-cy="startDate"
                    v-model="bikePlanProcess.bikePlan.startDate"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('bikeApp.bikePlanProcess.endDate')">endDate</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="endDate"
                    id="bike-plan-endDate"
                    data-cy="endDate"
                    v-model="bikePlanProcess.bikePlan.endDate"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('bikeApp.bikePlanProcess.userName')">userName</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="userName"
                    id="bike-plan-userName"
                    data-cy="userName"
                    v-model="bikePlanProcess.bikePlan.userName"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('bikeApp.bikePlanProcess.bikeNumber')">bikeNumber</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="bikeNumber"
                    id="bike-plan-bikeNumber"
                    data-cy="bikeNumber"
                    v-model="bikePlanProcess.bikePlan.bikeNumber"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('bikeApp.bikePlanProcess.tourNumber')">tourNumber</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="tourNumber"
                    id="bike-plan-tourNumber"
                    data-cy="tourNumber"
                    v-model="bikePlanProcess.bikePlan.tourNumber"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('bikeApp.bikePlanProcess.tourCity')">tourCity</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="tourCity"
                    id="bike-plan-tourCity"
                    data-cy="tourCity"
                    v-model="bikePlanProcess.bikePlan.tourCity"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('bikeApp.bikePlanProcess.clienteNumber')">clienteNumber</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="clienteNumber"
                    id="bike-plan-clienteNumber"
                    data-cy="clienteNumber"
                    v-model="bikePlanProcess.bikePlan.clienteNumber"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('bikeApp.bikePlanProcess.wantTour')">wantTour</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="wantTour"
                    id="bike-plan-wantTour"
                    data-cy="wantTour"
                    v-model="bikePlanProcess.bikePlan.wantTour"
                  />
                </div>
              </div>
            </div>
          </template>
        </akip-show-process-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./bike-plan-process-details.component.ts"></script>
