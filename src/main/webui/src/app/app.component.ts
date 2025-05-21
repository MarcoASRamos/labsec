import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { LabseqService } from './labseq.service';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [FormsModule, NgIf], 
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'webui';
  n: number = 0;
  result: string = '';

  constructor(private labseqService: LabseqService) {}

  fetchLabseq() {
    this.labseqService.getLabseq(this.n).subscribe({
      next: res => this.result = res,
      error: err => this.result = 'Error: ' + err.message
    });
  }
}