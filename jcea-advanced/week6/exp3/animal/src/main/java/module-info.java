module Animal {
    exports animal;
    provides animal.Animal with animal.Bird, animal.Dog;
}