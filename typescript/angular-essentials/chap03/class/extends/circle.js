class Circle {
    constructor(radius) {
        this.radius = radius;
    }

    getDiameter() {
        return 2 * this.radius;
    }

    getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }
}

class Cylinder extends Circle {
    constructor(radius, height) {
        super(radius);
        this.height = height;
    }

    getArea() {
        return (this.height * super.getPerimeter()) + (2 * super.getArea());
    }

    getVolume() {
        return super.getArea() * this.height
    }
}

const cylinder = new Cylinder(2, 10);

console.log(cylinder.getDiameter());
console.log(cylinder.getPerimeter());
console.log(cylinder.getArea());
console.log(cylinder.getVolume());
console.log(cylinder instanceof Cylinder);
console.log(cylinder instanceof Circle);
