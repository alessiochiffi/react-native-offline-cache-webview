package im.shimo.react.webview;

import java.util.ArrayList;

public class Config {
   public static final ArrayList<String> NON_CACHING_EXTENSIONS = new ArrayList<String>(){
       {
           add("html");
           add("htm");
           add("php");
           add("txt");
           add("text");
           add("js");
           add("json");
           add("");
       }
   };
}
