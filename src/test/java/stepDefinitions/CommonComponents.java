package stepDefinitions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CommonComponents {

    public static String RandomUniqueString(){


        LocalDateTime objDateTime = LocalDateTime.now();


        //how to format
        DateTimeFormatter objDTFormatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss_ms");

        //now formaat the above date
//        System.out.println(objDateTime.format(objDTFormatter));
        return objDateTime.format(objDTFormatter);

    }
}
