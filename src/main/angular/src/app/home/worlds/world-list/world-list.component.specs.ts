import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WorldList } from './world-list.component';

describe('WorldsComponent', () => {
  let component: WorldList;
  let fixture: ComponentFixture<WorldList>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WorldList ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WorldList);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
