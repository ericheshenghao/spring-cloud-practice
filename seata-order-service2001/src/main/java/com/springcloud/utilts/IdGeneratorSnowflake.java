package com.springcloud.utilts;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class IdGeneratorSnowflake {

    private  long workerId =0;
    private long datacenterId =1;
    private Snowflake snowflake = IdUtil.createSnowflake(workerId,datacenterId);

    // 初始化
    @PostConstruct
    public void init() {
        try {
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("当前机器的workerId:{}",workerId);
        }catch (Exception e){
            e.printStackTrace();
            log.warn("当前机器的workerId获取失败");
            workerId = NetUtil.getLocalhostStr().hashCode();
        }
    }
    public synchronized  long snowflakeId(){
        return snowflake.nextId();
    }

    public synchronized  long snowflakeId(long workerId,long datacenterId){
        Snowflake snowflake = IdUtil.createSnowflake(workerId,datacenterId);
        return snowflake.nextId();
    }

//    public static void main(String[] args) {
//       System.out.println( new IdGeneratorSnowflake().snowflakeId());
//    }
}
