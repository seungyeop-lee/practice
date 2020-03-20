class Vehicle {
  // color: string = 'red';

  // constructor(color: string) {
  //   this.color = color;
  // }

  // public, private, protected를 사용하면 필드의 값으로 사용 가능!
  constructor(public color: string) {}

  protected honk(): void {
    console.log('beep');
  }
}

const vehicle = new Vehicle('orange');
console.log(vehicle.color);

class Car extends Vehicle {
  constructor(public wheels: number, color: string) {
    super(color);
  }

  private drive(): void {
    console.log('vroom');
  }

  startDrivingProcess(): void {
    this.drive();
    this.honk();
  }
}

const car = new Car(4, 'red');
car.startDrivingProcess();
