import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  input!: string ;
  wordCount!: object;
  TotalWordCount!: object;
  title = 'occurances';

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  countWords() {
    this.http.get('http://localhost:8080/wordcount', {params: {input: this.input}})
      .subscribe(data => {
        this.wordCount = data;
        this.TotalWordCount = Object.values(data).reduce((a,b) => a+b);
      });
  }
}
