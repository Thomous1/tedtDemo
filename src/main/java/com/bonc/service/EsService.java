package com.bonc.service;

import com.bonc.domain.SysLog;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 王小浪 on 2018/11/20.
 */
@Service
public interface EsService {
    public Map<String, Object> get(String index, String type, String id);

    public String index(Map<String, Object> map);

    public List<Map<String, Object>> multiGet(String index, String type, String... ids) throws Exception;

    public List<Map<String, Object>> search(String... indexs) throws Exception;

    public List<Map<String, Object>> search(String template, Map<String, Object> map) throws Exception;

    public List<SysLog> searchForDo(String... indexs) throws Exception;

}