package com.bonc.controller;

import com.bonc.domain.SysLog;
import com.bonc.service.EsService;
import com.bonc.utils.EsClient;
import org.elasticsearch.common.bytes.BytesArray;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 王小浪 on 2018/11/20.
 */
@Controller
public class EsController {

    @Autowired
    private EsService service;

    @ResponseBody
    @RequestMapping("/esTest")
    public Map<String,Object> getById(){
        Map<String,Object> map = service.get("bonc","test","ciFEMGcBb_bQWdvOh3hS");
        if (null==map) {
            Map map1 = new HashMap();
            map1.put("msg", "您查询的结果为空，请尝试新的查询条件！");
            return map1;
        }
        return map;
    }
    @ResponseBody
    @RequestMapping("/esIndexTest")
    public  String index(){
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("user","test");
        json.put("message","this is only test example!");

        String id =  service.index(json);
        return  id;
    }
    @ResponseBody
    @RequestMapping("/esMultiGetTest")
    public List<Map<String,Object>> MultiGet() throws Exception {
        List<Map<String,Object>> list = service.multiGet("bonc","test","1","2","3","4","5");
        return list;
    }

    @ResponseBody
    @RequestMapping("/esSearchTest")
    public List<Map<String,Object>> search() throws Exception {
        List<Map<String,Object>> list = service.search("saas");
        return list;
    }
    @ResponseBody
    @RequestMapping("/esSearchByTemplateTest")
    public List<Map<String,Object>> searchByTemplate() throws Exception {
        Map<String, Object> template_params = new HashMap<>();
        template_params.put("param_name", "tom");
        List<Map<String,Object>> list = service.search("template_name",template_params);
        return list;
    }
    @ResponseBody
    @RequestMapping("/esSearchForDoTest")
    public List<SysLog> searchForDo() throws Exception {
        List<SysLog> list = service.searchForDo("saas");
        return list;
    }
    @RequestMapping("/test222")
    public  void  test(){
        EsClient.creatConEs().admin().cluster().preparePutStoredScript()
                .setId("template_gender")
                .setContent(new BytesArray(
                        "{\n" +
                                "    \"query\" : {\n" +
                                "        \"match\" : {\n" +
                                "            \"gender\" : \"{{param_gender}}\"\n" +
                                "        }\n" +
                                "    }\n" +
                                "}"), XContentType.JSON).get();
    }
}
