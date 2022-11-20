# Instructions  
### Description:
One of the most fundamental pillars of Object Oriented Programming is the concept of Inheritance. Inheritance allows developers to reuse code between classes by creating a hierarchical structure. These hierarchies model how humans typically understand the relationships between ideas. For instance, a "Sofa", an "Office Chair", and a "Bench" could all be categorized as a "Seat". In programing we would consider the "Seat" as a parent class, and the "Sofa", "Office Chair" and "Bench" would be considered child classes.

To establish an inheritance hierarchy, the keyword `extends` is used in the class declaration. In the following code snippet, note that the parent class and each child class would be placed in their own separate files.

```Java
// Parent Class 'Seat'
public class Seat { 
  ...
}

// Child Class 'Sofa'
public class Sofa extends Seat {
  ...
}

// Child class 'Bench'
public class Bench extends Seat {
  ...
}
```

When an inheritance hierarchy is established, any code which is visible in the parent class is inherited by the child class, meaning it is usable as if we wrote that code within the child class.

To observe and practice with inheritance in Java, we will create an inheritance hierarchy using different types of Animals.

### Steps:
1. Use the **Add file** button in replit to create a new file called *Animal.java*.
<br><br>
2. Copy and paste the following code into this newly created *Animal.java* file:
```Java
public class Animal {
  // Fields for Animal class
  public String name;
  public int age;

  // Parameterized Constructor for Animal class
  public Animal(String name, int age) {
    this.name = name;
    this.age = age;
    System.out.println("Animal Class Parameterized Constructor Called.");
  }

  // Method for Animal class
  public void printAnimalInfo() {
    System.out.println("My name is: " + this.name + ", I am: " + this.age + " year(s) old.");
  }
}
```
This Animal class will serve as the Parent class, otherwise referred to as the Super class for our Animal hierarchy. This will provide our child classes with two fields, a `String` field called *name* and an `int` field called *age*. Additionally, our child classes will inherit the method `printAnimalInfo()`.

Notice that this class also contain a parameterized constructor. The constructor takes two arguments, a String and an int, which it uses to initialize the fields of the matching name and datatype on the class. Additionally, invoking the constructor will print the message "Animal Class Parameterized Constructor Called" to the console. To see this class in action, lets create a new Animal object.

<br>

3. In your *Main.java* file, within the `main()` method, add the following code snippet:
```Java
Animal anim = new Animal("Arthur", 3);
anim.printAnimalInfo();
```
Now run the code, you should see the following console output:
```
Animal Class Parameterized Constructor Called.
My name is: Arthur, I am: 3 year(s) old.
```

<br>

4. Now, we will create a child class. Use the **Add file** button once more to create another new file called *Reptile.java*. Copy the following code snippet into this *Reptile.java* file.
```Java
// The use of the 'extends' keyword in the class declaration establishes that Reptile is a child of the class Animal
public class Reptile extends Animal { 
  // Field for the Replit class
  public int legCount;

  // Parameterized Constructor for Reptile Class
  public Reptile (String name, int age, int legCount) {
    super(name, age);
    this.legCount = legCount;
    System.out.println("Reptile Class Parameterized Constructor Called.");
  }
}
```

Notice the use of the keyword `super` within the Reptile class constructor. The keyword `super` is used to reference the parent class within the context of the child class. When used in a constructor, as we have done, this is a reference to the parameterized constructor in the Animal class that takes a `String` and `int` argument.

