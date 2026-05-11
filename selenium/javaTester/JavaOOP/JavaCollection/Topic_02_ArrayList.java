package javaTester.JavaOOP.JavaCollection;

import java.util.*;

public class Topic_02_ArrayList {
    public static void main(String[] args) {
        String[] student = {"Nam", "Hoa","Lan"};
        System.out.println(student.length);

        String[] employee = new String[3];
        employee[0] = "Nam";
        employee[1] = "Hoa";
        employee[2] = "Lan";
        //employee[3] = "Huy";
        System.out.println(employee.length);

        ArrayList pets = new ArrayList<>(); //Non-generic
        pets.add("Dog");
        pets.add(15);
        pets.add(true);
        pets.add('a');

        ArrayList<Integer> number = new ArrayList<Integer>();//generic
        //number.add("Dog"); sai
        number.add(15);
        //number.add(true);sai
        //number.add('a');sai
        List<String> listStudent = getListStudent(new ArrayList<>());
        List<String> listStudent2 = getListStudent(new Vector<>());
        List<String> listStudent3 = getListStudent(new LinkedList<>());


        ArrayList<String> animal = new ArrayList<String>();
        animal.add("Dog");
        animal.add("Cat");
        System.out.println(animal);
        animal.add(0,"Bird");
        System.out.println(animal);


        ArrayList<String> lovepets = new ArrayList<String>();
        lovepets.add("Fish");
        lovepets.add("Rabbit");
        animal.addAll(lovepets);
        System.out.println(animal);

        System.out.println(animal.get(3));

        Iterator<String> itr = animal.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

        animal.set(3,"Horse");
        System.out.println(animal);

        animal.remove("Rabbit");
        System.out.println(animal);
        animal.remove(0);
        System.out.println(animal);

        animal.removeAll(animal);
        System.out.println(animal);

        animal.add("Dog");
        animal.add("Cat");
        animal.add("Fish");
        animal.add("Rabbit");
        System.out.println("Truoc khi clear: " +animal);
        animal.clear();
        System.out.println("Sau khi clear: " +animal);
        System.out.println(animal.size());//tra ve do dai cua arraylist
        System.out.println("Is empty: " + animal.isEmpty());//kiem tra xem arraylist co rong hay khong

        animal.add("Fish");
        animal.add("Dog");
        animal.add("Cat");
        animal.add("Rabbit");
        animal.add("Bird");
        String[] animalArray = new String[animal.size()];
        animal.toArray(animalArray);//convert arraylist sang array
        for(String ann: animalArray){
            System.out.println(ann);
        }

        ArrayList<String> smallAnimal =  new ArrayList<String>(Arrays.asList(animalArray));//convert array sang arraylist
        System.out.println(smallAnimal);

        smallAnimal.toString();
        System.out.println("To String: " + smallAnimal.toString());

        System.out.println("Contains Dog: " + smallAnimal.contains("Dog"));//kiem tra xem co phan tu trong arraylist hay khong
        System.out.println("Index of Mouse: " + smallAnimal.contains("Mouse"));

        System.out.println("Index of Cat: " + smallAnimal.indexOf("Cat"));//tra ve index cua phan tu trong arraylist


        //Duyet arraylist
        // Cach 1: for
        for (int i = 0; i < smallAnimal.size(); i++) {
            System.out.println("For: " + smallAnimal.get(i));
        }

        // Cach 2: for-each
        for (String ann: smallAnimal) {
            System.out.println("For each: " + ann);
        }

         // Cach 3: while
        int i = 0;
        while (i < smallAnimal.size()) {
            System.out.println("While: " + smallAnimal.get(i));
            i++;
        }

         // Cach 4: iterator
        Iterator<String> iterator = smallAnimal.iterator();
        while (iterator.hasNext()) {
            System.out.println("Iterator: " + iterator.next());
        }

        // Cach 5: lambda expression (Java 8 +)
        smallAnimal.forEach(num -> System.out.println("Lambda: " + num));

        // Cach 6: Enumeration (deprecated, not recommended)
        Enumeration<String> enumeration = Collections.enumeration(smallAnimal);
        while (enumeration.hasMoreElements()) {
            System.out.println("Enumeration: " + enumeration.nextElement());
        }

        Collections.sort(animal);//sap xep theo thu tu tang dan
            System.out.println("Sorted animal: " + animal);

        Collections.reverse(animal);//sap xep theo thu tu giam dan, neu khong co sap xep truoc do thi se dao nguoc thu tu ban dau
            System.out.println("Reversed animal: " + animal);

        animal.sort(Comparator.naturalOrder());//sap xep theo thu tu tang dan
            System.out.println("Sorted animal: " + animal);

        animal.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("Sorted animal: " + animal);

        animal.sort((o1, o2) -> o1.compareTo(o2));
        System.out.println("Sorted animal: " + animal);

    }

    public static List<String> getListStudent(List<String> list){
        list.add(new String("Vo Van An"));
        list.add(new String("Vu Quynh Thu"));
        return list;
    }
}
