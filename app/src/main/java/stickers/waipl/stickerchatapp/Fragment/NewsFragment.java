package stickers.waipl.stickerchatapp.Fragment;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.samplestickerapp.R;
import com.google.android.ads.nativetemplates.NativeTemplateStyle;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.nativead.NativeAdOptions;


public class NewsFragment extends Fragment {
//    ListView lvrss;
//    ArrayList<String> titles;
//    ArrayList<String> description;
//    ArrayList<String> pubdate;
   // public WebView mWebView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NewsFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static NewsFragment newInstance(String param1, String param2) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_news,container,false);
        // Inflate the layout for this fragment



        // Inflate the layout for this fragment

//        titles = new ArrayList<String>();
//        description = new ArrayList<String>();
//        pubdate = new ArrayList<String>();
//
       // mWebView = (WebView) view.findViewById(R.id.mwebView);
       // mWebView.loadUrl("https://stickcric1.blogspot.com");
        // progressBar = (ProgressBar) view.findViewById(R.id.progressBar);

        AdLoader adLoader = new AdLoader.Builder(getActivity(), "ca-app-pub-4329208972214857/2673812291")                .forUnifiedNativeAd(unifiedNativeAd -> {
            NativeTemplateStyle styles = new
                    NativeTemplateStyle.Builder().build();

            TemplateView adView = view.findViewById(R.id.NewNative);
            adView.setStyles(styles);
            adView.setNativeAd(unifiedNativeAd);
            // Show the ad.
        })
                .withAdListener(new AdListener() {
                    public void onAdFailedToLoad(int errorCode) {
                        //  adView.setVisibility(View.GONE);
                        // Handle the failure by logging, altering the UI, and so on.
                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()
                        // Methods in the NativeAdOptions.Builder class can be
                        // used here to specify individual options settings.
                        .build())
                .build();
        adLoader.loadAd(new AdRequest.Builder().build());

        // Enable Javascript
       // WebSettings webSettings = mWebView.getSettings();
       // webSettings.setJavaScriptEnabled(true);


        // Force links and redirects to open in the WebView instead of in a browser
      //  mWebView.setWebViewClient(new WebViewClient());

        return view;

    }

//    public InputStream getInputStream(URL url) {
//        try {
//            return url.openConnection().getInputStream();
//        } catch (
//                IOException e)
//
//        {
//            return null;
//        }
//
//
//    }
//    public class ProcessInBackground extends AsyncTask<Integer, Void, Exception> {
//        ProgressDialog progressDialog = new ProgressDialog(getContext());
//        Exception exception = null;
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//
//            progressDialog.setMessage("Loading RSS Feed...");
//            progressDialog.show();
//        }
//
//        @Override
//        protected Exception doInBackground(Integer... integers) {
//
//            try {
//
//                URL url = new URL("https://stickcric1.blogspot.com/feeds/posts/default?alt=rss");
//                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
//                // creates new instance of pull parser factory that allows XML retrieval
//                factory.setNamespaceAware(false);
//                // parser produced does not support XML namespaces
//                XmlPullParser xpp = factory.newPullParser();
//                //new instance of parser, extracts xml document data
//                xpp.setInput(getInputStream(url), "UTF_8");
//                //encoding is in UTF8
//                boolean insideItem = false;
//                int eventType = xpp.getEventType();
//                //when we start reading, it returns the type of current event i.e. tag type
//
//                while (eventType != XmlPullParser.END_DOCUMENT) {
//                    if (eventType == XmlPullParser.START_TAG) {
//                        if (xpp.getName().equalsIgnoreCase("item")) {
//                            insideItem = true;
//                        } else if (xpp.getName().equalsIgnoreCase("title")) {
//                            if (insideItem) {
//                                titles.add(xpp.nextText());
//                            }
//                        } else if (xpp.getName().equalsIgnoreCase("description")) {
//                            if (insideItem) {
//                                description.add(xpp.nextText());
//                            }
//                        } else if (xpp.getName().equalsIgnoreCase("pubDate")) {
//                            if (insideItem) {
//                                pubdate.add(xpp.nextText());
//                            }
//                        }
//                    } else if (eventType == XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase("item")) {
//                        insideItem = false;
//                    }
//
//                    eventType = xpp.next();
//                }
//
//            } catch (MalformedURLException e) {
//                exception = e;
//            } catch (XmlPullParserException e) {
//                exception = e;
//            } catch (IOException e) {
//                exception = e;
//            }
//
//
//            return exception;
//        }
//
//        @Override
//        protected void onPostExecute(Exception s) {
//            super.onPostExecute(s);
//            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, titles);
//            lvrss.setAdapter(adapter);
//            //connects to data to the list view
//            progressDialog.dismiss();
//        }
//    }

}

