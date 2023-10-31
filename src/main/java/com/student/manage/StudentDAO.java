package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {
    public static boolean insertStudentToDB(Student st)
    {
   boolean f=false;
        try{

            Connection con=CP.create();
            String q="insert into students(sname,sphone,scity) values(?,?,?)";
            PreparedStatement pt= con.prepareStatement(q);
            pt.setString(1,st.getStudentName());
            pt.setString(2,st.getStudentPhone());
            pt.setString(3,st.getStudentCity());

            pt.executeUpdate();

            f=true;

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return f;


    }






    public static boolean deleteStudent(int userId) {
        boolean f=false;
        try{

            Connection con=CP.create();
            String q="delete from students where sid=?";
            PreparedStatement pt= con.prepareStatement(q);
            pt.setInt(1, userId);

            pt.executeUpdate();

            f=true;

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return f;
    }








    public static boolean showAllStudent() {
        boolean f=false;
        try{

            Connection con=CP.create();
            String q="select * from students";
            Statement stm= con.createStatement();

          ResultSet set=  stm.executeQuery(q);

          while(set.next())
          {
              int id=set.getInt(1);
              String name=set.getString(2);
              String phone=set.getString(3);
              String city=set.getString(4);
              System.out.println("ID: " + id);
              System.out.println("NAME: " + name);
              System.out.println("PHONE: " + phone);
              System.out.println("CITY: " + city);
              System.out.println("++++++++++++++++++++++++++");


          }



        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return f;

    }
}
