package top.golabe.kotlin.parallaxpageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import top.golabe.kotlin.library.view.ParallaxPageView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ParallaxPageView container = findViewById(R.id.parallaxPageView);
        container.setup(new int[]{R.layout.fragment_1
                , R.layout.fragment_2
                , R.layout.fragment_3
                , R.layout.fragment_4
                , R.layout.fragment_5,
                R.layout.fragment_1});

    }
}
