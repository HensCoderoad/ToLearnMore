package com.wechat.manager.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Hens
 * @DateTime: 2019/12/3 21:00
 * @Description: 消息格式处理
 */
public class MessageUtil {

    @SuppressWarnings("unchecked")
    public static Map<String, String> parseXML(HttpServletRequest request) throws Exception {
        Map<String, String> map = new HashMap<>();
        // 获取流
        InputStream inputStream = request.getInputStream();
        // 读取流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        // 得到根元素
        Element root =document.getRootElement();
        // 获得所有子节点
        List<Element> elementList = root.elements();
        // 遍历所有子节点
        for(Element e: elementList){
            map.put(e.getName(), e.getText());
        }
        inputStream.close();
        return map;
    }

    @SuppressWarnings("unused")
    private static XStream xStream = new XStream(new XppDriver(){
        @Override
        public HierarchicalStreamWriter createWriter(Writer out){
            return new PrettyPrintWriter(out){
                boolean cdata = true;
                @Override
                @SuppressWarnings("rawtypes")
                public void startNode(String name, Class clazz){
                    super.startNode(name, clazz);
                }
                @Override
                protected void writeText(QuickWriter writer, String text){
                    if(cdata){
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    }else {
                        writer.write(text);
                    }
                }
            };
        }
    });
}
