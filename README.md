# ParallaxPageView(视察动画ViewPager)

## XML  用ParallaxPageContainer 作为Fragment布局的父布容器
```xml
<?xml version="1.0" encoding="utf-8"?>
<top.golabe.kotlin.library.view.ParallaxPageContainer xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ImageView
        android:id="@+id/iv_0"
        android:layout_width="200dp"
        android:layout_height="100dp"
        app:y_in="1.0"
        app:y_out="1.0"
        app:a_in="false"
        app:a_out="true"
        app:x_in="1.8"
        app:x_out="1.8"/>

   

</top.golabe.kotlin.library.view.ParallaxPageContainer>
```

### 属性
        app:a_in="true"  开启进入 透明度 false 关闭透明
        app:a_out="true"  开启退出 透明度 false 关闭透明
        app:x_in="0.5" x 轴进入位移   1.0为正常，值越大速度越快，反之越小
        app:x_out="0.5" x 轴推出位移   1.0为正常，值越大速度越快，反之越小
        app:y_in="0.5" y 轴进入位移   1.0为正常，值越大速度越快，反之越小
        app:y_out="0.5" y 轴退出位移   1.0为正常，值越大速度越快，反之越小


## XML ParallaxPageView 作为容器 （ParallaxPageView 继承ViewPager）
```xml
    <top.golabe.kotlin.library.view.ParallaxPageView
        android:id="@+id/parallaxPageView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```

## JAVA 

```java
    ParallaxPageView container = findViewById(R.id.parallaxPageView);
        container.setup(new int[]{R.layout.fragment_1
                , R.layout.fragment_2
                , R.layout.fragment_3
                , R.layout.fragment_5
                , R.layout.fragment_4});
```
## ATTRS
```xml
<resources>

    <declare-styleable name="ParallaxPageContainer">
        <attr name="a_in" format="boolean" />
        <attr name="a_out" format="boolean" />
        <attr name="x_in" format="float" />
        <attr name="x_out" format="float" />
        <attr name="y_in" format="float" />
        <attr name="y_out" format="float" />
    </declare-styleable>
</resources>
```


