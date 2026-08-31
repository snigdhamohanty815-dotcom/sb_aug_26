package com.jt.intro_to_web;

import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloController {
    @RequestMapping("/home")
    public void sayHello(PrintWriter writer){
        System.out.println("Hello Web");
        writer.println("<h1>Hello spring web</h1>  <p>Welcome Home</p> ");
    }

     @RequestMapping("/")
    public void landingPage(PrintWriter printWriter){
        System.out.println("landing page1");
        printWriter.println("Our First Landing Page1 ");
    }

     @RequestMapping("/contact")
    public String contact(){
       return "contact-page";
    }
    // @RequestMapping("/submit-details")
    // public String submitDetails(HttpServletRequest request, Model model ){
    //     System.out.println("submit details handled");
    //     String name = request.getParameter("name");
    //      String phone = request.getParameter("phone");
    //     //  System.out.println("name is :- "+name);
    //     //  System.out.println("name is :- "+phone);

    //      model.addAttribute("name1", name);
    //       model.addAttribute("phone", phone);
    //      return "details-page";
    // }

    //  @RequestMapping(value = "/submit-details", method= RequestMethod.POST)
    // public String submitDetails(@RequestParam(value = "name2", required = false, defaultValue = "springBoot") String name12,@RequestParam String phone, Model model ){
       

    //      model.addAttribute("name1", name12);
    //       model.addAttribute("phone", phone);
    //      return "details-page";
    // }


     @RequestMapping(value = "/submit-details", method= RequestMethod.POST)
    public String submitDetails(@ModelAttribute Person person, Model model) {
       

         model.addAttribute("name1",person.getName1());
          model.addAttribute("phone", person.getPhone());
         return "details-page";
    }

}
