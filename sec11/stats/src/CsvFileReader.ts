import fs from 'fs';

export class CsvFileReader {
  data: string[][] = [];

  constructor(public filename: string) {}

  read(): void {
    this.data = fs
      //Load
      .readFileSync(this.filename, {
        encoding: 'utf-8'
      })
      //Parse
      .split('\n')
      .map((row: string): string[] => {
        return row.split(',');
      });
  }
}
