import { User } from './User';
import { Company } from './Company';
import * as dotenv from 'dotenv';

dotenv.config();
const googleMapScript = window.document.getElementById('googleMapScript');
googleMapScript.setAttribute(
  'src',
  `https://maps.googleapis.com/maps/api/js?key=${process.env.googleMapKey}`
);

const user = new User();

console.log(user);

const company = new Company();

console.log(company);
