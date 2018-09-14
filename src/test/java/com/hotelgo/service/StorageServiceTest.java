package com.hotelgo.service;

import com.amazonaws.services.s3.AmazonS3;
import com.hotelgo.config.AppConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.verify;


@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class StorageServiceTest {

    @InjectMocks
    @Autowired
    protected StorageService storageService;



    @Value("#{applicationProperties['amazon.s3.bucket']}")
    private String bucket;

    @Mock
    private AmazonS3 client = Mockito.mock(AmazonS3.class);

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception{
        validateMockitoUsage();
    }

//    @Test
//    public void getObjectTest(){
//        String bucket = "cde";
//        storageService.setBucket(bucket);
//        String S3key = "abc";
//        storageService.getObject(bucket, S3key);
//
//    }

    @Test
    public void getObject(){
        String key = "testKey";
        storageService.getObject(key);
        verify(client, times(1)).getObject(bucket,key);
        String key2 = null;
        storageService.getObject(key2);
        verify(client, times(0)).getObject(bucket,key2);
    }
}
