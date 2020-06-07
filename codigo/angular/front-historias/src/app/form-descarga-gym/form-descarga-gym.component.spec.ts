import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormDescargaGymComponent } from './form-descarga-gym.component';

describe('FormDescargaGymComponent', () => {
  let component: FormDescargaGymComponent;
  let fixture: ComponentFixture<FormDescargaGymComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormDescargaGymComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormDescargaGymComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
