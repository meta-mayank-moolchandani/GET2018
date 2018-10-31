import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';
import {User} from '../app/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {}

   endpoint = 'http://localhost:3000/user';
  
   httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  private extractData(res: Response) {
    let body = res;
    return body || { };
  }

  getUsers(): Observable<User> {
    return this.http.get<User>(this.endpoint);
  }

  addUser (user): Observable<User> {
    console.log(user);
    // return this.http.post<User>(this.endpoint, user, this.httpOptions);
    return this.http.post<any>(this.endpoint, JSON.stringify(user), this.httpOptions).pipe(
      tap((user) => console.log(`added user w/ id=${user.id}`)),
      catchError(this.handleError<any>('adduser'))
    );
  }

  getUser(id): Observable<any> {
    return this.http.get(this.endpoint + '/' + id).pipe(
      map(this.extractData));
  }

  updateUser (user): Observable<any> {
    debugger;
    console.log(user.id+ "\n"+this.endpoint +'/' + user.id);
    
    return this.http.put(this.endpoint +'/' + user.id , user).pipe(
      tap(_ => console.log(`updated user id=${user.id}`)),
      catchError(this.handleError<any>('updateProduct'))
    );
  }
  

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
  
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
  
      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);
  
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
