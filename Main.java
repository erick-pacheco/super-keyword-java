class Main {
  public static void main(String[] args) {
    Animal anim = new Animal("Arthur", 3);
    anim.printAnimalInfo();

    Reptile roger = new Reptile("Roger", 10, 4);
    roger.printAnimalInfo();

    Dog dog = new Dog("Doug", 5, "Labrador");
    dog.printAnimalInfo();
  }
}