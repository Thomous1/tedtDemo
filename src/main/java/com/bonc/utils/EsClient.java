package com.bonc.utils;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import java.net.InetAddress;

/**
 * Created by 王小浪 on 2018/11/19.
 */
public  class EsClient {

    //客户端TransportClient对象
    private static TransportClient client = null;
    //es集群名称，必须和配置文件中的对应
    private static String clusterName = "elasticsearch";
    //部署es服务器的ip
    private static String networkGost = "192.168.110.123";
    //es的port，注意不是http.host,是配置文件中的transport.tcp.port,默认9300.
    private static Integer transportTcpPort = 9300;

    /**
     * 创建es连接
     *
     * @return
     */
    public static TransportClient creatConEs() {
        if (null == client) {
            Settings settings = Settings.builder()
                    .put("cluster.name", clusterName)
                    .build();
            try {
                client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName(networkGost), transportTcpPort));
                System.out.println(".................连接成功！");
            } catch (Exception e) {
                System.out.println("连接出现异常");
            }
        }
        return client;
    }

    /**
     * 关闭连接
     */
    public static void closeConEs() {
        if (client != null) {
            client.close();
            client = null;
            System.out.println("........连接已关闭！");
        }
    }


}
