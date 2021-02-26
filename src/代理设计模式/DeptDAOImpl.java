package 代理设计模式;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 我们
 * @create 2021/2/16
 * @since 1.0.0
 */
public class DeptDAOImpl implements IDeptDAO{
    @Override
    public boolean doCreate(Dept vo) throws Exception {
        System.out.println("执行数据增加操作");
        return false;
    }

    @Override
    public List<Dept> findAll() throws Exception {
        System.out.println("执行数据查询操作");
        return null;
    }
}
