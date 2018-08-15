package com.bonc.utils;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.protocol.DatanodeInfo;

import java.io.IOException;

/**
 * Created by 王小浪 on 2018/6/27.
 */
public class FileSystemAPI {

    FileSystem fs = FileSystemUtil.getFS();

    //创建目录
    public  void mkdirs(String path) throws IOException {
        try {
            fs.mkdirs(new Path(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        fs.close();
    }
    //删除目录
    public  void deleteFloder(String path) throws IOException {
        try {
            fs.delete(new Path(path),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fs.close();
    }
    //获取路径下的全部文件
 /*   public static void main(String[] args) throws IOException {
        FileSystem fs = FileSystemUtil.getFS();
        FileStatus[] status= null;
        try {
            status = fs.listStatus(new Path("/data/input"));
            for (FileStatus s : status){
                System.out.println(s.toString());
            }
            Path[] listedPaths = FileUtil.stat2Paths(status);

            //循环读取每个文件
            for (Path path : listedPaths) {
                System.out.println(path);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        fs.close();
    }*/

 /*   //从本地复制到hdfs上
    public static void main(String[] args) throws IOException {
        FileSystem fs = FileSystemUtil.getFS();
         Path srcPath = new Path("F:\\test.txt");
         Path dstPath = new Path("/test");
         fs.copyFromLocalFile(srcPath,dstPath);
        fs.close();
    }*/
        //从hdfs下载文件到本地
  /*  public static void main(String[] args) throws IOException {
        FileSystem fs = FileSystemUtil.getFS();
        Path dstPath = new Path("D:\\");
        Path srcPath = new Path("/test/test.txt");
        fs.copyToLocalFile(srcPath,dstPath);
        fs.close();
    }*/
 public static void main(String[] args) throws IOException {
     FileSystem fs = FileSystemUtil.getFS();
     //获取分布式文件系统
     DistributedFileSystem hdfs = (DistributedFileSystem)fs;

     //获取所有节点
     DatanodeInfo[] dataNodeStats = hdfs.getDataNodeStats();

     //循环比遍历
     for (int i = 0; i < dataNodeStats.length; i++) {
         System.out.println("DataNote_" + i + "_Name:" + dataNodeStats[i].getHostName());
     }
     fs.close();
 }
}
