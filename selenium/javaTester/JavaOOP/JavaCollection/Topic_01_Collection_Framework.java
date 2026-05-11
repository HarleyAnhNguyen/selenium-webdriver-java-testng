package javaTester.JavaOOP.JavaCollection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class Topic_01_Collection_Framework {
    public static void main(String[] args) {
        // Collection Framework: là một tập hợp các interface và class được sử dụng để lưu trữ và quản lý dữ liệu trong Java.
        // Các interface chính trong Collection Framework bao gồm:
        // List: lưu trữ các phần tử theo thứ tự và cho phép trùng lặp (ví dụ: ArrayList, LinkedList).
        // Set: lưu trữ các phần tử duy nhất, không cho phép trùng lặp (ví dụ: HashSet, TreeSet).
        // Queue: lưu trữ các phần tử theo thứ tự và cho phép thêm vào cuối hàng đợi và lấy ra từ đầu hàng đợi (ví dụ: LinkedList, PriorityQueue).
        // Map: lưu trữ các cặp key-value, cho phép truy cập nhanh bằng key (ví dụ: HashMap, TreeMap).
//        WebDriver driver =null;
//        Set<String> windowIDs = driver.getWindowHandles();
//
//        List<WebElement> checkboxes = driver.findElements(By.className(""));
//
        ArrayList student = new ArrayList();
        student.add("Harry");
        student.add("Ron");

        LinkedList employee = new LinkedList();
        employee.add("John");
        employee.add("Jane");
        employee.add("Doe");
        employee.add("Clack");
        displayCollection(employee);

        Collections.addAll(student, "Alice", "Bob", "Charlie", "David");
        displayCollection(student);

    }

    public static void displayCollection(Collection<String> collection) {
        System.out.println("-------------------------");

        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println((String) iterator.next());
        }
    }
}
