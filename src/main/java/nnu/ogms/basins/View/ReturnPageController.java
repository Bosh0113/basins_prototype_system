package nnu.ogms.basins.View;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ReturnPageController {

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView mainpage(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main");
        return mv;
    }
}
