package com.utils.dfa;

import java.util.*;

/**
 * 敏感词处理工具 - DFA算法实现
 * @author Hens
 * 方法：
 * 初始化敏感词库sensitiveWord
 * 查看是否有关键词SensitiveWordUtil.contains(str,SensitiveWordUtil.MinMatchType);
 * 获取语句中的敏感词SensitiveWordUtil.getSensitiveWord(str,SensitiveWordUtil.MinMatchType);
 * 替换敏感词SensitiveWordUtil.replaceSensitiveWord(str, "*");SensitiveWordUtil.replaceSensitiveWord(str, "[敏感词]");
 */
public class SensitiveWordUtil {
    /**
     * 敏感词匹配规则
     */
    // 最小匹配规则，如敏感词库[中国，中国人]，语句：我是中国人，过滤后：我是**人
    public static final int MinMatchType = 1;
    // 最大匹配规则，如敏感词库[中国，中国人]，语句：我是中国人，过滤后：我是***
    public static final int MaxMatchType = 2;
    /**
     * 敏感词集合
     */
    public static HashMap sensitiveWordMap;

    /**
     * 初始化敏感词库，构建DFA算法模型
     * @param sensitiveWordSet
     */
    public static synchronized void init(Set<String> sensitiveWordSet){
        initSensitiveWordMap(sensitiveWordSet);
    }

    /**
     * 初始化敏感词库，构建DFA算法模型
     * @param sensitiveWordSet
     */
    private static void initSensitiveWordMap(Set<String> sensitiveWordSet){
        // 初始化铭感词容器，减少扩容操作
        sensitiveWordMap = new HashMap(sensitiveWordSet.size());
        String key;
        Map nowMap;
        Map<String, String> newWordMap;
        // 迭代sensitiveWordSet
        Iterator<String> iterator = sensitiveWordSet.iterator();
        while(iterator.hasNext()){
            // 关键词
            key = iterator.next();
            nowMap = sensitiveWordMap;
            for(int i = 0;i<key.length();i++){
                 // 转换成char
                char keyChar = key.charAt(i);
                // 库中获取关键字
                Object wordMap = nowMap.get(keyChar);
                // 如果存在该key，直接赋值，用于下一个循环获取
                if(wordMap != null){
                    nowMap = (Map) wordMap;
                }else{
                    // 不存在则构建一个map，同时将isEnd设置为0，因为他不是最后一个
                    newWordMap = new HashMap<>();
                    newWordMap.put("isEnd","0");
                    nowMap.put(keyChar, newWordMap);
                    nowMap = newWordMap;
                }
                if( i == key.length() - 1){
                    // 最后一个
                    nowMap.put("isEnd","1");
                }
            }
        }
    }

    /**
     * 判断文字是否包含敏感字符
     * @param txt 文字
     * @param matchType 匹配规则
     * @return 包含返回ture
     */
    public static boolean contains(String txt, int matchType){
        boolean flag = false;
        for(int i = 0;i<txt.length();i++){
            int matchFlag = checkSensitiveWord(txt,i,matchType);
            if(matchFlag > 0){
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 判断文字是否包含敏感字符
     * @param txt
     * @return
     */
    public static boolean contains(String txt){
        return contains(txt, MaxMatchType);
    }

    /**
     * @param txt
     * @param beginIndex
     * @param matchType
     * @return 如果存在，则返回敏感词字符的长度，不存在返回0
     */
    private static int checkSensitiveWord(String txt, int beginIndex, int matchType){
        // 敏感词结束标志位，用于敏感词只有一位的情况
        boolean flag = false;
        // 匹配标识数默认为0
        int matchFlag = 0;
        char word;
        Map nowMap = sensitiveWordMap;
        for(int i = beginIndex; i<txt.length();i++){
            word = txt.charAt(i);
            // 获取指定的key
            nowMap = (Map) nowMap.get(word);
            if(nowMap != null){
                matchFlag++;
                if("1".equals(nowMap.get("isEnd"))){
                    // 结束标志位为true
                    flag = true;
                    if(MinMatchType == matchType){
                        break;
                    }
                }
            }else {
                break;
            }
        }
        if(matchType < 2 || !flag){
            matchFlag = 0;
        }
        return matchFlag;
    }

    /**
     * 获取文字中的敏感词
     * @param txt
     * @param matchType
     * @return
     */
    public static Set<String> getSensitiveWord(String txt, int matchType){
        Set<String> sensitieWordList = new HashSet<>();
        for(int i = 0 ; i< txt.length();i++){
            // 判断是否包含敏感字符
            int length = checkSensitiveWord(txt, i, matchType);
            if(length > 0){
                sensitieWordList.add(txt.substring(i,i+length));
                i = i + length -1;
            }
        }
        return sensitieWordList;
    }

    /**
     * 获取文字中的敏感词
     * @param txt
     * @return
     */
    public static Set<String> getSensitiveWord(String txt){
        return getSensitiveWord(txt, MaxMatchType);
    }

    /**
     * 替换敏感字符
     * @param txt 文本
     * @param replaceChar 替换的字符，匹配的敏感词以字符逐个替换
     * @return
     */
    public static String replaceSensitiveWord(String txt, char replaceChar){
        return replaceSensitiveWord(txt, replaceChar, MaxMatchType);
    }

    /**
     * 替换敏感字符
     * @param txt
     * @param replaceChar
     * @param matchType
     * @return
     */
    public static String replaceSensitiveWord(String txt, char replaceChar, int matchType){
        String resultTxt = txt;
        Set<String> set = getSensitiveWord(txt, matchType);
        Iterator<String> iterator = set.iterator();
        String word;
        String replaceString;
        while(iterator.hasNext()){
            word = iterator.next();
            replaceString = getReplaceChars(replaceChar, word.length());
            resultTxt = resultTxt.replaceAll(word, replaceString);
        }
        return resultTxt;
    }

    /**
     * 获取替换字符
     * @param replaceChar
     * @param length
     * @return
     */
    public static String getReplaceChars(char replaceChar,int length){
        String resultReplace = String.valueOf(replaceChar);
        for(int i = 1;i<length;i++){
            resultReplace += resultReplace;
        }
        return resultReplace;
    }


    public static String replaceSensitiveWord(String txt, String replaceStr){
        return replaceSensitiveWord(txt,replaceStr,MaxMatchType);
    }

    public static String replaceSensitiveWord(String txt,String replaceStr,int matchType){
        String resultTxt = txt;
        Set<String> set = getSensitiveWord(txt,matchType);
        Iterator<String> iterator = set.iterator();
        String word;
        while(iterator.hasNext()){
            word = iterator.next();
            resultTxt = resultTxt.replaceAll(word, replaceStr);
        }
        return resultTxt;
    }
}
