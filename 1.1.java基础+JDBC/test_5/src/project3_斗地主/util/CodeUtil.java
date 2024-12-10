package project3_斗地主.util;

import java.util.Random;

public class CodeUtil {

    public static String getCode(){
      //自己练习
        Random r=new Random();
        StringBuilder sb=new StringBuilder();
        int index=r.nextInt(5);
        for(int i=0;i<5;i++){
            if(i==index){
                sb.append(r.nextInt(10));
                continue;
            }
            int decide=r.nextInt(2);
            if(decide==0){
                sb.append((char) ('a'+r.nextInt(26)));
            }
            else{
                sb.append((char) ('A'+r.nextInt(26)));
            }
        }
        return sb.toString();
    }

}