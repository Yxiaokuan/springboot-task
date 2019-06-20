package com.xiaokuan.springboot.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    /**
     *second , minute, hour, day of month(日), month , day of week（周几）.
     * eg:"0 * * * * MON-FRI"   0：整秒启动即每隔一分钟 周一到周五
     *  【0 0/5 14,18 * * ?】 每天14点整，和18点整，每隔5分钟执行一次
     *  【0 15 10 ? * 1-6】 每个月的周一至周六10:15分执行一次
     *  【0 0 2 ? * 6L】每个月的最后一个周六凌晨2点执行一次
     *  【0 0 2 LW * ?】每个月的最后一个工作日（周一到周五）凌晨2点执行一次
     *  【0 0 2-4 ? * 1#1】每个月的第一个周一凌晨2点到4点期间，每个整点都执行一次；
     */
//    @Scheduled(cron = "0 * * * * MON-FRI")
//    @Scheduled(cron = "0,2,4,5 * * * * MON-FRI") //周一到周五,无论什么时候,0秒,2秒,4秒,5秒执行该方法(枚举)
//    @Scheduled(cron = "0-5 * * * * MON-FRI") //周一到周五,无论什么时候,0到5秒之间的每一秒都会执行该方法(区间)
    @Scheduled(cron = "0/5 * * * * MON-FRI") //周一到周五,无论什么时候,每隔5秒执行一次该方法(步长)
    public void hello(){
        System.out.println("hello....");
    }
}
