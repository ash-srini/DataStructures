package MobileIron;

/**
 * Created by aishwaryasrinivasan on 06/10/16.
 */
public class ReplaceTag implements Tag{

    String tagName;

    public ReplaceTag (String tagName){
        this.tagName = tagName;
    }

    @Override
    public String processData(String data) {
        return "THIS STRING";
    }
}
