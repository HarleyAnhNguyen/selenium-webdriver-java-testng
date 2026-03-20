package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Groups {

    @BeforeClass
    public void beforeClass(){
        System.out.println("Run Before Class");

    }

    @Test(groups = {"payment", "regression"})
    public void TC_01(){
        System.out.println("Run groups TC01");
    }

    @Test(groups = "payment")
    public void TC_02(){
        System.out.println("Run groups TC02");
    }
    @Test(groups = "regression")
    public void TC_03(){
        System.out.println("Run groups TC03");
    }

    @Test (groups = {"tesng", "regression"})
    public void TC_04(){
        System.out.println("Run groups TC04");
    }

    @Test (groups = {"payment", "testng"})
    public void TC_05(){
        System.out.println("Run groups TC05");
    }

    @Test (groups = "testng")
    public void TC_06(){
        System.out.println("Run groups TC06");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("Run After Class");

    }
}
