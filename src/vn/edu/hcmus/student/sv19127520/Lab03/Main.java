package vn.edu.hcmus.student.sv19127520.Lab03;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void createData(){
        ListStudents t=new ListStudents(
                new Student("001","Nguyen Van A",5.8,"none","Binh Phuoc","dep trai, con nha giau, hoc gioi"),
                new Student("021","Nguyen Van B",8.8,"none","Ho Chi Minh",""),
                new Student("043","Nguyen Van C",7.6,"none","Dong Nai","dac biet quan tam")
        );
        try{
            FileOutputStream fos=new FileOutputStream("list.dat");
            ObjectOutputStream ob=new ObjectOutputStream(fos);
            ob.writeObject(t);
            ob.close();
        }
        catch (Exception e){

        }
    }
    public static void Save(ListStudents a){
        try{
            FileOutputStream fos=new FileOutputStream("list.dat");
            ObjectOutputStream ob=new ObjectOutputStream(fos);
            ob.writeObject(a);
            ob.close();
        }
        catch (Exception e){
        }
    }
    public static ListStudents Load(){
        ListStudents l=null;
        try{
            FileInputStream fis=new FileInputStream("list.dat");
            ObjectInputStream ob=new ObjectInputStream(fis);
            l=(ListStudents) ob.readObject();
            ob.close();

        }
        catch (Exception e){
        }
        return l;
    }
    public static void main(String[] args) throws IOException {
        createData();
        Scanner scan=new Scanner(System.in);
        ListStudents l=Load();
        while(true){
            System.out.println("------------MENU------------");
            System.out.println("1. List student");
            System.out.println("2. Update student");
            System.out.println("3. Add student");
            System.out.println("4. Delete student");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            int k=scan.nextInt();
            switch (k){
                case 1: {
                        if (l != null) {
                            while (true) {
                                l.show();
                                System.out.println("    1. Sort ascending by ID");
                                System.out.println("    2. Sort descending by ID");
                                System.out.println("    3. Sort ascending by Mark");
                                System.out.println("    4. Sort descending by Mark");
                                System.out.println("    5. Export to file text");
                                System.out.println("    6. Return");
                                System.out.print("      Your choice: ");
                                int p = scan.nextInt();
                                switch (p) {
                                    case 1: {
                                        l.sortAscID();
                                        l.show();
                                        break;
                                    }
                                    case 2: {
                                        l.sortDesID();
                                        l.show();
                                        break;
                                    }
                                    case 3: {
                                        l.sortAscMark();
                                        l.show();
                                        break;
                                    }
                                    case 4: {
                                        l.sortDesMark();
                                        l.show();
                                        break;
                                    }
                                    case 5: {
                                        l.export();
                                        break;
                                    }
                                    case 6:
                                        break;
                                }
                                if(p==6)
                                    break;
                            }
                        } else
                            System.out.println("Don't have any list students");
                        break;
                }
                case 2:{
                    System.out.println("    Update student: ");
                    l.update();
                    Save(l);
                    break;
                }
                case 3:
                {
                    System.out.println("    Add student:");
                    l.add();
                    Save(l);
                    break;
                }
                case 4:
                {
                    System.out.println("    Delete student:");
                    l.delete();
                    Save(l);
                    break;
                }
                case 5:
                    return;
                case 6:
                    System.out.println("Invalid!");
            }

        }


    }
}
