/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import BikePlanDetailComponent from '@/entities/bike-plan/bike-plan-details.vue';
import BikePlanClass from '@/entities/bike-plan/bike-plan-details.component';
import BikePlanService from '@/entities/bike-plan/bike-plan.service';
import router from '@/router';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('BikePlan Management Detail Component', () => {
    let wrapper: Wrapper<BikePlanClass>;
    let comp: BikePlanClass;
    let bikePlanServiceStub: SinonStubbedInstance<BikePlanService>;

    beforeEach(() => {
      bikePlanServiceStub = sinon.createStubInstance<BikePlanService>(BikePlanService);

      wrapper = shallowMount<BikePlanClass>(BikePlanDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { bikePlanService: () => bikePlanServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundBikePlan = { id: 123 };
        bikePlanServiceStub.find.resolves(foundBikePlan);

        // WHEN
        comp.retrieveBikePlan(123);
        await comp.$nextTick();

        // THEN
        expect(comp.bikePlan).toBe(foundBikePlan);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundBikePlan = { id: 123 };
        bikePlanServiceStub.find.resolves(foundBikePlan);

        // WHEN
        comp.beforeRouteEnter({ params: { bikePlanId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.bikePlan).toBe(foundBikePlan);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        comp.previousState();
        await comp.$nextTick();

        expect(comp.$router.currentRoute.fullPath).toContain('/');
      });
    });
  });
});
