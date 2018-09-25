package com.hotelgo.service;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


public class StorageService {

    public final Logger logger = LoggerFactory.getLogger(getClass());
        private AmazonS3 amazonS3;
        private String bucketName = "hotelGo_dev";

        public StorageService(AmazonS3 s3){
            this.amazonS3 = s3;
        }

        public void upload(String keyName, File file) {
                amazonS3.putObject(bucketName, keyName, file);
        }

        public String getObjectUrl(String keyName){

            String url = "https://"+ bucketName+".s3.amazonaws.com/"+keyName;
            return url;
        }

        public void setBucket(String bucket){
            this.bucketName = bucket;
        }

        public S3Object getObject(String S3Key){
            if(S3Key==null){
                return null;
            }else{
                return amazonS3.getObject(this.bucketName,S3Key);
            }
        }

        public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException
        {
            File convFile = new File( multipart.getOriginalFilename());
            multipart.transferTo(convFile);
            return convFile;
        }
}
