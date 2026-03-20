package testng;

import org.testng.annotations.Test;

public class Topic_06_Skipped {

    @Test (priority = 0)
    public void shouldBeCreatedNewProduct(){
        System.out.println("shouldBeCreatedNewProduct");
    }

    @Test(priority = 1)
    public void shouldBeViewProduct(){

        System.out.println("shouldBeViewProduct");
    }
    @Test(priority = 2, enabled = false)
    public void shouldBeEditProduct(){

        System.out.println("shouldBeEditProduct");
    }

    @Test(priority = 3)
    public void shouldBeDeletedProduct(){

        System.out.println("shouldBeDeletedProduct");
    }


}
