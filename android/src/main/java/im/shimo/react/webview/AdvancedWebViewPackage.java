package im.shimo.react.webview;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import ren.yale.android.cachewebviewlib.CacheType;
import ren.yale.android.cachewebviewlib.ResourceInterceptor;
import ren.yale.android.cachewebviewlib.WebViewCacheInterceptor;
import ren.yale.android.cachewebviewlib.WebViewCacheInterceptorInst;
import ren.yale.android.cachewebviewlib.config.CacheExtensionConfig;

public class AdvancedWebViewPackage implements ReactPackage {
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        //Initialize WebViewCacheInterceptor with config
        WebViewCacheInterceptor.Builder builder =  new WebViewCacheInterceptor.Builder(reactApplicationContext);

        CacheExtensionConfig extension = new CacheExtensionConfig();
        extension.removeExtension("html")
                .removeExtension("htm")
                .removeExtension("php")
                .removeExtension("txt")
                .removeExtension("text")
                .removeExtension("js")
                .removeExtension("json")
                .removeExtension("")
                .addExtension("mp4")
                .addExtension("mp3")
                .addExtension("ogg")
                .addExtension("avi")
                .addExtension("wmv")
                .addExtension("flv")
                .addExtension("rmvb")
                .addExtension("3gp");


        builder.setCachePath(new File(reactApplicationContext.getCacheDir(),"cache_path_name"))//set cache path, default getCacheDir, name CacheWebViewCache
                .setCacheSize(1024*1024*100)
                .setCacheExtensionConfig(extension)
                .setConnectTimeoutSecond(20)//set http connect timeou,default 20 seconds
                .setReadTimeoutSecond(20)//set http read timeout,default 20 seconds
                .setCacheType(CacheType.NORMAL);

        WebViewCacheInterceptorInst.getInstance().init(builder);

        return Arrays.<ViewManager>asList(
                new AdvancedWebViewManager()
        );
    }

    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }
}
