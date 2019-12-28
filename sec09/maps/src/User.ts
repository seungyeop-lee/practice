import faker from 'faker';

// 해당 파일을 import 할 경우 기본적으로 로딩되는 값은 default 키워드로 지정
// 그러나 사용는 피하는걸 추천
// export default 'red';

export class User {
  name: string;
  location: {
    lat: number;
    lng: number;
  };

  constructor() {
    this.name = faker.name.firstName();
    this.location = {
      lat: parseFloat(faker.address.latitude()),
      lng: parseFloat(faker.address.longitude())
    };
  }
}
