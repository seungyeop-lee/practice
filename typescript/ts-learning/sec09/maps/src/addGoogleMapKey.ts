import * as dotenv from 'dotenv';

dotenv.config();
const googleMapScript = window.document.getElementById('googleMapScript');
googleMapScript.setAttribute(
  'src',
  `https://maps.googleapis.com/maps/api/js?key=${process.env.googleMapKey}`
);
