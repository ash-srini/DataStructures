package MobileIron;
/**
 * Created by aishwaryasrinivasan on 06/10/16.
 */
public class TagFactory {

    public static Tag getTag(String tagName){
        if(tagName.equalsIgnoreCase("REPLCE")){
            return new ReplaceTag(tagName);
        }
        else if(tagName.equalsIgnoreCase("UPPRCS")){
            return new UpperCaseTag(tagName);
        }
        return null;
    }



}
