import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private storageKey = 'sunit';

  get isLoggedIn(): boolean {
    return localStorage.getItem(this.storageKey) === 'true';
  }

  get username(): string {
    return localStorage.getItem('RMname') || '';
  }

  login(username: string, password: string): boolean {
    if (username === 'prashanth' && password === 'prashanth') {
      localStorage.setItem(this.storageKey, 'true');
      const capitalizedUsername = username.charAt(0).toUpperCase() + username.slice(1).toLowerCase();
      localStorage.setItem('RMname', capitalizedUsername);
      return true;
    } else {
      return false;
    }
  }

  logout(): void {
    localStorage.removeItem(this.storageKey);
    localStorage.removeItem('RMname');
  }
}
