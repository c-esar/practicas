import { AfterViewInit, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import SignaturePad from 'signature_pad';


@Component({
  selector: 'app-firma',
  templateUrl: './firma.component.html',
  styleUrls: ['./firma.component.css']
})
export class FirmaComponent implements OnInit, AfterViewInit {
  @ViewChild('sPad1', { static: true }) signaturePadElement1;
  @ViewChild('sPad2', { static: true }) signaturePadElement2;
  signaturePad: any;
  signaturePad2: any;
  imagenMedico: any;
  imagenPaciente: any;
  constructor() { }

  ngOnInit(): void {
  }

  ngAfterViewInit(): void {
    const color = 'rgb(255,255,255)';
    this.signaturePad = new SignaturePad(this.signaturePadElement1.nativeElement);
    this.signaturePad.penColor = color;
    this.signaturePad2 = new SignaturePad(this.signaturePadElement2.nativeElement);
    this.signaturePad2.penColor = color;
  }

  changeColor() {
    const r = Math.round(Math.random() * 255);
    const g = Math.round(Math.random() * 255);
    const b = Math.round(Math.random() * 255);
    //const color = 'rgb(' + r + ',' + g + ',' + b + ')';
    const color = 'rgb(255,255,255)';
    this.signaturePad.penColor = color;
  }

  clearMedico() {
    this.signaturePad.clear();
  }

  clearPaciente() {
    this.signaturePad2.clear();
  }

  undo() {
    const data = this.signaturePad.toData();
    if (data) {
      data.pop(); // remove the last dot or line
      this.signaturePad.fromData(data);
    }
  }

  download(dataURL, filename) {
    if (navigator.userAgent.indexOf('Safari') > -1 && navigator.userAgent.indexOf('Chrome') === -1) {
      window.open(dataURL);
    } else {
      const blob = this.dataURLToBlob(dataURL);
      const url = window.URL.createObjectURL(blob);
      const a = document.createElement('a');
      a.href = url;
      a.download = filename;

      document.body.appendChild(a);
      a.click();

      window.URL.revokeObjectURL(url);
    }
  }

  dataURLToBlob(dataURL) {
    // Code taken from https://github.com/ebidel/filer.js
    const parts = dataURL.split(';base64,');
    const contentType = parts[0].split(':')[1];
    const raw = window.atob(parts[1]);
    const rawLength = raw.length;
    const uInt8Array = new Uint8Array(rawLength);
    for (let i = 0; i < rawLength; ++i) {
      uInt8Array[i] = raw.charCodeAt(i);
    }
    return new Blob([uInt8Array], { type: contentType });
  }

  savePNGMedico() {
    if (this.signaturePad.isEmpty()) {
      alert('Please provide a signature first.');
    } else {
      const dataURL = this.signaturePad.toDataURL();
      console.log(dataURL);
      this.imagenMedico = dataURL;
      //this.download(dataURL, 'signature.png');
    }
  }

  savePNGPaciente() {
    if (this.signaturePad.isEmpty()) {
      alert('Please provide a signature first.');
    } else {
      const dataURL = this.signaturePad.toDataURL();
      console.log(dataURL);
      this.imagenPaciente = dataURL;
      //this.download(dataURL, 'signature.png');
    }
  }

  saveJPG() {
    if (this.signaturePad.isEmpty()) {
      alert('Please provide a signature first.');
    } else {
      const dataURL = this.signaturePad.toDataURL('image/jpeg');
      this.download(dataURL, 'signature.jpg');
    }
  }

  saveSVG() {
    if (this.signaturePad.isEmpty()) {
      alert('Please provide a signature first.');
    } else {
      const dataURL = this.signaturePad.toDataURL('image/svg+xml');
      this.download(dataURL, 'signature.svg');
    }
  }

}
