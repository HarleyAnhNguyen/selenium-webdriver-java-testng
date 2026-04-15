package javaTester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Topic_08_For_ForEach {

    public static void main(String[] args){

        for(int i =0; i< 5;i ++){
            System.out.println(i);
        }
        String[] cityName ={"Ha Noi", "Ho Chi Minh", "Da Nang", "Hai Phong", "Can Tho"};

        for (int i =0; i<cityName.length; i++){
            System.out.println(cityName[i]);
        }

        for (int i =0; i<cityName.length; i++){
            if(cityName[i] =="Hai Phong") {
                System.out.println(cityName[i] + " Done");
                break;
            }
        }

        List<String> listCity = new ArrayList<String>();
        listCity.add("Ha Giang");
        for( String city : cityName){
            listCity.add(city);
        }

        for(int i =0; i<= listCity.size();i++){
            System.out.println(listCity.get(i));
        }



    }
}
