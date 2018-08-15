package com.bonc.utils;

import kafka.producer.KeyedMessage;
import kafka.producer.Producer;
import kafka.producer.ProducerConfig;
import scala.collection.Seq;


import java.util.Date;
import java.util.Properties;

/**
 * Created by 王小浪 on 2018/7/2.
 */
public class KafkaUtil {
    public static void main(String[] args) {
        int events=100;
        // 设置配置属性
        Properties props = new Properties();
        props.put("metadata.broker.list","192.168.110.123:2181");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        // key.serializer.class默认为serializer.class
        props.put("key.serializer.class", "kafka.serializer.StringEncoder");
        // 可选配置，如果不配置，则使用默认的partitioner
        props.put("partitioner.class", "com.jxl.cloub.kafka.PartitionerDemo");
        // 触发acknowledgement机制，否则是fire and forget，可能会引起数据丢失
        // 值为0,1,-1,可以参考
        props.put("request.required.acks", "1");
        ProducerConfig config = new ProducerConfig(props);

        // 创建producer
        Producer<String, String> producer = new Producer<String, String>(config);
        // 产生并发送消息
        long start=System.currentTimeMillis();
        for (long i = 0; i < events; i++) {
            long runtime = new Date().getTime();
            String ip = "10.1.6." + i;//rnd.nextInt(255);
            String msg = runtime + ",www.example.com," + ip;
            //如果topic不存在，则会自动创建，默认replication-factor为1，partitions为0
            KeyedMessage<String, String> data = new KeyedMessage<String, String>(
                    "test", ip, msg);
            producer.send((Seq<KeyedMessage<String, String>>) data);
        }
        System.out.println("耗时:" + (System.currentTimeMillis() - start));
        // 关闭producer
        producer.close();
    }
}
