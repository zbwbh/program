package com.baseframe.redis.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baseframe.redis.datasource.RedisDataSource;
import com.baseframe.util.Constants;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;

/**
 * 实际上本身redis概念还没清晰，路还很长啊
 * jedis使用模板,不过主要使用的还是redis命令
 * Repository持久层注解
 * @author koala
 * @since 2017年6月9日
 */
@Repository
public class RedisClientTemplate {

    private final static Logger log = LoggerFactory.getLogger(RedisClientTemplate.class);
    @Resource
    private RedisDataSource redisDataSource;
    
    public ShardedJedis getShardedJedis(){
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        return shardedJedis;
    }
    
    public void disconnect(){
        ShardedJedis shardedJedis = redisDataSource.getRedisClient();
        shardedJedis.disconnect();
    }
    
    public void delKey(String key){
        ShardedJedis shardedJedis = this.getShardedJedis();
        shardedJedis.del(key);
        shardedJedis.disconnect();
        shardedJedis.close();
    }
    
    /**
     * 存储字符串
     * 
     * @author koala
     * @since 2017年6月9日
     */
    public void setKey(String key,String value){
        if(Constants.isConnectCatch()){
            try {
                ShardedJedis shardedJedis = this.getShardedJedis();
                shardedJedis.set(key, value);
                shardedJedis.disconnect();
                shardedJedis.close();
            }
            catch (Exception e) {
                log.error("Jedis存储出现错误,key:"+key+",value:"+value,e);
            }
        }
    }
    
    /**
     * 获得字符串
     *
     * @author koala
     * @since 2017年6月9日
     */
    public Object getKey(String key){
        if(Constants.isConnectCatch()){
            try {
                ShardedJedis shardedJeids = this.getShardedJedis();
                Object obj = shardedJeids.get(key);
                shardedJeids.disconnect();
                shardedJeids.close();
                return obj;
            }
            catch (Exception e) {
                log.error("jedis存储出现错误,key:"+key,e);
            }
        }
        return null;
    }
    
    /**
     * 设置list
     *
     * @author koala
     * @since 2017年6月9日
     */
    public void setList(String key ,List<?>list){
        if(Constants.isConnectCatch()){
            try {
                ShardedJedis shardedJedis = this.getShardedJedis();
                shardedJedis.set(key, JSONArray.toJSONString(list));
                shardedJedis.disconnect();
                shardedJedis.close();
            }
            catch (Exception e) {
                log.error("jedis存储出现异常,key:"+key+",list:"+JSONArray.toJSONString(list),e);
            }
        }
    }
    
    /**
     * 跟上面的那个一样
     *
     * @author koala
     * @since 2017年6月9日
     */
    public void setMap(String key,Map<String,Object>map){
        if(Constants.isConnectCatch()){
            try {
                ShardedJedis shardedJeids = this.getShardedJedis();
                shardedJeids.set(key, JSONArray.toJSONString(map));
                shardedJeids.disconnect();
                shardedJeids.close();
            }
            catch (Exception e) {
                log.error("jedis存储出现错误,key:"+key+",map:"+JSONArray.toJSONString(map),e);
            }
        }
    }
    
    /**
     * 根据key和json设置redis中set类型
     * 这个方法乍看跟上面的一样，实际上用到了一个特殊的方法sadd
     * 该方法SADD key member [member ...]
     * 将一个或多个member元素加入到集合key当中，已经存在于集合的member元素将被忽略，估计是set集合特性导致的（不敢保准啊！！，估计是）
     * 假如key不存在，则创建一个只包含member元素作成员的集合。
     * 当key不是集合类型时，返回一个错误
     * @author koala
     * @since 2017年6月9日
     */
    public void setCacheSet(String key,String json){
        if(Constants.isConnectCatch()){
            try {
                ShardedJedis shardedJedis = this.getShardedJedis();
                shardedJedis.sadd(key, json);//<---I'm here O(∩_∩)O~
                shardedJedis.disconnect();
                shardedJedis.close();
            }
            catch (Exception e) {
                log.error("jedis存储出现错误,key:"+key+",json:"+json,e);
            }
        }
    }
    
