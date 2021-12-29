<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="bikePlan">
        <h2 class="jh-entity-heading" data-cy="bikePlanDetailsHeading">
          <span v-text="$t('bikeApp.bikePlan.detail.title')">BikePlan</span> {{ bikePlan.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('bikeApp.bikePlan.experience')">Experience</span>
          </dt>
          <dd>
            <span>{{ bikePlan.experience }}</span>
          </dd>
          <dt>
            <span v-text="$t('bikeApp.bikePlan.nameClient')">Name Client</span>
          </dt>
          <dd>
            <span>{{ bikePlan.nameClient }}</span>
          </dd>
          <dt>
            <span v-text="$t('bikeApp.bikePlan.phoneNumber')">Phone Number</span>
          </dt>
          <dd>
            <span>{{ bikePlan.phoneNumber }}</span>
          </dd>
          <dt>
            <span v-text="$t('bikeApp.bikePlan.userName')">User Name</span>
          </dt>
          <dd>
            <span>{{ bikePlan.userName }}</span>
          </dd>
          <dt>
            <span v-text="$t('bikeApp.bikePlan.userEmail')">User Email</span>
          </dt>
          <dd>
            <span>{{ bikePlan.userEmail }}</span>
          </dd>
          <dt>
            <span v-text="$t('bikeApp.bikePlan.startDate')">Start Date</span>
          </dt>
          <dd>
            <span>{{ bikePlan.startDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('bikeApp.bikePlan.endDate')">End Date</span>
          </dt>
          <dd>
            <span>{{ bikePlan.endDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('bikeApp.bikePlan.bikeNumber')">Bike Number</span>
          </dt>
          <dd>
            <span>{{ bikePlan.bikeNumber }}</span>
          </dd>
          <dt>
            <span v-text="$t('bikeApp.bikePlan.tourNumber')">Tour Number</span>
          </dt>
          <dd>
            <span>{{ bikePlan.tourNumber }}</span>
          </dd>
          <dt>
            <span v-text="$t('bikeApp.bikePlan.tourCity')">Tour City</span>
          </dt>
          <dd>
            <span v-text="$t('bikeApp.tourCity.' + bikePlan.tourCity)">{{ bikePlan.tourCity }}</span>
          </dd>
          <dt>
            <span v-text="$t('bikeApp.bikePlan.clienteNumber')">Cliente Number</span>
          </dt>
          <dd>
            <span>{{ bikePlan.clienteNumber }}</span>
          </dd>
          <dt>
            <span v-text="$t('bikeApp.bikePlan.wantTour')">Want Tour</span>
          </dt>
          <dd>
            <span>{{ bikePlan.wantTour }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./bike-plan-details.component.ts"></script>
