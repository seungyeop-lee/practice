import fs from 'fs';

const matches = fs
  //Load
  .readFileSync('football.csv', {
    encoding: 'utf-8'
  })
  //Parse
  .split('\n')
  .map((row: string): string[] => {
    return row.split(',');
  });

const homeWin = 'H';
const awayWin = 'A';
const draw = 'D';

//Analyze
let manUnitedWins = 0;
for (let match of matches) {
  if (match[1] === 'Man United' && match[5] === homeWin) {
    manUnitedWins++;
  } else if (match[2] === 'Man United' && match[5] === awayWin) {
    manUnitedWins++;
  }
}

//Report
console.log(`Man United won ${manUnitedWins} games`);
