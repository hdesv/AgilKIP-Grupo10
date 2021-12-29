<template>
  <div>
    <h2 id="page-heading" data-cy="BikePlanHeading">
      <span v-text="$t('bikeApp.bikePlan.home.title')" id="bike-plan-heading">Bike Plans</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('bikeApp.bikePlan.home.refreshListLabel')">Refresh List</span>
        </button>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && bikePlans && bikePlans.length === 0">
      <span v-text="$t('bikeApp.bikePlan.home.notFound')">No bikePlans found</span>
    </div>
    <div class="table-responsive" v-if="bikePlans && bikePlans.length > 0">
      <table class="table table-striped" aria-describedby="bikePlans">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('bikeApp.bikePlan.experience')">Experience</span></th>
            <th scope="row"><span v-text="$t('bikeApp.bikePlan.nameClient')">Name Client</span></th>
            <th scope="row"><span v-text="$t('bikeApp.bikePlan.phoneNumber')">Phone Number</span></th>
            <th scope="row"><span v-text="$t('bikeApp.bikePlan.userName')">User Name</span></th>
            <th scope="row"><span v-text="$t('bikeApp.bikePlan.userEmail')">User Email</span></th>
            <th scope="row"><span v-text="$t('bikeApp.bikePlan.startDate')">Start Date</span></th>
            <th scope="row"><span v-text="$t('bikeApp.bikePlan.endDate')">End Date</span></th>
            <th scope="row"><span v-text="$t('bikeApp.bikePlan.bikeNumber')">Bike Number</span></th>
            <th scope="row"><span v-text="$t('bikeApp.bikePlan.tourNumber')">Tour Number</span></th>
            <th scope="row"><span v-text="$t('bikeApp.bikePlan.tourCity')">Tour City</span></th>
            <th scope="row"><span v-text="$t('bikeApp.bikePlan.clienteNumber')">Cliente Number</span></th>
            <th scope="row"><span v-text="$t('bikeApp.bikePlan.wantTour')">Want Tour</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="bikePlan in bikePlans" :key="bikePlan.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'BikePlanView', params: { bikePlanId: bikePlan.id } }">{{ bikePlan.id }}</router-link>
            </td>
            <td>{{ bikePlan.experience }}</td>
            <td>{{ bikePlan.nameClient }}</td>
            <td>{{ bikePlan.phoneNumber }}</td>
            <td>{{ bikePlan.userName }}</td>
            <td>{{ bikePlan.userEmail }}</td>
            <td>{{ bikePlan.startDate }}</td>
            <td>{{ bikePlan.endDate }}</td>
            <td>{{ bikePlan.bikeNumber }}</td>
            <td>{{ bikePlan.tourNumber }}</td>
            <td v-text="$t('bikeApp.tourCity.' + bikePlan.tourCity)">{{ bikePlan.tourCity }}</td>
            <td>{{ bikePlan.clienteNumber }}</td>
            <td>{{ bikePlan.wantTour }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'BikePlanView', params: { bikePlanId: bikePlan.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span id="bikeApp.bikePlan.delete.question" data-cy="bikePlanDeleteDialogHeading" v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-bikePlan-heading" v-text="$t('bikeApp.bikePlan.delete.question', { id: removeId })">
          Are you sure you want to delete this Bike Plan?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-bikePlan"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeBikePlan()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./bike-plan.component.ts"></script>
