package SpringBoot;

import SpringBoot.dao.ISimpleBbsDao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @Autowired
    ISimpleBbsDao dao;

    @RequestMapping("/")
    public String root() throws Exception {
        // JdbcTemplate : SimpleBBS
        return "redirect:list";
    } // f end

    @RequestMapping("/list")
    public String userlistpage(Model model){
        model.addAttribute("list", dao.listDao());
        return "list";
    } // f end

    @RequestMapping("/view")
    public String view(HttpServletRequest req, Model model){
        String sId = req.getParameter("id");
        return "view";
    } // f end

    @RequestMapping("/writeForm")
    public String writeFrom(){
        return "writeForm";
    } // f end

    @RequestMapping("/wirte")
    public String wriite( Model model, HttpServletRequest req ){
        dao.writeDao( req.getParameter("writer"),
                      req.getParameter("title"),
                      req.getParameter("content") );
        return "redirect:list";
    } // f end

    @RequestMapping("/delete")
    public String delete( HttpServletRequest req, Model model ){
        dao.deleteDao( req.getParameter("id"));
        return "redirect:list";
    } // f end

}
