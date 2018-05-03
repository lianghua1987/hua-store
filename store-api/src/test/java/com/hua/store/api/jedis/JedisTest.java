package com.hua.store.api.jedis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class JedisTest {

    @Test
    public void testJedisStandalone() {

        Jedis jedis = new Jedis("10.0.0.77", 6379);
        jedis.set("name", "test123");
        assertEquals("test123", jedis.get("name"));
        jedis.close();
    }


    @Test
    public void testJedisPool() {
        //commons-pool2, or throws error
        JedisPool jedisPool = new JedisPool("10.0.0.77", 6379);
        Jedis jedis = jedisPool.getResource();
        assertEquals("test123", jedis.get("name"));
        jedis.close();
        jedisPool.close();
    }

    @Test
    public void testJedisCluster() throws IOException {
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("10.0.0.77", 7001));
        nodes.add(new HostAndPort("10.0.0.77", 7002));
        nodes.add(new HostAndPort("10.0.0.77", 7003));
        nodes.add(new HostAndPort("10.0.0.77", 7004));
        nodes.add(new HostAndPort("10.0.0.77", 7005));
        nodes.add(new HostAndPort("10.0.0.77", 7006));
        JedisCluster cluster = new JedisCluster(nodes);
        cluster.set("age", "30");
        assertEquals("30", cluster.get("age"));
        cluster.close();
    }

//    @Test
//    public void testSpringJedisStandalone() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
//
//        JedisPool pool = (JedisPool) context.getBean("redisClient");
//        Jedis jedis = pool.getResource();
//        System.out.println(jedis.get("name"));
//        pool.close();
//    }


    @Test
    public void testSpringJedisCluster() throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        JedisCluster cluster = (JedisCluster) context.getBean("redisClient");
        System.out.println(cluster.get("name"));
        cluster.close();
    }
}
