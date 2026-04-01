package testng;

import org.testng.annotations.Test;

public class Topic_12_DependOnTest {

    @Test
    public void shouldBeCreatedNewProduct(){

        System.out.println("shouldBeCreatedNewProduct");
    }

    @Test(dependsOnMethods = "shouldBeCreatedNewProduct")
    public void shouldBeViewProduct(){

        System.out.println("shouldBeViewProduct");
    }
    @Test(dependsOnMethods = "shouldBeCreatedNewProduct")
    public void shouldBeEditProduct(){

        System.out.println("shouldBeEditProduct");
    }

    @Test(dependsOnMethods = "shouldBeCreatedNewProduct")
    public void shouldBeDeletedProduct(){

        System.out.println("shouldBeDeletedProduct");
    }


}
