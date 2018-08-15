package com.bonc.utils;


import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.conf.Configuration;

import java.io.IOException;
import java.net.URI;

/**
 * Created by 王小浪 on 2018/6/27.
 */
public  class FileSystemUtil {


    public static  FileSystem getFS(){
        String uri = "hdfs://192.168.110.123:9000";
        Configuration conf = new Configuration();
        conf.set("fs.hdfs.impl",org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
        FileSystem fs= null;
        try {
           fs = FileSystem.get(URI.create(uri),conf,"hadoop");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  fs;
    }

}
