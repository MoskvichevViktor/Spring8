package spring.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UserController {

/*    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(" ")
    public String showAllUser(Model model) {
        model.addAttribute("userList", userService.getAllUser());
        return "users";
    }

 */
    @GetMapping("")
    public String editUsersList() {
        return "Edit Users List / страница со списком пользователей";
    }
}
