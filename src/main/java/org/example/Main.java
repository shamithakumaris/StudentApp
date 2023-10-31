package org.example;


import com.student.manage.Student;
import com.student.manage.StudentDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Student Management App");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            System.out.println("Press 1 to ADD Student");
            System.out.println("Press 2 to DELETE Student");
            System.out.println("Press 3 to DISPLAY Student");
            System.out.println("Press 4 to EXIT Student");
            int c=Integer.parseInt(br.readLine());
            if(c==1)
            {
                //add student
                System.out.println("Enter user name:");
                String name =br.readLine();

                System.out.println("Enter user phone:");
                String phone =br.readLine();

                System.out.println("Enter user city:");
                String city =br.readLine();

                //create student object
                Student st=new Student(name,phone,city);
                boolean answer= StudentDAO.insertStudentToDB(st);
                if(answer)
                {
                    System.out.println("Student is successfully added");
                }
                else{
                    System.out.println("Something went out");
                }
                System.out.println(st);



            }else if(c==2)
            {
                //delete student
                System.out.println("Enter student Id to delete");
                int userId=Integer.parseInt(br.readLine());
                boolean f= StudentDAO.deleteStudent(userId);
                if(f)
                {
                    System.out.println("Deleted...");
                }
                else {
                    System.out.println("Something went out");

                }


            }else if(c==3)
            {
                //display student
                StudentDAO.showAllStudent();

            }else if(c==4)
            {
                //exit



                break;
            }else
            {

            }

        }
        System.out.println("Thank You for using the Application");
        System.out.println("See you Soon ..Bi Bi");

    }
}