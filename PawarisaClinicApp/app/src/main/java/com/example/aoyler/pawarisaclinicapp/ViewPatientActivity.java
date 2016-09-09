package com.example.aoyler.pawarisaclinicapp;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class ViewPatientActivity extends AppCompatActivity {

    String Title, valID;
    private WebView webview;
    private static final String TAG = "Main";
    private ProgressDialog progressBar;
    WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_patient);

        //https://surasak.io/pawarisaclinic/view.php?ID=

        Bundle b = getIntent().getExtras();
        Title = b.getString("valTitle");
        valID = b.getString("valID");


        TextView textView = (TextView) findViewById(R.id.Title);
        if(valID.isEmpty()){
            textView.setText("ไม่พบข้อมูล");
        } else {
            textView.setText("Title: " + Title);
        }
        // find the WebView by name in the main.xml of step 2
        browser = (WebView) findViewById(R.id.webview);

        // Enable javascript
        browser.getSettings().setJavaScriptEnabled(true);

        // Set WebView client
        browser.setWebChromeClient(new WebChromeClient());

        browser.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        // Load the webpage
        browser.loadUrl("https://surasak.io/pawarisaclinic/view.php?ID="+valID);
    }
}
