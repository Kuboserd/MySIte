import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectedWorldComponent } from './selected-world.component';

describe('SelectedWorldComponent', () => {
  let component: SelectedWorldComponent;
  let fixture: ComponentFixture<SelectedWorldComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SelectedWorldComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SelectedWorldComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
