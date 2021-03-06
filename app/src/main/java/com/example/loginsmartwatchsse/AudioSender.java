package com.example.loginsmartwatchsse;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by home on 6/11/16.
 */
public class AudioSender implements Callable<String> {

    String outputFile;

    AudioSender(String fileLocation){
        outputFile=fileLocation;
    }

    public String call(){

        File output=new File(outputFile);
        String response = new String ();
        try {
            MultipartUtility1 multipart = new MultipartUtility1("http://icowms.cloud.reply.eu/Details/uploadfile");
            multipart.addFilePart("myFile", output);
            response = multipart.finish();
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            Log.d("SR", "SERVER REPLIED:");
            return response;
        }

    }
}