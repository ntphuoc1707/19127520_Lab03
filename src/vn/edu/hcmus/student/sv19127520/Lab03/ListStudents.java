package vn.edu.hcmus.student.sv19127520.Lab03;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import java.util.Vector;

/**
 * vn.edu.hcmus.student.sv19127520.Lab03;
 * Created by Phuoc -19127520
 * Date 11/3/2021 - 8:18 PM
 * Description: ...
 */
public class ListStudents implements Serializable {
    private Student[] students;
    public ListStudents(){
        students=null;
    }
    public ListStudents(Student...st){
        Student[] t=new Student[st.length];
        for (int i=0;i<st.length;i++){
            t[i]=st[i];
        }
        students=t;
    }

    public void add(){
        Scanner scan=new Scanner(System.in);
        Student p = new Student();
        System.out.print("      Enter id: ");
        String id=scan.next();
        for(int i=0;i<students.length;i++)
            if(students[i].getid().compareTo(id)==0)
            {
                System.out.println("        Id already exist!");
                return;
            }
        p.Input(id);
        Student[] t= new Student[students.length+1];
        for(int i=0;i<students.length;i++)
            t[i]=students[i];
        t[students.length]=p;
        students=t;
    }
    public void delete(){
        Scanner scan=new Scanner(System.in);
        System.out.print("      Enter ID: ");
        String a=scan.next();
        Student[] t=new Student[students.length-1];
        Vector<Student> p=new Vector<>();
        for(int i=0;i<students.length;i++)
            if (a.compareTo(students[i].getid())!=0){
                p.add(students[i]);
            }
        if(p.size()==students.length) {
            System.out.println("        Don't have this student!");
            return;
        }
        else{
            for(int i=0;i<p.size();i++){
                t[i]=p.elementAt(i);
            }
            students=t;
        }

    }
    public void show(){
        if(students.length==0){
            System.out.println("Empty");
        }
        else{
            System.out.println("-----------------LIST STUDENTS-------------");
            for(int i=0;i<students.length;i++){
                System.out.println("id: "+students[i].getid());
                System.out.println("  Name: "+students[i].getName());
                System.out.println("    Mark: "+students[i].getMark());
                System.out.println("      Image: "+students[i].getImage());
                System.out.println("        Address: "+students[i].getAddress());
                System.out.println("          Note: "+students[i].getNote());
            }
        }
    }
    public void update(){
        Scanner scan=new Scanner(System.in);
        System.out.print("    Enter ID: ");
        String a=scan.next();
        for(int i=0;i<students.length;i++){
            if (a.compareTo(students[i].getid())==0){
                while(true){
                    System.out.println("        1. Name");
                    System.out.println("        2. Mark");
                    System.out.println("        3. Image");
                    System.out.println("        4. Address");
                    System.out.println("        5.Note");
                    System.out.println("        6. Return");
                    System.out.print("       Your choice: ");
                    int k=scan.nextInt();
                    switch (k){
                        case 1:
                        {
                            System.out.print("        Enter Name:");
                            String n=scan.next();
                            students[i].setName(n);
                            break;
                        }
                        case 2:
                        {
                            System.out.print("        Enter Mark:");
                            double n =scan.nextDouble();
                            students[i].setMark(n);
                            break;
                        }
                        case 3:
                        {
                            System.out.print("        Enter Link Image:");
                            String n=scan.next();
                            students[i].setImage(n);
                            break;
                        }
                        case 4:
                        {
                            System.out.print("        Enter Address:");
                            String n=scan.next();
                            students[i].setAddress(n);
                            break;
                        }
                        case 5:
                        {
                            System.out.print("        Enter Note:");
                            String n=scan.next();
                            students[i].setNote(n);
                            break;
                        }
                        case 6:
                            return;
                        default:
                        {
                            System.out.println("      Invalid!");
                        }
                    }
                }
            }
        }
        System.out.println("Don't have this student!");
    }
    public void sortAscID(){
        for(int i=0;i<students.length-1;i++){
            for (int j=i+1;j<students.length;j++){
                if(students[i].getid().compareTo(students[j].getid())>0){
                    Student t=students[i];
                    students[i]=students[j];
                    students[j]=t;
                }
            }
        }
    }
    public void sortDesID(){
        for(int i=0;i<students.length-1;i++){
            for (int j=i+1;j<students.length;j++){
                if(students[i].getid().compareTo(students[j].getid())<0){
                    Student t=students[i];
                    students[i]=students[j];
                    students[j]=t;
                }
            }
        }
    }
    public void sortAscMark(){
        for(int i=0;i<students.length-1;i++){
            for (int j=i+1;j<students.length;j++){
                if(students[i].getMark()>students[j].getMark()){
                    Student t=students[i];
                    students[i]=students[j];
                    students[j]=t;
                }
            }
        }
    }
    public void sortDesMark(){
        for(int i=0;i<students.length-1;i++){
            for (int j=i+1;j<students.length;j++){
                if(students[i].getMark()<students[j].getMark()){
                    Student t=students[i];
                    students[i]=students[j];
                    students[j]=t;
                }
            }
        }
    }
    public void export() {
        try {
            FileOutputStream fos = new FileOutputStream("list.txt");
            DataOutputStream d=new DataOutputStream(fos);
            d.writeBytes("Total: "+students.length+"\n");
            for (Student i: students){
                d.writeBytes("ID: "+i.getid()
                        +" ,Name: "+i.getName()
                        +" ,Mark "+i.getMark()
                        +" ,Image: "+i.getImage()
                        +" ,Address: "+i.getAddress()
                        +" ,Note: "+i.getNote()
                        +"\n");
            }
        }
        catch (Exception e){}
    }
}
