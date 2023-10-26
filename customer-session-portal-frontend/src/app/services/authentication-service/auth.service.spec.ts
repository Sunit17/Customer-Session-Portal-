import { TestBed } from '@angular/core/testing';
import { AuthService } from './auth.service';

describe('AuthService', () => {
  let authService: AuthService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    authService = TestBed.inject(AuthService);
  });

  it('should be created', () => {
    expect(authService).toBeTruthy();
  });

  it('should return isLoggedIn as false initially', () => {
    expect(authService.isLoggedIn).toBe(false);
  });

  it('should return an empty string for username initially', () => {
    expect(authService.username).toBe('');
  });

  it('should logout successfully', () => {
    authService.login('prashanth', 'prashanth');
    authService.logout();
    expect(authService.isLoggedIn).toBe(false);
    expect(authService.username).toBe('');
  });
});
