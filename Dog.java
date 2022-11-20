public class Dog extends Animal {
  String breed;

  public Dog(String name, int age, String breed) {

    /* Section 10 */
    super(name, age);
    this.breed = breed;

    Console.log("Dog Class Parameterized Constructor Called.");
  }

  @Override
  public void printAnimalInfo() {
    super.printAnimalInfo();
    Console.log("I am a Dog and my breed is: " + this.breed + ".");
  }
}