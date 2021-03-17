package mvc.action.service.impl;

import mvc.action.service.IDemoService;
import mvcframework.GPService;

/**
 * 可以实例化--自动注入
 */
@GPService("tomService")
public class DemoService implements IDemoService {
    public void query() {
        System.out.println("query");
    }

    public void edit() {
        System.out.println("edit");
    }

    public String get(String name) {
        return "查询到了: " + name;
    }
}
