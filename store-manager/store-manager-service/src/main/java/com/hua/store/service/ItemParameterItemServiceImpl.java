package com.hua.store.service;

import com.hua.store.common.utils.JsonUtils;
import com.hua.store.mapper.ItemParameterItemMapper;
import com.hua.store.pojo.ItemParameterExample;
import com.hua.store.pojo.ItemParameterItem;
import com.hua.store.pojo.ItemParameterItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ItemParameterItemServiceImpl implements ItemParameterItemService {

    @Autowired
    private ItemParameterItemMapper mapper;


    @Override
    public String getByItemId(Long itemId) {
        ItemParameterItemExample itemParameterItemExample = new ItemParameterItemExample();
        ItemParameterItemExample.Criteria criteria = itemParameterItemExample.createCriteria();
        criteria.andItemIdEqualTo(itemId);
        List<ItemParameterItem> itemParameterItems = mapper.selectByExampleWithBLOBs(itemParameterItemExample);

        if (itemParameterItems == null || itemParameterItems.isEmpty()) {
            return "";
        }

        List<Map> list = JsonUtils.jsonToList(itemParameterItems.get(0).getParamData(), Map.class);

        StringBuilder sb = new StringBuilder();

        sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"1\">");
        sb.append("<tbody>");

        for (Map map : list) {
            sb.append("<tr>");
            sb.append("<th colspan=\"2\">" + map.get("group") + "</th>");
            sb.append("</tr>");
            List<Map> paramList = (List<Map>) map.get("params");

            for (Map paramMap : paramList) {
                sb.append("<tr>");
                sb.append("<td>" + paramMap.get("k") + "</td>");
                sb.append("<td>" + paramMap.get("v") + "</td>");
                sb.append("</tr>");
            }
        }

        sb.append("</tbody>");
        sb.append("</table>");

        return sb.toString();
    }
}
