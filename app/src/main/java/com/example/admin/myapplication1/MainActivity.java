package com.example.admin.myapplication1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sendbird.android.BaseChannel;
import com.sendbird.android.OpenChannel;
import com.sendbird.android.SendBird;
import com.sendbird.android.SendBirdException;
import com.sendbird.android.User;
import com.sendbird.android.UserMessage;

import java.util.List;


public class MainActivity extends AppCompatActivity {


    String chatname = "LOL";
    OpenChannel MY_openChannel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SendBird.connect("User001","7cea108e95742d17559d3e7472d37074cfb62f1d" , new SendBird.ConnectHandler() {
            @Override
            public void onConnected(User user, SendBirdException e) {
                if (e != null) {

                    return;
                }
            }
        });



        /*OpenChannel.createChannel(new OpenChannel.OpenChannelCreateHandler() {
            @Override
            public void onResult(OpenChannel openChannel, SendBirdException e) {
                if (e != null) {
                    // Error.
                    return;
                }
            }
        });
        */

         OpenChannel.getChannel("sendbird_open_channel_33811_0c892d91d9872a4be95b0a855b3c036a314149ab", new OpenChannel.OpenChannelGetHandler() {
            @Override
            public void onResult(final OpenChannel openChannel, SendBirdException e) {
                if (e != null) {

                    return;
                }

                openChannel.enter(new OpenChannel.OpenChannelEnterHandler() {
                    @Override
                    public void onResult(SendBirdException e) {
                        if (e != null) {
                          //  MY_openChannel = openChannel;
                            openChannel.sendUserMessage("LOL", null, "776", new BaseChannel.SendUserMessageHandler() {
                                @Override
                                public void onSent(UserMessage userMessage, SendBirdException e) {
                                    if (e != null) {
                                        // Error.
                                        return;
                                    }
                                }
                            });
                            return;
                        }
                    }
                });
            }
        });



    }
}
