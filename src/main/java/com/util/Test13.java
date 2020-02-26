package com.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.util.CollectionUtils;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test13
{
    @Test
    public void testLamda() {
        List<String> list = new ArrayList<String>();
        list.add("xiaoming");
        list.add("xiaohong");

        list.forEach(name -> System.out.println(name));

    }

    @Test
    public void testGetWebPage() throws IOException {
        String startUrl = "https://github.com/abel533/Mybatis-Spring";

        HttpEntity entity = HttpClients.createDefault().execute(new HttpGet(startUrl)).getEntity();
        String result = EntityUtils.toString(entity);
        List<ATagOfPart> list = convertHtml(result);
        for(ATagOfPart aTagOfPart: list) {
            String url = aTagOfPart.getGroup();

            HttpEntity entity2 = HttpClients.createDefault().execute(new HttpGet(url)).getEntity();
            String result2 = EntityUtils.toString(entity2);
            List<ATagOfPart> list2 = convertHtml(result2);


            list2.forEach(aTagOfPart2 -> System.out.println(aTagOfPart.getGroup()));
        }

        //System.out.println(result);

        //List<String> urlList = getHttpUrl(result);

    }

    private static List<ATagOfPart> convertHtml(String content) {
        List<ATagOfPart> matcher = getMatcher("<a href=\"http[^>]*>([^<]*)</a>", content);
        //List<ATagOfPart> matcher = getMatcher("<a href=\"http(^*$)</a>", content);
        if (CollectionUtils.isEmpty(matcher)) {
            return new ArrayList<ATagOfPart>();
        }

        System.out.println("dd");
        return matcher;
    }

    public static List<ATagOfPart> getMatcher(String regex, String source) {
        List<ATagOfPart> list = new LinkedList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);

        while (matcher.find()) {
            ATagOfPart htmlGroupVO = new ATagOfPart(matcher.group(), matcher.group(1));
            list.add(htmlGroupVO);
        }
        return list;
    }

}

class ATagOfPart
{
    /**
     * a标签的全部
     */
    private String group;
    /**
     * a标签的内容
     */
    private String aContent;

    public ATagOfPart() {
    }

    public ATagOfPart(String group, String aContent) {
        this.group = group;
        this.aContent = aContent;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getaContent() {
        return aContent;
    }

    public void setaContent(String aContent) {
        this.aContent = aContent;
    }

}
