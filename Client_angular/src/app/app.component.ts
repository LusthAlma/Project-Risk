import { Component } from '@angular/core';
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import { Territoire } from './classes/Territoire';
import { Joueur } from './classes/Joueur';
import { Plateau } from './classes/Plateau';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Bienvenue sur le jeu Risk';
  private serverUrl = 'http://localhost:8080/risk-websocket'
  private stompClient;
  private client: Joueur;
  private plateau: Plateau;
  text: string;
  

  constructor(){
      this.client=new Joueur();
      this.init();
}

init(){
    let ws = new SockJS (this.serverUrl);
    this.stompClient = Stomp.over(ws);
    let that = this;
    this.stompClient.connect({}, function(frame) {
        that.stompClient.subscribe("/user/queue/reply", (message) => {
          if(message.body) {
            $(".game-lobby").append("<div class='message'>"+message.body+"</div>")
            console.log(message.body);
          }
        });

        that.stompClient.subscribe("/user/queue/reply_maj", (joueur) => {
          this.client.ajoutTerritoire(JSON.parse(joueur.body).getTerritoiresPossedes())
        });

        

      });
    }

    sendMessage(message){
      this.stompClient.send("/app/send/message" , {}, message);
      $('#input_message').val('');
    }

    connect(message){
      this.stompClient.send("/app/connect", {}, message);
      $('#input_connect').val('');

    }

    disconnect(){
      if(this.stompClient != null){
        this.stompClient.disconnect();
      }
      console.log("Disconnected from websocket connection")

    }

    readyToStart(){
      this.stompClient.send("/app/ready", {})
    }

    move(terrDepart: Territoire, terrArrivee: Territoire, nbUnite: number) {
      if (terrDepart.getPossesseur()!==this.client.getNom()) {
        $(".game-lobby").append("<div class='message'>Vous devez déplacer des unités depuis un de vos territoires.</div>")
      } else {
        //send the move to the server
        //this.stompClient.send("/app/move", {}, terrDepart.getNom(), terrArrivee.getNom(), nbUnite);
      }
    }

    endTurn(): void {
      this.client.finirTour();
      //send to the server
      //this.stompClient.send("/app/endTurn", {});
    }

    placeUnits(terr: Territoire, nbUnites: number) {
      if (nbUnites>this.client.getRenforts() || nbUnites<0) {
        $(".game-lobby").append("<div class='message'>Nombre d'unités inapproprié.</div>")
      } else {
        //send to the server
        //this.stompClient.send("/app/placeUnits", {}, terr.getNom(), nbUnites);
      }
    }

    showName(id: string){
       // this.text = id + ',Nombre armées : ' + this.findArmy(id) + 'Possédé par ' + this.findOwner(id);
       this.text = id

    }

    highlight(id: string){
      const outline = document.getElementById(id).getAttribute( 'd' );
      const highlight = document.getElementById( 'highlight' );
      highlight.setAttribute( 'd', outline );

      

    }

    findArmy(id : string){
      this.plateau.getCarte().forEach(territoire => {
        if (territoire.getNom() == id){
          return territoire.getNbUnites();

        } 
           }  )

    }

    findOwner(id : string){
      this.plateau.getCarte().forEach(territoire => {
        if (territoire.getNom() == id){
          return territoire.getPossesseur();

        } 
           }  )

    }

}



