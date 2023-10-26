import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ArchiveSessionComponent } from './archive-session.component';
import { SessionService } from '../../services/session-service/session.service';
import { of } from 'rxjs';
import { ISession } from '../models/session.model';

describe('ArchiveSessionComponent', () => {
  let component: ArchiveSessionComponent;
  let fixture: ComponentFixture<ArchiveSessionComponent>;
  let dialogRef: MatDialogRef<ArchiveSessionComponent>;
  let sessionService: SessionService;
  let snackBar: MatSnackBar;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ArchiveSessionComponent],
      providers: [
        {
          provide: MatDialogRef,
          useValue: { close: jest.fn() },
        },
        {
          provide: MAT_DIALOG_DATA,
          useValue: { sessionId: 123, sessionName: 'Sample Session', remarks: 'Sample Remarks', createdBy: 'User', createdOn: new Date(), /* Add other properties */ }, // Complete ISession object
        },
        {
          provide: SessionService,
          useValue: {
            archiveSession: jest.fn(() => of({ message: 'Session archived' })),
          },
        },
        {
          provide: MatSnackBar,
          useValue: {
            open: jest.fn(),
          },
        },
      ],
    });
    fixture = TestBed.createComponent(ArchiveSessionComponent);
    component = fixture.componentInstance;
    dialogRef = TestBed.inject(MatDialogRef);
    sessionService = TestBed.inject(SessionService);
    snackBar = TestBed.inject(MatSnackBar);
  });

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });

  it('should close the dialog on cancel', () => {
    component.onCancelClick();
    expect(dialogRef.close).toHaveBeenCalled();
  });

  it('should archive the session and display a snackbar message', async(() => {
    component.archiveSession();

    expect(sessionService.archiveSession).toHaveBeenCalledWith(123);
    fixture.whenStable().then(() => {
      expect(snackBar.open).toHaveBeenCalledWith('Session archived', 'Close', {
        duration: 4000,
      });
      expect(dialogRef.close).toHaveBeenCalledWith(true);
    });
  }));
});