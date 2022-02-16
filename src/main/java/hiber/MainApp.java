package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("Tesla", 2)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("Toyota" , 3)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("Ford",4)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("Skoda", 5)));
      userService.add(new User("User5", "Lastname5", "user5@mail.ru", new Car("Tesla", 1)));
      userService.add(new User("User6", "Lastname6", "user6@mail.ru", new Car("Skoda", 6)));
      userService.add(new User("User7", "Lastname7", "user7@mail.ru", new Car("Tesla", 7)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car model= " + user.getCar().getModel());
         System.out.println("Car series= " + user.getCar().getSeries());
         System.out.println();
      }

      List<User> userList = userService.getUserByCarModelAndCarSeries("Skoda", 5);
      for (User user : userList) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car model= " + user.getCar().getModel());
         System.out.println("Car series= " + user.getCar().getSeries());
         System.out.println();
      }

      context.close();
   }
}
