import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WorldSelectedComponent } from './world-selected.component';

describe('SelectedWorldComponent', () => {
  let component: WorldSelectedComponent;
  let fixture: ComponentFixture<WorldSelectedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WorldSelectedComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WorldSelectedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
