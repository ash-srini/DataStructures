package MobileIron;

/**
 * Created by aishwaryasrinivasan on 06/10/16.
 */
public class UpperCaseTag implements Tag {


        String tagName;

        public UpperCaseTag (String tagName){
            this.tagName = tagName;
        }

        @Override
        public String processData(String data) {
            return data.toUpperCase();
        }


}
