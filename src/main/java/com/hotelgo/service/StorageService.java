package com.hotelgo.service;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import java.io.File;


public class StorageService {

        private AmazonS3 amazonS3;
        private String bucket;
        private String bucketName = "hotelGo_dev";


        public StorageService(AmazonS3 s3){
            this.amazonS3 = s3;
        }




        public void upload(String keyName, File file){

            amazonS3.putObject(bucketName, keyName, file);

        }

        public String getObjectUrl(String keyName){

            String url = "https://"+ bucketName+".s3.amazonaws.com/"+keyName;
            return url;

        }

        public void setBucket(String bucket){
            this.bucket = bucket;
        }


        public S3Object getObject(String S3Key){
            if(S3Key==null){
                return null;
            }else{
                return amazonS3.getObject(this.bucket,S3Key);
            }

        }


//        public S3Object getObject(String bucket , String ){
//
//        }


}
