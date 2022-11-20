public class Animal {
  // Fields for Animal class
  public String name;
  public int age;

  // Parameterized Constructor for Animal class
  public Animal(String name, int age) {
    this.name = name;
    this.age = age;
    Console.log("Animal Class Parameterized Constructor Called.");
  }

  // Method for Animal class
  public void printAnimalInfo() {
    Console.log("My name is: " + this.name + ", I am: " + this.age + " year(s) old.");
  }
}