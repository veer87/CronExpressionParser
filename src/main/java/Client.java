import Api.Parser;
import com.Parser.impl.CronParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.LogManager;

public class Client {
    public static void main(String[] args) throws Exception {

        LogManager.getLogManager().reset();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        // Reading data using readLine
        String line = null;
        Parser cronParser = new CronParser();
        do {
            System.out.println("\n-----Cron Parser Started----\n");
            System.out.println("1. Want to use Cron Parser, press 1\n" +
                    "2. For Exit, press e or q\n");
            line = reader.readLine();
            if (line.equalsIgnoreCase("e") || line.equalsIgnoreCase("q")) break;

            System.out.println("Give expression space separated, supported only Min Hour Day_Of_Month Month Day_of_Week and valid special characters are [*, /, -] \n");
            line = reader.readLine();
            System.out.println(cronParser.parse(line));

        } while(true);

      //  System.out.println("result === " + parser.parse("2/5"));
     //   System.out.println("result === " + parser.parse("2-5 1-5"));
        //System.out.println("result === " + parser.parse("2-5 1-5,6/4"));
      //  System.out.println(" Parser result : \n " + cronParser.parse(args[0]));
       // System.out.println("result === " + parser.parse("*/15 0 1,15 * 1-5 /usr/bin/find"));
       // System.out.println("result === " + parser.parse("*/1/5 0 1,15 * 1-5 /usr/bin/find"));
        //System.out.println("result === " + parser.parse("*/15 0 1,(15 * 1-f5 /usr/bin/find"));
        //System.out.println("result === " + parser.parse("*/15 0 1,15 * 1-f5 /usr/bin/find"));*/

        System.out.println("\n-----Cron Parser Stopped----\n");




    }
}
