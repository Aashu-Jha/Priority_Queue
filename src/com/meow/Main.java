package com.meow;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main extends PriorityQueue{


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        String str = br.readLine();
        while (!str.equals("quit")) {
            if (str.startsWith("add")) {
                try{
                    pq.add((Integer.parseInt(str.split(" ")[1])));
                }catch (Exception e){
                    System.out.println("Error occurred in testInt(). Details: " + e.getMessage());
                }

            } else if (str.startsWith("remove")) {
                System.out.println(pq.remove());
            } else if (str.startsWith("peek")) {
                System.out.println(pq.peek());
            } else if (str.startsWith("size")) {
                System.out.println(pq.size());
            } else if (str.startsWith("clear")) {
                pq.clear();
            }else if (str.startsWith("isEmpty")) {
                System.out.println(pq.isEmpty());
            }else if (str.startsWith("contains")) {
                try{
                    System.out.println(pq.contains(Integer.parseInt(str.split(" ")[1])));
                }catch (Exception e){
                    System.out.println("Error occurred in testInt(). Details: " + e.getMessage());
                }

            }else if (str.startsWith("quit")) {
                return;
            }else{
                System.out.println("Please enter valid method");
            }
            str = br.readLine();
        }


    }
}