    /**
     * 取出set类型集合里面的第一个元素
     * @author koala
     * @since 2017年6月9日
     */
    public String getCacheSetFirst(String key){
        if(Constants.isConnectCatch()){
            try {
                String result = null;
                ShardedJedis shardedJedis = this.getShardedJedis();
                Set<String> set = shardedJedis.smembers(key);
                shardedJedis.disconnect();
                shardedJedis.close();
                if(null!=set&&!set.isEmpty()){
                    while(set.iterator().hasNext()){ 
                        result = set.iterator().next();
                        break;//这个方法太巧妙了，直接获取完第一个元素之后就不拿了，循环终止
                    }
                    return result;
                }
            }
            catch (Exception e) {
                log.error("jedis存储出现错误,key:"+key,e);
            }
        }
        return null;
    }
    
    /**
     * 把map数据保存成redis里面的map类型
     * redis中文官网说的：
     * hmset，设置key指定的哈希集中指定字段的值，该命令将重写所有在哈希集中存在的字段
     * ，如果key指定的哈希集不存在，会创建一个新的哈希集并与key关联
     * 另一个网页说的：
     * hset，将哈希表中key中的域field的值设为value.如果key不存在，一个新的哈希表被创建并进行hset操作。
     * 如果域field已经存在于哈希表中，旧值将被覆盖。
     * hmset是对多个key-value进行处理，好了，详细的在qq里
     * @author koala
     * @since 2017年6月9日
     */
    public void setCacheMap(String key,Map<String,Object>map){
        if(Constants.isConnectCatch()){
            try {
                if(null!=map&&!map.isEmpty()){
                    Map<String,String>m1 = new HashMap<String,String>();
                    //这个Entry是Map.Entry的简写
                    Set<Entry<String,Object>>entrySet = map.entrySet();
                    for(Entry<String,Object> entry:entrySet){
                        Object value = entry.getValue();
                        if(value instanceof String){
                            m1.put(entry.getKey(), (String)value);
                        }
                        else{
                            m1.put(entry.getKey(), JSON.toJSONString(value));
                        }
                    }
                    ShardedJedis shardedJedis = this.getShardedJedis();
                    shardedJedis.hmset(key, m1);//不懂看redis中文文档去
                    shardedJedis.disconnect();
                    shardedJedis.close();
                }
            }
            catch (Exception e) {
                // TODO: handle exception
                log.error("jedis存储出现错误,key:"+key+",map:"+JSON.toJSONString(map), e);
            }
        }
    }
    
    /**
     * 获取redis中Map类型数据
     * 可以获取多个不确定参数，也可以是null，本身hmget命令支持返回null值，所以list也可能是null
     *
     * @author koala
     * @since 2017年6月9日
     */
    public List<String> getCacheMap(String key,String ...fields){
        if(Constants.isConnectCatch()){
            try {
                ShardedJedis shardedJedis = this.getShardedJedis();
                List<String> list = shardedJedis.hmget(key, fields);
                shardedJedis.disconnect();
                shardedJedis.close();
                return list;
            }
            catch (Exception e) {
                log.error("jedis存储出现错误,key:"+key+",fields:"+JSON.toJSONString(fields),e);
            }
        }
        return null;
    }
    
    private Jedis getJedis(){
        //这里虽然用的是常量，但是该常量在项目启动的开始就已经存好了，使用的是scriptload命令读取的脚本，在类加载的同时使用getResource方法获取了文件路径
        String cacheRedisServerKey = (String)this.getKey(Constants.REDIS_SERVER_KEY);
        Jedis jedis = null;
        ShardedJedis shardedJedis = this.getShardedJedis();
        Collection<Jedis> c = shardedJedis.getAllShards();//获取所有jedis对象
        Iterator<Jedis> it = c.iterator();
        while(it.hasNext()){
            Jedis j = it.next();
            String jedisInfo = j.info("server").replaceAll("\r|\n", " ");//转义字符中的回车和换行
            jedisInfo = jedisInfo.substring(jedisInfo.indexOf("process_id:"), jedisInfo.indexOf("uptime_in_seconds:"));
            if(cacheRedisServerKey.equals(jedisInfo)){
                jedis=j;
                break;
            }
        }
        shardedJedis.disconnect();
        shardedJedis.close();
        return jedis;
    }
    
