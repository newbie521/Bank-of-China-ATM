package com.example.atm;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Warn extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.warn);
//        设置隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageView imageView = findViewById(R.id.imageView);
        TextView textView = (TextView) findViewById(R.id.textView);

        String news = "本APP尊重并保护所有使用服务用户的个人隐私权。为了给您提供更准确、更有个性化的服务，本APP会按照本隐私权政策的规定使用和披露您的个人信息。但本APP将以高度的勤勉、审慎义务对待这些信息。除本隐私权政策另有规定外，在未征得您事先许可的情况下，本APP不会将这些信息对外披露或向第三方提供。本APP会不时更新本隐私权政策。 您在同意本APP服务使用协议之时，即视为您已经同意本隐私权政策全部内容。本隐私权政策属于本APP服务使用协议不可分割的一部分。<br />" +
                "<br />" +
                "<h3>1. 适用范围<h3/>" +
                "a) 在您使用本APP网络服务，或访问本APP平台网页时，本APP自动接收并记录的您的浏览器和计算机上的信息，包括但不限于您的IP地址、浏览器的类型、使用的语言、访问日期和时间、软硬件特征信息及您需求的网页记录等数据；<br />" +
                "<br />" +
                "b) 本APP通过合法途径从商业伙伴处取得的用户个人数据。<br />" +
                "<br />" +
                "<h3>2. 信息使用<h3/>" +
                "a) 本APP不会向任何无关第三方提供、出售、出租、分享或交易您的个人信息，除非事先得到您的许可，或该第三方和本APP（含本APP关联公司）单独或共同为您提供服务，且在该服务结束后，其将被禁止访问包括其以前能够访问的所有这些资料。<br />" +
                "<br />" +
                "b) 本APP亦不允许任何第三方以任何手段收集、编辑、出售或者无偿传播您的个人信息。任何本APP平台用户如从事上述活动，一经发现，我司有权立即终止与该用户的服务协议。<br />" +
                "<br />" +
                "c) 为服务用户的目的，本APP可能通过使用您的个人信息，向您提供您感兴趣的信息，包括但不限于向您发出产品和服务信息，或者与我司合作伙伴共享信息以便他们向您发送有关其产品和服务的信息（后者需要您的事先同意）。<br />" +
                "<br />" +
                "<h3>3. 信息披露<h3/>" +
                "在如下情况下，本APP将依据您的个人意愿或法律的规定全部或部分的披露您的个人信息：<br />" +
                "<br />" +
                "a) 经您事先同意，向第三方披露；<br />" +
                "<br />" +
                "b) 为提供您所要求的产品和服务，而必须和第三方分享您的个人信息；<br />" +
                "<br />" +
                "c) 根据法律的有关规定，或者行政或司法机构的要求，向第三方或者行政、司法机构披露；<br />" +
                "<br />" +
                "d) 如您出现违反中国有关法律、法规或者本APP服务协议或相关规则的情况，需要向第三方披露；<br />" +
                "<br />" +
                "e) 如您是适格的知识产权投诉人并已提起投诉，应被投诉人要求，向被投诉人披露，以便双方处理可能的权利纠纷；<br />" +
                "<br />" +
                "f) 在本APP平台上创建的某一交易中，如交易任何一方履行或部分履行了交易义务并提出信息披露请求的，本APP有权决定向该用户提供其交易对方的联络方式等必要信息，以促成交易的完成或纠纷的解决。<br />" +
                "<br />" +
                "g) 其它本APP根据法律、法规或者网站政策认为合适的披露。<br />" +
                "<br />" +
                "<h3>4. 信息存储和交换<h3/>" +
                "本APP收集的有关您的信息和资料将保存在本APP及（或）其关联公司的服务器上，这些信息和资料可能传送至您所在国家、地区或本APP收集信息和资料所在地的境外并在境外被访问、存储和展示。<br />" +
                "<br />" +
                "<h3>5. 信息安全<h3/>" +
                "a) 本APP帐号均有安全保护功能，请妥善保管您的用户名及密码信息。本APP将通过对用户密码进行加密等安全措施确保您的信息不丢失，不被滥用和变造。尽管有前述安全措施，但同时也请您注意在信息网络上不存在“完善的安全措施”。<br />" +
                "<br />" +
                "b) 在使用本APP网络服务进行网上交易时，您不可避免的要向交易对方或潜在的交易对方披露自己的个人信息，如联络方式或者邮政地址。请您妥善保护自己的个人信息，仅在必要的情形下向他人提供。如您发现自己的个人信息泄密，尤其是本APP用户名及密码发生泄露，请您立即联络本APP客服，以便本APP采取相应措施。<br />" +
                "<br />" +
                "<h3 style=\"text-align:center;\">最终解释权归中国矿业大学梅二A114大寝所有<h3/><br />";
        textView.setText(Html.fromHtml(news));//这是显示段落文本的,通过解析html
//        textView.setText(news);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());//段落文本的话要加这个

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Warn.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
