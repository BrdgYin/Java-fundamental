package mvc.action;

import mvc.action.service.IDemoService;
import mvcframework.GPAutowried;
import mvcframework.GPController;
import mvcframework.GPRequestMapping;
import mvcframework.GPRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@GPController
@GPRequestMapping("/web")
public class DemoAction {

    @GPAutowried private IDemoService demoService;

    @GPRequestMapping("/query.json")
    public void query(HttpServletRequest req, HttpServletResponse resp,@GPRequestParam("name") String name){
        String result = demoService.get(name);

        try{
            resp.getWriter().write(result);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @GPRequestMapping("/edit.json")
    public void edit(HttpServletRequest req, HttpServletResponse resp,@GPRequestParam("id") Integer id){

    }

}
