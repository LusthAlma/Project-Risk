import { Component } from '@angular/core';
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Bienvenue sur le jeu Risk';
  private serverUrl = 'http://localhost:8080/risk-websocket'
  private stompClient;

  constructor(){
      this.initializeWebSocketConnection();
}

initializeWebSocketConnection(){
    let ws = new SockJS (this.serverUrl);
    this.stompClient = Stomp.over(ws);
    let that = this;
    this.stompClient.connect({}, function(frame) {
        that.stompClient.subscribe("/game-lobby", (message) => {
          if(message.body) {
            $(".game-lobby").append("<div class='message'>"+message.body+"</div>")
            console.log(message.body);
          }
        });
      });
    }
  
    sendMessage(message){
      console.log("coucou")
      this.stompClient.send("/app/send/message" , {}, message);
      $('#input').val('');
    }

}



