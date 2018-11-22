package com.bonc.service.impl;


import com.bonc.domain.SysLog;
import com.bonc.service.EsService;
import com.bonc.utils.EsClient;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetItemResponse;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.common.document.DocumentField;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.script.ScriptService;
import org.elasticsearch.script.ScriptType;
import org.elasticsearch.script.mustache.SearchTemplateRequestBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Created by 王小浪 on 2018/11/20.
 */
@Service
public class EsServiceImpl implements EsService {

//按照id查询
    @Override
    public Map<String,Object> get(String index,String type,String id) {
        GetResponse response = EsClient.creatConEs().prepareGet(index,type,id).get();
        Map<String,DocumentField> fields = response.getFields();
        Map<String,Object> source = response.getSource();
        return source;
    }
//添加
    @Override
    public String index(Map<String, Object> map) {

        IndexResponse response = EsClient.creatConEs()
                .prepareIndex("bonc","test")
                .setSource(map,XContentType.JSON)
                .get();
        String id = response.getId();
        return id;
    }
//按照多个id查询
    @Override
    public List<Map<String,Object>> multiGet(String index,String type,String ... ids) throws Exception {
        List<Map<String,Object>> list = new LinkedList<>();
        MultiGetResponse responses = EsClient.creatConEs().prepareMultiGet()
                .add(index,type,ids)
                .get();
        for (MultiGetItemResponse multiGetItemResponse : responses){
            GetResponse getResponse = multiGetItemResponse.getResponse();
            if (getResponse.isExists()){
                Map<String,Object> map = getResponse.getSource();
                list.add(map);
            }

        }
        return list;
    }

    @Override
    public List<Map<String, Object>> search(String ... indexs) throws Exception {
        List<Map<String,Object>> list = new LinkedList<>();
        SearchResponse response = EsClient.creatConEs().prepareSearch(indexs)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                /*.setQuery(QueryBuilders.rangeQuery("age")
                        .from(25)
                        .to(60))*/
                .setFrom(0)
                .setSize(20)
                .get();
               SearchHits hits =  response.getHits();
               for (SearchHit hit : hits) {
                   Map<String, Object> map = hit.getSourceAsMap();
                   list.add(map);
               }
        return list;
    }

    @Override
    public List<Map<String, Object>> search(String template,Map<String,Object> maps) throws Exception {


        List<Map<String,Object>> list = new LinkedList<>();
        SearchResponse sr = new SearchTemplateRequestBuilder(EsClient.creatConEs())
                .setScript(template)
                .setScriptType(ScriptType.STORED)
                .setScriptParams(maps)
                .setRequest(new SearchRequest())
                .get()
                .getResponse();
        SearchHits hits =  sr.getHits();
        for (SearchHit hit : hits) {
            Map<String, Object> map = hit.getSourceAsMap();
            list.add(map);
        }
        return list;
    }

    @Override
    public List<SysLog> searchForDo(String... indexs) throws Exception {
        List<SysLog> list = new LinkedList<>();
        SearchResponse response = EsClient.creatConEs().prepareSearch(indexs)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.matchQuery("operation","访问首页"))
                .addSort("id", SortOrder.ASC)
                .setFrom(0)
                .setSize(100)
                .get();
        SearchHits hits =  response.getHits();
        for (SearchHit hit : hits) {
            Map<String, Object> map = hit.getSourceAsMap();
            SysLog sysLog = new SysLog();
            sysLog.setUser_id((Integer) map.get("user_id"));
            sysLog.setIp((String) map.get("ip"));
            sysLog.setMethod((String) map.get("method"));
            sysLog.setOperation((String) map.get("operation"));
            sysLog.setTime((Integer) map.get("time"));
            sysLog.setUsername((String) map.get("username"));
            sysLog.setParams((String) map.get("params"));
            sysLog.setId((Integer) map.get("id"));
            list.add(sysLog);
        }
        return list;
    }

}
