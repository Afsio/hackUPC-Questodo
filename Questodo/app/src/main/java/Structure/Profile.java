package Structure;
import android.content.SyncStatusObserver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.Scanner;

/**
 * Created by carlos on 8/10/16.
 */

public class Profile {

    Scanner read= new Scanner(System.in);
        public void LoadFile() throws IOException{
            User u1;
            //int day, month, year;
            String name;
            String description;
            String user;        //User alias
            // private Date birthday;
            int level;

            try{
                BufferedReader bf = new BufferedReader(new FileReader("user_logs.txt"));
                String line = bf.readLine();

                    StringTokenizer st = new StringTokenizer(line, ",");

                    name=st.nextToken();
                    description=st.nextToken();
                    user=st.nextToken();
                //   day=Integer.parseInt(st.nextToken());
                //   month=Integer.parseInt(st.nextToken());
                //   year=Integer.parseInt(st.nextToken());
                //   birthday= new Date(day, month, year);
                    level= Integer.parseInt(st.nextToken());
                    u1= new User(name, description, user, level);





            }catch(FileNotFoundException e){    //If it's not found, ask for a new user.
                System.out.println("Insert your name:");
                name=read.next();
                System.out.println("Insert your Username:");
                user=read.next();
                //System.out.println("Insert your birthday(day/month/year)");
                level=0;


            }


        }






}
