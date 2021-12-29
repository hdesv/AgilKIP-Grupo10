import { tourCity } from '@/shared/model/enumerations/tour-city.model';
export interface IBikePlan {
  id?: number;
  experience?: string | null;
  nameClient?: string | null;
  phoneNumber?: number | null;
  userName?: string | null;
  userEmail?: string | null;
  startDate?: Date | null;
  endDate?: Date | null;
  bikeNumber?: number | null;
  tourNumber?: number | null;
  tourCity?: tourCity | null;
  clienteNumber?: number | null;
  wantTour?: string | null;
}

export class BikePlan implements IBikePlan {
  constructor(
    public id?: number,
    public experience?: string | null,
    public nameClient?: string | null,
    public phoneNumber?: number | null,
    public userName?: string | null,
    public userEmail?: string | null,
    public startDate?: Date | null,
    public endDate?: Date | null,
    public bikeNumber?: number | null,
    public tourNumber?: number | null,
    public tourCity?: tourCity | null,
    public clienteNumber?: number | null,
    public wantTour?: string | null
  ) {}
}
