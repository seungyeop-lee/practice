import { MatchResult } from './MatchResult';
import { CsvFileReader } from './CsvFileReader';
import { MatchReader } from './MatchReader';

// Create an object that satisfies the 'DataReader' interface
const csvFileReader = new CsvFileReader('football.csv');

// Create an instance of MatchReader and pass in somthing satisfying
// the 'DataReader' interface
const matchReader = new MatchReader(csvFileReader);
matchReader.load();

//Report
console.log(`Man United won ${manUnitedWins} games`);
