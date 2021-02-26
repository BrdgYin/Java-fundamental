package 代理设计模式;

import java.util.List;

public interface IDeptDAO {
    boolean doCreate(Dept vo) throws Exception;
    List<Dept> findAll() throws Exception;
}
