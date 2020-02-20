import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormOcupacionalComponent } from './form-ocupacional.component';

describe('FormOcupacionalComponent', () => {
  let component: FormOcupacionalComponent;
  let fixture: ComponentFixture<FormOcupacionalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormOcupacionalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormOcupacionalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
