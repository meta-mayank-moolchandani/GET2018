package orderWalaPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Order {
	 public static void main(String[] args) {
	      try {
	         String order1 =  "\t2018-12-03\tNULL\t6\n";
	         String order2 =  "\t2017-11-06\tNULL\t2\n";
	         String order3 =  "\t2018-1-07\tNULL\t3\n";
	         String order4 =  "\t2016-1-19\tNULL\t4\n";
	         String order5 =  "\t2018-2-13\tNULL\t5\n";
	         String order6 =  "\t2015-2-23\tNULL\t7\n";
	         String order7 =  "\t2018-3-11\tNULL\t8\n";
	         String order8 =  "\t2014-4-21\tNULL\t2\n";
	         String order9 =  "\t2018-5-11\tNULL\t3\n";
	         String order10 = "\t2018-6-22\tNULL\t4\n";
	         String order11 = "\t2018-7-11\tNULL\t5\n";
	         String order12 = "\t2018-8-14\tNULL\t11\n";
	         String order13 = "\t2018-9-15\tNULL\t12\n";
	         String order14 = "\t2018-10-12\tNULL\t10\n";
	         String order15 = "\t2018-12-2\tNULL\t2\n";
	         
	         File file = new File("C:\\Users\\User33\\Desktop\\StoreFront Data\\orderData.txt");
	         if (!file.exists()) {
	            file.createNewFile();
	         } 
	         FileWriter fw = new FileWriter(file.getAbsoluteFile());
	         BufferedWriter bw = new BufferedWriter(fw);
	         int j=1;
	         for(int i=0;i<10;i++)
	         {
	         bw.write((j++)+order1);
	         bw.newLine();
	         bw.write((j++)+order2);
	         bw.newLine();
	         bw.write((j++)+order3);
	         bw.newLine();
	         bw.write((j++)+order4);
	         bw.newLine();
	         bw.write((j++)+order5);
	         bw.newLine();
	         bw.write((j++)+order6);
	         bw.newLine();
	         bw.write((j++)+order7);
	         bw.newLine();
	         bw.write((j++)+order8);
	         bw.newLine();
	         bw.write((j++)+order9);
	         bw.newLine();
	         bw.write((j++)+order10);
	         bw.newLine();
	         bw.write((j++)+order11);
	         bw.newLine();
	         bw.write((j++)+order12);
	         bw.newLine();
	         bw.write((j++)+order13);
	         bw.newLine();
	         bw.write((j++)+order14);
	         bw.newLine();
	         bw.write((j++)+order15);
	         bw.newLine();
	         }
	         bw.close();
	         
	         System.out.println("order Data written succesfully");
	      } catch (IOException e) {
	         e.printStackTrace();
	      } 
	   } 

}
