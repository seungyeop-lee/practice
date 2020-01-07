import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-servers',
  // 3줄 이상이면 templateUrl을 이용해 html파일로 따로 빼는 것을 추천
  template: `
    <app-server></app-server>
    <app-server></app-server>
  `,
  styleUrls: ['./servers.component.css']
})
export class ServersComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {
  }

}
