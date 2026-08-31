package com.jt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
 // private Engine engine = new Engine();

 //DI
 //DI is a mechanism in which spring container automatically inject the bean inside a class refernce variable
 //In simple word spring container automatically assigns the address of the bean inside another class reference variable
 //1. Field based injection-NR
// @Autowired
//  private Engine engine;
 //2. Setter method based injection -R

//  private Engine engine;
//   @Autowired
//  public void setEngine(Engine engine){
//     System.out.println("parameter engine"+engine);//parameter enginecom.jt.Engine@6ebd78d1
//     System.out.println("variable engine"+this.engine);//variable enginenull
//   this.engine = engine;
//  }

 //3.Constructor based injection -HR
 private Engine engine;
  @Autowired
  public Car(@Qualifier("dieselEngine")  Engine engine){
    this.engine= engine;
    System.out.println("parameterized constructor");
  }
   

  public Car(){
    System.out.println("non parameterized constructor");
  }

    public void startCar(){
     // Engine engine = new Engine();
        engine.startEngine();

        System.out.println("car is starting");
    }
    

    public void stopCar(){
      //Engine engine = new Engine();
        engine.stopEngine();

        System.out.println("car is stopping");
    }

}
