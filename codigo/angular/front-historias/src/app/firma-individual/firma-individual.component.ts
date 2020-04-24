import { AfterViewInit, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import SignaturePad from 'signature_pad';

@Component({
  selector: 'app-firma-individual',
  templateUrl: './firma-individual.component.html',
  styleUrls: ['./firma-individual.component.css']
})
export class FirmaIndividualComponent implements OnInit, AfterViewInit {
  @ViewChild('sPad1', { static: true }) signaturePadElement1;
  signaturePad: any;
  imagenUsuario: any;
  constructor() { }

  ngOnInit(): void {
  }

  ngAfterViewInit(): void {
    const color = 'rgb(255,255,255)';
    this.signaturePad = new SignaturePad(this.signaturePadElement1.nativeElement);
    this.signaturePad.penColor = color;
  }

  changeColor() {
    const r = Math.round(Math.random() * 255);
    const g = Math.round(Math.random() * 255);
    const b = Math.round(Math.random() * 255);
    //const color = 'rgb(' + r + ',' + g + ',' + b + ')';
    const color = 'rgb(255,255,255)';
    this.signaturePad.penColor = color;
  }

  clearUsuario() {
    this.signaturePad.clear();
  }


  savePNGUsuario() {
    if (this.signaturePad.isEmpty()) {
      alert('Please provide a signature first.');
    } else {
      const dataURL = this.signaturePad.toDataURL();
      console.log(dataURL);
      this.imagenUsuario = dataURL;
      //this.download(dataURL, 'signature.png');
    }
  }

}