5. Now, we will create an instance of our Reptile class. Back in your *Main.java* file add the following to your main method, below where you have previously created your Animal Object:
```Java
Reptile roger = new Reptile("Roger", 10, 4);
roger.printAnimalInfo();
```
Run the code, and you should see the following output:
```
Animal Class Parameterized Constructor Called.
My name is: Arthur, I am: 3 year(s) old.
Animal Class Parameterized Constructor Called.
Reptile Class Parameterized Constructor Called.
My name is: Roger, I am: 10 year(s) old.
```
In addition to the previous output, we should now see that a new Reptile is created. Notice that we can invoke the inherited method `printAnimalInfo()` from our Reptile reference variable, which prints the inherited name and age fields.
<br><br>
But wait! Why do we also see the output *"Animal Class Parameterized Constructor Called."* A second time? If we take a look at the Reptile class' Parameterized constructor, we can see a call to the Parent class Constructor:
<br><br>
`super(name, age);`
<br><br>
This means each time the Reptile class constructor is called, a call to the Animal class constructor will also be made. In fact, this call to the super class constructor is required. When a child class extends a parent class, a call to the parent's constructor is implicit, meaning that Java will attempt to perform this call regardless of whether you include the code or not. 
<br><br>
Java can only implicitly call a no-argument constructor for a parent class. This is because Java can only guarantee that at least a default, no-argument constructor is given to any class. If you create a custom constructor that takes any parameters, Java will no longer provide you with a default constructor. This is a common occurence, and as the developer you must make sure to match the arguments of the parent's constructor.

6. Now, lets take a look at another application of the keyword `super`. Back in the *Reptile.java* file, add the following code underneath the parameterized constructor:
```Java
  @Override
public void printAnimalInfo() {
  super.printAnimalInfo();
  System.out.println("I am a Reptile with " + legCount + " leg(s).");
}
```
Notice the use of the annotation `@Override`, We will not be discussing annotations in depth in this course, but as a brief description: ***Annotations are modifiers that can be applied to classes, variables or methods, which provide meta-data context for the entity.*** In this case, the `@Override` annotation lets our program know that we are overriding a method that was inherited from a parent class.
<br><br>
**Method Overriding** is a concept that will be discussed in more detail during our examination of Polymorphism. For now, just know that Method Overriding allows you to change the code executed in an inherited method within a child class.
<br><br>
Next, notice the line `super.printAnimalInfo()`. This is a another application of the keyword `super`. By using the keyword `super`, followed by the name of a parent class method, we are able to invoke the parent class' implementation of the method as well as provide some additional changes that are specific to the child class.
<br>

7. Go back to the *Main.java* and run the code again with no modification. You will see that the output will change slightly:
```
Animal Class Parameterized Constructor Called.
My name is: Arthur, I am: 3 year(s) old.
Animal Class Parameterized Constructor Called.
Reptile Class Parameterized Constructor Called.
My name is: Roger, I am: 10 year(s) old.
I am a Reptile with 4 leg(s).
```
Notice that we now see a print out stating how many legs the Reptile has.
<br>

8. Now its your turn! Create another class called *Dog* that inherits from the *Animal* class using the `extends` keyword.
9. Add a `String` field to the *Dog* class called *breed*.
10. Create a parameterized constructor for the *Dog* class that does the following:
- has three parameters total. Two `String` parameters, one for the *name*, and one for the *breed*, and an `int` parameter for the *age*. Make sure that you match the order of arguments in the *Animal* class' constructor (`String` then `int`).
- calls to the *Animal* class constructor. Make sure that the call to the *Animal* class constructor is the first line of the *Dog* class constructor and that you're passing in the *name* and *age* variables to the super constructor call.
- Initializes the *breed* instance variable with the *breed* parameter.
- prints the following to the console: *"Dog Class Parameterized Constructor Called."*
  
11. Within the *Dog* class, override the `printAnimalInfo()` method by calling the super class implementation (`super.printAnimalInfo()`), and adding another line that prints the breed of the Dog (`System.out.println("I am a Dog and my breed is: " + this.breed + ".");`)
12. Create an instance of the Dog class in your Main method. In the Dog class constructor call, give the Dog the name `"Doug"`, an age of `5`, and a breed of `"Labrador"`. 
13. Finally, Invoke the `printAnimalInfo()` method using the new Dog object.

### Test:
Use the test provided.

### Sample Output
```
Animal Class Parameterized Constructor Called.
My name is: Arthur, I am: 3 year(s) old.
Animal Class Parameterized Constructor Called.
Reptile Class Parameterized Constructor Called.
My name is: Roger, I am: 10 year(s) old.
I am a Reptile with 4 leg(s).
Animal Class Parameterized Constructor Called.
Dog Class Parameterized Constructor Called.
My name is: Doug, I am: 5 year(s) old.
I am a Dog and my breed is: Labrador.
```