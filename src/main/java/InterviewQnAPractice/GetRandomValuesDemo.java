package InterviewQnAPractice;



import java.time.LocalDate;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class GetRandomValuesDemo {

    Random r = new Random();


    public static void main(String[] args) {

        GetRandomValuesDemo g = new GetRandomValuesDemo();

        //get random values for 10 times
        for (int x=1 ; x<=11; x++)
        {
//            g.usingRandomClass();
            g.usingDateTime();
        }


    }

    private void usingRandomClass(){

        Random r = new Random();
        final int maxValue = 9999999;

        System.out.println(r.nextInt(maxValue));
    }

    private void usingDateTime()
    {
        LocalDate objDate = LocalDate.now();  /// ??? how object cratead without new keyword
        LocalTime objTime = LocalTime.now();

        LocalDateTime objDateTime = LocalDateTime.now();
        System.out.println(objDateTime);

        //how to format
        DateTimeFormatter objDTFormatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss_ms");

        //now formaat the above date
        System.out.println(objDateTime.format(objDTFormatter));

    }


}
