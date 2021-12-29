/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import BikePlanComponent from '@/entities/bike-plan/bike-plan.vue';
import BikePlanClass from '@/entities/bike-plan/bike-plan.component';
import BikePlanService from '@/entities/bike-plan/bike-plan.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  describe('BikePlan Management Component', () => {
    let wrapper: Wrapper<BikePlanClass>;
    let comp: BikePlanClass;
    let bikePlanServiceStub: SinonStubbedInstance<BikePlanService>;

    beforeEach(() => {
      bikePlanServiceStub = sinon.createStubInstance<BikePlanService>(BikePlanService);
      bikePlanServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<BikePlanClass>(BikePlanComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          bikePlanService: () => bikePlanServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      bikePlanServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllBikePlans();
      await comp.$nextTick();

      // THEN
      expect(bikePlanServiceStub.retrieve.called).toBeTruthy();
      expect(comp.bikePlans[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
