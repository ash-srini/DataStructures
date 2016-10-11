package MobileIron;
import java.util.*;

/**
 * Created by aishwaryasrinivasan on 06/10/16.
 */

/*
Write a TLV processor in Java

* Process TLVs with the following format.

* Format: TYPE(6)-LEN(4)-VALUE

* Type - fixed 6 chars length. Defines the type of processing required.

* Len - fixed 4 chars (represented as text) length of the value.

* Value - the actual data to be processed of length 'Len' above.

* Processing details:

* For Type UPPRCS: convert the value to uppercase, if already uppercase do nothing.

* For Type REPLCE: replace the value with fixed string "THIS STRING"

* For any other type indicate an error and continue processing.

* Assume all data is in ascii.

* Assume all data will always follow the format specified, i.e. no malformed TLVs.

* Input is specified on StdIn and output is expected on StdOut.

** Extra points for flexible design which will help to easily add new input-output types (like network streams), processors (for example, LOWRCS), or any other parts of the design.

* E.g.

Input:

UPPRCS-0005-abcde

REPLCE-0003-123

UPPRCS-0008-Abcdefgh

REPLCE-0003-123

REPLCE-0001-Z

TAG001-0012-abcdefgh1234

UPPRCS-0004-1234

Output:

UPPRCS-ABCDE

REPLCE-THIS STRING

UPPRCS-ABCDEFGH

REPLCE-THIS STRING

REPLCE-THIS STRING

Type not valid

UPPRCS-1234
 */


public class TLVParser {
    public static void parseTLVInput(String line){
        //read tag from line
        if(!line.equals("")) {
            String[] tagInfo = line.split("-");
            Tag tag = TagFactory.getTag(tagInfo[0]);
            if (tag != null) {
                System.out.println(tagInfo[0] + "-" + tag.processData(tagInfo[2]));
            } else {
                System.out.println("Type not valid");
            }
            //call factory class method to create the required tag object
            //tag.processData(tag);
            //call processData on that tag object via the factory method
            //print tag name and value returned by tag to stdout
        }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

            while (sc.hasNextLine() == true) {
                parseTLVInput(sc.nextLine());
            }

            if(sc!= null)
                sc.close();

    }

}
