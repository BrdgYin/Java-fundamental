package 反射;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈简单类〉
 *
 * @author 我们
 * @create 2021/2/9
 * @since 1.0.0
 */
interface Info{
    String msg = "知乎";
}
class Message{
    public String content;
    public Date date;
}
public class Member extends Message implements Serializable, Info{
    public Member(){
        System.out.println("无参构造");
    }
    public Member(String xx, String xx1) throws NumberFormatException, NullPointerException{
        System.out.println("有参构造：" + xx + xx1);
    }
    @Override
    public String toString() {
        return "这是一个简单类";
    }

    public void getNum(int num, String dName){
        System.out.println("当前成员数: "+ dName + num);
    }
}
