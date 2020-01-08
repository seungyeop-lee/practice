import {Component, OnInit} from '@angular/core';

@Component({
  // selector: '[app-servers]', // 속성 선택자
  // selector: '.app-servers',  // 클래스 선택자
  selector: 'app-servers',  // 태그 선택자; 꼭 이것만 쓰자!
  // 3줄 이상이면 templateUrl을 이용해 html파일로 따로 빼는 것을 추천
  // template: `
  //   <app-server></app-server>
  //   <app-server></app-server>
  // `,
  templateUrl: './servers.component.html',
  styleUrls: ['./servers.component.css']
})
export class ServersComponent implements OnInit {
  allowNewServer = false;
  serverCreationStatus = 'No server was created!';

  constructor() {
    setTimeout(() => {
      this.allowNewServer = true;
    }, 2000);
  }

  ngOnInit() {
  }

  onCreateServer() {
    this.serverCreationStatus = 'Server was created!';
  }

}