    //--------------接下来是最重要的两个方法
    /**
     * 模糊搜索redis中set的key集合的值
     * 因为里面的evalsha网上没有明确的答案，所以不敢轻易理解
     * 其他类的引用联系着看这个而是什么意思吧
     * 看了eval命令的解释，evalsha算是eval的升级版，速度快
     * @author koala
     * @since 2017年6月12日
     */
    public <T> List<T> getCacheSetFuzzyKey(String fuzzyKey,Class<T>clazz){
        if(Constants.isConnectCatch()){
            List<String> setFuzzyKeyScriptSha = this.getCacheMap(Constants.REDIS_SCRIPT,"getSetFuzzyKey");
            Jedis jedis = getJedis();
            if(null!=jedis){
                List<String>s= (List<String>)jedis.evalsha(setFuzzyKeyScriptSha.get(0), 1, fuzzyKey);
                jedis.disconnect();
                jedis.close();
                if(null!=s&&s.size()>0){
                    return JSON.parseArray(s.toString(),clazz);
                }
                else{
                    return new ArrayList();
                }
            }else{
                return null;
            }
        }
        return null;
    }
    
    /**
     * 这个比上面那个方法更复杂，问题就在evalsha这个命令上面了
     * 文档没有说明每个参数是什么
     *
     * @author koala
     * @since 2017年6月12日
     */
    public <T> List<T> searchSet(String key,String value,Class<T>clazz){
        if(Constants.isConnectCatch()){
            return null;
        }
        String cacheRedisServerKey = (String)this.getKey(Constants.REDIS_SERVER_KEY);
        if(null==cacheRedisServerKey){
            return null;
        }
        List<String> searchScriptKey = this.getCacheMap(Constants.REDIS_SCRIPT, "searchSet");
        if(null==searchScriptKey){
            return null;
        }
        Jedis jedis = getJedis();
        String ps[] = {key+"*",value};
        if(null!=jedis){
            List<String>s = (List<String>) jedis.evalsha(searchScriptKey.get(0),2,ps);
            System.out.println("evalsha第一个参数的值是：");
            System.out.println(searchScriptKey.get(0));
            jedis.disconnect();
            jedis.close();
            if(null!=s&&s.size()>0){
                return JSON.parseArray(s.toString(),clazz);
            }else{
                return new ArrayList();
            }
        }else{
            return null;
        }
    }
    
    /**
     * EntrySet是java中的一个对象，一般可以通过map.entrySet()得到
     */
    public void test(){
        /**
         * 1、entrySet实现了Set接口，里面存放的是键值对。一个K对应一个V
         * 2、用来遍历map的一种方法
         */
        Map<String,Object>map = new HashMap<String,Object>();
        Set<Map.Entry<String, Object>>entrySet = map.entrySet();
        for(Map.Entry<String, Object>entry:entrySet){
          //通过getKey()得到K, getValue得到V
            System.out.println(entry.getKey()+","+entry.getValue());
        }
        /**
         * 3、还有一种是keySet
         */
        Set<String>set = map.keySet();
        for(String s :set){
            System.out.println(s+","+map.get(s));
        }
        /**
         * 总结：keySet是键的集合，Set里面的类型就是key的类型
         * entrySet是键-值对的集合，Set里面的类型时Map.Entry
         * keySet()的速度比entrySet()慢了很多
         * 使用entrySet则必须将map对象转换为Map.Entry
         */
    }
    
}
