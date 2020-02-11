import com.toulan.domain.Account;
import com.toulan.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用Junit单元测试：测试我们的配置
 */

public class AccountServiceTest {



    @Test
    public void testFindAll() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        AccountService as = (AccountService) ac.getBean("accountService");
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for(Account account : accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        AccountService as = (AccountService) ac.getBean("accountService");
        //3.执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        AccountService as = (AccountService) ac.getBean("accountService");
        Account account = new Account();
        account.setName("test");
        account.setMoney(12345f);
        //3.执行方法
        as.saveAccount(account);

    }

    @Test
    public void testUpdate() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        AccountService as = (AccountService) ac.getBean("accountService");
        //3.执行方法
        Account account = as.findAccountById(4);
        account.setMoney(23456f);
        as.updateAccount(account);
    }

    @Test
    public void testDelete() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        AccountService as = (AccountService) ac.getBean("accountService");
        //3.执行方法
        as.deleteById(4);
    }

    @Test
    public void testTransfer() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        AccountService as = (AccountService) ac.getBean("accountService");
        //3.执行方法
        as.transfer("aaa","bbb",100f);
    }
}
