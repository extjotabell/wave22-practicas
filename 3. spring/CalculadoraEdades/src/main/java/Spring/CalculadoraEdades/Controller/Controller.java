package Spring.CalculadoraEdades.Controller;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/age-calculator")
public class Controller {
    @GetMapping("/{day}/{month}/{year}")
    public int calculateAge(@PathVariable int day, @PathVariable int month, @PathVariable int year){
        LocalDate birthdate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();

        if (birthdate.isAfter(currentDate))
            return 0;

        return Period.between(birthdate, currentDate).getYears();
    }
}
