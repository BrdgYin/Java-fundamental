package 代理设计模式;
/**
 * 〈通过工厂类隐藏具体细节〉<br>
 * 〈〉
 *
 * @author 我们
 * @create 2021/2/16
 * @since 1.0.0
 */
public class DAOFactory {
    public static Object getDAOInstance(){
        // 直接将真实主题类绑定到代理中返回代理后的类
        return new DAOProxy().bind(new DeptDAOImpl());
    }
}
