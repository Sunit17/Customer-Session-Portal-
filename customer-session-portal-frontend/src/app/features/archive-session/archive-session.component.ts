import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { SessionService } from '../../services/session-service/session.service';
import { IResponseDto, ISession } from '../models/session.model';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-archive-session',
  templateUrl: './archive-session.component.html',
  styleUrls: ['./archive-session.component.scss'],
})
export class ArchiveSessionComponent {
  constructor(
    public _dialogRef: MatDialogRef<ArchiveSessionComponent>,
    @Inject(MAT_DIALOG_DATA) public session: ISession,
    private sessionService: SessionService,
    private snackBar: MatSnackBar
  ) {}

  onCancelClick(): void {
    this._dialogRef.close();
  }

  archiveSession() {
    this.sessionService
      .archiveSession(this.session.sessionId)
      .subscribe((x: IResponseDto) => {
        this.snackBar.open(x.message, 'Close', {
          duration: 4000,
        });
        this._dialogRef.close(true);
      });
  }
}
