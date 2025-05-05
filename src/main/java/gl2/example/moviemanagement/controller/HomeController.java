package gl2.example.moviemanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping({ "/", "/api/test", "/api/test/" })
  public String index() {
    return "redirect:/swagger-ui/index.html";
  }
}
