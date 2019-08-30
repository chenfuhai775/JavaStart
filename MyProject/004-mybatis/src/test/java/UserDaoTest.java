import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import java.io.IOException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

public class UserDaoTest {

  @Test
  public void findUserById() {
    SqlSession sqlSession = getSessionFactory().openSession();
    UserDao userMapper = sqlSession.getMapper(UserDao.class);
    User user = userMapper.findUserById(2);
    Assert.assertNotNull("没找到数据", user);
    if (user != null) {
      System.out.println("編號:" + user.getContactID() + ",訂單號:" + user.getOrderNo());
    }
  }

  //Mybatis 通过SqlSessionFactory获取SqlSession, 然后才能通过SqlSession与数据库进行交互
  private static SqlSessionFactory getSessionFactory() {
    SqlSessionFactory sessionFactory = null;
    String resource = "configuration.xml";
    try {
      sessionFactory = new SqlSessionFactoryBuilder().build(Resources
          .getResourceAsReader(resource));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return sessionFactory;
  }
}
