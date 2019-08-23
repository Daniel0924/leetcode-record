package com.ydh.leetcode.February;

import redis.clients.jedis.Jedis;

public class RedisConnection {

    public static void main(String[] args){

        Jedis jedis = new Jedis("localhost");

        System.out.println("连接成功");
        System.out.println("服务正在运行：" + jedis.ping());

        jedis.set("runoobkey", "www.baidu.com");

        System.out.println(jedis.get("runoobkey"));
    }
}
