public class Reptile extends Animal {
  public int legCount;

  public Reptile(String name, int age, int legCount) {

    /* calling parametirized constructor of Animal */
    super(name, age);

    this.legCount = legCount;
    Console.log("Reptile Class Parameterized Constructor Called.");
  }

  @Override
  public void printAnimalInfo() {
    super.printAnimalInfo();
    Console.log("I am a Reptile with " + legCount + " leg(s).");
  }
}