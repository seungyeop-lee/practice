export class Course {
    constructor(name, isAdvanced) {
        this._name = name;
        this._isAdvanced = isAdvanced;
    }

    get name() {
        return this._name;
    }
    get isAdvanced() {
        return this._isAdvanced;
    }
}
