package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      System.out.println("Hi!");
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);
      System.out.println("Hi1!");
      UserService userService = context.getBean(UserService.class);
      System.out.println("H22");
      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      CarService carService = context.getBean(CarService.class);
      carService.add(new Car("audi", 89));
      carService.add(new Car("audi", 0));
      User user = new User("User1111111111111111", "Lastname1", "user1@mail.ru");
      userService.add(user);  // Сначала добавляем пользователя в базу
      Car car = new Car("BMW", 5); // Создаем машину
      carService.setUser(car, user);


      List<User> users = userService.listUsers();
      for (User userr : users) {
         System.out.println("Id = "+userr.getId());
         System.out.println("First Name = "+userr.getFirstName());
         System.out.println("Last Name = "+userr.getLastName());
         System.out.println("Email = "+userr.getEmail());
         System.out.println();
      }

      context.close();
   }
}
