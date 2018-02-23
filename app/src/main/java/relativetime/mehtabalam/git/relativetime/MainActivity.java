package relativetime.mehtabalam.git.relativetime;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

        String time;
        String rtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            rtime=GetRelativeTime("23/02/2018 15:28:24"); // old_time should be in this format only.


    }


    public String GetRelativeTime(String old_time){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String c_time = sdf.format(new Date());
        String m_old_time = old_time.substring(0,c_time.indexOf(" "));
        String c_date=c_time.substring(0,10);
        String c_hh = c_time.charAt(11)+""+c_time.charAt(12);
        String c_mm = c_time.charAt(14)+""+c_time.charAt(15);
        // String c_ss = c_time.charAt(17)+""+c_time.charAt(18);
        String c_dd=c_time.charAt(0)+""+c_time.charAt(1);
        String c_MM = c_time.charAt(3)+""+c_time.charAt(4);
        String c_YY = c_time.charAt(8)+""+c_time.charAt(9);
        String o_hh = old_time.charAt(11)+""+old_time.charAt(12);
        String o_mm = old_time.charAt(14)+""+old_time.charAt(15);
        //   String o_ss = old_time.charAt(17)+""+old_time.charAt(18);
        String o_dd = old_time.charAt(0)+""+old_time.charAt(1);
        String o_MM = old_time.charAt(3)+""+old_time.charAt(4);
        String o_YY =  old_time.charAt(8)+""+old_time.charAt(9);
        if(m_old_time.equals(c_date)) {
            if(c_hh.equals(o_hh)) {
                if(c_mm.equals(o_mm)) {
                    time= ""+"Just now";
                }else {
                    time=""+(Integer.valueOf(c_mm)-Integer.valueOf(o_mm)+" min ago");
                }
            } else {
                time=""+(Integer.valueOf(c_hh)-Integer.valueOf(o_hh)+" hr ago");
            }
        }else if(o_MM.equals(c_MM)) {

            String temp  =""+(Integer.valueOf(c_dd)-Integer.valueOf(o_dd));
            if(temp.equals("1")) {
                time="yesterday";
            } else {
                time=""+(Integer.valueOf(c_dd)-Integer.valueOf(o_dd))+" day ago";
            }

        } else if(o_YY.equals(c_YY)){
            time=""+(Integer.valueOf(c_MM)-Integer.valueOf(o_MM)+" month ago");

        }



        return time;
    }
}


