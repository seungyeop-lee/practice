import 'googlemaps';
// import { User } from './User';
// import { Company } from './Company';
import * as dotenv from 'dotenv';

dotenv.config();
const googleMapScript = window.document.getElementById('googleMapScript');
googleMapScript.setAttribute(
  'src',
  `https://maps.googleapis.com/maps/api/js?key=${process.env.googleMapKey}`
);

window.onload = () => {
  new google.maps.Map(document.getElementById('map'), {
    zoom: 1,
    center: {
      lat: 0,
      lng: 0
    }
  });
};
