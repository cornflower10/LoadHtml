package cn.cornflower.com.loadhtml;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {


    private ProgressWebView webView;
    private String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {

         url = "https://www.baidu.com";

        webView = (ProgressWebView) findViewById(R.id.wv);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //  重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
                view.loadUrl(url);

                return  true;
            }



        });

        webView.setVerticalScrollBarEnabled(true);
        webView. setHorizontalScrollBarEnabled(false);
        webView. getSettings().setJavaScriptEnabled(true);
        webView. getSettings().setSupportZoom(true);
        webView.getSettings().setDomStorageEnabled(true);
		webView.getSettings().setSavePassword(true);
        webView. requestFocus();
        webView. getSettings().setUseWideViewPort(true);
        webView. getSettings().setLoadWithOverviewMode(true);
        webView.loadUrl(url);

    }


    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else
        finish();
        super.onBackPressed();
    }
}
