package com.hotelgo.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.stereotype.Service;
import java.io.File;

@Service
public class StorageService {

        private AmazonS3 amazonS3;
        private String bucketName = "hotelGo_dev";



        public StorageService(){
//            this.amazonS3 = AmazonS3ClientBuilder.defaultClient();
        }

        public void upload(String keyName, File file){

            amazonS3.putObject(bucketName, keyName, file);

        }

        public String getObjectUrl(String keyName){

            String url = "https://"+ bucketName+".s3.amazonaws.com/"+keyName;
            return url;

        }

}
