import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BkashDataService {
  url = environment.apiUrl;

  constructor( private httpClient:HttpClient) { }

  add(data: any){
    return this.httpClient.post(this.url+
      "/bkash-data/add",data,{
        headers: new HttpHeaders().set('Content-Type',"application/json")
      })
  }
  
  getBkashDatas(){
    return this.httpClient.get(this.url+"/bkash-data/get");
  }
}
