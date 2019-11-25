import { Component, OnInit } from '@angular/core';
import { DonneesService } from '../../services/donnees.service'

@Component({
  selector: 'app-utilisateur',
  templateUrl: './utilisateur.component.html',
  styleUrls: ['./utilisateur.component.css']
})
export class UtilisateurComponent implements OnInit {

  constructor(private donnees: DonneesService) { }

  ngOnInit() {
  }

}
